// Crear 2 objetos Cliente y experimentar con los métodos consultar y consumir para
// comprobar el comportamiento del objeto ChequeRegalo que van a tener asociados (dado
// que es un Singleton ... INSTANCIA ÚNICA PARA TODA LA APLICACIÓN Y EN CADA EJECUCIÓN,
// será el mismo para todos).


package p0;

public class PruebaCheque {
    
    public static void main(String[] args) {
               
        Cliente pepi = new Cliente("PEPI");
        Cliente andres = new Cliente("ANDRES");
        
        pepi.consultarSaldo();
        
        andres.consultarSaldo();
        
        pepi.consumirSaldo(30);

        andres.consultarSaldo();
        andres.consumirSaldo(62);
        
        pepi.consumirSaldo(9); 
    }
}