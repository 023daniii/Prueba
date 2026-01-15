package LdDataAccess.LdDAOs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import LdDataAccess.LdDTOs.LdHormigaDTO;
import LdDataAccess.LdDTOs.LdVWHormigaDTO;
import LdDataAccess.LdHelpers.DataHelperSQLiteDAO;
import LdInfrastructure.AppException;

public class LdHormigaDAO extends DataHelperSQLiteDAO<LdHormigaDTO>{
    public LdHormigaDAO() throws AppException {
        super(LdHormigaDTO.class, "LdHormiga", "IdLdHormiga");
    }

    public List<LdVWHormigaDTO> readAllvwHormiga() throws AppException {
        LdVWHormigaDTO dto;
        List<LdVWHormigaDTO> lst = new ArrayList<>();
        String query = " SELECT IdLdHormiga"
                     +"  ,LdTipo         "   
                     +"  ,LdSexo         "
                     +"  ,LdEstadoHormiga"   
                     +"  ,LdNombre       "
                     +"  ,LdDescripcion  "
                     +"  ,LdEstado       "
                     +"  ,LdFechaCreacion"   
                     +"  ,LdFechaModifica" 
                     +"  FROM LdvwHormiga";
        try {
            Connection conn = openConnection();     
            Statement  stmt = conn.createStatement();    
            ResultSet rs    = stmt.executeQuery(query);  
            while (rs.next()) {
                dto = new LdVWHormigaDTO(rs.getString(1)       // IdHormiga
                                        ,rs.getString(2)       // Tipo            
                                        ,rs.getString(3)       // Sexo        
                                        ,rs.getString(4)       // EstadoHormiga 
                                        ,rs.getString(5)       // Nombre 
                                        ,rs.getString(6)       // Descripcion
                                        ,rs.getString(7)       // Estado
                                        ,rs.getString(8)       // FechaCreacion
                                        ,rs.getString(9)       // FechaModifica
                                      ); 
                lst.add(dto);
            }
        } 
        catch (SQLException e) {
            throw new AppException("Ups... problemas con la vista", e, getClass(), "readAllvwHormiga()");
        }
        return lst;
    }
}