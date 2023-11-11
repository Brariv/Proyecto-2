package Model;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CreatorCSV {
    

    public void CreateFileCSV(int N, ArrayList<String> newT) {
        String path = "Cotizacion"+N+".csv";    
        ArrayList<String> Rotulos = new ArrayList<String>();
        Rotulos.add("Consumo (Kw)");
        Rotulos.add("Pago Mensual (Q)");
        Rotulos.add("Capacidad Panel (Kw)");
        Rotulos.add("Precio Panel (Q)");
        Rotulos.add("Tarifa Restante (Q)");
        Rotulos.add("Le conviene comprar el panel solar?");
        try (FileWriter writer = new FileWriter(path)){
            for (String word : Rotulos) {
                writer.write(word);
                writer.write(",");
            }
            writer.write("\n");
            for (String word : newT) {
                writer.write(word);
                writer.write(",");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

