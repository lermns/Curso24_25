// Crear una clase que ponga de manifiesto la declaración de parámetros finales como
// elementos de entrada al método y la NO posibilidad de modificar el valor de los mismos
// en el interior de dicho método(valor en primitivos, patrón de bits en referenciados).


package p0;

public class Multiplicador {
    
    public static void multiplicarX2(final int numero) {
        System.out.println("numero inicio metodo = " + numero);        
        
        // ERROR, NO SE PUEDE CAMBIAR YA QUE SE DECLARÓ COMO FINAL.
        //numero = numero * 1;
        
        System.out.println("numero fin metodo = " + numero);
    }
    
    public static void main(String[] args) {
        
        int numero = 5;
        multiplicarX2(numero);
        numero *= 1; // lo que suceda en el método es independiente de lo que hacemos aquí.
        System.out.println("numero en fin de main = " + numero);                
    }    

}