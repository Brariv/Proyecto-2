public class CalculoKW{
    private static double Kwatts;
    private static double valorFactura;
    private static double facturaIVA;
    private static double precioKwattsNS = 1.75;
    private static double precioKwattsS = 1.5;

    public void Calcular(double KW){
        Kwatts = KW;
        if (Kwatts <= 300){
            valorFactura = Kwatts * precioKwattsS;
        } else if( Kwatts > 300) {
            valorFactura = Kwatts * precioKwattsNS;
        }
        facturaIVA = valorFactura * 1.12;
        facturaIVA = facturaIVA *1.10;
        
    }

    public double getKwatts() {
        return Kwatts;
    }

    public double getFacturaIva() {
        return facturaIVA;
    }

}
