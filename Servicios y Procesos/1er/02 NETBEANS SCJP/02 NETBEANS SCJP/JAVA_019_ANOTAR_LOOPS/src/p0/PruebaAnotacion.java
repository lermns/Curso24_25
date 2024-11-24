// Crear una clase que compruebe el funcionamiento de las etiquetas sobre bucles 
// anidados (un bucle interno queda contenido dentro de uno externo) de cara a ver
// cómo se puede controlar el comportamiento del bucle externo desde el interno.

// Un break o continue convencional afecta únicamente al bucle sobre el que se han
// definido (al más cercano).


package p0;

public class PruebaAnotacion {

    
    public static void main(String[] args) {
        
        bucleExterno: // ANOTACIÓN SOBRE EL BUCLE EXTERNO.
        for (int i = 1; i <= 10; i++) {
            
            System.out.println("i = " + i + "\n");
            
            bucleInterno: // ANOTACIÓN SOBRE EL BUCLE INTERNO.
            for (int j = 1; j <= 5; j++) {
                // LA VARIABLE j SE INICIALIZA POR CADA VUELTA DEL for ANTERIOR.
                System.out.println("j = " + j);
                //break bucleInterno;
                //break;
                //break bucleExterno;
                System.out.println("\n\t\t______ÚLTIMA LÍNEA BUCLE INTERNO______\n");
                //continue bucleExterno;
            }
            
            System.out.println("\n______ÚLTIMA LÍNEA BUCLE EXTERNO______\n");
        }
        
        System.out.println("\n\nFIN DE PROGRAMA");
    }
}