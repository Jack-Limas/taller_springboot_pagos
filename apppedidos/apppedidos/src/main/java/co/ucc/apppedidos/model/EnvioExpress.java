package co.ucc.apppedidos.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
@DiscriminatorValue("EXPRESS")
public class EnvioExpress extends Envio {

    public EnvioExpress() {
    }

    public EnvioExpress(Long idEnvio, Date fechaEnvio, String estado, Pedido pedido, Distribuidor distribuidor,
                        String codigoRastreo, double peso, double volumen) {
        super(idEnvio, fechaEnvio, estado, pedido, distribuidor, codigoRastreo, peso, volumen);
    }

    @Override
    public double calcularCosto() {
        return getPeso() * getVolumen() * 8000;
    }
}
