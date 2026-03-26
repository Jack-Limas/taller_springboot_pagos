package co.ucc.apppedidos.repository;

import co.ucc.apppedidos.model.Factura;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FacturaRepository {

    private List<Factura> facturas = new ArrayList<>();

    public List<Factura> listar() {
        return facturas;
    }

    public Factura guardar(Factura factura) {
        facturas.add(factura);
        return factura;
    }

    public Optional<Factura> buscarPorId(Long id) {
        return facturas.stream()
                .filter(f -> f.getIdFactura().equals(id))
                .findFirst();
    }
}