package LdDataAccess.LdDAOs;

import LdDataAccess.LdDTOs.LdAlimentoTipoDTO;
import LdDataAccess.LdHelpers.DataHelperSQLiteDAO;
import LdInfrastructure.AppException;

public class LdAlimentoTipoDAO extends DataHelperSQLiteDAO <LdAlimentoTipoDTO>{
    public LdAlimentoTipoDAO() throws AppException{
        super(LdAlimentoTipoDTO.class, "LdAlimentoTipo", "IdLdAlimentoTipo");
    }
}