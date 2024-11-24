// Crear una clase que haga uso de la clase del sistema java.lang.Math, para generar
// 10 números enteros entre -1 y -100.


package p1;

public class Negativos {

    public static void main(String[] args) {
        
        for (int i = 1; i <= 10; i++) {
            int numero = (int)(Math.random()* -100) - 1;
            System.out.println("numero_" + i + " ---> " + numero);
        }        
    }
}