package Model;
import java.util.ArrayList;
import java.util.List;

interface ElectrodomesticosManager {
    void agregarElectrodomestico(Electrodomestico electrodomestico);
    void calcularConsumoTotal();
    void mostrarElectrodomesticos();
}

class Electrodomestico {
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

class ElectrodomesticosList implements ElectrodomesticosManager {
    private List<Electrodomestico> electrodomesticos = new ArrayList<>();

    @Override
    public void agregarElectrodomestico(Electrodomestico electrodomestico) {
        electrodomesticos.add(electrodomestico);
    }

    @Override
    public void calcularConsumoTotal() {
        double consumoTotal = 0;
        for (Electrodomestico electrodomestico : electrodomesticos) {
            consumoTotal += electrodomestico.calcularConsumoMensual();
        }
        System.out.println("Consumo total: " + consumoTotal + " kilowatts");
        
    }

    @Override
    public void mostrarElectrodomesticos() {
        for (Electrodomestico electrodomestico : electrodomesticos) {
            System.out.println(electrodomestico);
        }
    }
}