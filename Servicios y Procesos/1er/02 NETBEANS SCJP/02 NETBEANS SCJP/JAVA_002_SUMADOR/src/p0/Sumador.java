// Crear una clase para sumar 2 números introducidos como parámetros en NetBeans.

// Introducción de parámetros: Menú RUN - SET PROJECT CONFIGURATIÓN - CUSTOMIZE -
// ARGUMENTS  ... colocaremos los valores 1 y 2 (separados por un espacio blanco).
// Los parámetros actúan sobre el proyecto, siendo iguales para todas las clases del
// mismo.
// En el mismo lugar podemos utilizar la opción MAIN CLASS para elegir la clase que
// se ejecutará al ejecutar el proyecto (debe contener el método main).

// Elegir el proyecto principal: Menú RUN - SET MAIN PROJECT ... seleccionar con ratón.

// EJECUTAR: Pulsar sobre el boton verde con forma de flecha o pulsar F6, botón derecho
// sobre panel izquierdo [Project] + RUN PROJECT(XXX).

// NOTA: Utilizar [MAYÚSCULAS] + [F6] ejecuta el fichero actual, no el proyecto lo que
// provoca que NO se utilicen los parámetros definidos, generándose un error.

package p0;

public class Sumador {
    
    public static void main(String[] args) {
        
        if(args.length != 2) {
            System.out.println("DEBES INTRODUCIR UN TOTAL DE 2 PARÁMETROS");
            System.exit(0);
        }
        
        int numero1=1;
        int numero2=4356;
        
        
        System.out.println("LA SUMA DE " + args[0] + " CON " + args[1] + " ES IGUAL A " +
                (numero1 + numero2));        
    }    
}