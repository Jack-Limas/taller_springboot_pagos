package co.ucc.apppedidos.services;

import co.ucc.apppedidos.model.Proveedor;
import co.ucc.apppedidos.repository.ProveedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService implements IProveedorService {

    private final ProveedorRepository repository;

    public ProveedorService(ProveedorRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Proveedor> listar() {
        return repository.listar();
    }

    @Override
    public Proveedor guardar(Proveedor proveedor) {
        return repository.guardar(proveedor);
    }

    @Override
    public Proveedor buscarPorId(Long id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
    }
}