package View;

import Controller.MenuUI;
import Model.Funciones;

public class Driver {
    

    public static void main(String[] args) {
        Funciones interfazGrafica = (Funciones) new MenuUI();


        while (interfazGrafica.run()){

            if (interfazGrafica.Show() == 0){
                interfazGrafica.menu();
            }else if(interfazGrafica.Show() == 1){
                interfazGrafica.PagoMensual();
            }else if(interfazGrafica.Show() == 2){
                interfazGrafica.KiloWatts();
            }else if(interfazGrafica.Show() == 3){
                interfazGrafica.info();
            }else if(interfazGrafica.Show() == 4){
                interfazGrafica.Electrodomesticos();
            }else if(interfazGrafica.Show() == 5){
                interfazGrafica.Salir();
            }else{
                interfazGrafica.Error();
            }
        }

    }
}
