package co.ucc.apppedidos.repository;

import co.ucc.apppedidos.model.DetallePedido;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class DetallePedidoRepository {

    private final List<DetallePedido> detalles = new ArrayList<>();

    public List<DetallePedido> listar() {
        return new ArrayList<>(detalles);
    }

    public DetallePedido guardar(DetallePedido detallePedido) {
        if (detallePedido.getIdDetalle() != null) {
            detalles.removeIf(detalle -> Objects.equals(detalle.getIdDetalle(), detallePedido.getIdDetalle()));
        }
        detalles.add(detallePedido);
        return detallePedido;
    }

    public DetallePedido buscarPorId(Long idDetalle) {
        return detalles.stream()
                .filter(detalle -> Objects.equals(detalle.getIdDetalle(), idDetalle))
                .findFirst()
                .orElse(null);
    }
}
