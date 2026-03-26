package co.ucc.apppedidos.service;

import co.ucc.apppedidos.model.DetallePedido;
import co.ucc.apppedidos.model.Pedido;
import co.ucc.apppedidos.model.Producto;
import co.ucc.apppedidos.repository.ClienteRepository;
import co.ucc.apppedidos.repository.PedidoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class PedidoService {

    private static final Set<String> ESTADOS_PEDIDO_VALIDOS =
            Set.of("PENDIENTE", "EN_PROCESO", "ENVIADO", "ENTREGADO", "CANCELADO");

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ProductoService productoService;

    public PedidoService(PedidoRepository pedidoRepository,
                         ClienteRepository clienteRepository,
                         ProductoService productoService) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.productoService = productoService;
    }

    @Transactional(readOnly = true)
    public List<Pedido> listarPedidos() {
        return pedidoRepository.listar();
    }

    @Transactional
    public Pedido registrarPedido(Pedido pedido) {
        if (pedido.getDetalles() == null || pedido.getDetalles().isEmpty()) {
            throw new IllegalArgumentException("El pedido debe tener al menos un detalle");
        }
        if (pedido.getCliente() != null && pedido.getCliente().getIdCliente() != null) {
            pedido.setCliente(clienteRepository.findById(pedido.getCliente().getIdCliente())
                    .orElseThrow(() -> new IllegalArgumentException(
                            "Cliente no encontrado: " + pedido.getCliente().getIdCliente())));
        }

        pedido.setFecha(pedido.getFecha() == null ? new Date() : pedido.getFecha());
        pedido.setEstado(normalizarEstadoPedido(pedido.getEstado()));

        List<DetallePedido> detallesNormalizados = new ArrayList<>();
        for (DetallePedido detalle : pedido.getDetalles()) {
            if (detalle.getProducto() == null || detalle.getProducto().getIdProducto() == null) {
                throw new IllegalArgumentException("Cada detalle debe referenciar un producto");
            }
            if (detalle.getCantidad() == null || detalle.getCantidad() <= 0) {
                throw new IllegalArgumentException("Cada detalle debe tener una cantidad mayor a cero");
            }
            Producto producto = productoService.buscarProducto(detalle.getProducto().getIdProducto());
            detalle.setProducto(producto);
            detalle.setPrecioUnitario(producto.getPrecio());
            detalle.setSubtotal(detalle.getCantidad() * producto.getPrecio());
            productoService.actualizarStock(producto.getIdProducto(), detalle.getCantidad(), "SALIDA");
            detallesNormalizados.add(detalle);
        }

        pedido.setDetalles(detallesNormalizados);
        pedido.setTotal(calcularTotal(pedido));
        return pedidoRepository.guardar(pedido);
    }

    @Transactional(readOnly = true)
    public Pedido buscarPedido(Long idPedido) {
        Pedido pedido = pedidoRepository.buscarPorId(idPedido);
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido no encontrado: " + idPedido);
        }
        return pedido;
    }

    @Transactional
    public void cancelarPedido(Long idPedido) {
        Pedido pedido = buscarPedido(idPedido);
        pedido.setEstado("CANCELADO");
        pedidoRepository.guardar(pedido);
    }

    public double calcularTotal(Pedido pedido) {
        return pedido.getDetalles().stream()
                .mapToDouble(DetallePedido::getSubtotal)
                .sum();
    }

    private String normalizarEstadoPedido(String estado) {
        String estadoNormalizado = estado == null ? "PENDIENTE" : estado;
        if (!ESTADOS_PEDIDO_VALIDOS.contains(estadoNormalizado)) {
            throw new IllegalArgumentException("Estado de pedido invalido: " + estadoNormalizado);
        }
        return estadoNormalizado;
    }
}
