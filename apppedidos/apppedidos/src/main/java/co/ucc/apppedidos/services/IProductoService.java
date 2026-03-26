package co.ucc.apppedidos.services;

import co.ucc.apppedidos.model.Producto;
import java.util.List;

public interface IProductoService {

    List<Producto> listar();

    Producto guardar(Producto producto);

    Producto buscarPorId(Long id);

    void eliminar(Long id);
}