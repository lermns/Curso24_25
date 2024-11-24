// Crear el tipo enumerado PPT para simbolizar el clásico juego de Piedra, Papel
// o Tijera. Crear un método estático para obtener de forma aleatoria la jugada
// a utilizar por el futuro jugador.


package enumerados;

public enum PPT {

    PIEDRA, PAPEL, TIJERA;
    
    private static final PPT[] valores = values(); // array de valores de uso interno.
                
    // HACIÉNDO UN MÉTODO ESTÁTICO NO NECESITO UTILIZAR NINGUNO DE LOS VALORES DEL
    // TIPO ENUMERADO PARA PODER LLAMAR AL MÉTODO obtenerJugada.
    
    // Método estático (usar y tirar ... me pides algo, te lo doy y aquí terminamos).    
    public static PPT obtenerJugada() { // obtener un valor aleatorio PPT.
        //0 .. 2
        int aleatorio = (int)(Math.random() * valores.length);        
        return valores[aleatorio]; // me devuelve una  PIEDRA ó un PAPEL ó una TIJERA.
    }
}