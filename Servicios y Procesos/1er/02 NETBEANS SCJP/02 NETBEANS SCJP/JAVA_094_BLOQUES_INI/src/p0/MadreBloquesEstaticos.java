// Crear una clase a partir de la cúal comprobar el orden de llamada de los
// distintos bloque de inicialización estáticos declarados en la misma. Dicha
// clase deberá heredar de otra en la que de igual forma se habrán declarado
// bloques de incialización estáticos.

// Instanciar un objeto de la clase madre y a continuación uno de la hija,
// observando cómo los constructores entran siempre después de lo bloques.
// Volver a instanciar un objeto hija para demostrar como los bloques de
// inicialización estáticos ya no se vuelven a llamar (es 1 vez por ejecución,
// al cargar la clase en memoria ... CLASSLOADER).


package p0;

public class MadreBloquesEstaticos { // clase madre.

    static{
        System.out.println("BLOQUE INI ESTATICO 1 DE A"); // BIS 1 madre.
    }

    public MadreBloquesEstaticos() { // constructor de madre.
        System.out.println("CONSTRUCTOR DE A");
    }
    
    static{
        System.out.println("BLOQUE INI ESTATICO 2 DE A"); //BIS 2 madre.
    }
       
}


//////////////////////////////////////////////////////////////////


class B extends MadreBloquesEstaticos {
   
    static{
        System.out.println("BLOQUE INI ESTATICO 1 DE B"); // BIS 1 hija
    }

    public B() { // constructor de hija.
        System.out.println("CONSTRUCTOR DE B");
    }
    
    static{ // BIS 2 hija.
        System.out.println("BLOQUE INI ESTATICO 2 DE B");
    }
        
}


class Prueba {

    public static void main(String[] args) {

// Comentar/descomentar este bloque o el de la creación de los objetos B.        
//        new A();
//        System.out.println("\n_____________________________\n");
//        new A();
        
        new B();
        System.out.println("\n_____________________________\n");

        // UNA VEZ EJECUTADOS LOS BLOQUES DE INICIALIZACIÓN ESTÁTICOS YA NO
        // SE VUELVEN A REALIZAR.
        new B();
    }
}