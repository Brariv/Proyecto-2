package Model;
public class ValorFuturo {
    
    //Generado Con IA, "Has un codigo en java que calcule el valor valor presente neto inversion a 9 años, con la formula de valor presente neto"

    public Boolean ValorPresenteNeto(double Vp, double g, double a){
        double VPN = 0;
        double p = g - a;
        Vp = Vp + 4500;
        
        for (int i = 1; i < 9; i++){
            double CF = Calcular(p*12, i);
            VPN = VPN + (CF) / Math.pow((1.045),i);
        }
        VPN = VPN - Vp;
        if (VPN > 0){
            
            return true;
            
        }else {
            
            return false;
        }
    }
    
    
    public double Calcular(double p, double n){
        double i = 0.045;
        double vf = p * Math.pow((1+i),n);
        return vf;
    }

}
