package LdBussinessLogic.LdEntities;

// Importante que herede de LdHormiga
public class LdHLarva extends LdHormiga {

    public LdHLarva() {
        super();
        this.ldSuperHabilidad = "SuperCortadora"; // Caso E
    }

    @Override
    public boolean vive(String alimento, String genoma) {
        // Lógica Caso E: Solo vive si el alimento es Herbívoro
        return alimento.equalsIgnoreCase("Herbívoro");
    }

    @Override
    public String getLdSuperHabilidad() {
        return ldSuperHabilidad;
    }
}