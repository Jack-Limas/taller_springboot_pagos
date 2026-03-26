package co.ucc.apppedidos.model;

public class Vehiculo {

    private Long idVehiculo;
    private String placa;
    private String tipo;       // Ej: Camión, Moto, Furgón
    private double capacidad;  // Capacidad en kg

    public Vehiculo() {}

    public Vehiculo(Long idVehiculo, String placa, String tipo, double capacidad) {
        this.idVehiculo = idVehiculo;
        this.placa = placa;
        this.tipo = tipo;
        this.capacidad = capacidad;
    }

    // Getters y Setters

    public Long getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Long idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }
}