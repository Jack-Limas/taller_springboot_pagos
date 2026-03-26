package co.ucc.apppedidos.repository;

import co.ucc.apppedidos.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {

    Pago findFirstByPedido_IdPedido(Long idPedido);

    default List<Pago> listar() {
        return findAll();
    }

    default Pago guardar(Pago pago) {
        return save(pago);
    }

    default Pago buscarPorId(Long idPago) {
        return findById(idPago).orElse(null);
    }

    default Pago buscarPorPedido(Long idPedido) {
        return findFirstByPedido_IdPedido(idPedido);
    }
}
