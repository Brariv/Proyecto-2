public class CalculoPS {
    CalculoKW calculoKW = new CalculoKW();
    private static double panel62kw = 27750;
    private static double panel68kw = 28303;
    private static double panel72kw = 31803;
    private static double panel80kw = 34000;
    private static double panel90kw = 34154;
    private static double panel100kw = 38904;
    private static double panel120kw = 52500;
    private static double panel150kw = 62610;
    private static double panel200kw = 86810;

    private static double facturaRestante;
    private static double capacidad;

    public double Calcular(double KWM){
        double KWD = KWM / 30;
        double panelPrecio = 0;
        
        if (KWD < 6.8){
            capacidad = 6.2;
            facturaRestante =  valorFactura(KWD, capacidad);
            panelPrecio = panel62kw;
        }
        if (KWD >= 6.8 && KWD < 7.2){
            capacidad = 6.8;
            facturaRestante =  valorFactura(KWD, capacidad);
            panelPrecio = panel68kw;
        }
        if (KWD >= 7.2 && KWD < 8){
            capacidad = 7.2;
            facturaRestante =  valorFactura(KWD, capacidad);
            panelPrecio = panel72kw;
        }
        if (KWD >= 8 && KWD < 9){
            capacidad = 8;
            facturaRestante =  valorFactura(KWD, capacidad);
            panelPrecio = panel80kw;
        }
        if (KWD >= 9 && KWD < 10){
            capacidad = 9;
            facturaRestante =  valorFactura(KWD, capacidad);
            panelPrecio = panel90kw;
        }
        if (KWD >= 10 && KWD < 12){
            capacidad = 10;
            facturaRestante =  valorFactura(KWD, capacidad);
            panelPrecio = panel100kw;
        }
        if (KWD >= 12 && KWD < 15){
            capacidad = 12;
            facturaRestante =  valorFactura(KWD, capacidad);
            panelPrecio = panel120kw;
        }
        if (KWD >= 15 && KWD < 20){
            capacidad = 15;
            facturaRestante =  valorFactura(KWD, capacidad);
            panelPrecio = panel150kw;
        }
        if (KWD >= 20){
            capacidad = 20;
            facturaRestante =  valorFactura(KWD, capacidad);
            panelPrecio = panel200kw;
        }


        return panelPrecio;

    }

    private double valorFactura(double KWD, double panelCapacidad){
        double KWR = KWD - panelCapacidad;
        if (KWR < 0){
            KWR = 0;
            return KWR;
        }else{
            double KWM = KWR * 30;
            calculoKW.Calcular(KWM);
            double facturaIVA = calculoKW.getFacturaIva();
            return facturaIVA;
        }
    }

    public double getFacturaRestante(){
        return facturaRestante;
    }

    public double getCapacidad(){
        return capacidad;
    }

    
}   
