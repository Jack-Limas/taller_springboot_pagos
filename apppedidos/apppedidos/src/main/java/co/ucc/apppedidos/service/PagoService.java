package co.ucc.apppedidos.service;

import co.ucc.apppedidos.model.Pago;
import co.ucc.apppedidos.model.Pedido;
import co.ucc.apppedidos.repository.PagoRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class PagoService {

    private static final Set<String> ESTADOS_PAGO_VALIDOS =
            Set.of("PENDIENTE", "COMPLETADO", "REEMBOLSADO", "FALLIDO");
    private static final Set<String> TIPOS_PAGO_VALIDOS = Set.of("PAGO", "REEMBOLSO");

    private final PagoRepository pagoRepository;
    private final PedidoService pedidoService;

    public PagoService(PagoRepository pagoRepository, PedidoService pedidoService) {
        this.pagoRepository = pagoRepository;
        this.pedidoService = pedidoService;
    }

    public Pago realizarPago(Pago pago) {
        if (pago.getIdPago() == null) {
            throw new IllegalArgumentException("El pago debe tener idPago");
        }
        Pedido pedido = pedidoService.buscarPedido(pago.getPedido().getIdPedido());

        pago.setPedido(pedido);
        pago.setFecha(pago.getFecha() == null ? new Date() : pago.getFecha());
        pago.setEstado("COMPLETADO");
        pago.setTipo(normalizarTipoPago(pago.getTipo() == null ? "PAGO" : pago.getTipo()));

        pedido.setEstado("EN_PROCESO");
        return pagoRepository.guardar(pago);
    }

    public void realizarReembolso(Long idPago) {
        Pago pago = buscarPago(idPago);
        pago.setEstado("REEMBOLSADO");
        pago.setTipo("REEMBOLSO");
        pago.getPedido().setEstado("CANCELADO");
        pagoRepository.guardar(pago);
    }

    public Pago buscarPago(Long idPago) {
        Pago pago = pagoRepository.buscarPorId(idPago);
        if (pago == null) {
            throw new IllegalArgumentException("Pago no encontrado: " + idPago);
        }
        if (!ESTADOS_PAGO_VALIDOS.contains(pago.getEstado())) {
            throw new IllegalArgumentException("Estado de pago invalido almacenado: " + pago.getEstado());
        }
        return pago;
    }

    public List<Pago> listarPagos() {
        return pagoRepository.listar();
    }

    private String normalizarTipoPago(String tipo) {
        if (!TIPOS_PAGO_VALIDOS.contains(tipo)) {
            throw new IllegalArgumentException("Tipo de pago invalido: " + tipo);
        }
        return tipo;
    }
}
