package co.ucc.apppedidos.controller;

import co.ucc.apppedidos.model.Proveedor;
import co.ucc.apppedidos.services.IProveedorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    private final IProveedorService service;

    public ProveedorController(IProveedorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Proveedor> listar() {
        return service.listar();
    }

    @PostMapping
    public Proveedor guardar(@RequestBody Proveedor proveedor) {
        return service.guardar(proveedor);
    }

    @GetMapping("/{id}")
    public Proveedor buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}