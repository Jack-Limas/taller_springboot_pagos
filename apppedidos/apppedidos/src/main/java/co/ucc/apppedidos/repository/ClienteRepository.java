package co.ucc.apppedidos.repository;


import co.ucc.apppedidos.model.Cliente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository {

    private List<Cliente> clientes = new ArrayList<>();

    public List<Cliente> listar() {
        return clientes;
    }

    public Cliente guardar(Cliente cliente) {
        clientes.add(cliente);
        return cliente;
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return clientes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }

    public void eliminar(Long id) {
        clientes.removeIf(c -> c.getId().equals(id));
    }
}