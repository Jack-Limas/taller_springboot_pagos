package co.ucc.apppedidos.repository;


import co.ucc.apppedidos.model.Proveedor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProveedorRepository {

    private List<Proveedor> proveedores = new ArrayList<>();

    public List<Proveedor> listar() {
        return proveedores;
    }

    public Proveedor guardar(Proveedor proveedor) {
        proveedores.add(proveedor);
        return proveedor;
    }

    public Optional<Proveedor> buscarPorId(Long id) {
        return proveedores.stream()
                .filter(p -> p.getIdProveedor().equals(id))
                .findFirst();
    }
}