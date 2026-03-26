package co.ucc.apppedidos.controller;

import co.ucc.apppedidos.model.HistorialInventario;
import co.ucc.apppedidos.model.Producto;
import co.ucc.apppedidos.model.Proveedor;
import co.ucc.apppedidos.service.ProductoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> listarProductos() {
        return productoService.listarProductos();
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoService.crearProducto(producto);
    }

    @GetMapping("/{id}")
    public Producto buscarProducto(@PathVariable("id") Long idProducto) {
        return productoService.buscarProducto(idProducto);
    }

    @PutMapping("/{id}/stock")
    public void actualizarStock(@PathVariable("id") Long idProducto,
                                @RequestParam int cantidad,
                                @RequestParam String tipo) {
        productoService.actualizarStock(idProducto, cantidad, tipo);
    }

    @GetMapping("/{id}/stock")
    public int consultarStock(@PathVariable("id") Long idProducto) {
        return productoService.consultarStock(idProducto);
    }

    @GetMapping("/{id}/historial")
    public List<HistorialInventario> listarHistorial(@PathVariable("id") Long idProducto) {
        return productoService.listarHistorial(idProducto);
    }

    @GetMapping("/proveedores")
    public List<Proveedor> listarProveedores() {
        return productoService.listarProveedores();
    }

    @PostMapping("/proveedores")
    public Proveedor guardarProveedor(@RequestBody Proveedor proveedor) {
        return productoService.guardarProveedor(proveedor);
    }
}
