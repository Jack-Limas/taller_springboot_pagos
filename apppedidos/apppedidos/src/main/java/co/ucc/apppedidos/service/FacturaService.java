package co.ucc.apppedidos.service;

import co.ucc.apppedidos.model.DetalleFactura;
import co.ucc.apppedidos.model.DetallePedido;
import co.ucc.apppedidos.model.Factura;
import co.ucc.apppedidos.model.Pedido;
import co.ucc.apppedidos.repository.FacturaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FacturaService {

    private final FacturaRepository facturaRepository;
    private final PedidoService pedidoService;

    public FacturaService(FacturaRepository facturaRepository, PedidoService pedidoService) {
        this.facturaRepository = facturaRepository;
        this.pedidoService = pedidoService;
    }

    @Transactional(readOnly = true)
    public List<Factura> listarFacturas() {
        return facturaRepository.listar();
    }

    @Transactional
    public Factura generarFactura(Pedido pedido) {
        Pedido pedidoPersistido = pedidoService.buscarPedido(pedido.getIdPedido());

        Factura factura = new Factura();
        factura.setFecha(new Date());
        factura.setPedido(pedidoPersistido);

        List<DetalleFactura> detallesFactura = new ArrayList<>();
        for (DetallePedido detallePedido : pedidoPersistido.getDetalles()) {
            DetalleFactura detalleFactura = new DetalleFactura();
            detalleFactura.setCantidad(detallePedido.getCantidad());
            detalleFactura.setPrecioUnitario(detallePedido.getPrecioUnitario());
            detalleFactura.setSubtotal(detallePedido.getSubtotal());
            detalleFactura.setProducto(detallePedido.getProducto());
            detallesFactura.add(detalleFactura);
        }

        factura.setDetalles(detallesFactura);
        factura.setTotal(pedidoPersistido.getTotal());
        return facturaRepository.guardar(factura);
    }

    @Transactional(readOnly = true)
    public Factura buscarFactura(Long idFactura) {
        Factura factura = facturaRepository.buscarPorId(idFactura);
        if (factura == null) {
            throw new IllegalArgumentException("Factura no encontrada: " + idFactura);
        }
        return factura;
    }
}
