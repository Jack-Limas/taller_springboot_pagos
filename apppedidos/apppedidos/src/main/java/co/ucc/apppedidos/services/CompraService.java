package co.ucc.apppedidos.services;

import co.ucc.apppedidos.model.Compra;
import co.ucc.apppedidos.model.DetalleCompra;
import co.ucc.apppedidos.repository.CompraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraService implements ICompraService {

    private final CompraRepository repository;

    public CompraService(CompraRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Compra> listar() {
        return repository.listar();
    }

    @Override
    public Compra guardar(Compra compra) {

        // Reducir stock de cada producto
        for (DetalleCompra detalle : compra.getDetalles()) {
            detalle.getProducto().reducirStock(detalle.getCantidad());
        }

        return repository.guardar(compra);
    }

    @Override
    public Compra buscarPorId(Long id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Compra no encontrada"));
    }
}