//  © 2K26 ❱──💀──❰ pat_mic ? code is life : life is code
package LdDataAccess.LdHelpers;

import java.sql.*;
import java.util.List;

import LdDataAccess.LdInterfaces.ILdDAO;

import java.util.ArrayList;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import LdInfrastructure.AppConfig;
import LdInfrastructure.AppException;

public class LdDataHelperSQLiteDAO <T> implements ILdDAO<T> {
    protected final Class<T> DTOClass;
    protected final String  tableName;
    protected final String  tablePK;

    private static final String DBPath = AppConfig.DATABASE; 
    private static Connection conn = null;

    protected static synchronized Connection openConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            conn = DriverManager.getConnection(DBPath);
        }
        return conn;
    }

    protected static void closeConnection() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

    protected String getDataTimeNow() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * Construye la relación entre la clase DTO y la tabla de la base de datos
     * @param dtoClass  : Nombre de la clase DTO
     * @param tableName : Nombre de la tabla
     * @param tablePK   : Nombre del PK de la tabla
     * @throws AppException: Error al asociar la clase con la tabla
     */
    public LdDataHelperSQLiteDAO(Class<T> dtoClass, String tableName, String tablePK) throws AppException {
        try {
            openConnection();
        } catch (SQLException e) {
            throw new AppException(null, e, getClass(), "LdDataHelperSQLiteDAO");
        }
        this.DTOClass  = dtoClass;
        this.tableName = tableName;
        this.tablePK   = tablePK;
    }

    @Override
    public boolean create(T entity) throws AppException {
        Field[] fields = DTOClass.getDeclaredFields();
        StringBuilder columns = new StringBuilder();
        StringBuilder placeholders = new StringBuilder();

        for (Field field : fields) {
            field.setAccessible(true);
            String name = field.getName();
            // Excluir PK y campos por defecto y auditoría (Refactorizado a Ld)
            if (!name.equalsIgnoreCase(tablePK)
                && !name.equalsIgnoreCase("LdEstado")
                && !name.equalsIgnoreCase("LdFechaCreacion")
                && !name.equalsIgnoreCase("LdFechaModifica")) {
                columns.append(name).append(",");
                placeholders.append("?,");
            }
        }

        String cols = columns.substring(0, columns.length() - 1);
        String vals = placeholders.substring(0, placeholders.length() - 1);

        String sql = String.format("INSERT INTO %s (%s) VALUES (%s)", tableName, cols, vals);

        try (PreparedStatement stmt = openConnection().prepareStatement(sql)) {
            int index = 1;
            for (Field field : fields) {
                String name = field.getName();
                if (!name.equalsIgnoreCase(tablePK)
                    && !name.equalsIgnoreCase("LdEstado")
                    && !name.equalsIgnoreCase("LdFechaCreacion")
                    && !name.equalsIgnoreCase("LdFechaModifica")) 
                        stmt.setObject(index++, field.get(entity));
            }
            return (stmt.executeUpdate() > 0);
        } catch (SQLException | IllegalAccessException e) {
            throw new AppException(null, e, getClass(), "create");
        }
    }

    @Override
    public boolean update(T entity) throws AppException {
        try {
            Field[] fields = DTOClass.getDeclaredFields();
            StringBuilder updates = new StringBuilder();
            Object pkValue = null;

            for (Field field : fields) {
                String name = field.getName();

                if (!name.equalsIgnoreCase(tablePK)) {
                    // Evitamos duplicar la actualización de la fecha si ya viene en el loop
                    if (!name.equalsIgnoreCase("LdFechaModifica"))
                        updates.append(name).append(" = ?, ");
                } else {
                    if (!field.canAccess(entity)) {
                        field.setAccessible(true);
                    }
                    pkValue = field.get(entity);
                }
            }

            updates.append("LdFechaModifica = ?"); 

            String sql = String.format("UPDATE %s SET %s WHERE %s = ?", tableName, updates, tablePK);

            try (PreparedStatement stmt = openConnection().prepareStatement(sql)) {
                int index = 1;
                for (Field field : fields) {
                    String name = field.getName();
                    if (!name.equalsIgnoreCase(tablePK) && !name.equalsIgnoreCase("LdFechaModifica")) {
                        if (!field.canAccess(entity)) {
                            field.setAccessible(true);
                        }
                        stmt.setObject(index++, field.get(entity));
                    }
                }

                stmt.setString(index++, getDataTimeNow()); 
                stmt.setObject(index, pkValue); 

                return stmt.executeUpdate() > 0;
            }

        }   catch (SQLException | IllegalAccessException e) {
            throw new AppException(null, e, getClass(), "update");
        }
    }

    @Override
    public boolean delete(Integer id) throws AppException {
        String sql = String.format("UPDATE %s SET LdEstado = ?, LdFechaModifica = ? WHERE %s = ?", tableName, tablePK);
        try (PreparedStatement stmt = openConnection().prepareStatement(sql)) {
            stmt.setString(1, "X");
            stmt.setString(2, getDataTimeNow());
            stmt.setInt   (3, id);
            return stmt.executeUpdate() > 0;
        }catch (SQLException e) {
            throw new AppException(null, e, getClass(), "delete");
        }
    }

    @Override
    public T readBy(Integer id) throws AppException {
        String sql = String.format("SELECT * FROM %s WHERE %s = ? AND LdEstado = 'A'", tableName, tablePK);
        try (PreparedStatement stmt = openConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() ? mapResultSetToEntity(rs) : null;
            }
        }catch (SQLException e) {
            throw new AppException(null, e, getClass(), "readBy");
        }
    }

    @Override
    public List<T> readAll() throws AppException {
        List<T> list = new ArrayList<>();
        String sql = String.format("SELECT * FROM %s WHERE LdEstado = 'A'", tableName);
        try (PreparedStatement stmt = openConnection().prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                list.add(mapResultSetToEntity(rs));
            }
        } catch (SQLException e) {
            throw new AppException(null, e, getClass(), "readAll");
        }
        return list;
    }

    @Override
    public Integer getMaxReg() throws AppException {
        String sql = String.format("SELECT COUNT(*) FROM %s WHERE LdEstado = 'A'", tableName);
        try (PreparedStatement stmt = openConnection().prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            return rs.next() ? rs.getInt(1) : 0;
        } catch (SQLException e) {
            throw new AppException(null, e, getClass(), "getMaxReg");
        }
    }

    protected T mapResultSetToEntity(ResultSet rs) throws AppException {
        try {
            T instance = DTOClass.getDeclaredConstructor().newInstance();
            ResultSetMetaData meta = rs.getMetaData();

            for (int i = 1; i <= meta.getColumnCount(); i++) {
                String col = meta.getColumnLabel(i); 
                Object val = rs.getObject(i);

                try {
                    Field field = DTOClass.getDeclaredField(col);
                    if (!field.canAccess(instance)) {
                        field.setAccessible(true);
                    }
                    field.set(instance, val);
                } catch (NoSuchFieldException e) {
                    // Ignorar columnas que no están en el DTO (como campos de auditoría extras)
                }
            }
            return instance;
        } catch (SQLException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new AppException(null, e, getClass(), "mapResultSetToEntity");
        }
    }
}