// Crear la clase abstracta PC como punto de inicio de la jerarquía de clases.
// Todas las subclases, que clasificaremos según el tipo de microprocesador que
// empleen (AMD - INTEL) dispondrán de los atributos caja, placaBase, procesador,
// memoria y precio.

// El atributo caja se determina aleatoriamente al cargarse la clase en memoria
// a través de un bloque de inicialización estático y será el mismo para todos
// y cada uno de los objetos que se puedan crear (para una determinada ejecución).
// Se crea el método calcularPrecio para evaluar el coste final del equipo y se
// sobrescribe el método toString para presentar información en pantalla del mismo.


package ordenadores;

import enumerados.Cajas;
import enumerados.Memorias;
import enumerados.PlacasBase;
import enumerados.Procesadores;

public abstract class PC {

    protected static final Cajas caja;
    protected PlacasBase placaBase;
    protected Procesadores procesador;
    protected Memorias memoria;
    protected int precio;

    static { // BLOQUE DE INICIALIZACIÓN ESTÁTICO (todos usarán la misma caja).
        final Cajas modelosCaja[] = Cajas.values();
        int aleatorio = (int) (Math.random() * modelosCaja.length); // 0 .. 1
        caja = modelosCaja[aleatorio];
    }
       
    private int calcularPrecio() {
        
        precio =    caja.cosultarPrecio() +
                    placaBase.cosultarPrecio() +
                    procesador.cosultarPrecio() + 
                    memoria.cosultarPrecio();
        
        return precio;        
    }
    

    @Override
    public String toString() {
        String texto = "";
        calcularPrecio();
        
        texto += "MODELO = " + getClass().getSimpleName().toUpperCase() + "\n";
        texto += "CAJA = " + caja + "\n";
        texto += "PLACA BASE = " + placaBase + "\n";
        texto += "PROCESADOR = " + procesador + "\n";
        texto += "MEMORIA = " + memoria + "\n\n";
        
        texto += "PRECIO DEL EQUIPO = " + precio + " €\n";
        
        return texto;
    }
}