// 
package p2;

public class MadreBloquesNoEstaticos {

    // BLOQUE DE INICIALIZACIÓN NO ESTÁTICO, DE LA MADRE.
    {
        System.out.println("BLOQUE INI NO ESTATICO 1 DE A");
    }

    // CONSTRUCTOR DE LA MADRE.
    public MadreBloquesNoEstaticos() {
        System.out.println("CONSTRUCTOR DE A");
    }
}


//////////////////////////////////////////////////////////////////


class B extends MadreBloquesNoEstaticos {

    private static int valor;

    // CONSTRUCTOR DE LA HIJA.
    public B() {
        System.out.println("CONSTRUCTOR DE B");
    }

    // BLOQUE DE INICIALIZACIÓN NO ESTÁTICO DE LA HIJA.
    {
        valor = 666;
        System.out.println("BLOQUE INI NO ESTATICO 1 DE B");
    }
}


//////////////////////////////////////////////////////////////////


class Prueba {

    public static void main(String[] args) {

        new B();
        System.out.println("\n_________________\n");
        new B();

    }
}