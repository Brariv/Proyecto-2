package Model;

public interface ElectrodomesticoManager {
    void agregarCocina(ECocina cocina);
    void calcularConsumoTotal();
    void mostrarElectrodomesticos();
    void agregarEntretenimiento(EEntretenimiento entretenimiento);
    void agregarLimpieza(ELimpieza limpieza);

}
