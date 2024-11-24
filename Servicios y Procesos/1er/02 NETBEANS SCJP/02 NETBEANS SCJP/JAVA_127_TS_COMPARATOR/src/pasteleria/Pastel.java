// Crear la clase Pastel como tipo JavaBean. Definir las propiedades sabor,
// medida y precio, un constructor parametrizado para establecer sus valores.
// Disponer los métodos getter necesarios para poder consultarlos.


// Nota: La clase Pastel no implementa Comparable, luego NO SE PODRÍA ORDENAR.
//       Como solución, se define el Comparator, que se encargará de ir sacando
//       y comparando los elementos de la colección entre sí, volviéndolos a
//       colocar en ella de forma ordenada, según dicte el código utilizado.
//       Se puede combinar Comparable y Comparator en una misma clase.

package pasteleria;

import enumerados.Medidas;
import enumerados.Sabores;


public class Pastel {

    private Sabores sabor;
    private Medidas medida;
    private Integer precio;
   
    public Pastel(Sabores sabor, Medidas medida, Integer precio) {
        this.sabor = sabor;
        this.medida = medida;
        this.precio = precio;
    }
    
    public Medidas getMedida() {
        return medida;
    }

    public Integer getPrecio() {
        return precio;
    }

    public Sabores getSabor() {
        return sabor;
    }
    
    @Override
    public String toString() {
        return sabor + ", " + medida + ", " + precio;
    }    

}