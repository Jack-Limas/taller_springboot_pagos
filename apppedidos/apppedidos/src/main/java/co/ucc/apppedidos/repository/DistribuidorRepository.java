package co.ucc.apppedidos.repository;

import co.ucc.apppedidos.model.Distribuidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistribuidorRepository extends JpaRepository<Distribuidor, Long> {

    default List<Distribuidor> listar() {
        return findAll();
    }

    default Distribuidor guardar(Distribuidor distribuidor) {
        return save(distribuidor);
    }

    default Distribuidor buscarPorId(Long idDistribuidor) {
        return findById(idDistribuidor).orElse(null);
    }
}
