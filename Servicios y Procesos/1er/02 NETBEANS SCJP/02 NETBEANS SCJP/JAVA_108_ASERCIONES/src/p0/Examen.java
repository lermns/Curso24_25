// Crear una clase que haga uso de las aserciones (depuración de código en ejecución).
// Para ello, se define un valor entero llamado nota, que se cargará aleatoriamente
// con un número entre 1 y 10. Si no se supera el examen (nota >= 5), el sistema
// lanzará un error (AsertionError), indicándose que se ha suspendido.

// Nota: Por defecto, la aserciones están deshabilitadas. Para activarlas, hay
// que ir a Run - Set Project Configuration - Customize, y en la opción Run -
// para la caja de VM Options, escribir -ea  ... lo cúal posibilitará las 
// aserciones (-ea = enable assertions // -da = disable assertions).
// Cada proyecto tiene su propia configuración, siendo independientes los unos
// de los otros.

// Assertion equivale a "asegurate de que ... " produciéndose el error en el caso
// de que el resultado de la evaluación sea false (con true no ocurriría nada, ya
// sucede lo que queremos que ocurra). Podemos imprimir como mensaje de la
// aserción cualquier cosa, incluso un objeto, ya que se llamaría al toString
// de éste.


package p0;

public class Examen {

    
    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            // RANGO [0 .. n-1]
            int nota = (int)(Math.random()*11); // mínimo 0, máximo 10.

            System.out.println("NOTA = " + nota + "\n");

            assert nota >=5 : nota + " en la asignatura: " +(i+1)+" ... HAS SUSPENDIDO EL EXAMEN ... "; 

            // Si hay error, la aplicación se corrompe en este punto.

            System.out.println(" ... HAS SUPERADO EL EXAMEN ... ");
        }
    }    
}