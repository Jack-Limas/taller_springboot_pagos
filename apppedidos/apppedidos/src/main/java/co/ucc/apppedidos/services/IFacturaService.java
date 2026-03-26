package co.ucc.apppedidos.services;

import co.ucc.apppedidos.model.Factura;
import java.util.List;

public interface IFacturaService {

    List<Factura> listar();

    Factura guardar(Factura factura);

    Factura buscarPorId(Long id);
}
