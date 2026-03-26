package co.ucc.apppedidos.repository;

import co.ucc.apppedidos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    default List<Producto> listar() {
        return findAll();
    }

    default Producto guardar(Producto producto) {
        return save(producto);
    }

    default Producto buscarPorId(Long idProducto) {
        return findById(idProducto).orElse(null);
    }

    default void eliminar(Long idProducto) {
        deleteById(idProducto);
    }
}
