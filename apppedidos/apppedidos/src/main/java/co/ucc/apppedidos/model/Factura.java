package co.ucc.apppedidos.model;

import java.util.Date;

public class Factura {

    private Long idFactura;
    private String numeroFactura;
    private Date fecha;
    private Venta venta;

    public Factura() {
        this.fecha = new Date();
    }

    public Factura(Long idFactura, String numeroFactura, Venta venta) {
        this.idFactura = idFactura;
        this.numeroFactura = numeroFactura;
        this.venta = venta;
        this.fecha = new Date();
    }

    // Obtener total desde la venta
    public double obtenerTotal() {
        return venta != null ? venta.getTotal() : 0;
    }

    // Getters y Setters

    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
}