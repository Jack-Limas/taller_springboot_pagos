package co.ucc.apppedidos.services;

import co.ucc.apppedidos.model.Vehiculo;
import java.util.List;

public interface IVehiculoService {

    List<Vehiculo> listar();

    Vehiculo guardar(Vehiculo vehiculo);

    Vehiculo buscarPorId(Long id);
}