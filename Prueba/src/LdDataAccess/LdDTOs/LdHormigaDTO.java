package LdDataAccess.LdDTOs;

public class LdHormigaDTO {

    private Integer IdLdHormiga     ; 
    private Integer IdLdHormigaTipo ; 
    private Integer IdLdSexo        ; 
    private Integer IdLdEstado      ; 
    private String  LdNombre        ; 
    private String  LdDescripcion   ; 
    private String  LdEstado        ; 
    private String  LdFechaCreacion ; 
    private String  LdFechaModifica ;

    public LdHormigaDTO(){}
    
    public LdHormigaDTO(Integer idLdHormiga, Integer idLdHormigaTipo, Integer idLdSexo, Integer idLdEstado,
            String ldNombre, String ldDescripcion) {
        this.IdLdHormiga = idLdHormiga;
        this.IdLdHormigaTipo = idLdHormigaTipo;
        this.IdLdSexo = idLdSexo;
        this.IdLdEstado = idLdEstado;
        this.LdNombre = ldNombre;
        this.LdDescripcion = ldDescripcion;
    }

    public LdHormigaDTO(Integer idLdHormiga, Integer idLdHormigaTipo, Integer idLdSexo, Integer idLdEstado,
            String ldNombre, String ldDescripcion, String ldEstado, String ldFechaCreacion, String ldFechaModifica) {
        this.IdLdHormiga = idLdHormiga;
        this.IdLdHormigaTipo = idLdHormigaTipo;
        this.IdLdSexo = idLdSexo;
        this.IdLdEstado = idLdEstado;
        this.LdNombre = ldNombre;
        this.LdDescripcion = ldDescripcion;
        this.LdEstado = ldEstado;
        this.LdFechaCreacion = ldFechaCreacion;
        this.LdFechaModifica = ldFechaModifica;
    }

    public Integer getIdLdHormiga() {
        return IdLdHormiga;
    }

    public void setIdLdHormiga(Integer idLdHormiga) {
        IdLdHormiga = idLdHormiga;
    }

    public Integer getIdLdHormigaTipo() {
        return IdLdHormigaTipo;
    }

    public void setIdLdHormigaTipo(Integer idLdHormigaTipo) {
        IdLdHormigaTipo = idLdHormigaTipo;
    }

    public Integer getIdLdSexo() {
        return IdLdSexo;
    }

    public void setIdLdSexo(Integer idLdSexo) {
        IdLdSexo = idLdSexo;
    }

    public Integer getIdLdEstado() {
        return IdLdEstado;
    }

    public void setIdLdEstado(Integer idLdEstado) {
        IdLdEstado = idLdEstado;
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
        + "\n IdLdHormiga     : "+ getIdLdHormiga()
        + "\n IdLdHormigaTipo : "+ getIdLdHormigaTipo()
        + "\n IdLdSexo        : "+ getIdLdSexo()
        + "\n IdLdEstado      : "+ getIdLdEstado()  
        + "\n LdNombre        : "+ getLdNombre()
        + "\n LdDescripcion   : "+ getLdDescripcion()
        + "\n LdEstado        : "+ getLdEstado()
        + "\n LdFechaCreacion : "+ getLdFechaCreacion()
        + "\n LdFechaModifica : "+ getLdFechaModifica();
    }
}