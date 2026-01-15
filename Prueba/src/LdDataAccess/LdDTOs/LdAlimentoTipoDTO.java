package LdDataAccess.LdDTOs;

public class LdAlimentoTipoDTO {
    private Integer IdLdAlimentoTipo; 
    private String LdNombre;          
    private String LdDescripcion;     
    private String LdEstado;          
    private String LdFechaCreacion;
    private String LdFechaModifica;

    public LdAlimentoTipoDTO(){}

    public LdAlimentoTipoDTO(Integer idLdAlimentoTipo, String ldNombre, String ldDescripcion) {
        this.IdLdAlimentoTipo = 0;
        this.LdNombre = ldNombre;
        this.LdDescripcion = ldDescripcion;
    }

    public LdAlimentoTipoDTO(Integer idLdAlimentoTipo, String ldNombre, String ldDescripcion, String ldEstado,
        String ldFechaCreacion, String ldFechaModifica) {
        this.IdLdAlimentoTipo = idLdAlimentoTipo;
        this.LdNombre = ldNombre;
        this.LdDescripcion = ldDescripcion;
        this.LdEstado = ldEstado;
        this.LdFechaCreacion = ldFechaCreacion;
        this.LdFechaModifica = ldFechaModifica;
    }

    public Integer getIdLdAlimentoTipo() {
        return IdLdAlimentoTipo;
    }
    public void setIdLdAlimentoTipo(Integer idLdAlimentoTipo) {
        IdLdAlimentoTipo = idLdAlimentoTipo;
    }
    public String getLdNombre() {
        return LdNombre;
    }
    public void setLdNombre(String ldNombre) {
        this.LdNombre = ldNombre;
    }
    public String getLdDescripcion() {
        return LdDescripcion;
    }
    public void setLdDescripcion(String ldDescripcion) {
        this.LdDescripcion = ldDescripcion;
    }
    public String getLdEstado() {
        return LdEstado;
    }
    public void setLdEstado(String ldEstado) {
        this.LdEstado = ldEstado;
    }
    public String getLdFechaCreacion() {
        return LdFechaCreacion;
    }
    public void setLdFechaCreacion(String ldFechaCreacion) {
        this.LdFechaCreacion = ldFechaCreacion;
    }
    public String getLdFechaModifica() {
        return LdFechaModifica;
    }
    public void setLdFechaModifica(String ldFechaModifica) {
        this.LdFechaModifica = ldFechaModifica;
    }

    @Override
    public String toString() {
        return getClass().getName()
        + "\n IdLdAlimentoTipo: "+ getIdLdAlimentoTipo()
        + "\n LdNombre         : "+ getLdNombre()
        + "\n LdDescripcion    : "+ getLdDescripcion()
        + "\n LdEstado         : "+ getLdEstado()
        + "\n LdFechaCreacion  : "+ getLdFechaCreacion()
        + "\n LdFechaModifica  : "+ getLdFechaModifica()
        + "\n --------------------------- " ;
    }
}