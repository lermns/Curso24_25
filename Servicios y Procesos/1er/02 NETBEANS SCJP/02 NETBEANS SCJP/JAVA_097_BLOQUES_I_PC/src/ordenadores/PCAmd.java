// Crear la clase PCAmd como heredera de la clase abstracta PC. Se define en
// ella un bloque de incialización no estático de forma que todos las instancias
// que se creen de ellan, llevarán el procesador PHENOM (marca AMD). Así mismo,
// se establece la sobrecarga del constructor para poder determinar la placa base,
// la memoria, la placa base y la memoria, o nada, en cuyo caso se utilizarán los
// valores por defecto, ASUS_P6 y SKILL_16GB.


package ordenadores;

import enumerados.Memorias;
import enumerados.PlacasBase;
import enumerados.Procesadores;

public class PCAmd extends PC {

    { // BLOQUE DE INICIALIZACIÓN NO ESTÁTICO. Se llama por cada instancia.
        procesador = Procesadores.PHENOM;
    }

    public PCAmd() {
        placaBase = PlacasBase.ASUS_P6;
        memoria = Memorias.SKILL_16GB;        
    }

    public PCAmd(PlacasBase placaBase) {
        this.placaBase = placaBase;
        memoria = Memorias.SKILL_16GB;        
    }
    
    public PCAmd(Memorias memoria) {
        placaBase = PlacasBase.ASUS_P6;
        this.memoria = memoria;
    }

    public PCAmd(PlacasBase placaBase, Memorias memoria) {
        this.placaBase = placaBase;
        this.memoria = memoria;
    }
}