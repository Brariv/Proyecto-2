public class CalculoKW {
    private static double Kwatts;
    private static double valorFactura;
    private static double precioKwattsNS = 1.36;
    private static double precioKwattsS = 1.28;

    public double Calcular(int KW){
        Kwatts = KW;
        if (Kwatts <= 300){
            valorFactura = Kwatts * precioKwattsS;
        } else if( Kwatts > 300) {
            valorFactura = Kwatts * precioKwattsNS;
        }
        valorFactura = valorFactura * 1.12;
        
        return valorFactura;
    }

    public static double getKwatts() {
        return Kwatts;
    }

}
