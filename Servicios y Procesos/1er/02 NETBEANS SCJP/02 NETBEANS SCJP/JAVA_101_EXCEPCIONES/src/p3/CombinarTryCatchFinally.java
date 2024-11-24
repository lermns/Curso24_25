// Crear una clase que muestre las posibles combinaciones try-catch-finally que
// podemos establecer por código. Utilizar anidamiento de bloques de captura y
// comprobar cómo para cierto tipo de excepciones, si se utiliza un catch, el
// código de su try debe contener algo que pueda ser capaz de lanzar la excepción
// que se está intentando capturar o de lo contrario dará error el compilador
//(ej: SQLException).

// Nota: son válidos:
// try-catch.
// try-catch-catch ... catch y  try-catch-catch ... catch - finally.
// try-catch-finally.
// try-finally.

// En ningún caso en válido un try, un catch o un finally por si solos.
// Tabular bien el código y utlizar para el nombre del objeto excepción, al
// menos las siglas de la clase excepción que captura.

// Vigilar la granularidad con las de tipo comprobativo:
// arriba las más específicas, seguido de las generales o de lo contrario
// obtendremos un error de compilación (la excepción ya ha sido capturada
// CON LAS NO COMPROBATIVAS ÉSTO NO PASA.


package p3;

public class CombinarTryCatchFinally {

    public static void main(String[] args) {

        try {
        } catch (Exception e) {
        }

        ///////////////////////////////////////////////////////////////

        try {
        } catch (Exception e) { // granularidad.
        } catch (Throwable t) {
        }

        ///////////////////////////////////////////////////////////////

        try {
        } finally {
        }

        ///////////////////////////////////////////////////////////////

        try {
        } catch (Exception e) {
        } catch (Throwable t) {
        } finally {
        }

        try {          
        } catch (Exception e1) {
            try { // anidamiento de bloques try-catch.
                try {
                    try {
                    } catch (Exception e4) {                    
                    }
                } catch (Exception e3) {
                }
            } catch (Exception e2) {
            }
        }

        //////////// ERRORES /////////////

//        try { // sin catch ni finally.
//        
//        }


//        try {
//        
//        } catch(Throwable t) { // grano grueso.
//        
//        } catch(Exception e) { // grano fino.
//        
//        }


//        try {
//            // sin código en el try que pueda lanzar la SQLException.
//        } catch(java.sql.SQLException sqle) {
//        
//        }


//        try {            
//            
//        } catch(Exception e) {
//        
//        } catch(Exception e) { // ya se ha capturado.
//        
//        }


//        try {           
//            
//        } catch(Exception e) {
//        
//        } finally {
//        
//        } finally { // no puede haber 2 finally para el mismo bloque.
//
//        }

    }

}