package co.ucc.apppedidos.controller;

import co.ucc.apppedidos.model.Compra;
import co.ucc.apppedidos.services.ICompraService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras")
public class CompraController {

    private final ICompraService service;

    public CompraController(ICompraService service) {
        this.service = service;
    }

    @GetMapping
    public List<Compra> listar() {
        return service.listar();
    }

    @PostMapping
    public Compra guardar(@RequestBody Compra compra) {
        return service.guardar(compra);
    }

    @GetMapping("/{id}")
    public Compra buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}