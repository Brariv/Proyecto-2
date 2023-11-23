package Model;

public class ECocina extends Electrodomestico {
    private int temperatura;

    public ECocina(String nombre, double consumoEnergetico, int cantidad, int temperatura) {
        super(nombre, consumoEnergetico, cantidad);
        this.temperatura = temperatura;
    }

    public int getTemperatura() {
        return temperatura;
    }
    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }
    public String toString() {
        return "Nombre: " + nombre + ", Consumo Energetico: " + consumoEnergetico + ", Cantidad: " + cantidad + ", Temperatura: " + temperatura;
    }
}