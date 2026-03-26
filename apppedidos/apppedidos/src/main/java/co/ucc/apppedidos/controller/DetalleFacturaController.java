package co.ucc.apppedidos.controller;

import co.ucc.apppedidos.model.DetalleFactura;
import co.ucc.apppedidos.services.IDetalleFacturaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalles")
public class DetalleFacturaController {

    private final IDetalleFacturaService service;

    public DetalleFacturaController(IDetalleFacturaService service) {
        this.service = service;
    }

    @GetMapping
    public List<DetalleFactura> listar() {
        return service.listar();
    }

    @PostMapping
    public DetalleFactura guardar(@RequestBody DetalleFactura detalle) {
        return service.guardar(detalle);
    }

    @GetMapping("/{id}")
    public DetalleFactura buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}