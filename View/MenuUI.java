package View;


import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.Scanner;

import Model.CalculoFS;
import Model.CalculoKW;
import Model.CalculoPS;
import Model.CreatorCSV;
import Model.ValorFuturo;
import Model.Electrodomestico;
import Model.ElectrodomesticosList;
import Controller.Wait;
import Model.ECocina;
import Model.EEntretenimiento;
import Model.ELimpieza;

import java.util.Random;


public class MenuUI implements Funciones {
    
    private static final DecimalFormat df = new DecimalFormat("0.00");
    Scanner scan = new Scanner(System.in);
    int Exit = 0;
    int opcion = 0;
    
    
    /**
     * 
     */
    @Override
    public void menu(){

        System.out.println("Bienvenido!"+"\n"); 
        System.out.println("Opciones:");
        System.out.println("1.Calcular tarifa con pago mensual");
        System.out.println("2.Calcular tarifa con KiloWatts");
        System.out.println("3.Mostrar fuentes de informacion");
        System.out.println("4.Calcular por electrodoméstico");
        System.out.println("5.Salir");
        String Opciones1 = scan.nextLine();
        int Opciones = Integer.parseInt(Opciones1);

        switch (Opciones) {
            case 1:
                opcion = 1;
                break;
            case 2:
                opcion = 2;
                break;
            case 3:
                opcion = 3;
                break;
            case 4:
                opcion = 4;
                break;
            case 5:
                opcion = 5;
                break;
            default:
                opcion = 6;
                break;
        }
    }


    public static void calcular(double Kwatts, double pagoM){
        ArrayList<String> newT = new ArrayList<String>();
        CalculoPS calculoPS = new CalculoPS();
        ValorFuturo valorFuturo = new ValorFuturo();
        CreatorCSV creatorCSV = new CreatorCSV();

        double preciopanel = calculoPS.Calcular(Kwatts);
        double tarifarestante = calculoPS.getFacturaRestante();

        newT.add(df.format(Kwatts));
        newT.add(df.format(pagoM));
        
        
        System.out.println("\n");
        System.out.println("Calculando...");
        Wait.sleep(2000);
        System.out.println("\n");
        System.out.println("**********************************************************************************************************************************");
        System.out.println("El panel solar que mas le conviene es de capacidad de: "+calculoPS.getCapacidad()+"Kwatts");
        newT.add(Double.toString(calculoPS.getCapacidad()));
        Wait.sleep(500);
        System.out.println("El precio del panel solar que más le conviene según su consumo de energía es de: Q"+df.format(preciopanel));
        newT.add(Double.toString(preciopanel));
        Wait.sleep(500);
        System.out.println("Mas un costo de instalacion de Q4500.00");
        Wait.sleep(500);
        System.out.println("El excedente del consumo mensual de energía se lo tendrá que pagar a Eegsa, y sería un total de Q"+df.format(tarifarestante));
        newT.add(df.format(tarifarestante));
        Wait.sleep(1000);
        System.out.println("\n");
        if (valorFuturo.ValorPresenteNeto(preciopanel, pagoM, tarifarestante)){
            System.out.println("Le conviene comprar el panel solar, la compra se compensara en 8 años");
            newT.add("Si");
        } else {
            System.out.println("No le conviene comprar el panel solar");
            newT.add("No");
        }
        Random random = new Random(); 
        int N = random.nextInt(100) + 1;
        
        creatorCSV.CreateFileCSV(N, newT);
    }

    @Override
    public void KiloWatts(){
        CalculoKW calculoKW = new CalculoKW();
        System.out.println("Ingrese cuantos KiloWatts consume al mes:");
        double Kwatts = scan.nextInt();
        calculoKW.Calcular(Kwatts);
        double tarifan = calculoKW.getFacturaIva();
        System.out.println("Su tarifa actual es de: Q"+df.format(tarifan));
        //Print results
        calcular(Kwatts, tarifan);
        Exit = 6;
    }

