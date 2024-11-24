// Crear la clase Hija como heredera de la clase Madre, de forma que envíe el precio
// de la venta (tanto de las tierras del pueblo cómo del chalet en Madrid) para que
// al recibir las variables heredadas, estas vengan con el valor decidido por la 
// propia clase hija. Dotar a la clase de un método público calcularPatrimonio que
// devuelta la suma de los precios parciales de venta.

package p0;

public class Hija extends Madre {
  
    // CONSTANTES. VALORES QUE IMPONEMOS A LA VENTA.

    // Las declaramos estáticas para poder ser empleadas en la llamada hacia el 
    // constructor de la madre (si no daría error puesto que el objeto no puede
    // existir antes de obtener la información de la madre y todo lo que haya en
    // su línea de jerarquía hasta llegar a Object).
    
    private static final int PRECIO_TIERRAS_PUEBLO = 50000;
    private static final int PRECIO_CHALET_MADRID  = 400000;
    private static final int PRECIO_PISO_GETAFE    = 180000;
    
    // VARIABLES:
    protected int precioPisoGetafe;
    
    // INCIALIZAR LAS VARIABLES POR ENCADENAMIENTO:
    public Hija() {
        super(PRECIO_TIERRAS_PUEBLO, PRECIO_CHALET_MADRID);
        this.precioPisoGetafe = PRECIO_PISO_GETAFE;
        System.out.println("precioPisoGetafe = " + precioPisoGetafe);
    }
        
    // Las variables son de tipo protected ("un privado que se hereda") o bien
    // de tipo private. Este método actúa de getter para obtener el valor total
    // del patrimonio (un miembro de la clase tiene derecho a ver al resto de
    // miembros de su misma clase independientemente del nivel de encapsulación
    // de éstos).
    public int calcularPatrimonio() {
        return precioTierrasPueblo + precioChaletMadrid + precioPisoGetafe;
    }    
}