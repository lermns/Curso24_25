// Crear una clase que realice una colección de billetes. Así, en toda colección
// sólo se puede tener 1 ejemplar de cada uno de los elementos disponibles. 
// Intentar añadir elementos ya introducidos para comprobar como el sistema no
// los acepta.


package billetes;

import java.util.HashSet;

public class PruebaBilletes {

    public static void main(String[] args) {
        
        // CONJUNTO HASHSET DE BILLETES
     
        HashSet<Billete> billetes = new HashSet<Billete>();
        
        billetes.add(new Billete100Euros());
        billetes.add(new Billete1Dolar());
        billetes.add(new Billete1Libra());
        billetes.add(new Billete20Libras());        
       
        System.out.println("\n - BILLETES EN LA COLECCIÓN HASHSET - \n");
        System.out.println(billetes);

        System.out.println("\n__________ INTENTAR VOLVER A AÑADIRLOS _________\n");

        billetes.add(new Billete100Euros()); // devolverían false.
        billetes.add(new Billete1Dolar());
        billetes.add(new Billete1Libra());
        billetes.add(new Billete20Libras());
        
        System.out.println("\n - BILLETES FINALMENTE EN LA COLECCIÓN HASHSET - \n");        
        
        System.out.println(billetes + "\n");               
    }   

}