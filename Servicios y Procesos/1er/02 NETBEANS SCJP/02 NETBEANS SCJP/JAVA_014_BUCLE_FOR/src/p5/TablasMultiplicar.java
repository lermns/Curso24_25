// Crear una clase que imprima las tablas de multiplicar desde la 1 a la 10, exceptuando la del 5. Utilizar
// bucles for convencionales anidados y la sentencia continue (vuelve a la cabecera del for, saltando un paso).


package p5;

public class TablasMultiplicar {

    public static void main(String[] args) {
        
        int tablaProhibida = 5;
        
        for (int tabla = 1; tabla <= 10; tabla++) {
            
            if(tabla == tablaProhibida) {
                continue; // se va a la zona de operaciones: tabla++;
            }
            
            System.out.println("\n________TABLA DEL: " + tabla + "_________\n");            
            
            for (int indice = 1; indice  <= 10; indice++) {
                System.out.println(indice + " * " + tabla + " = " + (indice*tabla));
            }            
        }
    }
}