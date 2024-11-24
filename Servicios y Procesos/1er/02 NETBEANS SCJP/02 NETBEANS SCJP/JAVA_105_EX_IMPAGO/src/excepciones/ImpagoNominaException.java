// Crear la clase de excepción ImpagoNomina que extenderá a la clase Exception.
// Establecer el constructor por defecto para que de valor al mensaje asociado
// a la excepción (aquello que se obtiene a través del getMessage) a través del
// encadenamiento con el constructor de la madre.


package excepciones;

public class ImpagoNominaException extends Exception {

    public ImpagoNominaException() {
        super("ME QUEJO PORQUE NO ME HAN PAGADO LA NOMINA DE ESTE MES");         
    }
    
//    @Override
//    public String toString() {
//        return getClass().getCanonicalName() + " ... " + getMessage();
//    }
    
}