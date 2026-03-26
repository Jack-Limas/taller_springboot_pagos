package co.ucc.apppedidos.services;

import co.ucc.apppedidos.model.Distribuidor;
import java.util.List;

public interface IDistribuidorService {

    List<Distribuidor> listar();

    Distribuidor guardar(Distribuidor distribuidor);

    Distribuidor buscarPorId(Long id);
}