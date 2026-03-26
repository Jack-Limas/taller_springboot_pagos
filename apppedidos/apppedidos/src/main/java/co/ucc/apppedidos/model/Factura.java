package co.ucc.apppedidos.model;

import java.util.Date;
import java.util.List;

public class Factura {

    private Long idFactura;
    private Date fecha;
    private double total;
    private Pedido pedido;
    private List<DetalleFactura> detalles;

    public Factura() {
    }

    public Factura(Long idFactura, Date fecha, double total, Pedido pedido, List<DetalleFactura> detalles) {
        this.idFactura = idFactura;
        this.fecha = fecha;
        this.total = total;
        this.pedido = pedido;
        this.detalles = detalles;
    }

    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
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

    public void setTotal(double total) {
        this.total = total;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<DetalleFactura> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleFactura> detalles) {
        this.detalles = detalles;
    }
}
