package co.ucc.apppedidos.controller;

import co.ucc.apppedidos.model.Factura;
import co.ucc.apppedidos.model.Pedido;
import co.ucc.apppedidos.service.FacturaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/facturas")
public class FacturaController {

    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @GetMapping
    public List<Factura> listarFacturas() {
        return facturaService.listarFacturas();
    }

    @PostMapping
    public Factura generarFactura(@RequestBody Pedido pedido) {
        return facturaService.generarFactura(pedido);
    }

    @GetMapping("/{id}")
    public Factura buscarFactura(@PathVariable("id") Long idFactura) {
        return facturaService.buscarFactura(idFactura);
    }
}
