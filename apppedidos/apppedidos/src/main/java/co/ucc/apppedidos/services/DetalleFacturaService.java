package co.ucc.apppedidos.services;

import co.ucc.apppedidos.model.DetalleFactura;
import co.ucc.apppedidos.repository.DetalleFacturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleFacturaService implements IDetalleFacturaService {

    private final DetalleFacturaRepository repository;

    public DetalleFacturaService(DetalleFacturaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DetalleFactura> listar() {
        return repository.listar();
    }

    @Override
    public DetalleFactura guardar(DetalleFactura detalle) {
        return repository.guardar(detalle);
    }

    @Override
    public DetalleFactura buscarPorId(Long id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Detalle no encontrado"));
    }
}