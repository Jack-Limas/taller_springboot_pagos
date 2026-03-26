package co.ucc.apppedidos.repository;

import co.ucc.apppedidos.model.Pedido;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class PedidoRepository {

    private final List<Pedido> pedidos = new ArrayList<>();

    public List<Pedido> listar() {
        return new ArrayList<>(pedidos);
    }

    public Pedido guardar(Pedido pedido) {
        if (pedido.getIdPedido() != null) {
            eliminar(pedido.getIdPedido());
        }
        pedidos.add(pedido);
        return pedido;
    }

    public Pedido buscarPorId(Long idPedido) {
        return pedidos.stream()
                .filter(pedido -> Objects.equals(pedido.getIdPedido(), idPedido))
                .findFirst()
                .orElse(null);
    }

    public void eliminar(Long idPedido) {
        pedidos.removeIf(pedido -> Objects.equals(pedido.getIdPedido(), idPedido));
    }
}
