package co.ucc.apppedidos.model;

public class DetalleFactura {

    private Long idDetalle;
    private Producto producto;
    private int cantidad;
    private double precioUnitario;
    private double subtotal;

    public DetalleFactura() {}

    public DetalleFactura(Long idDetalle, Producto producto, int cantidad) {
        this.idDetalle = idDetalle;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = producto.getPrecio();
        calcularSubtotal();
    }

    // Calcular subtotal
    public void calcularSubtotal() {
        this.subtotal = precioUnitario * cantidad;
    }

    // Getters y Setters

    public Long getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Long idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
        this.precioUnitario = producto.getPrecio();
        calcularSubtotal();
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        calcularSubtotal();
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public double getSubtotal() {
        return subtotal;
    }
}