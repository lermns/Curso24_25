package p7;

public class FrioCalorTernario {

    public static void main(String[] args) {
        
        int temperatura = 180;
        
        String sensacion = (temperatura>=22)?"CALOR":"FRIO";
        
        System.out.println("SENSACION = " + sensacion);
    }    
}