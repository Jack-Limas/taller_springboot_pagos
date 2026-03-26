package co.ucc.apppedidos.model;

public class Distribuidor {

    private Long idDistribuidor;
    private String nombre;
    private String telefono;
    private Vehiculo vehiculo; // Vehículo asignado

    public Distribuidor() {}

    public Distribuidor(Long idDistribuidor, String nombre, String telefono, Vehiculo vehiculo) {
        this.idDistribuidor = idDistribuidor;
        this.nombre = nombre;
        this.telefono = telefono;
        this.vehiculo = vehiculo;
    }

    // Getters y Setters

    public Long getIdDistribuidor() {
        return idDistribuidor;
    }

    public void setIdDistribuidor(Long idDistribuidor) {
        this.idDistribuidor = idDistribuidor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}