package p7;

public class SueldoMasDetallado {

    public static void main(String[] args) {
        
        int sueldo = 500;

        // TERNARIO ANIDADO ... TOTAL 3 TERNARIOS:
        
        String opinion = (sueldo >= 2000)?
                (sueldo >= 6000)?"MUY BUENO":"BUENO" // ZONA RICA
                :
                (sueldo >= 1000)?"MALO":"MUY MALO"   // ZONA POBRE
                ;
        
        String opinion2="";
        if(sueldo >= 2000){
            if(sueldo >= 6000){
                opinion2="MUY BUENO";
            }else{
                opinion2="BUENO";
            }
        }else{
            if(sueldo >= 1000){
                opinion2="MALO";
            }else{
                opinion2="MUY MALO";
            }
        }
        
        
        // LO MISMO PERO EN UNA LÍNEA:
        
        String opinion2 = (sueldo >= 2000)?((sueldo >= 6000)?"MUY BUENO":"BUENO"):((sueldo >= 1000)?"MALO":"MUY MALO");

        
        System.out.println("opinion sobre " + sueldo + "€ ... " + opinion);        
        System.out.println("opinion2 sobre " + sueldo + "€ ... " + opinion2);
    }        
}