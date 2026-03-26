package co.ucc.apppedidos.model;

import java.util.Date;

public class Inventario {

    private Long idInventario;
    private Date fechaActualizacion;

    public Inventario() {
        this.fechaActualizacion = new Date();
    }

    public Inventario(Long idInventario) {
        this.idInventario = idInventario;
        this.fechaActualizacion = new Date();
    }

    // Agregar stock a un producto
    public void agregarProducto(Producto producto, int cantidad) {
        producto.setStock(producto.getStock() + cantidad);
        actualizarFecha();
    }

    // Actualizar stock directamente
    public void actualizarStock(Producto producto, int nuevoStock) {
        producto.setStock(nuevoStock);
        actualizarFecha();
    }

    // Consultar stock
    public int consultarStock(Producto producto) {
        return producto.getStock();
    }

    private void actualizarFecha() {
        this.fechaActualizacion = new Date();
    }

    // Getters y Setters

    public Long getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(Long idInventario) {
        this.idInventario = idInventario;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}