package co.ucc.apppedidos.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venta {

    private Long idVenta;
    private Date fecha;
    private double total;

    private Vendedor vendedor;
    private List<DetalleFactura> detalles;

    public Venta() {
        this.fecha = new Date();
        this.detalles = new ArrayList<>();
    }

    public Venta(Long idVenta) {
        this.idVenta = idVenta;
        this.fecha = new Date();
        this.detalles = new ArrayList<>();
    }

    // Agregar detalle a la venta
    public void agregarDetalle(DetalleFactura detalle) {
        detalles.add(detalle);
        calcularTotal();
    }

    // Calcular total de la venta
    public void calcularTotal() {
        total = 0;
        for (DetalleFactura d : detalles) {
            total += d.getSubtotal();
        }
    }

    // Getters y Setters

    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public List<DetalleFactura> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleFactura> detalles) {
        this.detalles = detalles;
        calcularTotal();
    }
}