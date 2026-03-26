package co.ucc.apppedidos.model;

import java.util.Date;

public class HistorialInventario {

    private Long idMovimiento;
    private Date fechaMovimiento;
    private Producto producto;
    private int cantidad;
    private String tipoMovimiento;
    private String descripcion;

    public HistorialInventario() {
    }

    public HistorialInventario(Long idMovimiento, Date fechaMovimiento, Producto producto, int cantidad,
                               String tipoMovimiento, String descripcion) {
        this.idMovimiento = idMovimiento;
        this.fechaMovimiento = fechaMovimiento;
        this.producto = producto;
        this.cantidad = cantidad;
        this.tipoMovimiento = tipoMovimiento;
        this.descripcion = descripcion;
    }

    public Long getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Long idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

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

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
