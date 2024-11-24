// Crear la clase Abuela como inicio de la jerarquía de clases Abuela - Madre - Hija.
// Se Dispone del atributo precioTierrasPueblo cuyo valor de venta será designado por
// su clase heredera (clase Madre) a la que, a su vez, le enviará el valor su respectiva
// clase heredera (clase Hija).

// Se trata de poner de manifiesto cómo siempre se debe cumplir con el encadenamiento
// entre clases y la posibilidad de que sea la clase hija la que decida el valor a
// utilizar en la clase madre, de forma que la variable recibida por herencia venga
// con el valor elegido por la propia hija.


package p0;

public class Abuela {

    protected int precioTierrasPueblo;

    public Abuela(int precioTierrasPueblo) {
        this.precioTierrasPueblo = precioTierrasPueblo;
        System.out.println("precioTierrasPueblo = " + precioTierrasPueblo);
    }   
}