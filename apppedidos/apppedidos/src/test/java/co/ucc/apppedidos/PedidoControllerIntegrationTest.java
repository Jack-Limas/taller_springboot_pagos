package co.ucc.apppedidos;

import co.ucc.apppedidos.model.Cliente;
import co.ucc.apppedidos.model.DetallePedido;
import co.ucc.apppedidos.model.Pedido;
import co.ucc.apppedidos.model.Producto;
import co.ucc.apppedidos.repository.ClienteRepository;
import co.ucc.apppedidos.repository.ProductoRepository;
import co.ucc.apppedidos.service.PedidoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class PedidoControllerIntegrationTest {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoRepository productoRepository;

    private Cliente cliente;
    private Producto producto;

    @BeforeEach
    void setUp() {
        productoRepository.deleteAll();
        clienteRepository.deleteAll();

        cliente = new Cliente();
        cliente.setNombre("Juan Perez");
        cliente.setDireccion("Calle 10");
        cliente.setTelefono("3001234567");
        cliente = clienteRepository.save(cliente);

        producto = new Producto();
        producto.setNombre("Teclado");
        producto.setPrecio(95000.0);
        producto.setStock(20);
        producto = productoRepository.save(producto);
    }

    @Test
    void registrarPedidoDebeResponderOk() throws Exception {
        DetallePedido detallePedido = new DetallePedido();
        detallePedido.setCantidad(2);
        detallePedido.setProducto(producto);

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setDetalles(List.of(detallePedido));

        Pedido respuesta = pedidoService.registrarPedido(pedido);

        assertNotNull(respuesta);
        assertNotNull(respuesta.getIdPedido());
        assertEquals(190000.0, respuesta.getTotal());
        assertEquals(1, respuesta.getDetalles().size());
    }
}
