package co.ucc.apppedidos.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
@DiscriminatorValue("ESTANDAR")
public class EnvioEstandar extends Envio {

    public EnvioEstandar() {
    }

    public EnvioEstandar(Long idEnvio, Date fechaEnvio, String estado, Pedido pedido, Distribuidor distribuidor,
                         String codigoRastreo, double peso, double volumen) {
        super(idEnvio, fechaEnvio, estado, pedido, distribuidor, codigoRastreo, peso, volumen);
    }

    @Override
    public double calcularCosto() {
        return getPeso() * getVolumen() * 5000;
    }
}
