package co.ucc.apppedidos.services;

import co.ucc.apppedidos.model.Cliente;
import java.util.List;

public interface IClienteService {

    List<Cliente> listar();

    Cliente guardar(Cliente cliente);

    Cliente buscarPorId(Long id);

    void eliminar(Long id);
}