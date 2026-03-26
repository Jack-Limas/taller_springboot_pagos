package co.ucc.apppedidos.services;

import co.ucc.apppedidos.model.Venta;
import co.ucc.apppedidos.repository.VentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService implements IVentaService {

    private final VentaRepository repository;

    public VentaService(VentaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Venta> listar() {
        return repository.listar();
    }

    @Override
    public Venta guardar(Venta venta) {
        return repository.guardar(venta);
    }

    @Override
    public Venta buscarPorId(Long id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));
    }
}