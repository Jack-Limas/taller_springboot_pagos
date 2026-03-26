package co.ucc.apppedidos.repository;

import co.ucc.apppedidos.model.DetalleFactura;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DetalleFacturaRepository {

    private List<DetalleFactura> detalles = new ArrayList<>();

    public List<DetalleFactura> listar() {
        return detalles;
    }

    public DetalleFactura guardar(DetalleFactura detalle) {
        detalles.add(detalle);
        return detalle;
    }

    public Optional<DetalleFactura> buscarPorId(Long id) {
        return detalles.stream()
                .filter(d -> d.getIdDetalle().equals(id))
                .findFirst();
    }
}