public class CalculoFS{
    private static double Kwatts;
    private static double valorFactura;
    private static double facturaIVA;
    private static double precioKwattsNS = 1.75;
    private static double precioKwattsS = 1.5;

    public void Calcular(double PL){
        facturaIVA = PL;
        double AP = facturaIVA * 0.10;
        facturaIVA = facturaIVA - AP;
        double IVA = facturaIVA * 0.12;
        valorFactura = facturaIVA - IVA;

        if (valorFactura <= 523.25){
           Kwatts = valorFactura / precioKwattsS;
        } else if( valorFactura > 523.25) {
           Kwatts = valorFactura / precioKwattsNS;
        }
        
    }

    public double getKwatts() {
        return Kwatts;
    }

    public double getFacturaIva() {
        return facturaIVA;
    }
}
