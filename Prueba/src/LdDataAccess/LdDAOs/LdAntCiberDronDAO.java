package LdDataAccess.LdDAOs;

import LdDataAccess.LdDTOs.LdAntCiberDronDTO;
import LdDataAccess.LdHelpers.DataHelperSQLiteDAO;
import LdInfrastructure.AppException;

public class LdAntCiberDronDAO extends DataHelperSQLiteDAO<LdAntCiberDronDTO> {
    
    public LdAntCiberDronDAO() throws AppException {
        
        super(LdAntCiberDronDTO.class, "LdAntCiberDron", "IdLdAntCiberDron");
    }
}