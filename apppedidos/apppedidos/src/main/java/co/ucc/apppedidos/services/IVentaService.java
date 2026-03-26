package co.ucc.apppedidos.services;


import co.ucc.apppedidos.model.Venta;
import java.util.List;

public interface IVentaService {

    List<Venta> listar();

    Venta guardar(Venta venta);

    Venta buscarPorId(Long id);
}