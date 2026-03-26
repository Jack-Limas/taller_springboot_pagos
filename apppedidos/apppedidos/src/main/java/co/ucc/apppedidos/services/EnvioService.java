package co.ucc.apppedidos.services;

import co.ucc.apppedidos.model.Envio;
import co.ucc.apppedidos.repository.EnvioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnvioService implements IEnvioService {

    private final EnvioRepository repository;

    public EnvioService(EnvioRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Envio> listar() {
        return repository.listar();
    }

    @Override
    public Envio guardar(Envio envio) {
        return repository.guardar(envio);
    }

    @Override
    public Envio buscarPorId(Long id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Envío no encontrado"));
    }
}
