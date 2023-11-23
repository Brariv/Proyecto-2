package Model;

public class EEntretenimiento extends Electrodomestico {
    private int pulgadas;

    public EEntretenimiento(String nombre, double consumoEnergetico, int cantidad, int pulgadas) {
        super(nombre, consumoEnergetico, cantidad);
        this.pulgadas = pulgadas;
    }

    public int getPulgadas() {
        return pulgadas;
    }
    public void setPulgadas(int pulgadas) {
        this.pulgadas = pulgadas;
    }
    public String toString() {
        return "Nombre: " + nombre + ", Consumo Energetico: " + consumoEnergetico + ", Cantidad: " + cantidad + ", Pulgadas: " + pulgadas;
    }
}