package LdBussinessLogic.LdEntities;

public class LdHSoldado extends LdHormiga {
    
    @Override
    public boolean vive(String alimento, String genoma) {
        // Lógica original: el soldado no sobrevive bajo estas condiciones base
        return false;
    }

    @Override
    public String toString() {
        return "LdHSoldado {}";
    }
}