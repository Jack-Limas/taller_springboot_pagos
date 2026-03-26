package co.ucc.apppedidos.repository;

import co.ucc.apppedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    default List<Pedido> listar() {
        return findAll();
    }

    default Pedido guardar(Pedido pedido) {
        return save(pedido);
    }

    default Pedido buscarPorId(Long idPedido) {
        return findById(idPedido).orElse(null);
    }

    default void eliminar(Long idPedido) {
        deleteById(idPedido);
    }
}
