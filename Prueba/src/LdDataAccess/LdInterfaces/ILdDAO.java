package LdDataAccess.LdInterfaces;

import java.util.List;
import LdInfrastructure.AppException;

public interface ILdDAO<T> {
    List<T> readAll()            throws AppException;
    T       readBy (Integer id)  throws AppException;
    boolean create (T entity)    throws AppException;
    boolean update (T entity)    throws AppException;
    boolean delete (Integer id)  throws AppException;
    Integer getMaxReg()          throws AppException;
}