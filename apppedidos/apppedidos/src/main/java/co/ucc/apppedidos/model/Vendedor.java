package co.ucc.apppedidos.model;


public class Vendedor {

    private Long idVendedor;
    private String nombre;

    public Vendedor() {}

    public Vendedor(Long idVendedor, String nombre) {
        this.idVendedor = idVendedor;
        this.nombre = nombre;
    }

    // Método de negocio
    public void registrarVenta(Venta venta) {
        venta.setVendedor(this);
    }

    // Getters y Setters

    public Long getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Long idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}