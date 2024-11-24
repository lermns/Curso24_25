// Crear una clase que demuestre la naturaleza inmutable de los Wrappers utilizando para
// ello un Boolean. Así, a diferencia del ejercicio anterior que usaba un objeto mutable
// de tipo Gato, las modificaciones sobre un Wrapper conllevan la generación automática de
// un nuevo objeto y la NO modificación del ya existente. Es por ésto que para constatar
// los cambios, se hace necesario la reasignación de referencias hacia dicho nuevo objeto.


package p2;

public class PasoBooleanoMetodo {

    private static void cambiarVerdad(boolean verdad) {
        System.out.println("Al entrar metodo, verdad = " + verdad);
        verdad = !verdad; // reasignación de la referencia al nuevo objeto creado.
        System.out.println("Al salir del metodo, verdad = " + verdad);
        
        // si quisiese modificar la variable original, tendría que ser accesible desde
        // este método, lo que nos obligaría a declararla como global, no como local ó
        // bien devolver el nuevo objeto creado a través de un return (eliminar el void)
        // con la posterior reasignación de referencias.
    }
    
    
    public static void main(String[] args) {
        
        boolean verdad = true;
        System.out.println("Al iniciar el metodo main ,verdad = " + verdad);
        cambiarVerdad(verdad);
        System.out.println("Al finalizar el metodo main ,verdad = " + verdad);        
    }   
    
}