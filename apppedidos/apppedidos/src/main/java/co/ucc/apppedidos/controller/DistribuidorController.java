package co.ucc.apppedidos.controller;

import co.ucc.apppedidos.model.Distribuidor;
import co.ucc.apppedidos.services.IDistribuidorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/distribuidores")
public class DistribuidorController {

    private final IDistribuidorService service;

    public DistribuidorController(IDistribuidorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Distribuidor> listar() {
        return service.listar();
    }

    @PostMapping
    public Distribuidor guardar(@RequestBody Distribuidor distribuidor) {
        return service.guardar(distribuidor);
    }

    @GetMapping("/{id}")
    public Distribuidor buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}