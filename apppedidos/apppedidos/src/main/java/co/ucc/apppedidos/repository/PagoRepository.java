package co.ucc.apppedidos.repository;

import co.ucc.apppedidos.model.Pago;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class PagoRepository {

    private final List<Pago> pagos = new ArrayList<>();

    public List<Pago> listar() {
        return new ArrayList<>(pagos);
    }

    public Pago guardar(Pago pago) {
        if (pago.getIdPago() != null) {
            pagos.removeIf(actual -> Objects.equals(actual.getIdPago(), pago.getIdPago()));
        }
        pagos.add(pago);
        return pago;
    }

    public Pago buscarPorId(Long idPago) {
        return pagos.stream()
                .filter(pago -> Objects.equals(pago.getIdPago(), idPago))
                .findFirst()
                .orElse(null);
    }

    public Pago buscarPorPedido(Long idPedido) {
        return pagos.stream()
                .filter(pago -> pago.getPedido() != null && Objects.equals(pago.getPedido().getIdPedido(), idPedido))
                .findFirst()
                .orElse(null);
    }
}
