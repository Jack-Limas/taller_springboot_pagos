package co.ucc.apppedidos.repository;

import co.ucc.apppedidos.model.HistorialInventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistorialInventarioRepository extends JpaRepository<HistorialInventario, Long> {

    List<HistorialInventario> findByProducto_IdProducto(Long idProducto);

    default List<HistorialInventario> listar() {
        return findAll();
    }

    default HistorialInventario guardar(HistorialInventario historialInventario) {
        return save(historialInventario);
    }

    default HistorialInventario buscarPorId(Long idMovimiento) {
        return findById(idMovimiento).orElse(null);
    }

    default List<HistorialInventario> buscarPorProducto(Long idProducto) {
        return findByProducto_IdProducto(idProducto);
    }
}
