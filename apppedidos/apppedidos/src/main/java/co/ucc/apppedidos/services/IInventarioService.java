package co.ucc.apppedidos.services;

import co.ucc.apppedidos.model.Inventario;
import java.util.List;

public interface IInventarioService {

    List<Inventario> listar();

    Inventario guardar(Inventario inventario);

    Inventario buscarPorId(Long id);
}