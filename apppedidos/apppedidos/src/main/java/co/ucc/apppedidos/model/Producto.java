package co.ucc.apppedidos.model;

public class Producto {

    private Long id;
    private String nombre;
    private double precio;
    private int stock;

    // Constructor vacío
    public Producto() {}

    // Constructor con parámetros
    public Producto(Long id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // MÉTODO DE NEGOCIO
    public void reducirStock(int cantidad) {
        if (cantidad > stock) {
            throw new RuntimeException("Stock insuficiente");
        }
        this.stock -= cantidad;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}