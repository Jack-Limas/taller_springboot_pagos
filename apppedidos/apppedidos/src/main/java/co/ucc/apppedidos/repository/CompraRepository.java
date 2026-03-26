package co.ucc.apppedidos.repository;

import co.ucc.apppedidos.model.Compra;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository {

    private List<Compra> compras = new ArrayList<>();

    public List<Compra> listar() {
        return compras;
    }

    public Compra guardar(Compra compra) {
        compras.add(compra);
        return compra;
    }

    public Optional<Compra> buscarPorId(Long id) {
        return compras.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }
}