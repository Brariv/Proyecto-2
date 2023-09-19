import java.util.Scanner;

public class MenuUI {
    public static void main(String[] args) {
        CalculoFS calculoFS = new CalculoFS();
        CalculoKW calculoKW = new CalculoKW();
        CalculoPS calculoPS = new CalculoPS();
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
            double pagoM = scan.nextInt();
            calculoFS.Calcular(pagoM);
            double Kwatts = calculoFS.getKwatts();
            System.out.println("Su consumo mensual de energía es de: "+Kwatts+"Kwatts");
            double preciopanel = calculoPS.Calcular(Kwatts);
            double tarifarestante = calculoPS.getFacturaRestante();
            System.out.println("El precio del panel solar que más le conviene  según su consumo de energía es de: Q"+preciopanel);
            System.out.println("El excedente del consumo mensual de energía se lo tendrá que pagar a Eegsa, y sería un total de Q"+tarifarestante);

        } else if (Opciones.equals("2")){
            System.out.println("Ingrese cuantos KiloWatts consume al mes:");
            double Kwatts = scan.nextInt();
            calculoKW.Calcular(Kwatts);
            double tarifan = calculoKW.getFacturaIva();
            System.out.println("Su tarifa actual es de: Q"+tarifan);
            double preciopanel = calculoPS.Calcular(Kwatts);
            double tarifarestante = calculoPS.getFacturaRestante();
            System.out.println("El precio del panel solar que más le conviene  según su consumo de energía es de: Q"+preciopanel);
            System.out.println("El excedente del consumo mensual de energía se lo tendrá que pagar a Eegsa, y sería un total de Q"+tarifarestante);



        } else if (Opciones.equals("3")){
            System.out.println("Informacion de tarifas y precios obtenidas de:");
            System.out.println("Tarifas: Eegsa");
            System.out.println("Precios: Aisa (Solar)");
            
        }
    }
}
