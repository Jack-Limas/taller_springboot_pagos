package co.ucc.apppedidos.services;

import co.ucc.apppedidos.model.Compra;
import java.util.List;

public interface ICompraService {

    List<Compra> listar();

    Compra guardar(Compra compra);

    Compra buscarPorId(Long id);
}