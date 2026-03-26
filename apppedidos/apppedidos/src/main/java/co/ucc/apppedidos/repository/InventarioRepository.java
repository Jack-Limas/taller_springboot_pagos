package co.ucc.apppedidos.repository;

import co.ucc.apppedidos.model.Inventario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InventarioRepository {

    private List<Inventario> inventarios = new ArrayList<>();

    public List<Inventario> listar() {
        return inventarios;
    }

    public Inventario guardar(Inventario inventario) {
        inventarios.add(inventario);
        return inventario;
    }

    public Optional<Inventario> buscarPorId(Long id) {
        return inventarios.stream()
                .filter(i -> i.getIdInventario().equals(id))
                .findFirst();
    }
}