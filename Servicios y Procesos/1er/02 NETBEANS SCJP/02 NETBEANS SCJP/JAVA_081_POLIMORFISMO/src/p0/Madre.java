// Crear una clase Madre que defina un método de caracter estático cocinar y
// otro de instancia llamado trabajar. 


package p0;

public class Madre {

    // METODO ESTÁTICO, NO POLIMORFICO.
    public static void cocinar() {
        System.out.println("LA MADRE COCINA");
    }
    
    // METODO NO ESTÁTICO, SÍ POLIMORFICO O DE INSTANCIA.
    public void trabajar() {
        System.out.println("LA MADRE TRABAJA");
    }    
}