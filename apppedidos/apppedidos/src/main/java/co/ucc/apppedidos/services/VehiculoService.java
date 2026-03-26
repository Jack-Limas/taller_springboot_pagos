package co.ucc.apppedidos.services;

import co.ucc.apppedidos.model.Vehiculo;
import co.ucc.apppedidos.repository.VehiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService implements IVehiculoService {

    private final VehiculoRepository repository;

    public VehiculoService(VehiculoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Vehiculo> listar() {
        return repository.listar();
    }

    @Override
    public Vehiculo guardar(Vehiculo vehiculo) {
        return repository.guardar(vehiculo);
    }

    @Override
    public Vehiculo buscarPorId(Long id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado"));
    }
}