import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Bienvenido!"+"\n"); 
        System.out.println("Opciones:");
        System.out.println("1.Calcular tarifa con pago mensual");
        System.out.println("2.Calcular tarifa con KiloWatts");
        System.out.println("3.Mostrar fuentes de informacion");
        System.out.println("4.Salir");
        String Opciones = scan.nextLine();


        if (Opciones.equals("1")){
            System.out.println("Ingrese cuanto paga al mes por su factura de electricidad:");
            int pagoM = scan.nextInt();
            
        } else if (Opciones.equals("2")){
            System.out.println("Ingrese cuantos KiloWatts consume al mes:");
            int Kwatts = scan.nextInt();
            
        } else if (Opciones.equals("3")){
            System.out.println("Informacion de tarifas y precios obtenidas de:");
            System.out.println("Tarifas: LuzSA");
            System.out.println("Precios: PanelesGT");
            
        }
    }
}
