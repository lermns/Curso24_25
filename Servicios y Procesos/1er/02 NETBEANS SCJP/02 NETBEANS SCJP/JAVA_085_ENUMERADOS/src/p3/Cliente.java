// Crear un tercer tipo enumerado Gatos en el paquete p3 de forma que sea un 
// miembro de la clase pública, Cliente. Establecer el nivel de encapsulación
// del enumerado a público y su sufijo a _p3_a. En último lugar, generar un
// cuarto tipo enumerado Gatos como elemento (nivel "default") asociado al
// presente fichero, designando el sufijo a _p3_b.

// Utilizar un valor de cada uno de los tipos enumerados estableciendo la ruta
// necesaria en cada caso (vigilar encapsulación de paquete para ver si es posible).

// Nota: orden de uso: Miembro de clase -> fichero asociado o clase del paquete -> externos.


package p3;

public class Cliente {

    // MIEMBRO DE LA CLASE Cliente EN EL PAQUETE p3.
    public enum Gatos {

        ANGORA_p3_a,
        PERSA_p3_a,
        CALLEJERO_p3_a
    }
    
    public static void main(String[] args) {
        
        // ¿QUÉ TIPO ENUMERADO SE ESTÁ UTILIZANDO REALMENTE?:
        
        Gatos       unGato1     = Gatos.ANGORA_p3_a;            // de la propia clase. 
        // Gatos unGato1        = Cliente.Gatos.ANGORA_p3_a;    // válido pero redundante.

        p3.Gatos    unGato2     = p3.Gatos.ANGORA_p3_b;         // del paquete p3.
        
        // p2.Gatos    unGato4  = p2.Gatos.ANGORA_p2;           // error, es de "paquete".
        
        p1.Gatos    unGato3     = p1.Gatos.ANGORA_p1;               // del paquete p1.        
    }
}


// CLASE ASOCIADA A LA CLASE Cliente EN EL PAQUETE p3.
enum Gatos {

    ANGORA_p3_b,
    PERSA_p3_b,
    CALLEJERO_p3_b
}