package Model;
import java.util.ArrayList;
import java.util.List;



public class ElectrodomesticosList implements ElectrodomesticoManager {
    private List<Electrodomestico> electrodomesticos = new ArrayList<>();

    @Override
    public void agregarCocina(ECocina cocina) {
        electrodomesticos.add(cocina);
    }

    @Override
    public void agregarEntretenimiento(EEntretenimiento entretenimiento) {
        electrodomesticos.add(entretenimiento);
    }

    @Override
    public void agregarLimpieza(ELimpieza limpieza) {
        electrodomesticos.add(limpieza);
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