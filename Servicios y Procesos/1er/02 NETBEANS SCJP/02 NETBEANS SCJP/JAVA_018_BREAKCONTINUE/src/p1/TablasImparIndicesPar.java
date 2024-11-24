// Crear una clase que imprima por pantalla las tablas de multiplicar entre el 1 y el
// 10 que tengan valor impar y de ellas, sólo los elementos que sean de valor par.
// Utilizar bucles for convencionales anidados y la sentencia continue.


package p1;

public class TablasImparIndicesPar {

    public static void main(String[] args) {
        
        for (int tabla = 1; tabla <= 10; tabla++) {
            
            if(tabla%2==0) {
                continue;
            }
            
            System.out.println("TABLA DEL " + tabla + "\n");
            
            for (int j = 1; j <= 10; j++) {
                if(j%2!=0) {
                    continue;
                }
                System.out.println(j + " * " + tabla + " = " + (j*tabla));
            }
            
            System.out.println("\n_______________________________________\n");
        }        
    }
}