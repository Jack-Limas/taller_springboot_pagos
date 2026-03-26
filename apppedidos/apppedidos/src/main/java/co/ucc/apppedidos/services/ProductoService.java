package co.ucc.apppedidos.services;

import co.ucc.apppedidos.model.Producto;
import co.ucc.apppedidos.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Producto> listar() {
        return repository.listar();
    }

    @Override
    public Producto guardar(Producto producto) {
        return repository.guardar(producto);
    }

    @Override
    public Producto buscarPorId(Long id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @Override
    public void eliminar(Long id) {
        repository.eliminar(id);
    }
}