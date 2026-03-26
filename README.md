# API de Gestion de Pedidos con Spring Boot

Proyecto Spring Boot para gestionar clientes, productos, compras, ventas, facturas, inventario, proveedores, vendedores, distribuidores, vehiculos y envios mediante una API REST.

## Estado actual del proyecto

- El proyecto Maven real esta dentro de `apppedidos/apppedidos`.
- Usa Spring Boot `4.0.3`.
- Usa Java `21`.
- La aplicacion expone endpoints REST con `spring-boot-starter-webmvc`.
- No hay base de datos configurada en `application.properties`.
- La informacion se almacena en memoria usando listas dentro de la capa `repository`, por lo que los datos se pierden al reiniciar la aplicacion.

## Estructura del repositorio

```text
tallerspringboot/
|-- README.md
|-- .gitignore
`-- apppedidos/
    `-- apppedidos/
        |-- pom.xml
        |-- mvnw
        |-- mvnw.cmd
        |-- src/
        `-- target/
```

## Requisitos

- Git
- Java 21
- Maven 3.9+ opcional, porque el proyecto ya incluye Maven Wrapper

## Comandos despues de hacer git clone

### 1. Clonar el repositorio

```bash
git clone <URL_DEL_REPOSITORIO>
```

### 2. Entrar al proyecto

```bash
cd tallerspringboot
cd apppedidos/apppedidos
```

### 3. Ejecutar la aplicacion

En Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

En Linux o macOS:

```bash
chmod +x mvnw
./mvnw spring-boot:run
```

Si ya tienes Maven instalado globalmente:

```bash
mvn spring-boot:run
```

## Comandos utiles para desarrollo

Compilar el proyecto:

```bash
./mvnw clean compile
```

Ejecutar pruebas:

```bash
./mvnw test
```

Generar el `.jar`:

```bash
./mvnw clean package
```

En Windows puedes reemplazar `./mvnw` por `.\mvnw.cmd`.

## URL base de la API

Una vez iniciada la aplicacion, la API queda disponible en:

```text
http://localhost:8080
```

Endpoint de prueba:

```text
GET /
```

## Recursos disponibles

La aplicacion tiene controladores REST para estos recursos:

- `/clientes`
- `/productos`
- `/compras`
- `/ventas`
- `/facturas`
- `/detalles`
- `/inventarios`
- `/proveedores`
- `/vendedores`
- `/vehiculos`
- `/distribuidores`
- `/envios`

## Operaciones encontradas en la API

La mayoria de controladores implementan:

- `GET /recurso` para listar
- `POST /recurso` para crear
- `GET /recurso/{id}` para consultar por id

Adicionalmente:

- `DELETE /clientes/{id}`
- `DELETE /productos/{id}`

## Ejemplos de uso

Crear un cliente:

```bash
curl -X POST http://localhost:8080/clientes ^
  -H "Content-Type: application/json" ^
  -d "{\"id\":1,\"nombre\":\"Juan Perez\",\"direccion\":\"Calle 10\",\"telefono\":\"3001234567\"}"
```

Listar clientes:

```bash
curl http://localhost:8080/clientes
```

Crear un producto:

```bash
curl -X POST http://localhost:8080/productos ^
  -H "Content-Type: application/json" ^
  -d "{\"id\":1,\"nombre\":\"Teclado\",\"precio\":95000,\"stock\":20}"
```

Listar productos:

```bash
curl http://localhost:8080/productos
```

## Modelo de dominio identificado

Las entidades principales del proyecto son:

- `Cliente`: id, nombre, direccion, telefono
- `Producto`: id, nombre, precio, stock
- `Compra`: id, cliente, detalles
- `Venta`: idVenta, fecha, total, vendedor, detalles
- `Factura`: idFactura, numeroFactura, fecha, venta
- `DetalleFactura`: idDetalle, producto, cantidad, precioUnitario, subtotal
- `Inventario`: idInventario, fechaActualizacion
- `Proveedor`: idProveedor, nombre, telefono, direccion
- `Vendedor`: idVendedor, nombre
- `Vehiculo`: idVehiculo, placa, tipo, capacidad
- `Distribuidor`: idDistribuidor, nombre, telefono, vehiculo
- `Envio`: idEnvio, factura, distribuidor, vehiculo, fechaEnvio, estado

## Arquitectura del proyecto

El proyecto sigue una separacion por capas:

- `controller`: expone los endpoints REST
- `services`: contiene la logica de aplicacion
- `repository`: almacena datos en memoria
- `model`: define las entidades del dominio

## Configuracion

Archivo actual:

```properties
spring.application.name=apppedidos
```

No hay configuracion de base de datos, puertos personalizados, perfiles activos ni variables de entorno obligatorias.

## Observaciones importantes

- La carpeta `target/` no debe subirse al repositorio.
- El wrapper de Maven (`mvnw`, `mvnw.cmd` y `.mvn/`) si debe conservarse versionado.
- Si clonas el proyecto y no tienes Maven instalado, puedes trabajar solo con el wrapper.
- En este momento no se detecta persistencia en base de datos; si reinicias la app, los registros creados vuelven a quedar vacios.
