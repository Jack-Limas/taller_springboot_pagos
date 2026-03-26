package co.ucc.apppedidos.services;

import co.ucc.apppedidos.model.Factura;
import co.ucc.apppedidos.repository.FacturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaService implements IFacturaService {

    private final FacturaRepository repository;

    public FacturaService(FacturaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Factura> listar() {
        return repository.listar();
    }

    @Override
    public Factura guardar(Factura factura) {
        return repository.guardar(factura);
    }

    @Override
    public Factura buscarPorId(Long id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));
    }
}