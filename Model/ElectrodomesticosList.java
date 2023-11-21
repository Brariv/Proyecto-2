package Model;
import java.util.ArrayList;
import java.util.List;



public class ElectrodomesticosList implements ElectrodomesticoManager {
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