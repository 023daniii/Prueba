package LdBussinessLogic.LdEntities;

public class LdCoordenadaUK {
    private String LdGeoposicion;
    private String LdTipoArsenal;
    private Boolean LdAccion;

    public LdCoordenadaUK(String LdGeoposicion, String LdTipoArsenal, Boolean LdAccion) {
        this.LdGeoposicion = LdGeoposicion;
        this.LdTipoArsenal = LdTipoArsenal;
        this.LdAccion = LdAccion;
    }

    @Override
    public String toString(){
        return getClass().getName()
        + "\n LdGeoposicion      : " + getLdGeoposicion()
        + "\n LdTipoArsenal      : " + getLdTipoArsenal()
        + "\n LdAccion           : " + getLdAccion();
    }

    public String getLdGeoposicion() {
        return LdGeoposicion;
    }

    public void setLdGeoposicion(String LdGeoposicion) {
        this.LdGeoposicion = LdGeoposicion;
    }

    public String getLdTipoArsenal() {
        return LdTipoArsenal;
    }

    public void setLdTipoArsenal(String LdTipoArsenal) {
        this.LdTipoArsenal = LdTipoArsenal;
    }

    public Boolean getLdAccion() {
        return LdAccion;
    }

    public void setLdAccion(Boolean LdAccion) {
        this.LdAccion = LdAccion;
    }
}
