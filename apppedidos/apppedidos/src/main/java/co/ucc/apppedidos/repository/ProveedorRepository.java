package co.ucc.apppedidos.repository;

import co.ucc.apppedidos.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

    default List<Proveedor> listar() {
        return findAll();
    }

    default Proveedor guardar(Proveedor proveedor) {
        return save(proveedor);
    }

    default Proveedor buscarPorId(Long idProveedor) {
        return findById(idProveedor).orElse(null);
    }

    default void eliminar(Long idProveedor) {
        deleteById(idProveedor);
    }
}
