package Model;

public class ELimpieza extends Electrodomestico {
    private boolean automatico;

    public ELimpieza(String nombre, double consumoEnergetico, int cantidad, boolean automatico) {
        super(nombre, consumoEnergetico, cantidad);
        this.automatico = automatico;
    }

    public boolean isAutomatico() {
        return automatico;
    }
    public void setAutomatico(boolean automatico) {
        this.automatico = automatico;
    }
    public String toString() {
        return "Nombre: " + nombre + ", Consumo Energetico: " + consumoEnergetico + ", Cantidad: " + cantidad + ", Automatico: " + automatico;
    }
}
