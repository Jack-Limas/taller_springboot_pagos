package co.ucc.apppedidos.repository;

import co.ucc.apppedidos.model.Cliente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ClienteRepository {

    private final List<Cliente> clientes = new ArrayList<>();

    public List<Cliente> listar() {
        return new ArrayList<>(clientes);
    }

    public Cliente guardar(Cliente cliente) {
        if (cliente.getIdCliente() != null) {
            eliminar(cliente.getIdCliente());
        }
        clientes.add(cliente);
        return cliente;
    }

    public Cliente buscarPorId(Long idCliente) {
        return clientes.stream()
                .filter(cliente -> Objects.equals(cliente.getIdCliente(), idCliente))
                .findFirst()
                .orElse(null);
    }

    public void eliminar(Long idCliente) {
        clientes.removeIf(cliente -> Objects.equals(cliente.getIdCliente(), idCliente));
    }
}
