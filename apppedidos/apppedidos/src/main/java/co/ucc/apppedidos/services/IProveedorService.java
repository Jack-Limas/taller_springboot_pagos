package co.ucc.apppedidos.services;

import co.ucc.apppedidos.model.Proveedor;
import java.util.List;

public interface IProveedorService {

    List<Proveedor> listar();

    Proveedor guardar(Proveedor proveedor);

    Proveedor buscarPorId(Long id);
}