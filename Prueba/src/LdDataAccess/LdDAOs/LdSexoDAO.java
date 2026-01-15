package LdDataAccess.LdDAOs;

import LdDataAccess.LdDTOs.LdSexoDTO;
import LdDataAccess.LdHelpers.DataHelperSQLiteDAO;
import LdInfrastructure.AppException;

public class LdSexoDAO extends DataHelperSQLiteDAO<LdSexoDTO>{
    public LdSexoDAO() throws AppException {
        super(LdSexoDTO.class, "LdSexo", "IdLdSexo");
    }
}