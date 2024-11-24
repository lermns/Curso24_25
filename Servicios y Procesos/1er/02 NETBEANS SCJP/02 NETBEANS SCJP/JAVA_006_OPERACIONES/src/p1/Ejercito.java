// Crear las clases Teniente y Soldado para comprobar cómo la realización
// del casting entre ambas, permite o no la utilización del método obedecer(),
// que declararemos en la clase Soldado (Teniente dispone del método ordenar()
// de caracter protected).

// Para ello, crear un objeto de Soldado y cargar una referencia Teniente con dicho
// objeto (UpCasting automático). A continuación, realizar casting sobre dicha 
// referencia Teniente para cargar una referencia Soldado (downCasting manual).


package p1;
/////////////////////////////////////////////////////////////////////////

// NO ES LO CORRECTO DECLARAR MÁS DE UNA CLASE EN EL MISMO FICHERO, PERO DE
// CARA A SIMPLIFICAR EL EJERCICIO SE HARÁ ASÍ.

class Teniente {
    protected void ordenar() {}
}

class Soldado extends Teniente {
    // hereda ordenar de Teniente (suponer que es un cabo ... da ordenes a otros soldados).    
    public void obedecer() {}    
}

public class Ejercito {

    public static void main(String[] args) {
        
        Soldado s = new Soldado();
        s.obedecer(); // propio.
        s.ordenar(); // heredado de teniente.

        // VER UN Soldado COMO UN Teniente (REGLA IS-A).
        Teniente t1 = s; // UPCASTING ... ver qué métodos puedo utilizar.
        t1.ordenar();
        //t1.obedecer(); // error, el manejador (handler) teniente no dispone de ese método.
        
        // VER UN Soldado COMO UN Teniente (REGLA IS-A Y CASTING FORZADO QUE NO ES NECESARIO).
        Teniente t2 = (Teniente)s; // UPCASTING ... ver qué métodos puedo utilizar.
        t2.ordenar();
        //t2.obedecer(); // error, el manejador (handler) teniente no dispone de ese método.                         
        
        s = (Soldado)t1; // DOWNCASTING. LOS MÉTODOS SE PODRÁN INVOCAR PORQUE EL OBJETO REAL ES DE TIPO Soldado.
        s.ordenar();
        s.obedecer();
        
        // Cuanto más abajo estemos en la línea de jerarquía de clases, más específica o
        // especialista es la clase (el conjunto de métodos se amplía para poder realizar
        // funcionalidad más detallada, además de la propia de la madre).        
        
        System.out.println("\n --------- COMPILACION VALIDA ---------- \n");

        // GENERARÁ UN ERROR EN EJECUCIÓN. EL OBJETO ES DE TIPO Teniente NO PUDIENDO SER MANEJADO
        // POR UNA REFERENCIA DE TIPO Soldado. Soldado ES-UN Teniente, PERO Teniente NO-ES-UN Soldado).
        // EL COMPILADOR NO SE METE A VER LA NATURALEZA EXACTA DEL OBJETO CON EL QUE CARGAMOS LA REFERENCIA 
        // CUÁNDO UTILIZAMOS EL CASTING, SÓLO VIGILA QUE HAY RELACIÓN IS-A. 

        Teniente teniente = new Teniente(); // INTRODUCIMOS EN LA REFERENCIA Teniente UN OBJETO TENIENTE, NO UN Soldado.
        Soldado soldado = (Soldado)teniente; // CASTING VÁLIDO POR QUE HAY RELACIÓN DE HERENCIA.
        soldado.ordenar();
        soldado.obedecer(); 
        System.out.println("\n --------- COMPILACION VALIDA, PERO ERROR EN EJECUCION ---------- \n");
    }        
}


