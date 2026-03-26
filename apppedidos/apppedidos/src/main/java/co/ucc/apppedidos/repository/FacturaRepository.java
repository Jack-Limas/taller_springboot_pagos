package co.ucc.apppedidos.repository;

import co.ucc.apppedidos.model.Factura;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class FacturaRepository {

    private final List<Factura> facturas = new ArrayList<>();

    public List<Factura> listar() {
        return new ArrayList<>(facturas);
    }

    public Factura guardar(Factura factura) {
        if (factura.getIdFactura() != null) {
            facturas.removeIf(actual -> Objects.equals(actual.getIdFactura(), factura.getIdFactura()));
        }
        facturas.add(factura);
        return factura;
    }

    public Factura buscarPorId(Long idFactura) {
        return facturas.stream()
                .filter(factura -> Objects.equals(factura.getIdFactura(), idFactura))
                .findFirst()
                .orElse(null);
    }

    public Factura buscarPorPedido(Long idPedido) {
        return facturas.stream()
                .filter(factura -> factura.getPedido() != null && Objects.equals(factura.getPedido().getIdPedido(), idPedido))
                .findFirst()
                .orElse(null);
    }
}
