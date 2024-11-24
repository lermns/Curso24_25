// Crear una clase que muestre los valores (en formato char e int) correpondientes
// a la letra 'a' y demuestre cómo es posible sumar valores para obtener nuevas
// letras o números.


package p0;

public class CharInt {

    public static void main(String[] args) {
        
        char letra = 'a';        
        
        System.out.println("letra a ... " + letra); // 'a'
        
        System.out.println("letra a ... " + (letra + 0)); // 97 ... promoción a int.
        
        System.out.println("letra d ... " + (char)(letra + 3)); // 'd'        
        
        System.out.println("letra d ... " + (letra + 3)); // 100
        
        System.out.println("\n________________________\n");
        
        System.out.println("A ... " + (int)'A');
        System.out.println("z ... " + (int)'z');
    }    
}