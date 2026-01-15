package LdBussinessLogic.LdEntities;

import LdBussinessLogic.LdInterfaces.ILdHormiga;
import LdDataAccess.LdDTOs.LdHormigaDTO;

public abstract class LdHormiga implements ILdHormiga {
    protected LdHormigaDTO ldData;
    protected String ldSuperHabilidad;
    protected String ldSexo;

    public LdHormiga() {
        ldData = new LdHormigaDTO();
    }

    public String getLdSuperHabilidad() {
        return ldSuperHabilidad;
    }

    public String getLdSexo() {
        return ldSexo;
    }

    public void ldSuperCortadora() {
        System.out.println("La hormiga vive");
        System.out.println("Superhabilidad: SuperCortadora");
    }

    @Override
    public abstract boolean vive(String alimento, String genoma);
}