package LdBussinessLogic;

import java.util.List;

import LdDataAccess.LdInterfaces.ILdDAO;
import LdInfrastructure.AppException;

public class LdFactoryBL<T> {
    private final ILdDAO<T> oDAO;

    public LdFactoryBL(Class<? extends ILdDAO<T>> classDAO) {
        try {
            this.oDAO = classDAO.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            LdInfrastructure.AppException er = new LdInfrastructure.AppException("Error al instanciar classDAO<T>", e, getClass(), "LdFactoryBL(...)");
            throw new RuntimeException(er);
        }
    }

    // Constructor que usa un Supplier para crear la instancia de T
    // public LdFactoryBL(Supplier<ILdDAO<T>> supplier) {
    //     this.oDAO = supplier.get(); 
    // }
 
    public List<T> getAll() throws LdInfrastructure.AppException {
         return oDAO.readAll();
    }

    public T getBy(Integer id) throws LdInfrastructure.AppException {
        return oDAO.readBy(id);
    }

    public boolean add(T oT) throws LdInfrastructure.AppException {
        return oDAO.create(oT);
    }

    public boolean upd(T oT) throws LdInfrastructure.AppException {
        return oDAO.update(oT);
    }

    public boolean del(Integer id) throws LdInfrastructure.AppException {
        return oDAO.delete(id);
    }
}