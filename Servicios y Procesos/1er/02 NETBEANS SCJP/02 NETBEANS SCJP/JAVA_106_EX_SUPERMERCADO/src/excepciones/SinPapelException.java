// Crear la clase de excepción personalizada SinPapelException para ejemplarizar
// la posible situación de que la caja registradora se quede sin papel.


package excepciones;

public class SinPapelException extends Exception {

    public SinPapelException() {
        super("LA CAJA REGISTRADORA SE HA QUEDADO SIN PAPEL");
    }    
}