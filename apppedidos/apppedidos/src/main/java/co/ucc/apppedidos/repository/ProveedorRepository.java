package co.ucc.apppedidos.repository;

import co.ucc.apppedidos.model.Proveedor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ProveedorRepository {

    private final List<Proveedor> proveedores = new ArrayList<>();

    public List<Proveedor> listar() {
        return new ArrayList<>(proveedores);
    }

    public Proveedor guardar(Proveedor proveedor) {
        if (proveedor.getIdProveedor() != null) {
            eliminar(proveedor.getIdProveedor());
        }
        proveedores.add(proveedor);
        return proveedor;
    }

    public Proveedor buscarPorId(Long idProveedor) {
        return proveedores.stream()
                .filter(proveedor -> Objects.equals(proveedor.getIdProveedor(), idProveedor))
                .findFirst()
                .orElse(null);
    }

    public void eliminar(Long idProveedor) {
        proveedores.removeIf(proveedor -> Objects.equals(proveedor.getIdProveedor(), idProveedor));
    }
}
