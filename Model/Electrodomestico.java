package Model;

public class Electrodomestico {
    protected String nombre;
    protected double consumoEnergetico;
    protected int cantidad;

    public Electrodomestico(String nombre, double consumoEnergetico, int cantidad) {
        this.nombre = nombre;
        this.consumoEnergetico = consumoEnergetico;
        this.cantidad = cantidad;
    }

    public double calcularConsumoMensual() {
        return consumoEnergetico * cantidad;
    }
    public String getNombre() {
        return nombre;
    }
    public double getConsumoEnergetico() {
        return consumoEnergetico;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setConsumoEnergetico(double consumoEnergetico) {
        this.consumoEnergetico = consumoEnergetico;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}