    @Override
    public void PagoMensual(){
        CalculoFS calculoFS = new CalculoFS();
        System.out.println("Ingrese cuanto paga al mes por su factura de electricidad:");
        double pagoM = scan.nextInt();
        calculoFS.Calcular(pagoM);
        double Kwatts = calculoFS.getKwatts();
        System.out.println("Su consumo mensual de energía es de: "+df.format(Kwatts)+"Kwatts");
        // Print results
        calcular(Kwatts, pagoM);
        Exit = 6;
    }

    @Override
    public void info(){
        System.out.println("Informacion de tarifas y precios obtenidas de:");
        System.out.println("Tarifas: Eegsa");
        System.out.println("Precios: Aisa (Solar)");
        opcion = 0;
    }

    @Override
    public void Electrodomesticos(){
        ElectrodomesticosList manager = new ElectrodomesticosList();
        String nombre;
        double consumoEnergetico;
        int cantidad;
        System.out.println("");
        while (true) {
            System.out.println("Ingrese el electrodoméstico que desea agregar: ");
            nombre = scan.nextLine();
            System.out.println("Ingrese el consumo energético del electrodoméstico: ");
            consumoEnergetico = scan.nextDouble();
            System.out.println("Ingrese la cantidad de electrodomésticos: ");
            cantidad = scan.nextInt();
            
            System.out.println("Ingrese el tipo de electrodoméstico (1 - ECocina, 2 - EEntretenimiento, 3 - ELimpieza): ");
            int tipo = scan.nextInt();
            ECocina cocina;
            ELimpieza limpieza;
            EEntretenimiento entretenimiento;
            switch (tipo) {
                case 1:
                        switch (tipo) {
                            case 1:
                                System.out.println("Ingrese el dato extra para el tipo ECocina: ");
                                int temperatura = scan.nextInt();
                                cocina = new ECocina(nombre, consumoEnergetico, cantidad, temperatura);
                                manager.agregarCocina(cocina);
                                break;
                            case 2:
                                System.out.println("Ingrese el dato extra para el tipo ELimpieza: ");
                                boolean automatico = scan.nextBoolean();
                                limpieza = new ELimpieza(nombre, consumoEnergetico, cantidad, automatico);
                                manager.agregarLimpieza(limpieza);
                                break;
                            case 3:
                                System.out.println("Ingrese el dato extra para el tipo EEntretenimiento: ");
                                int pulgadas = scan.nextInt();
                                entretenimiento = new EEntretenimiento(nombre, consumoEnergetico, cantidad, pulgadas);
                                manager.agregarEntretenimiento(entretenimiento);
                                break;
                            default:
                                continue;
                        }
                        break;
                default:
                    continue;
            }
            
            System.out.println("Electrodoméstico agregado!");
            System.out.println("Lista de electrodomésticos agregados");
            manager.mostrarElectrodomesticos();
            System.out.println("¿Desea agregar otro electrodoméstico? (s/n)");
            String respuesta = scan.next();
            if (respuesta.equals("n")) {
                manager.calcularConsumoTotal();
                break;
            }
        }
        opcion = 0;
    }

    /**
     * 
     */
    @Override
    public void Error(){
        System.out.println("Error, ingrese una opcion valida");
        opcion = 0;
    }

    @Override
    public Boolean run() {
        return (Exit != 6);
    }

    @Override
    public void Salir(){
        System.out.println("Gracias por usar nuestro programa!");
        Exit = 6;
    }

    @Override
    public int Show() {
        if (opcion == 0){
            return 0;
        } else if (opcion == 1){
            return 1;
        } else if (opcion == 2){
            return 2;
        } else if (opcion == 3){
            return 3;
        } else if (opcion == 4){
            return 4;
        } else if (opcion == 5){
            return 5;
        } else {
            return 6;
        }
    }

}
