package co.ucc.apppedidos.service;

import co.ucc.apppedidos.model.HistorialInventario;
import co.ucc.apppedidos.model.Producto;
import co.ucc.apppedidos.model.Proveedor;
import co.ucc.apppedidos.repository.HistorialInventarioRepository;
import co.ucc.apppedidos.repository.ProductoRepository;
import co.ucc.apppedidos.repository.ProveedorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class ProductoService {

    private static final Set<String> TIPOS_MOVIMIENTO_VALIDOS = Set.of("ENTRADA", "SALIDA", "AJUSTE");

    private final ProductoRepository productoRepository;
    private final HistorialInventarioRepository historialInventarioRepository;
    private final ProveedorRepository proveedorRepository;

    public ProductoService(ProductoRepository productoRepository,
                           HistorialInventarioRepository historialInventarioRepository,
                           ProveedorRepository proveedorRepository) {
        this.productoRepository = productoRepository;
        this.historialInventarioRepository = historialInventarioRepository;
        this.proveedorRepository = proveedorRepository;
    }

    @Transactional(readOnly = true)
    public List<Producto> listarProductos() {
        return productoRepository.listar();
    }

    @Transactional
    public Producto crearProducto(Producto producto) {
        if (producto.getNombre() == null || producto.getNombre().isBlank()) {
            throw new IllegalArgumentException("El producto debe tener nombre");
        }
        return productoRepository.guardar(producto);
    }

    public Producto buscarProducto(Long idProducto) {
        Producto producto = productoRepository.buscarPorId(idProducto);
        if (producto == null) {
            throw new IllegalArgumentException("Producto no encontrado: " + idProducto);
        }
        return producto;
    }

    @Transactional
    public void actualizarStock(Long idProducto, int cantidad, String tipo) {
        if (!TIPOS_MOVIMIENTO_VALIDOS.contains(tipo)) {
            throw new IllegalArgumentException("Tipo de movimiento invalido: " + tipo);
        }

        Producto producto = buscarProducto(idProducto);
        int nuevoStock;
        int stockActual = producto.getStock() == null ? 0 : producto.getStock();

        if ("SALIDA".equals(tipo)) {
            nuevoStock = stockActual - cantidad;
            if (nuevoStock < 0) {
                throw new IllegalArgumentException("Stock insuficiente para el producto " + idProducto);
            }
        } else {
            nuevoStock = stockActual + cantidad;
        }

        producto.setStock(nuevoStock);
        productoRepository.guardar(producto);

        HistorialInventario movimiento = new HistorialInventario();
        movimiento.setFechaMovimiento(new Date());
        movimiento.setProducto(producto);
        movimiento.setCantidad(cantidad);
        movimiento.setTipoMovimiento(tipo);
        movimiento.setDescripcion("Movimiento " + tipo + " para producto " + producto.getNombre());
        historialInventarioRepository.guardar(movimiento);
    }

    @Transactional(readOnly = true)
    public int consultarStock(Long idProducto) {
        Integer stock = buscarProducto(idProducto).getStock();
        return stock == null ? 0 : stock;
    }

    @Transactional(readOnly = true)
    public List<HistorialInventario> listarHistorial(Long idProducto) {
        buscarProducto(idProducto);
        return historialInventarioRepository.buscarPorProducto(idProducto);
    }

    @Transactional(readOnly = true)
    public List<Proveedor> listarProveedores() {
        return proveedorRepository.listar();
    }

    @Transactional
    public Proveedor guardarProveedor(Proveedor proveedor) {
        if (proveedor.getNombre() == null || proveedor.getNombre().isBlank()) {
            throw new IllegalArgumentException("El proveedor debe tener nombre");
        }
        return proveedorRepository.guardar(proveedor);
    }
}
