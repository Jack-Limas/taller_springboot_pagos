package co.ucc.apppedidos.controller;

import co.ucc.apppedidos.model.Inventario;
import co.ucc.apppedidos.services.IInventarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventarios")
public class InventarioController {

    private final IInventarioService service;

    public InventarioController(IInventarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Inventario> listar() {
        return service.listar();
    }

    @PostMapping
    public Inventario guardar(@RequestBody Inventario inventario) {
        return service.guardar(inventario);
    }

    @GetMapping("/{id}")
    public Inventario buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}