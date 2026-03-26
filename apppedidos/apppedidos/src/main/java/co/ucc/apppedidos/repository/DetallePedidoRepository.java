package co.ucc.apppedidos.repository;

import co.ucc.apppedidos.model.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long> {

    default List<DetallePedido> listar() {
        return findAll();
    }

    default DetallePedido guardar(DetallePedido detallePedido) {
        return save(detallePedido);
    }

    default DetallePedido buscarPorId(Long idDetalle) {
        return findById(idDetalle).orElse(null);
    }
}
