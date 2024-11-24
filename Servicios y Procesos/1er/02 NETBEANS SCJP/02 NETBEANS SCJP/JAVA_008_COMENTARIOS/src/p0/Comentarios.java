// Crear una clase en la que se utilicen los diversas formas de comentar texto,
// el poder generar javaDoc (Run - Generate Javadoc), y los principales caracteres
// de escape.


package p0;

// JAVADOC .. Run - Generate Javadoc (proyecto)

/**
 * 
 * @author yo // informamos sobre el autor de la clase.
 */
public class Comentarios {

    private int dinero;
    private String oficio;

    /**
     * 
     * @return dinero // indicamos el tipo de dato devuelto.
     */
    public int obtenerDinero() {
        return dinero;
    }
       
    /**
     * 
     * @param x // los parámetros que pueda utilizar el método
     * @param y 
     */
    public void sumarNumeros(int x, int y) {
        System.out.println("EL RESULTADO ES ... " + (x+y));
    }
    
    /**
     * 
     * @throws NumberFormatException  // informar sobre las posibles excepciones.
     */
    public void realizarExponenciacion() throws NumberFormatException {
        System.out.println("2 elevado a 2 es ... " + Math.exp(2));
    }
    
    // Utilizar todas y cada una de las anotaciones JavaDoc conjuntamente. 
    
    
    public static void main(String[] args) {
        
        // COMENTARIOS DE LÍNEA SIMPLE.
        // variable edad ... que se usa para especificar la edad del animal
        int edad = 4;
        
        //////////////////////////////////////////////////
        
        // COMENTARIOS MULTILÍNEA.
        /*
        for (int i = 0; i < 10; i++) {
            System.out.println("i = " + i);
        }
        */

        // O DE FORMA MÁS SENCILLA CON CTRL+C SOBRE EL BLOQUE SELECCIONADO (MAYÚSC + FLECHA)
//        for (int i = 0; i < 10; i++) {
//            System.out.println("i = " + i);
//        }
        
        
        
        System.out.println("*******************");
        System.out.println("\n\n"); // saltos de línea.
        System.out.println("*******************");
        
        // CARACTERES DE ESCAPE.
        System.out.println("DIJO TEXTUALMENTE \"DESPEDIDO\""); // comillas dobles.
        System.out.println("LA RUTA DEL FICHERO ES C:\\p0\\pruebas"); // barra invertida.
    }    
}