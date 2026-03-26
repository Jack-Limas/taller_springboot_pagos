package co.ucc.apppedidos.model;

public class Distribuidor {

    private Long idDistribuidor;
    private String nombre;
    private String tipo;
    private String contacto;

    public Distribuidor() {
    }

    public Distribuidor(Long idDistribuidor, String nombre, String tipo, String contacto) {
        this.idDistribuidor = idDistribuidor;
        this.nombre = nombre;
        this.tipo = tipo;
        this.contacto = contacto;
    }

    public Long getIdDistribuidor() {
        return idDistribuidor;
    }

    public void setIdDistribuidor(Long idDistribuidor) {
        this.idDistribuidor = idDistribuidor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
}
