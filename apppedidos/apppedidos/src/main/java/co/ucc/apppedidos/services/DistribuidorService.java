package co.ucc.apppedidos.services;

import co.ucc.apppedidos.model.Distribuidor;
import co.ucc.apppedidos.repository.DistribuidorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistribuidorService implements IDistribuidorService {

    private final DistribuidorRepository repository;

    public DistribuidorService(DistribuidorRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Distribuidor> listar() {
        return repository.listar();
    }

    @Override
    public Distribuidor guardar(Distribuidor distribuidor) {
        return repository.guardar(distribuidor);
    }

    @Override
    public Distribuidor buscarPorId(Long id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Distribuidor no encontrado"));
    }
}