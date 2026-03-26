package co.ucc.apppedidos.model;

public class DetalleCompra {

    private Producto producto;
    private int cantidad;

    public DetalleCompra() {}

    public DetalleCompra(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    // Método de negocio
    public double calcularSubtotal() {
        return producto.getPrecio() * cantidad;
    }

    // Getters y Setters

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}