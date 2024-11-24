// Crear una clase para instanciar distintos tipos de equipos, Intel o Amd,
// mostrándose por pantalla, para cada uno de ellos, la configuración elegida.
// Comprobar cómo los bloques de inicialización estáticos se llaman sólo 1
// vez (al cargarse la clase en memoria por el hecho de ser requerida para la
// ejecución del programa), mientras que los no estáticos se llaman por cada
// instancia generada (recordar que para poder instanciar una clase hija se
// ha de llamar en primer lugar a la madre, lo cual activará sus bloques de 
// inicialización y el constructor utilizado para el encadenamiento).


package tiendas;

import enumerados.Memorias;
import enumerados.PlacasBase;
import ordenadores.PC;
import ordenadores.PCAmd;
import ordenadores.PCIntel;

public class Tienda {
    
    public static void main(String[] args) {
        
        PC pc1 = new PCIntel(); // no indico nada, luego usar valores por defecto.
        System.out.println(pc1);
        
        PC pc2 = new PCIntel(PlacasBase.ASUS_P6); // elijo la placa base.
        System.out.println(pc2);
        
        PC pc3 = new PCIntel(Memorias.SKILL_16GB); // elijo la memoria.
        System.out.println(pc3);

        // elijo placa base y memoria.
        PC pc4 = new PCIntel(PlacasBase.ASUS_P6, Memorias.SKILL_16GB); 
        System.out.println(pc4);
        
        System.out.println("\n_________________________________\n");
        
        PC pc5 = new PCAmd(); 
        System.out.println(pc5); // valores por defecto para el Amd ... como antes.
    }
}