package co.ucc.apppedidos.services;

import co.ucc.apppedidos.model.DetalleFactura;
import java.util.List;

public interface IDetalleFacturaService {

    List<DetalleFactura> listar();

    DetalleFactura guardar(DetalleFactura detalle);

    DetalleFactura buscarPorId(Long id);
}