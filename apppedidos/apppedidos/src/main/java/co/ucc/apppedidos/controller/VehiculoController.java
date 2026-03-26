package co.ucc.apppedidos.controller;

import co.ucc.apppedidos.model.Vehiculo;
import co.ucc.apppedidos.services.IVehiculoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    private final IVehiculoService service;

    public VehiculoController(IVehiculoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Vehiculo> listar() {
        return service.listar();
    }

    @PostMapping
    public Vehiculo guardar(@RequestBody Vehiculo vehiculo) {
        return service.guardar(vehiculo);
    }

    @GetMapping("/{id}")
    public Vehiculo buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}