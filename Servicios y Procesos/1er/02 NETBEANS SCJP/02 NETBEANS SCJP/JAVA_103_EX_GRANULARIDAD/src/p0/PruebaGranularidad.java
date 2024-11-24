// Crear una clase que demuestre el concepto de granularidad para las excepciones
// comprobativas de una determinada línea de herencia. Generar una array de tipo
// Throwable cargado con objetos Throwable, Exception y NumberFormatException (ésta
// es NO comprobativa y la colocaremos la primera en la secuencia de captura), a
// los que daremos un nombre (usar el constructor que pide un String). Lanzar una
// de las excepciones aleatoriamente, disponiendo su captura a través de una bateria
// de bloques catch (respetar granularidad). En el caso de lanzarse el tipo
// NumberFormatException, capturarla para ser relanzada bajo la apariencia de una
// excepción personalizada MiException (que heredará de Exception) y a la que daremos
// nombre y sobrescribiremos su método toString. La re-captura se realiza internamente
// en el catch que la capturó originalmente. Indicar en todo caso el tipo capturado.


package p0;

public class PruebaGranularidad {  
    
    public static void main(String[] args) throws MiException {
        
        Throwable[] misExcepciones = {
            new Throwable("LA GRANDE - COMPROBATIVA"),
            new Exception("LA MEDIANA - COMPROBATIVA"),
            new NumberFormatException("LA FINA - NO COMPROBATIVA")
        };
                
        int aleatorio = (int)(Math.random()*misExcepciones.length);
        
        // ORDEN DE CAPTURA PARA COMPROBATIVAS ... RESPETAR GRANULARIDAD PARA LÍNEA DE HERENCIA.
        // En el caso de ser comprobativas pero no tener ninguna relación entre ellas, podemos
        // colocarlas en el orden que queramos.
        
        try {            
            // Las lanzamos bajo la apariencia de Throwable pero en los catch
            // se comprueba la verdadera naturaleza o tipo del objeto de excepción.
            Throwable excepcionElegida = misExcepciones[aleatorio]; 
            System.out.println(">>> EXCEPCION ELEGIDA = " + excepcionElegida + "\n\n");
            throw excepcionElegida; // lanzar ...
                        
        } catch(NumberFormatException nfe) { // ... y tratar de capturar.
            System.out.println("HE CAPTURADO EN CATCH-NUMBER_FORMAT_EXCEPTION UNA EXCEPCION TIPO ... " + nfe.getClass().getSimpleName());
            System.out.println("------> LA VOY A RELANZAR COMO UNA MiException, QUE ES COMPROBATIVA");
            try {
                throw new MiException("EL MENSAJE ORIGINAL DE LA EXCEPCION ES ... " + nfe.getMessage());
            } catch(MiException me) {
                System.out.println("******** HE CAPTURADO MiException (EXCEPCIÓN PERSONALIZADA) *********");
                System.out.println("******** " + me + "********");
            }                
          } catch(Exception e) {
            System.out.println("HE CAPTURADO EN CATCH-EXCEPTION UNA EXCEPCION TIPO ... " + e.getClass().getSimpleName());
        } catch(Throwable t) {
            System.out.println("HE CAPTURADO EN CATCH-THROWABLE UNA EXCEPCION TIPO ... " + t.getClass().getSimpleName());
        }
        
        System.out.println("\n\n-----------FIN DE PROGRAMA------------\n\n");        
    }    
}


class MiException extends Exception { // hereda de Exception (comprobativa).
    
    public MiException(String mensaje) {
        // asignamos el mensaje de la excepción llamando al constructor de la madre que pide String.
        super(mensaje);
    }
    
    @Override
    public String toString() { // sobrescribimos el método toString.
        return "EL toString de MiException es ... " + getMessage();
    }


//    public void metodo() throws Throwable {
//        if(true) { // el if(){xxx} evita el error unreachable statement.
//            throw new Throwable(); // si se lanza, provoca salida del método.
//        }
//        throw new ArrayIndexOutOfBoundsException(); // nunca se llegaría aquí
//    }
    
}