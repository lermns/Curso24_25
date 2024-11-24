// Crear la clase Madre que recibe los valores de venta de la clase hija (tierras y
// chalet). Envía el precio de las tierras a su clase madre (Abuela) e inicializa su
// variable precio del chalet con el valor designado por la hija.

package p0;

public class Madre extends Abuela {

    protected int precioChaletMadrid;

    public Madre(int precioTierrasPueblo, int precioChaletMadrid) {
        super(precioTierrasPueblo);
        this.precioChaletMadrid = precioChaletMadrid;
        System.out.println("precioChaletMadrid = " + precioChaletMadrid);        
    }
    
}
