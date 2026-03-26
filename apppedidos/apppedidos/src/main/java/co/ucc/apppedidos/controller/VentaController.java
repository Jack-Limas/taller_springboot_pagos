package co.ucc.apppedidos.controller;

import co.ucc.apppedidos.model.Venta;
import co.ucc.apppedidos.services.IVentaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    private final IVentaService service;

    public VentaController(IVentaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Venta> listar() {
        return service.listar();
    }

    @PostMapping
    public Venta guardar(@RequestBody Venta venta) {
        return service.guardar(venta);
    }

    @GetMapping("/{id}")
    public Venta buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}