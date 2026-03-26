package co.ucc.apppedidos.repository;

import co.ucc.apppedidos.model.Vendedor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VendedorRepository {

    private List<Vendedor> vendedores = new ArrayList<>();

    public List<Vendedor> listar() {
        return vendedores;
    }

    public Vendedor guardar(Vendedor vendedor) {
        vendedores.add(vendedor);
        return vendedor;
    }

    public Optional<Vendedor> buscarPorId(Long id) {
        return vendedores.stream()
                .filter(v -> v.getIdVendedor().equals(id))
                .findFirst();
    }
}