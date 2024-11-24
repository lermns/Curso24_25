// Crear una clase CadenaTexto que defina como atributo la variable texto. Hacer
// uso de la sobrescritura de los métodos hashCode, equals y toString pero 
// aprovechándonos de la versión propietaría de la clase java.lang.String.
// Generar las cadenas HOLA y hola para comprobar como al resultar distintas
// entre si se añaden a la colección HashSet. Por último, utilizar 2 cadenas que
// sean iguales en contenido ("HOLA") pero físicamente distintas (utilizar new para
// cada una de ellas), comprobando como la sobrescritura de equals para realizar
// comparación de contenidos (no de direcciones de memoria), no añade la segunda
// de ellas.


package p0;

import java.util.HashSet;


public class CadenaTexto {
    
    private String texto;
    
    public CadenaTexto(String texto) {
        this.texto = texto;
    }

    
    @Override
    public int hashCode() {
        int codigoHash = texto.hashCode(); // el hashCode propio de String.
        System.out.println("SE LLAMA AL METODO HASHCODE ... " + codigoHash);
        return codigoHash;
    }
    
    
    @Override
    public boolean equals(Object objeto) {
              
        // Si los códigos de hash son distintos, no se llamará a equals, ya
        // que se añade el objeto directamente a la colección (ES NO REPETIDO).
        System.out.println("SE LLAMA AL METODO EQUALS");
        if(objeto instanceof CadenaTexto) {
            CadenaTexto cadenaTexto = (CadenaTexto)objeto;
            return texto.equals(cadenaTexto.texto); // el equals propio de String.
        }
        
        return false;
    }
    
    @Override
    public String toString() {
        return texto;
    }

    
    public static void main(String[] args) {
        
        CadenaTexto ct1 = new CadenaTexto("HOLA");
        //CadenaTexto ct2 = new CadenaTexto("hola");
        
        // Podemos hacer uso de un new, de forma que el objeto es físicamente
        // distinto pero su contenido es el mismo que el de ct1 y dado que
        // comparamos por contenido, no nos lo añadiría a la colección.
        
        CadenaTexto ct2 = new CadenaTexto("HOLA");
                
        System.out.println("ct1 == ct2 " + (ct1 == ct2));
                
        System.out.println("\n______________________________\n");
        
        HashSet cadenas = new HashSet();
        
        cadenas.add(ct1);
        cadenas.add(ct2);
        
        System.out.println("\n\nELEMENTOS EN EL HASHSET:\n");
        System.out.println(cadenas);
        System.out.println("TOTAL ELEMENTOS = " + cadenas.size());   
    }   

}