package LdDataAccess.LdDTOs;

public class LdAntCiberDronDTO {
    private Integer IdLdAntCiberDron;
    private String  LdSerie;
    private String  LdEstado;
    private String  LdFechaCreacion;
    private String  LdFechaModifica;

    public LdAntCiberDronDTO(){}

    public LdAntCiberDronDTO(String ldSerie) {
        this.IdLdAntCiberDron = 0;
        this.LdSerie = ldSerie;
    }

    public LdAntCiberDronDTO(Integer idLdAntCiberDron, String ldSerie, String ldEstado, String ldFechaCreacion,
                            String ldFechaModifica) {
        this.IdLdAntCiberDron = idLdAntCiberDron;
        this.LdSerie = ldSerie;
        this.LdEstado = ldEstado;
        this.LdFechaCreacion = ldFechaCreacion;
        this.LdFechaModifica = ldFechaModifica;
    }

    public Integer getIdLdAntCiberDron() {
        return IdLdAntCiberDron;
    }
    public void setIdLdAntCiberDron(Integer idLdAntCiberDron) {
        IdLdAntCiberDron = idLdAntCiberDron;
    }
    public String getLdSerie() {
        return LdSerie;
    }
    public void setLdSerie(String ldSerie) {
        this.LdSerie = ldSerie;
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
        + "\n IdLdAntCiberDron: " + getIdLdAntCiberDron()
        + "\n LdSerie          : " + getLdSerie()
        + "\n LdEstado         : " + getLdEstado()
        + "\n LdFechaCreacion  : " + getLdFechaCreacion()
        + "\n LdFechaModifica  : " + getLdFechaModifica()
        + "\n --------------------------- " ;
    }
}