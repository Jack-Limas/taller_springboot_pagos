package co.ucc.apppedidos.repository;

import co.ucc.apppedidos.model.Envio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnvioRepository extends JpaRepository<Envio, Long> {

    Envio findFirstByPedido_IdPedido(Long idPedido);

    default List<Envio> listar() {
        return findAll();
    }

    default Envio guardar(Envio envio) {
        return save(envio);
    }

    default Envio buscarPorId(Long idEnvio) {
        return findById(idEnvio).orElse(null);
    }

    default Envio buscarPorPedido(Long idPedido) {
        return findFirstByPedido_IdPedido(idPedido);
    }
}
