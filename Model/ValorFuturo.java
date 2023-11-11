package Model;
public class ValorFuturo {
    
    public Boolean ValorPresenteNeto(double Vp, double g, double a){
        double VPN = 0;
        double p = g - a;
        Vp = Vp + 4500;
        
        for (int i = 1; i < 9; i++){
            double CF = Calcular(p, i);
            VPN = VPN + (CF) / Math.pow((1+0.045),i);
        }
        VPN = VPN - Vp;
        if (VPN > 0){
            return true;
        }else {
            return false;
        }
    }
    
    
    public double Calcular(double P, int n){
        P = P * 12;
        double VF = P * Math.pow((1+0.045),n);
        return VF;
    }

}
