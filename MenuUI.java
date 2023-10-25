import java.text.DecimalFormat;
import java.util.Scanner;

public class MenuUI {
    
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public static void main(String[] args) {

        CalculoFS calculoFS = new CalculoFS();
        CalculoKW calculoKW = new CalculoKW();
        CalculoPS calculoPS = new CalculoPS();
        ValorFuturo valorFuturo = new ValorFuturo();
        ElectrodomesticosManager manager = new ElectrodomesticosList();
        Scanner scan = new Scanner(System.in);
        
        
        System.out.println("Bienvenido!"+"\n"); 
        System.out.println("Opciones:");
        System.out.println("1.Calcular tarifa con pago mensual");
        System.out.println("2.Calcular tarifa con KiloWatts");
        System.out.println("3.Mostrar fuentes de informacion");
        System.out.println("4.Calcular por electrodoméstico");
        System.out.println("5.Salir");
        String Opciones = scan.nextLine();
        String nombre;
        double consumoEnergetico;
        int cantidad;
        

        if (Opciones.equals("1")){
            System.out.println("Ingrese cuanto paga al mes por su factura de electricidad:");
            double pagoM = scan.nextInt();
            calculoFS.Calcular(pagoM);
            double Kwatts = calculoFS.getKwatts();
            System.out.println("Su consumo mensual de energía es de: "+Kwatts+"Kwatts");
            double preciopanel = calculoPS.Calcular(Kwatts);
            double tarifarestante = calculoPS.getFacturaRestante();
            System.out.println("El panel solar que mas le conviene es de capacidad de: "+calculoPS.getCapacidad()+"Kwatts");
            System.out.println("El precio del panel solar que más le conviene  según su consumo de energía es de: Q"+df.format(preciopanel));
            System.out.println("Mas un costo de instalacion de Q4500.00");
            System.out.println("El excedente del consumo mensual de energía se lo tendrá que pagar a Eegsa, y sería un total de Q"+df.format(tarifarestante));
            if (valorFuturo.ValorPresenteNeto(preciopanel, pagoM, tarifarestante)){
                System.out.println("Le conviene comprar el panel solar, la compra se compensara en 8 años");
            } else {
                System.out.println("No le conviene comprar el panel solar");
            }

        } else if (Opciones.equals("2")){
            System.out.println("Ingrese cuantos KiloWatts consume al mes:");
            double Kwatts = scan.nextInt();
            calculoKW.Calcular(Kwatts);
            double tarifan = calculoKW.getFacturaIva();
            System.out.println("Su tarifa actual es de: Q"+df.format(tarifan));
            double preciopanel = calculoPS.Calcular(Kwatts);
            double tarifarestante = calculoPS.getFacturaRestante();
            System.out.println("El panel solar que mas le conviene es de capacidad de: "+calculoPS.getCapacidad()+"Kwatts");
            System.out.println("El precio del panel solar que más le conviene  según su consumo de energía es de: Q"+df.format(preciopanel));
            System.out.println("Mas un costo de instalacion de Q4500.00");
            System.out.println("El excedente del consumo mensual de energía se lo tendrá que pagar a Eegsa, y sería un total de Q"+df.format(tarifarestante));
            if (valorFuturo.ValorPresenteNeto(preciopanel, tarifan, tarifarestante)){
                System.out.println("Le conviene comprar el panel solar, la compra se compensara en 8 años");
            } else {
                System.out.println("No le conviene comprar el panel solar");
            }



        } else if (Opciones.equals("3")){
            System.out.println("Informacion de tarifas y precios obtenidas de:");
            System.out.println("Tarifas: Eegsa");
            System.out.println("Precios: Aisa (Solar)");
            
        }
        else if (Opciones.equals("4")){
            System.out.println("");
            while (true){
                System.out.println("Ingrese el electrodomestico que desea agregar: ");
                nombre = scan.nextLine();
                nombre = scan.nextLine();
                System.out.println("Ingrese el consumo energetico del electrodomestico: ");
                consumoEnergetico = scan.nextDouble();
                System.out.println("Ingrese la cantidad de electrodomesticos: ");
                cantidad = scan.nextInt();
                Electrodomestico electrodomestico = new Electrodomestico(nombre, consumoEnergetico, cantidad);
                manager.agregarElectrodomestico(electrodomestico);
                System.out.println("Electrodomestico agregado!");
                System.out.println("Liste de electrodomésticos agregados");
                manager.mostrarElectrodomesticos();
                System.out.println("Desea agregar otro electrodomestico? (s/n)");
                String respuesta = scan.next();
                if (respuesta.equals("n")) {
                    manager.calcularConsumoTotal();
                    break;

                }
            }
        }
    }
}
