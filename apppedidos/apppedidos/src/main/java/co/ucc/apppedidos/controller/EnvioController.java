package co.ucc.apppedidos.controller;

import co.ucc.apppedidos.model.Envio;
import co.ucc.apppedidos.services.IEnvioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/envios")
public class EnvioController {

    private final IEnvioService service;

    public EnvioController(IEnvioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Envio> listar() {
        return service.listar();
    }

    @PostMapping
    public Envio guardar(@RequestBody Envio envio) {
        return service.guardar(envio);
    }

    @GetMapping("/{id}")
    public Envio buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}