package co.ucc.apppedidos.controller;

import co.ucc.apppedidos.model.Cliente;
import co.ucc.apppedidos.service.ClienteService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    @PostMapping
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return clienteService.crearCliente(cliente);
    }

    @GetMapping("/{id}")
    public Cliente buscarCliente(@PathVariable("id") Long idCliente) {
        return clienteService.buscarCliente(idCliente);
    }

    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable("id") Long idCliente) {
        clienteService.eliminarCliente(idCliente);
    }
}
