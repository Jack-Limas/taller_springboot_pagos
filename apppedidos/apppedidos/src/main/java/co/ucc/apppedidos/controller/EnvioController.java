package co.ucc.apppedidos.controller;

import co.ucc.apppedidos.model.Distribuidor;
import co.ucc.apppedidos.model.Envio;
import co.ucc.apppedidos.service.EnvioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/envios")
public class EnvioController {

    private final EnvioService envioService;

    public EnvioController(EnvioService envioService) {
        this.envioService = envioService;
    }

    @GetMapping
    public List<Envio> listarEnvios() {
        return envioService.listarEnvios();
    }

    @PostMapping
    public Envio registrarEnvio(@RequestBody Envio envio) {
        return envioService.registrarEnvio(envio);
    }

    @GetMapping("/{id}")
    public Envio buscarEnvio(@PathVariable("id") Long idEnvio) {
        return envioService.buscarEnvio(idEnvio);
    }

    @PutMapping("/{id}/despachar")
    public void despacharEnvio(@PathVariable("id") Long idEnvio) {
        envioService.despacharEnvio(idEnvio);
    }

    @PutMapping("/{id}/entregar")
    public void entregarEnvio(@PathVariable("id") Long idEnvio) {
        envioService.entregarEnvio(idEnvio);
    }

    @GetMapping("/distribuidores")
    public List<Distribuidor> listarDistribuidores() {
        return envioService.listarDistribuidores();
    }

    @PostMapping("/distribuidores")
    public Distribuidor guardarDistribuidor(@RequestBody Distribuidor distribuidor) {
        return envioService.guardarDistribuidor(distribuidor);
    }

    @PostMapping("/calcular-costo")
    public double calcularCostoEnvio(@RequestBody Envio envio) {
        return envioService.calcularCostoEnvio(envio);
    }
}
