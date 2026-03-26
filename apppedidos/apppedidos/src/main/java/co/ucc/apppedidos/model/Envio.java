package co.ucc.apppedidos.model;

import java.util.Date;

public class Envio {

    private Long idEnvio;
    private Factura factura;
    private Distribuidor distribuidor;
    private Vehiculo vehiculo;
    private Date fechaEnvio;
    private String estado; // En preparación, En camino, Entregado

    public Envio() {
        this.fechaEnvio = new Date();
        this.estado = "En preparación";
    }

    public Envio(Long idEnvio, Factura factura, Distribuidor distribuidor, Vehiculo vehiculo) {
        this.idEnvio = idEnvio;
        this.factura = factura;
        this.distribuidor = distribuidor;
        this.vehiculo = vehiculo;
        this.fechaEnvio = new Date();
        this.estado = "En preparación";
    }

    // Cambiar estado
    public void actualizarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    // Getters y Setters

    public Long getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(Long idEnvio) {
        this.idEnvio = idEnvio;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Distribuidor getDistribuidor() {
        return distribuidor;
    }

    public void setDistribuidor(Distribuidor distribuidor) {
        this.distribuidor = distribuidor;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public String getEstado() {
        return estado;
    }
}