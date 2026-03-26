package co.ucc.apppedidos.repository;

import co.ucc.apppedidos.model.Producto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ProductoRepository {

    private final List<Producto> productos = new ArrayList<>();

    public List<Producto> listar() {
        return new ArrayList<>(productos);
    }

    public Producto guardar(Producto producto) {
        if (producto.getIdProducto() != null) {
            eliminar(producto.getIdProducto());
        }
        productos.add(producto);
        return producto;
    }

    public Producto buscarPorId(Long idProducto) {
        return productos.stream()
                .filter(producto -> Objects.equals(producto.getIdProducto(), idProducto))
                .findFirst()
                .orElse(null);
    }

    public void eliminar(Long idProducto) {
        productos.removeIf(producto -> Objects.equals(producto.getIdProducto(), idProducto));
    }
}
