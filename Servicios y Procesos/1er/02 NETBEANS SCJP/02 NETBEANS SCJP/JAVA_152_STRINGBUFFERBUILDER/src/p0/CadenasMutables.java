// Crear una clase que estudie el comportamiento de java.lang.StringBuffer
// (su API es identica a StringBuilder, pero sus métodos, son síncronos).
// Comprobar cómo a diferencia de los tradicionales String, los objetos
// obtenidos tanto de StringBuffer como de StringBuilder, SÍ son mutables
// (no se crea un nuevo objeto, sino que los cambios generados por el método
// invocado afectan al objeto original que lo invocó).


package p0;

public class CadenasMutables {

    public static void main(String[] args) {
        
        // USANDO STRING:
        String cadena1 = "hola";
        String cadena2 = "hola";
        System.out.println("String dice ..." + cadena1.equals(cadena2));
        String cadena3 = cadena1.concat(cadena2);
        System.out.println(cadena3);
        System.out.println(cadena1);
        //cadena1.reverse(); // este método NO está disponible.
        
        System.out.println("\n_______________________\n");
        
        // USANDO LOS STRINGBUFFER O STRINGBUILDER:
        
        //StringBuffer sb = "adios"; // la forma rápida no está disponible.
        
        StringBuffer sb1 = new StringBuffer("adios"); // objetos distintos, ya que.
        StringBuffer sb2 = new StringBuffer("adios"); // estamos empleando new.
        
        // el equals no se ha sobrescrito, luego es comparación FÍSICA (referencias).
        System.out.println("¿iguales? ... " + sb1.equals(sb2)); // false.
        StringBuffer sb3 = sb1.append(sb2); // sb1 se ve afectado.
        System.out.println(sb3);
        System.out.println(sb1);
        
        sb2.reverse(); // inversión de caracteres.
        System.out.println(sb2);   
    }   

}