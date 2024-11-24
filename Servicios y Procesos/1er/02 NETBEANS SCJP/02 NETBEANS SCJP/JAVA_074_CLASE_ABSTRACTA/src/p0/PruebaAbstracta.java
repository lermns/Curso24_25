// Crear la clase de prueba generando un par de objetos Hija a través de la sobrecarga
// de sus constructores.


package p0;

public class PruebaAbstracta {
    
    public static void main(String[] args) {
    
        //Madre madre = new Madre();    // error, es clase NO instanciable.
        
        Madre madre = new Hija(5);      // polimorfismo.
        System.out.println(madre.m1()); // se busca m1() en la instancia (lazy-binding).

        System.out.println("\n-------------------------------------------------\n");
        
        Hija hija = new Hija();
        System.out.println(hija.m1());
        hija.x = 10;
        System.out.println(hija.m1());
        
        
        Hija2 hija2 = new Hija2();
        System.out.println(hija2.m1());
    }
}