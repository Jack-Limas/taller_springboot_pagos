package co.ucc.apppedidos.service;

import co.ucc.apppedidos.model.Cliente;
import co.ucc.apppedidos.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.listar();
    }

    @Transactional
    public Cliente crearCliente(Cliente cliente) {
        if (cliente.getNombre() == null || cliente.getNombre().isBlank()) {
            throw new IllegalArgumentException("El cliente debe tener nombre");
        }
        return clienteRepository.guardar(cliente);
    }

    public Cliente buscarCliente(Long idCliente) {
        Cliente cliente = clienteRepository.buscarPorId(idCliente);
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente no encontrado: " + idCliente);
        }
        return cliente;
    }

    @Transactional
    public void eliminarCliente(Long idCliente) {
        buscarCliente(idCliente);
        clienteRepository.eliminar(idCliente);
    }
}
