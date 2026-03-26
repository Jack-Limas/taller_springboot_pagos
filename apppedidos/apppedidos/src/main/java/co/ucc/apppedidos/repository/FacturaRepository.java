package co.ucc.apppedidos.repository;

import co.ucc.apppedidos.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {

    Factura findFirstByPedido_IdPedido(Long idPedido);

    default List<Factura> listar() {
        return findAll();
    }

    default Factura guardar(Factura factura) {
        return save(factura);
    }

    default Factura buscarPorId(Long idFactura) {
        return findById(idFactura).orElse(null);
    }

    default Factura buscarPorPedido(Long idPedido) {
        return findFirstByPedido_IdPedido(idPedido);
    }
}
