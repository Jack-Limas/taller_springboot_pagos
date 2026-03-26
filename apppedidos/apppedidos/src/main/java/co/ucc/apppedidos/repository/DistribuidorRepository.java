package co.ucc.apppedidos.repository;

import co.ucc.apppedidos.model.Distribuidor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class DistribuidorRepository {

    private final List<Distribuidor> distribuidores = new ArrayList<>();

    public List<Distribuidor> listar() {
        return new ArrayList<>(distribuidores);
    }

    public Distribuidor guardar(Distribuidor distribuidor) {
        if (distribuidor.getIdDistribuidor() != null) {
            distribuidores.removeIf(actual -> Objects.equals(actual.getIdDistribuidor(), distribuidor.getIdDistribuidor()));
        }
        distribuidores.add(distribuidor);
        return distribuidor;
    }

    public Distribuidor buscarPorId(Long idDistribuidor) {
        return distribuidores.stream()
                .filter(distribuidor -> Objects.equals(distribuidor.getIdDistribuidor(), idDistribuidor))
                .findFirst()
                .orElse(null);
    }
}
