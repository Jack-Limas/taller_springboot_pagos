package co.ucc.apppedidos.repository;

import co.ucc.apppedidos.model.Venta;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VentaRepository {

    private List<Venta> ventas = new ArrayList<>();

    public List<Venta> listar() {
        return ventas;
    }

    public Venta guardar(Venta venta) {
        ventas.add(venta);
        return venta;
    }

    public Optional<Venta> buscarPorId(Long id) {
        return ventas.stream()
                .filter(v -> v.getIdVenta().equals(id))
                .findFirst();
    }
}
