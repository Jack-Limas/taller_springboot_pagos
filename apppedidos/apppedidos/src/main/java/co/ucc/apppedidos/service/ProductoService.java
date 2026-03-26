package co.ucc.apppedidos.service;

import co.ucc.apppedidos.model.HistorialInventario;
import co.ucc.apppedidos.model.Producto;
import co.ucc.apppedidos.model.Proveedor;
import co.ucc.apppedidos.repository.HistorialInventarioRepository;
import co.ucc.apppedidos.repository.ProductoRepository;
import co.ucc.apppedidos.repository.ProveedorRepository;
import org.springframework.stereotype.Service;

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

    public List<Producto> listarProductos() {
        return productoRepository.listar();
    }

    public Producto crearProducto(Producto producto) {
        if (producto.getIdProducto() == null) {
            throw new IllegalArgumentException("El producto debe tener idProducto");
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

    public void actualizarStock(Long idProducto, int cantidad, String tipo) {
        if (!TIPOS_MOVIMIENTO_VALIDOS.contains(tipo)) {
            throw new IllegalArgumentException("Tipo de movimiento invalido: " + tipo);
        }

        Producto producto = buscarProducto(idProducto);
        int nuevoStock;

        if ("SALIDA".equals(tipo)) {
            nuevoStock = producto.getStock() - cantidad;
            if (nuevoStock < 0) {
                throw new IllegalArgumentException("Stock insuficiente para el producto " + idProducto);
            }
        } else {
            nuevoStock = producto.getStock() + cantidad;
        }

        producto.setStock(nuevoStock);
        productoRepository.guardar(producto);

        HistorialInventario movimiento = new HistorialInventario();
        movimiento.setIdMovimiento((long) historialInventarioRepository.listar().size() + 1);
        movimiento.setFechaMovimiento(new Date());
        movimiento.setProducto(producto);
        movimiento.setCantidad(cantidad);
        movimiento.setTipoMovimiento(tipo);
        movimiento.setDescripcion("Movimiento " + tipo + " para producto " + producto.getNombre());
        historialInventarioRepository.guardar(movimiento);
    }

    public int consultarStock(Long idProducto) {
        return buscarProducto(idProducto).getStock();
    }

    public List<HistorialInventario> listarHistorial(Long idProducto) {
        buscarProducto(idProducto);
        return historialInventarioRepository.buscarPorProducto(idProducto);
    }

    public List<Proveedor> listarProveedores() {
        return proveedorRepository.listar();
    }

    public Proveedor guardarProveedor(Proveedor proveedor) {
        if (proveedor.getIdProveedor() == null) {
            throw new IllegalArgumentException("El proveedor debe tener idProveedor");
        }
        return proveedorRepository.guardar(proveedor);
    }
}
