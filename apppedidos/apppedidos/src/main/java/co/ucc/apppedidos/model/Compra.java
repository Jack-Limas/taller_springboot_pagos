package co.ucc.apppedidos.model;

import java.util.ArrayList;
import java.util.List;

public class Compra {

    private Long id;
    private Cliente cliente;
    private List<DetalleCompra> detalles = new ArrayList<>();

    public Compra() {}

    public Compra(Long id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
    }

    // Método para agregar productos
    public void agregarDetalle(DetalleCompra detalle) {
        detalles.add(detalle);
    }

    // Método para calcular total
    public double calcularTotal() {
        return detalles.stream()
                .mapToDouble(DetalleCompra::calcularSubtotal)
                .sum();
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetalleCompra> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleCompra> detalles) {
        this.detalles = detalles;
    }
}