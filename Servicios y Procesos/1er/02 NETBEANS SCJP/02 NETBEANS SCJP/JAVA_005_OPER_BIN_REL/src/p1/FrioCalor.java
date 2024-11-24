// Crear una clase que evalúe si la temperatura del aula es mayor o menor de 22ºC.

package p1;

public class FrioCalor {

    public static void main(String[] args) {
        
        int temperatura = 22;
        
        if(temperatura >= 22) {
            System.out.println("HACE CALOR");
        }
        
        if(temperatura < 22) {
            System.out.println("HACE FRIO");
        }
    }    
}