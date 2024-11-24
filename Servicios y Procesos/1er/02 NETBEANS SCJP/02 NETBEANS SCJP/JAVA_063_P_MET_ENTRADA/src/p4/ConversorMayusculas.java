// Crear la clase ConversorMayusculas para comprobar la inmutabilidad de los String
// al recibirlos como parámetros de entrada a un método. Probar cómo podemos devolver
// el nuevo objeto creado para, mediante reasignación de referencias, hacer posibles
// los cambios buscados (realmente no hay cambio, sino una modificación en el patrón
// de bits de la referencia original ... se apunta hacia el nuevo objeto).


package p4;

public class ConversorMayusculas {

    public static String conversor(String texto) {
        System.out.println("TEXTO AL INICIAR EL METODO CONVERSOR = " + texto);
        // STRING ES INMUTABLE, LUEGO APLICAR UN MÉTODO SOBRE ELLA PROVOCA LA GENERACIÓN
        // DE UN NUEVO OBJETO STRING CON LOS CAMBIOS, PERO EN NINGÚN CASO MODIFICA EL
        // OBJETO ORIGINAL.
        //texto.toUpperCase();
        
        // PARA QUE LOS CAMBIOS PERSISTAN, SE HA DE REASIGNAR LA REFERENCIA, CARGAR LA
        // VARIABLE CON EL NUEVO OBJETO RESULTANTE DEL MÉTODO APLICADO SOBRE EL ORIGINAL.
        texto = texto.toUpperCase();
        
        System.out.println("TEXTO AL FINALIZAR EL METODO CONVERSOR = " + texto);
        return texto;
    }
            
    
    public static void main(String[] args) {
        
        String texto = "hola";
        
        System.out.println("TEXTO AL INICIAR EL METODO MAIN = " + texto);
        //conversor(texto); // NO reasignación, luego no se observaran cambios.
        texto = conversor(texto); // reasignación
        System.out.println("TEXTO AL FINALIZAR EL METODO MAIN = " + texto);        
    }    
    
}