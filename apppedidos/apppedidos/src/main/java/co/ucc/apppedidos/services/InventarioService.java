package co.ucc.apppedidos.services;

import co.ucc.apppedidos.model.Inventario;
import co.ucc.apppedidos.repository.InventarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioService implements IInventarioService {

    private final InventarioRepository repository;

    public InventarioService(InventarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Inventario> listar() {
        return repository.listar();
    }

    @Override
    public Inventario guardar(Inventario inventario) {
        return repository.guardar(inventario);
    }

    @Override
    public Inventario buscarPorId(Long id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Inventario no encontrado"));
    }
}