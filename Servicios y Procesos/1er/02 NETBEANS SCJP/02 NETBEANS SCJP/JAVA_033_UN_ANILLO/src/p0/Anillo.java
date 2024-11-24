
// La clase Anillo como en el ejercicio anterior. En esta ocasión, en lugar de utilizar
// el constructor directamente, lo que hacemos es usar un método público que nos devuelva
// el objeto anillo (dentro de dicho método se elige aleatoriamente el tipo de anillo).


package p0;

public class Anillo {

    private String tipoAnillo;
    
    private static final String[] tipos = {
        "DIAMANTES",    // posición 0
        "ESMERALDAS",   // posición 1
        "RUBIES"        // posición 2
    };
    
    // Constructor implícito con nivel de encapsulación el de la clase (public).
    // En esta ocasión no hacemos uso directo de él.
    
    public Anillo obtenerTipoAnillo() {
        int aleatorio = (int)(Math.random()*tipos.length); // 0 .. 2
        tipoAnillo =  tipos[aleatorio];       
        return this; // en esta ocasión hacemos uso del this (el objeto que se crea).
    }
    
    @Override
    public String toString() {
        return tipoAnillo;
    }    
}