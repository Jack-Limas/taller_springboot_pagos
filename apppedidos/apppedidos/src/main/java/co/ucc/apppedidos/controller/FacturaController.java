package co.ucc.apppedidos.controller;

import co.ucc.apppedidos.model.Factura;
import co.ucc.apppedidos.services.IFacturaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facturas")
public class FacturaController {

    private final IFacturaService service;

    public FacturaController(IFacturaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Factura> listar() {
        return service.listar();
    }

    @PostMapping
    public Factura guardar(@RequestBody Factura factura) {
        return service.guardar(factura);
    }

    @GetMapping("/{id}")
    public Factura buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}