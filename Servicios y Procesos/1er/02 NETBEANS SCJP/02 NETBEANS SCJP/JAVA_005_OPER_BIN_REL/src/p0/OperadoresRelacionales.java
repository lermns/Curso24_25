// Crear una clase que utilice los operadores de relación (evaluación final a booleano).

package p0;

public class OperadoresRelacionales {

    public static void main(String[] args) {
        
        int numero1 = 10;
        int numero2 = 20;
        
        if(numero1 > numero2) {
            System.out.println(numero1 + " ES MAYOR QUE " + numero2);
        }
        
        if(numero1 >= numero2) {
            System.out.println(numero1 + " ES MAYOR O IGUAL QUE " + numero2);
        }

        if(numero1 < numero2) {
            System.out.println(numero1 + " ES MENOR QUE " + numero2);
        }
        
        if(numero1 <= numero2) {
            System.out.println(numero1 + " ES MENOR O IGUAL QUE " + numero2);
        }

        if(numero1 == numero2) {
            System.out.println(numero1 + " ES IGUAL QUE " + numero2);
        }
        
        if(numero1 != numero2) {
            System.out.println(numero1 + " ES DISTINTO QUE " + numero2);
        }        
    }    
}