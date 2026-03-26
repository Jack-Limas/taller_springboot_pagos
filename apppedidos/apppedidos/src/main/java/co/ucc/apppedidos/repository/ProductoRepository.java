package co.ucc.apppedidos.repository;

import co.ucc.apppedidos.model.Producto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {

    private List<Producto> productos = new ArrayList<>();

    public List<Producto> listar() {
        return productos;
    }

    public Producto guardar(Producto producto) {
        productos.add(producto);
        return producto;
    }

    public Optional<Producto> buscarPorId(Long id) {
        return productos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public void eliminar(Long id) {
        productos.removeIf(p -> p.getId().equals(id));
    }
}