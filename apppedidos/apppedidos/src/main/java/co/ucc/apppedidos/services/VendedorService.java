package co.ucc.apppedidos.services;

import co.ucc.apppedidos.model.Vendedor;
import co.ucc.apppedidos.repository.VendedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendedorService implements IVendedorService {

    private final VendedorRepository repository;

    public VendedorService(VendedorRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Vendedor> listar() {
        return repository.listar();
    }

    @Override
    public Vendedor guardar(Vendedor vendedor) {
        return repository.guardar(vendedor);
    }

    @Override
    public Vendedor buscarPorId(Long id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Vendedor no encontrado"));
    }
}