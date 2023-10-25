public class ValorFuturo {
    
    public double ValorPresenteNeto(double Vp, double g, double a){
        double VPN = 0;
        double p = g - a;
        
        
        
        for (int i = 1; i < 8; i++){
            double CF = Calcular(p, i);
            VPN = VPN + (CF) / Math.pow((1+0.045),i);
        }
        VPN = VPN - Vp;
        return VPN;
    }
    
    
    public double Calcular(double P, int n){
        P = P * 12;
        double VF = P * Math.pow((1+0.045),n);
        return VF;
    }

}
