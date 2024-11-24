// Crear la clase Licoreria generando diversos objetos de tipo Cliente. Probar
// a través de ellos las distintas opciones de compra disponibles.


package p0;

public class Licoreria {

    public static void main(String[] args) {
        
        Cliente c1 = new Cliente("ANA");
        c1.comprarUnaDeCada(); // 1 de cada tipo.
        c1.imprimirTicket();
     
        System.out.println("\n................................\n");
        
        Cliente c2 = new Cliente("JUAN");
        c2.comprarAleatoriamente(); // que el sistema elija cuántas.
        c2.imprimirTicket();
        
        System.out.println("\n................................\n");        

        Cliente c3 = new Cliente("LUIS");
        c3.comprarAleatoriamente(2); // queremos sólo 2 bebidas.
        c3.imprimirTicket();
        
        System.out.println("\n................................\n");        

        Cliente c4 = new Cliente("MARTA");
        c4.comprarSeleccion(Bebidas.VODKA, Bebidas.GINEBRA); // 1 de Vodka más 1 de Ginebra.
        c4.imprimirTicket();
        
        System.out.println("\n................................\n");        

        //Cliente c5 = new Cliente("FERNANDO");
        //c5.comprarSeleccion(Bebidas.VINO); // error, en esta licorería NO HAY VINO.
        //c5.imprimirTicket();   
    }   
}