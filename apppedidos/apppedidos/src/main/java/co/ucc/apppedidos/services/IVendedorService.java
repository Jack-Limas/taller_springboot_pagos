package co.ucc.apppedidos.services;

import co.ucc.apppedidos.model.Vendedor;
import java.util.List;

public interface IVendedorService {

    List<Vendedor> listar();

    Vendedor guardar(Vendedor vendedor);

    Vendedor buscarPorId(Long id);
}