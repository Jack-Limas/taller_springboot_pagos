package co.ucc.apppedidos.repository;

import co.ucc.apppedidos.model.Vehiculo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VehiculoRepository {

    private List<Vehiculo> vehiculos = new ArrayList<>();

    public List<Vehiculo> listar() {
        return vehiculos;
    }

    public Vehiculo guardar(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
        return vehiculo;
    }

    public Optional<Vehiculo> buscarPorId(Long id) {
        return vehiculos.stream()
                .filter(v -> v.getIdVehiculo().equals(id))
                .findFirst();
    }
}
