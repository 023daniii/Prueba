package LdBussinessLogic.LdEntities;

public class LdHormigaObrera extends LdHormiga {

    public LdHormigaObrera() {
        super();
        this.ldSuperHabilidad = "SuperCortadora";
    }

    @Override
    public boolean vive(String alimento, String genoma) {
        // Lógica Caso E: Solo vive si come Herbívoro o Nectarívoros
        if (alimento.equalsIgnoreCase("Herbívoro") || alimento.equalsIgnoreCase("Nectarívoros")) {
            ldSuperCortadora(); // Activa la habilidad de tu caso
            return true;
        }
        System.out.println("La hormiga MUERE");
        return false;
    }
}