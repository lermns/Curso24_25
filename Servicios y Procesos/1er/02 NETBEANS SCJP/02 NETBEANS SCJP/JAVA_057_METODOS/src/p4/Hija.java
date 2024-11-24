// Crear la clase Hija, que extiende a la clase Madre, de forma que ésta defina su
// propio método estático cocinar (es posible ya que en la Madre el método no se
// marcó como final)

// Nota: Si el método visible desde la Madre en la Hija es estático y no final y
// se decide que la Hija deba dar su propia versión, dicho método tendrá también
// que ser estático y se podrá elegir el marcarlo como final. No hay sobrescritura
// pero se deben seguir las reglas de las sobrescritura (no podemos poner @Override).


package p4;

public class Hija extends MadreMEstaticoFinal {

    // A PESAR DE QUE NO ES SOBRESCRITURA, SE DEBEN RESPETAR LAS REGLAS
    // DE LA SOBRESCRITURA (excepto si no hay visibilidad del método de la Madre).
    
    //@Override // error, no se puede sobrescribir un método estático.
    public static void cocinar() {
        System.out.println("LA HIJA NO SABE COCINAR");
    }
}