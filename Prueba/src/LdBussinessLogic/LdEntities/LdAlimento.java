package LdBussinessLogic.LdEntities;

public class LdAlimento {
    // CAMBIO: Usa 'protected' en lugar de 'private' para que LdHerbivoro pueda usarlo
    protected String ldTipo; 
    protected String ldGenoma;

    // CAMBIO: Agrega este constructor vacío para que el super() de los hijos funcione
    public LdAlimento() { }

    public LdAlimento(String ldTipo) {
        this.ldTipo = ldTipo;
    }

    public String getLdTipo() { return ldTipo; }
    public void setLdGenoma(String ldGenoma) { this.ldGenoma = ldGenoma; }
}