package co.ucc.apppedidos.repository;

import co.ucc.apppedidos.model.Envio;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class EnvioRepository {

    private final List<Envio> envios = new ArrayList<>();

    public List<Envio> listar() {
        return new ArrayList<>(envios);
    }

    public Envio guardar(Envio envio) {
        if (envio.getIdEnvio() != null) {
            envios.removeIf(actual -> Objects.equals(actual.getIdEnvio(), envio.getIdEnvio()));
        }
        envios.add(envio);
        return envio;
    }

    public Envio buscarPorId(Long idEnvio) {
        return envios.stream()
                .filter(envio -> Objects.equals(envio.getIdEnvio(), idEnvio))
                .findFirst()
                .orElse(null);
    }

    public Envio buscarPorPedido(Long idPedido) {
        return envios.stream()
                .filter(envio -> envio.getPedido() != null && Objects.equals(envio.getPedido().getIdPedido(), idPedido))
                .findFirst()
                .orElse(null);
    }
}
