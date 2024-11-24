// Crear una clase que demuestre la necesidad de utilizar la reasignación de referencias
// para "bordear" la inmutabilidad de la clase String y los Wrappers.


package p5;

public class PruebaInmutabilidad {

    public static void main(String[] args) {
        
        String texto = "hola";
        System.out.println(texto = texto.toUpperCase()); // reasignación.
        System.out.println(texto);
        
        System.out.println("\n___________________________\n");
        
        Integer numero = 7;
        System.out.println(numero = numero * 2); // reasignación e impresión por pantalla.
        System.out.println(numero);   
    }   
}