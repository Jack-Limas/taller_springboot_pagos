package co.ucc.apppedidos.controller;


import co.ucc.apppedidos.model.Vendedor;
import co.ucc.apppedidos.services.IVendedorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {

    private final IVendedorService service;

    public VendedorController(IVendedorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Vendedor> listar() {
        return service.listar();
    }

    @PostMapping
    public Vendedor guardar(@RequestBody Vendedor vendedor) {
        return service.guardar(vendedor);
    }

    @GetMapping("/{id}")
    public Vendedor buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}