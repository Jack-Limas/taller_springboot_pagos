package co.ucc.apppedidos.service;

import co.ucc.apppedidos.model.Distribuidor;
import co.ucc.apppedidos.model.Envio;
import co.ucc.apppedidos.model.Pedido;
import co.ucc.apppedidos.repository.DistribuidorRepository;
import co.ucc.apppedidos.repository.EnvioRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class EnvioService {

    private static final Set<String> ESTADOS_ENVIO_VALIDOS = Set.of("PENDIENTE", "DESPACHADO", "ENTREGADO");
    private static final Set<String> TIPOS_DISTRIBUIDOR_VALIDOS = Set.of("ENVIO", "PAGO");

    private final EnvioRepository envioRepository;
    private final DistribuidorRepository distribuidorRepository;
    private final PedidoService pedidoService;

    public EnvioService(EnvioRepository envioRepository,
                        DistribuidorRepository distribuidorRepository,
                        PedidoService pedidoService) {
        this.envioRepository = envioRepository;
        this.distribuidorRepository = distribuidorRepository;
        this.pedidoService = pedidoService;
    }

    public List<Envio> listarEnvios() {
        return envioRepository.listar();
    }

    public Envio registrarEnvio(Envio envio) {
        if (envio.getIdEnvio() == null) {
            throw new IllegalArgumentException("El envio debe tener idEnvio");
        }
        Pedido pedido = pedidoService.buscarPedido(envio.getPedido().getIdPedido());
        Distribuidor distribuidor = buscarDistribuidor(envio.getDistribuidor().getIdDistribuidor());

        envio.setPedido(pedido);
        envio.setDistribuidor(distribuidor);
        envio.setFechaEnvio(envio.getFechaEnvio() == null ? new Date() : envio.getFechaEnvio());
        envio.setEstado(normalizarEstadoEnvio(envio.getEstado()));
        return envioRepository.guardar(envio);
    }

    public Envio buscarEnvio(Long idEnvio) {
        Envio envio = envioRepository.buscarPorId(idEnvio);
        if (envio == null) {
            throw new IllegalArgumentException("Envio no encontrado: " + idEnvio);
        }
        return envio;
    }

    public void despacharEnvio(Long idEnvio) {
        Envio envio = buscarEnvio(idEnvio);
        envio.setEstado("DESPACHADO");
        envio.getPedido().setEstado("ENVIADO");
        envioRepository.guardar(envio);
    }

    public void entregarEnvio(Long idEnvio) {
        Envio envio = buscarEnvio(idEnvio);
        envio.setEstado("ENTREGADO");
        envio.getPedido().setEstado("ENTREGADO");
        envioRepository.guardar(envio);
    }

    public List<Distribuidor> listarDistribuidores() {
        return distribuidorRepository.listar();
    }

    public Distribuidor guardarDistribuidor(Distribuidor distribuidor) {
        if (distribuidor.getIdDistribuidor() == null) {
            throw new IllegalArgumentException("El distribuidor debe tener idDistribuidor");
        }
        if (!TIPOS_DISTRIBUIDOR_VALIDOS.contains(distribuidor.getTipo())) {
            throw new IllegalArgumentException("Tipo de distribuidor invalido: " + distribuidor.getTipo());
        }
        return distribuidorRepository.guardar(distribuidor);
    }

    public double calcularCostoEnvio(Envio envio) {
        return envio.calcularCosto();
    }

    private Distribuidor buscarDistribuidor(Long idDistribuidor) {
        Distribuidor distribuidor = distribuidorRepository.buscarPorId(idDistribuidor);
        if (distribuidor == null) {
            throw new IllegalArgumentException("Distribuidor no encontrado: " + idDistribuidor);
        }
        return distribuidor;
    }

    private String normalizarEstadoEnvio(String estado) {
        String estadoNormalizado = estado == null ? "PENDIENTE" : estado;
        if (!ESTADOS_ENVIO_VALIDOS.contains(estadoNormalizado)) {
            throw new IllegalArgumentException("Estado de envio invalido: " + estadoNormalizado);
        }
        return estadoNormalizado;
    }
}
