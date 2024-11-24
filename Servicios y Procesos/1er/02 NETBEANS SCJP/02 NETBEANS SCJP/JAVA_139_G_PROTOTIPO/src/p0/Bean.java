// Crear una clase JavaBean denominada Bean, que permita almacenar un dato de
// tipo entero (int). Disponer en la clase de una sobrecarga de constructores
// (por defecto y parametrizado) así como de los correspondientes métodos getters
// y setters. Sobrescribir el método toString.

// Nota: Esta clase sólo permite almacenar un dato de tipo entero, sin ser 
//       útil para otros tipos como String, Gato ... etc.

package p0;


public class Bean {
    
    private int dato;
    
    public Bean() {}
    
    public Bean(int dato) {
        this.dato = dato;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public String toString() {
        return "" + dato;
    }   

}