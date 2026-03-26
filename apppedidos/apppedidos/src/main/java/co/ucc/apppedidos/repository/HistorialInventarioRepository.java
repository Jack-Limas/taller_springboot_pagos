package co.ucc.apppedidos.repository;

import co.ucc.apppedidos.model.HistorialInventario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class HistorialInventarioRepository {

    private final List<HistorialInventario> movimientos = new ArrayList<>();

    public List<HistorialInventario> listar() {
        return new ArrayList<>(movimientos);
    }

    public HistorialInventario guardar(HistorialInventario historialInventario) {
        if (historialInventario.getIdMovimiento() != null) {
            movimientos.removeIf(actual -> Objects.equals(actual.getIdMovimiento(), historialInventario.getIdMovimiento()));
        }
        movimientos.add(historialInventario);
        return historialInventario;
    }

    public HistorialInventario buscarPorId(Long idMovimiento) {
        return movimientos.stream()
                .filter(movimiento -> Objects.equals(movimiento.getIdMovimiento(), idMovimiento))
                .findFirst()
                .orElse(null);
    }

    public List<HistorialInventario> buscarPorProducto(Long idProducto) {
        return movimientos.stream()
                .filter(movimiento -> movimiento.getProducto() != null
                        && Objects.equals(movimiento.getProducto().getIdProducto(), idProducto))
                .collect(Collectors.toList());
    }
}
