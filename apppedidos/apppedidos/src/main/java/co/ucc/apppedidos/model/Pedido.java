package co.ucc.apppedidos.model;

import java.util.Date;
import java.util.List;

public class Pedido {

    private Long idPedido;
    private Date fecha;
    private double total;
    private String estado;
    private Cliente cliente;
    private List<DetallePedido> detalles;

    public Pedido() {
    }

    public Pedido(Long idPedido, Date fecha, double total, String estado, Cliente cliente, List<DetallePedido> detalles) {
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.total = total;
        this.estado = estado;
        this.cliente = cliente;
        this.detalles = detalles;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetallePedido> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallePedido> detalles) {
        this.detalles = detalles;
    }
}
