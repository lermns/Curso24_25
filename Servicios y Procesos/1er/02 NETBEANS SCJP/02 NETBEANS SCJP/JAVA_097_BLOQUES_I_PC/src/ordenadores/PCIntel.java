// Crear la clase PCIntel que hereda de la clase abstracta PC. Al igual que con
// la clase PCAmd, se define un bloque de inicialización no estático que establezca
// el tipo de procesador, en este caso INTEL_I7. Se dispone igualmente de la 
// sobrecarga de constructores para determinar la placa base y/o la memoria o bien
// ninguna de las 2, siendo sus valores por defecto ASROCK y KINGSTONE_32GB.


package ordenadores;

import enumerados.Memorias;
import enumerados.PlacasBase;
import enumerados.Procesadores;
public class PCIntel extends PC {

    { // BLOQUE DE INICIALIZACIÓN NO ESTÁTICO. Se llama por cada instancia.
        procesador = Procesadores.INTEL_I7;
    }

    public PCIntel() {
        placaBase = PlacasBase.ASROCK;
        memoria = Memorias.KINGSTONE_32GB;        
    }

    public PCIntel(PlacasBase placaBase) {
        this.placaBase = placaBase;
        memoria = Memorias.KINGSTONE_32GB;        
    }
        
    public PCIntel(Memorias memoria) {
        placaBase = PlacasBase.ASROCK;
        this.memoria = memoria;
    }

    public PCIntel(PlacasBase placaBase, Memorias memoria) {
        this.placaBase = placaBase;
        this.memoria = memoria;
    }   
}