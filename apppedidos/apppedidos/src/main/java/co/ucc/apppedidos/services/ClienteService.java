package co.ucc.apppedidos.services;


import co.ucc.apppedidos.model.Cliente;
import co.ucc.apppedidos.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Cliente> listar() {
        return repository.listar();
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        return repository.guardar(cliente);
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    @Override
    public void eliminar(Long id) {
        repository.eliminar(id);
    }
}