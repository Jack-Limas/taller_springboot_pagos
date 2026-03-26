package co.ucc.apppedidos.repository;

import co.ucc.apppedidos.model.Envio;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EnvioRepository {

    private List<Envio> envios = new ArrayList<>();

    public List<Envio> listar() {
        return envios;
    }

    public Envio guardar(Envio envio) {
        envios.add(envio);
        return envio;
    }

    public Optional<Envio> buscarPorId(Long id) {
        return envios.stream()
                .filter(e -> e.getIdEnvio().equals(id))
                .findFirst();
    }
}