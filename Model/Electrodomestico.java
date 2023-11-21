package Model;

public class Electrodomestico {
    private String nombre;
    private double consumoEnergetico;
    private int cantidad;

    public Electrodomestico(String nombre, double consumoEnergetico, int cantidad) {
        this.nombre = nombre;
        this.consumoEnergetico = consumoEnergetico;
        this.cantidad = cantidad;
    }

    public double calcularConsumoMensual() {
        return consumoEnergetico * cantidad;
    }

    @Override
    public String toString() {
        return nombre + ": Cantidad=" + cantidad + ", Consumo mensual=" + calcularConsumoMensual() + " kilowatts";
    }
}