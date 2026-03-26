package co.ucc.apppedidos.model;

import java.util.Date;

public class Pago {

    private Long idPago;
    private Date fecha;
    private double monto;
    private String estado;
    private String tipo;
    private Pedido pedido;

    public Pago() {
    }

    public Pago(Long idPago, Date fecha, double monto, String estado, String tipo, Pedido pedido) {
        this.idPago = idPago;
        this.fecha = fecha;
        this.monto = monto;
        this.estado = estado;
        this.tipo = tipo;
        this.pedido = pedido;
    }

    public Long getIdPago() {
        return idPago;
    }

    public void setIdPago(Long idPago) {
        this.idPago = idPago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
