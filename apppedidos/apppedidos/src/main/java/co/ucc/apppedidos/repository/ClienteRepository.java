package co.ucc.apppedidos.repository;

import co.ucc.apppedidos.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    default List<Cliente> listar() {
        return findAll();
    }

    default Cliente guardar(Cliente cliente) {
        return save(cliente);
    }

    default Cliente buscarPorId(Long idCliente) {
        return findById(idCliente).orElse(null);
    }

    default void eliminar(Long idCliente) {
        deleteById(idCliente);
    }
}
