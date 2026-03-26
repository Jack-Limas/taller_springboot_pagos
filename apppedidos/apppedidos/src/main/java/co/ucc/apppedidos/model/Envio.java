package co.ucc.apppedidos.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Date;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipoEnvio")
@JsonSubTypes({
        @JsonSubTypes.Type(value = EnvioEstandar.class, name = "ESTANDAR"),
        @JsonSubTypes.Type(value = EnvioExpress.class, name = "EXPRESS"),
        @JsonSubTypes.Type(value = EnvioInternacional.class, name = "INTERNACIONAL"),
        @JsonSubTypes.Type(value = EnvioDron.class, name = "DRON")
})
public abstract class Envio {

    private Long idEnvio;
    private Date fechaEnvio;
    private String estado;
    private Pedido pedido;
    private Distribuidor distribuidor;
    private String codigoRastreo;
    private double peso;
    private double volumen;

    public Envio() {
    }

    public Envio(Long idEnvio, Date fechaEnvio, String estado, Pedido pedido, Distribuidor distribuidor,
                 String codigoRastreo, double peso, double volumen) {
        this.idEnvio = idEnvio;
        this.fechaEnvio = fechaEnvio;
        this.estado = estado;
        this.pedido = pedido;
        this.distribuidor = distribuidor;
        this.codigoRastreo = codigoRastreo;
        this.peso = peso;
        this.volumen = volumen;
    }

    public Long getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(Long idEnvio) {
        this.idEnvio = idEnvio;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Distribuidor getDistribuidor() {
        return distribuidor;
    }

    public void setDistribuidor(Distribuidor distribuidor) {
        this.distribuidor = distribuidor;
    }

    public String getCodigoRastreo() {
        return codigoRastreo;
    }

    public void setCodigoRastreo(String codigoRastreo) {
        this.codigoRastreo = codigoRastreo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public abstract double calcularCosto();
}
