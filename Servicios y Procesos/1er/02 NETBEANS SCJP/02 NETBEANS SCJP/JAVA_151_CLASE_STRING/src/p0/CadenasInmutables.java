// Crear una clase que muestre los métodos más habituales de trabajo de la
// clase java.lang.String. Comprobar cómo en función de la forma elegida para
// instanciar el objeto de tipo String, se hará uso o no del denominado "pool 
// de Strings". Verificar el funcionamiento del método equals sobrescrito en 
// la clase, demostrando que se compara por contenido y no por posición física.
// Por último, realizar o no, una reasignación de la referencia con respecto al
// objeto que nos pueda devolver un determinado método de la clase, de cara a
// estudiar el concepto de inmutabilidad.


package p0;


public class CadenasInmutables {
    
    public static void main(String[] args) {
        
        String s1 = "hola"; // creación rápida.
        
        String s2 = "hola"; // reutilización (pool de String). No se usó new.
        
        System.out.println("¿s1 == s2? ...." + (s1==s2)); // físicamente iguales.
        
        String s3 = new String("hola"); // nuevo objeto físico. Se utilizó new.
        
        System.out.println("¿s1 == s3? ...." + (s1==s3)); // físicamente distintos.
        
        System.out.println("\n__________________________________\n");
        
        System.out.println(s3); // hola.
        System.out.println(s3.toUpperCase()); // se crear nuevo objeto "HOLA".
        //s3 = s3.toUpperCase(); // reasignación de la referencia al nuevo objeto "HOLA".
        System.out.println(s3); // hola ... inmutabilidad de los String.
        
        
        // MÉTODOS MÁS COMUNES:
        
        // obtener caracter de una posición dada.
        String cadena = "0123456789";
        char c5 = cadena.charAt(5); // empieza en posición 0.
        System.out.println(c5);
        
        String saludar = "hola";
        String despedir = " y adios";
        
        // concatenar cadenas ... se crea un nuevo objeto. 
        String concatenacion = saludar.concat(despedir);
        System.out.println(concatenacion);
        
        // comprobar igualdad física o por contenido(conceptualmente).
        String texto1 = "avion";
        String texto2 = new String("avion"); // nuevo objeto, mismo contenido.
        System.out.println("texto1 == texto2 " + (texto1 == texto2) ); // false
        System.out.println("texto1.equals(texto2) " + (texto1.equals(texto2))); // true.
     
        // longitud de la cadena (es método, en los arrays es propiedad).
        System.out.println("cuantos caracteres en avion ... " + texto1.length());
        
        // reemplazar todos los caracteres por otro.
        String cadenaOriginal = "a1b2c3-a1b2c3";
        System.out.println(cadenaOriginal);
        cadenaOriginal = cadenaOriginal.replace('a','A');
        System.out.println(cadenaOriginal);
        
        // obtener subcadenas [ el primero se coge .. el último no se coge).
        String parrafo = "0123456789";
        //String trozoCadena = parrafo.substring(3,3);  // NO SALDRIA NADA        
        //String trozoCadena = parrafo.substring(3);    // posición 3 al final. 
        String trozoCadena = parrafo.substring(3,8); // [3..8)
        System.out.println("TROZO DE LA CADENA ---> " + trozoCadena);
        
        // convertir a mayúsculas. Si no hay reasignación veremos lo mismo.
        String nombre = "ana";
        System.out.println(nombre);
        nombre = nombre.toUpperCase();
        System.out.println(nombre);
        nombre = nombre.toLowerCase();
        System.out.println(nombre);
        
        // borrar los espacios blancos de los extremos (no toca los internos).
        String apellido = "       GARCIA PEREZ       ";
        System.out.println(apellido);
        System.out.println(apellido.length());
        apellido = apellido.trim();
        System.out.println(apellido);
        System.out.println(apellido.length());

        // obtener posiciones inicial o final de un determinado caracter.
        // si no encuentra lo que busca, dará -1.
        // admite String o caracteres en forma de int (código unicode).
        String numeros = "0123 6 45 6 789";
        System.out.println("la primera posicion del 6 es ... " + numeros.indexOf('6'));
        System.out.println("la ultima posicion del 6 es ... " + numeros.lastIndexOf('6'));

        // cortar la cadena en base a un separador. Se obtiene array de String.
        String comentario = "ESTO ES UN MASTER SOBRE LA TECNOLOGIA JAVA";
        String[] arrayString = comentario.split(" ");
        
        for(String laCadena : arrayString) {
            System.out.println("---> " + laCadena);
        }
        
        System.out.println("\n");
        
        // obtener un array con los caracteres de la cadena.
        String caracteres = "SCJP";
        char[] arrayCaracteres = caracteres.toCharArray();
        
        for(char c : arrayCaracteres) {
            System.out.println("---> " + c);
        }   
    }   
    
}