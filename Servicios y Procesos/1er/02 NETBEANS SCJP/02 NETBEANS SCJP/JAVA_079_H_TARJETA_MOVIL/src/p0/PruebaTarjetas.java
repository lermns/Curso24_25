// Crear una clase que compruebe el funcionamiento de las 2 subclases de Tarjeta. Para
// ello, realizar distintos gastos e ingresos (cuándo no permita el gasto deseado),
// consultando en todo momento el capital disponible.


package p0;

public class PruebaTarjetas {

    public static void main(String[] args) {
        
        Tarjeta tarjetaCredito = new TarjetaCredito();
        Tarjeta tarjetaDebito = new TarjetaDebito();
        
        tarjetaCredito.consultar();
        tarjetaCredito.gastar(100);        
        tarjetaCredito.consultar();
        System.out.println("INTENTO GASTAR OTROS 100 €");
        tarjetaCredito.gastar(100);        
        tarjetaCredito.consultar();
        
        System.out.println("\n__________________________________________________\n");
        
        tarjetaDebito.consultar();
        tarjetaDebito.gastar(100);
        tarjetaDebito.consultar();
        System.out.println("INTENTO GASTAR OTROS 100 €");                
        tarjetaDebito.gastar(100);
        tarjetaDebito.consultar();
        System.out.println("INTRODUZCO 50 €");                        
        tarjetaDebito.asignar(50);
        tarjetaDebito.gastar(100);
        tarjetaDebito.consultar();
    }
}