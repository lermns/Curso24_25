// Crear una clase que demuestre cómo el paso de parámetros a un método es SIEMPRE por
// valor. Utilizar un dato de tipo primitivo entero (int) cómo parámetro de entrada al
// método que modificará su valor internamente. Imprimir antes, durante y después de la
// invocación.


package p0;

public class PasoPrimitivoMetodo {
    

    private static void cambiarX(int x) { // lo marcamos estático por comodidad.
        System.out.println("X AL INICIAR cambiarX() VALE = " + x);
        x += 7;
        System.out.println("X AL FINALIZAR cambiarX() VALE = " + x);
    }

    
    public static void main(String[] args) {
        
        int x = 5;
        
        System.out.println("X AL INICIAR MAIN VALE = " + x);
        cambiarX(x);
        System.out.println("X AL FINALIZAR MAIN VALE = " + x); // 5, no se modifica original.  
    }   
}