package p7;

public class SueldoBuenoMalo {
    
    public static void main(String[] args) {
        
        int sueldo = 5000;
        
        String opinion = (sueldo >= 2000)?"BUENO":"MALO";
        
        System.out.println("opinion sobre " + sueldo + "€ ... " + opinion);
                
        if(sueldo >= 2000) {
            opinion = "BUENO";
        } else {
            opinion = "MALO";
        }
        
        System.out.println("opinion IF-ELSE sobre " + sueldo + "€ ... " + opinion);       
    }
}