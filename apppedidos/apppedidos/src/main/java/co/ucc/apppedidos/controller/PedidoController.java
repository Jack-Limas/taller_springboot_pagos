package co.ucc.apppedidos.controller;

import co.ucc.apppedidos.model.Pedido;
import co.ucc.apppedidos.service.PedidoService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidoService.listarPedidos();
    }

    @PostMapping
    public Pedido registrarPedido(@RequestBody Pedido pedido) {
        return pedidoService.registrarPedido(pedido);
    }

    @GetMapping("/{id}")
    public Pedido buscarPedido(@PathVariable("id") Long idPedido) {
        return pedidoService.buscarPedido(idPedido);
    }

    @DeleteMapping("/{id}")
    public void cancelarPedido(@PathVariable("id") Long idPedido) {
        pedidoService.cancelarPedido(idPedido);
    }
}
