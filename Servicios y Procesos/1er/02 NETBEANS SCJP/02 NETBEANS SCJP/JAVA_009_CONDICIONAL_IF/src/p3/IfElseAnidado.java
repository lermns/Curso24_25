// Crear una clase que establezca la calidad del sueldo de una persona en base a 
// un total de 4 tramos (MUY MALO - MALO - BUENO - MUY BUENO), para lo cuál deberá
// emplear sentencias de tipo if-else anidadas (unas dentro de otras).


package p3;

public class IfElseAnidado {

    public static void main(String[] args) {
        
        int sueldo = 2000;
        
        if(sueldo >= 1500) {
            if(sueldo >= 3000) {
                System.out.println("SUELDO MUY BUENO");
            } else {
                System.out.println("SUELDO BUENO");
            }
        } else {
            if(sueldo >= 1000) {
                System.out.println("SUELDO MALO");
            } else {
                System.out.println("SUELDO MUY MALO");
            }
        }        
    }    
}