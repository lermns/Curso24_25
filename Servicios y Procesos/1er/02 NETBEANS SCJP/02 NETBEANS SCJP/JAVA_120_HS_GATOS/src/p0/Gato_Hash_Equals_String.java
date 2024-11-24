// Crear la clase Gato para dotarla de los atributos nombre, edad.
// Utilizar distintas implementaciones para los métodos hashCode e equals de 
// forma que se pueda comprobar cómo, en función del código establecido, se  
// van a añadir o no, la pareja de gatos que generaremos más tarde.
// Sobrescribir el método toString para completar el total de 3 métodos que 
// siempre se deberían redefinir sobre la versión original de Object, al
// constituirse una nueva clase.

// Nota: Se puede dejar a NetBeans generar el código para los 3 métodos: hashCode,
// equals y toString ... [ALT] + [INSERT] + Override Method ...


package p0;

import java.util.*;

public class Gato_Hash_Equals_String {

    private static int paso = 1; // para mostrar el orden de llamada.

    private String nombre;
    private int edad;

    public Gato_Hash_Equals_String(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public int hashCode() {

        // EJEMPLO DE VALORES QUE PODEMOS DAR AL CÓDIGO ENTERO HASHCODE.
        // NOTA: HAY QUE DAR UN VALOR QUE RESPETE LAS REGLAS DE HASHING (teoría).
        
        // int codigoHash = (int)(Math.random()*1000000 +1);    // aleatorio.
        // int codigoHash = 0;                                  // fijo.
        // int codigoHash = super.hashCode();                   // el definido en Object.
        int codigoHash = nombre.hashCode() +                    // en base a atributos.
                         Integer.valueOf(edad).hashCode();

        ///////////////////////////////////////////////////////////////////////////////////
        //codigoHash = 0; // si quieres forzar que actúe el equals con todos los elementos.
        ///////////////////////////////////////////////////////////////////////////////////
        
        System.out.println("\n\n======================================================================");
        System.out.println(paso++ + " SE LLAMA AL hashCode() DEL GATO DE"
                + " NOMBRE ... " + nombre + ".... hash = " + codigoHash + "\n");
        System.out.println("======================================================================\n\n");        
        
        return codigoHash;
    }

    @Override
    public boolean equals(Object objeto) {

        // Es el programador EL QUE ELIGE si son iguales ó distintos:
        System.out.println("\n\n======================================================================");
        System.out.println(paso++ + " SE LLAMA AL equals() DEL GATO DE"
                + " NOMBRE ... " + nombre);
        
        // EJEMPLOS DE COMPARACIONES QUE PODRÍAMOS REALIZAR ENTRE LOS OBJETOS.
        
        // return this == objeto;       // mismo objeto físico (A == B).
        // return super.equals(objeto); // Object compara por objetos físicos.         
        // return true;                 // devolver siempre true.
        // return false;                // devolver siempre false.

        
        // *** HACER UNA DEEP-COMPARATION EN BASE A SUS ATRIBUTOS ***
        
        // 1. comprobar misma naturaleza para evitar cometer un casting erroneo.
        System.out.println("\n*** CODIGOS DE HASH IGUALES ---> REALIZAR DEEP-COMPARATION *** \n ");
        if (objeto instanceof Gato_Hash_Equals_String) {
            // castear el objeto recibido a tipo Gato, y dado que estamos en la
            // propia clase Gato, los elementos private del objeto recibido se verán.
            Gato_Hash_Equals_String g = (Gato_Hash_Equals_String) objeto;

            // 2. comprobar el valor de los atributos (aquellos que deseemos utilizar).
            System.out.println("SE ESTAN COMPARANDO LOS GATOS ... " + nombre + "(this) <-> " +
                    g.nombre + " (parametro)\n");
            
            // mirar si son iguales en contenido (no nos importa que sean objetos físicos distintos).
            System.out.println("--this--------------parametro--");
            System.out.println(nombre + "\t\t"+ g.nombre);
            System.out.println(edad + "\t\t\t"+ g.edad);
            System.out.println("---------------------------------------");
            if (g.nombre.equals(nombre) && g.edad == edad) {
                System.out.println("EQUALS DICE QUE SON IGUALES");
                return true;
            }
        }
        
        // en cualquier otro caso, devolver false (no son CONCEPTUALMENTE iguales).
        System.out.println("EQUALS DICE QUE SON DISTINTOS");
        System.out.println("======================================================================\n\n");
        return false;
    }

    @Override
    public String toString() {
        return nombre + "-" + edad;
    }

    public static void main(String[] args) {

        Gato_Hash_Equals_String gato1 = new Gato_Hash_Equals_String("FELIX", 1);

        Gato_Hash_Equals_String gato2 = new Gato_Hash_Equals_String("ISIDORO", 2);

        HashSet misGatos = new HashSet();           // esta colección usa hashing.
       
        // CONFORME INTENTAMOS AÑADIR LOS ELEMENTOS, EL SISTEMA REALIZA LAS COMPROBACIONES.
        misGatos.add(gato1); // se llama al hashCode de Felix (SIEMPRE SE HACE ESTE LA COLECCIÓN VACIA O NO).
        misGatos.add(gato2); // se llama al hashCode de Isidoro.
        misGatos.add(new Gato_Hash_Equals_String("GARFIELD", 1)); // hashCode de Garfield.
        
        //System.out.println("\n>>>>>>>  CASOS ESPECIALES ... TIENES QUE FORZAR EL HASHCODE A 0 <<<<<<<<\n");
        
        // CASOS ESPECIALES ... DESCOMENTAR Y PROBAR:
        
        // 1. MISMO OBJETO FÍSICO, INTENTAMOS VOLVER A INTRODUCIRLO: 
        
        //misGatos.add(gato1);
        
        // Este objeto físico ya se añadió, se llamará al hashCode de Felix, se comparará
        // con el resto de objetos ya contenidos pero no con el Felix (mismo objeto físico).
        // En el momento que encuentre uno que su equals de true, ya no sigue comparando y
        // por supuesto, no lo añadirá a la colección. NO PODEMOS ASEGURAR CON QUÉ OBJETO
        // DE LOS YA CONTENIDOS EMPEZARÁ A COMPARAR, YA QUE EN UN CONJUNTO, NO HAY NINGÚN
        // ORDEN GARANTIZADO.Así, si el primero en revisar fuese el Felix ya introducido,
        // no realizará comparacion ni con Isidoro ni con Garfield.

        
        // 2. NUEVO OBJETO FÍSICO(new) PERO MISMO CONTENIDO QUE UNO QUE YA EXISTE:
        
        //misGatos.add(new Gato_Hash_Equals_String("FELIX", 1)); // mismo contenido.
        //misGatos.add(new Gato_Hash_Equals_String("FELIX", 2)); // distinto contenido (edad).
        
        // se llama al hashCode de este nuevo Felix.
        // se llama al equals de este nuevo Felix, que se compara con el Felix
        // que ya estaba. Al ver, por Deep-Comparation, que son iguales, no se
        // introduce en la colección y no se sigue comparando con el resto.
        // De no haber sido iguales, se habría realizado la comparación con
        // todos los objetos ya existentes en la colección, hasta el momento
        // de encontrar uno que coincida y si finalmente no hay correspondencia
        // se añadirá (los objetos ya añadidos son usados como parámetro de 
        // entrada al método equals del objeto que se quiere añadir).
        
        System.out.println("\n\n --- CONTENIDO DEL HASHSET --- ");
        System.out.println(misGatos);
        System.out.println("\n TOTAL ELEMENTOS = " + misGatos.size());

        // CON HASHING, EN EL MOMENTO EN QUE EL HASHCODE DEL OBJETO A AÑADIR NO
        // COINCIDE CON NINGUNO DE LOS YA AÑADIDOS, SE CONSIDERA DISTINTO Y POR
        // TANTO SE AGREGA A LA COLECCIÓN DE INMEDIATO, SIN TENER QUE LLAMAR AL equals.
                
        // PROBAR A PONER UN CÓDIGO DE HASH FIJO E IGUAL PARA TODOS, VERIFICANDO
        // CÓMO SE HACE USO DEL equals DEL OBJETO A AÑADIR CON RESPECTO A TODOS
        // Y CADA UNO DE LOS YA AÑADIDOS ... Garfield se comparará con Felix y
        // con Isidoro y si su equals dice en ambos casos que false, se añadirá.
    }
    
}