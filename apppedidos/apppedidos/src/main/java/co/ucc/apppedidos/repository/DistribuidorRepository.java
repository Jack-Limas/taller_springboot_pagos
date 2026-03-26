package co.ucc.apppedidos.repository;

import co.ucc.apppedidos.model.Distribuidor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DistribuidorRepository {

    private List<Distribuidor> distribuidores = new ArrayList<>();

    public List<Distribuidor> listar() {
        return distribuidores;
    }

    public Distribuidor guardar(Distribuidor distribuidor) {
        distribuidores.add(distribuidor);
        return distribuidor;
    }

    public Optional<Distribuidor> buscarPorId(Long id) {
        return distribuidores.stream()
                .filter(d -> d.getIdDistribuidor().equals(id))
                .findFirst();
    }
}