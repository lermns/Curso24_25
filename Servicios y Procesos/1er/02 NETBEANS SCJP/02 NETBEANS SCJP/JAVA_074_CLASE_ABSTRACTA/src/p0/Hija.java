// Crear la clase Hija que extiende a la clase madre. Al ser Hija instanciable, deberá
// implementar todos y cada uno de los posibles métodos abstractos heredados (visibles).


package p0;

public class Hija extends Madre {

    // recordar que todos los constructores de la hija deben poder alcanzar
    // a uno de los constructores de la madre para poder realizar encadenamiento,
    // aún en el caso de que dicho constructor nunca se llegue a usar por el resto
    // del código.
    
    public Hija() {
    }

    public Hija(int x) {
        super(x);
    }    
    
    @Override
    public String m1() { // private y "default" dan error. Reglas de la sobrescritura.
        return "EN HIJA, LA X HEREDADA DE MADRE VALE ... " + x;
    }
}