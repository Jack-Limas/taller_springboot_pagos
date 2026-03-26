package co.ucc.apppedidos.services;

import co.ucc.apppedidos.model.Envio;
import java.util.List;

public interface IEnvioService {

    List<Envio> listar();

    Envio guardar(Envio envio);

    Envio buscarPorId(Long id);
}