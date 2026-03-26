package co.ucc.apppedidos.controller;

import co.ucc.apppedidos.model.Pago;
import co.ucc.apppedidos.service.PagoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @PostMapping
    public Pago realizarPago(@RequestBody Pago pago) {
        return pagoService.realizarPago(pago);
    }

    @PostMapping("/{id}/reembolso")
    public void realizarReembolso(@PathVariable("id") Long idPago) {
        pagoService.realizarReembolso(idPago);
    }

    @GetMapping("/{id}")
    public Pago buscarPago(@PathVariable("id") Long idPago) {
        return pagoService.buscarPago(idPago);
    }

    @GetMapping
    public List<Pago> listarPagos() {
        return pagoService.listarPagos();
    }
}
