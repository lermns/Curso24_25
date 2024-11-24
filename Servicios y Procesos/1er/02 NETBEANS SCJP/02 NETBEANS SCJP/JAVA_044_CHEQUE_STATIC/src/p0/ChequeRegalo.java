// Crear una clase ChequeRegalo que emule el comportamiento del típico cheque con el que 
// cada cierto tiempo un supermercado puede obsequiar a sus clientes, pudiéndolo gastar 
// en aquellos productos que deseen. El cheque puede ser usado por 1 o más personas,
// contabilizándose los gastos que todos y cada uno de ellos hagan. En ningún caso se
// puede superar el gasto disponible con el importe del artículo que se quiera adquirir.

// La clase simulará el comportamiento de un Singleton, disponiéndose de métodos
// para consular y consumir el crédito del cheque, además del que nos va a permitir
// obtener una referencia a la instancia ÚNICA que constituye dicho Singleton.


package p0;

public class ChequeRegalo {

    private int saldo;    
    
//////////////////// ESTRUCTURA DEL SINGLETON ///////////////////    
    private static ChequeRegalo chequeRegalo;
        
    private ChequeRegalo() {
        saldo = 100; // se carga el cheque inicialmente con 100 euros.
    }

    // Suponemos que sólo hay 1 hilo de ejecución.
    public static ChequeRegalo obtenerChequeRegalo() {
        if(chequeRegalo == null) {
            
            chequeRegalo = new ChequeRegalo();
            System.out.println("Hay un nuevo cheque regalo con "+chequeRegalo.saldo+"€");
        }
        
        return chequeRegalo;
    }
///////////////////////////////////////////////////////

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
    public void consumirSaldo(String nombre, int saldo) {
                
        System.out.println(nombre + " ---> UTILIZA: " + saldo);
        
        if(this.saldo < saldo) {
            System.out.println(nombre + " ---> NO ES POSIBLE GASTAR ... " + saldo);
            consultarSaldo(nombre);
            
            // OPCIÓN A. SI NO HAY SALDO SUFICIENTE ... SE TERMINA EL PROGRAMA.
            //System.out.println("\n --- FIN DE PROGRAMA --- \n");
            //System.exit(0);
            
            // OPCIÓN B. SI NO HAY SALDO SUFICIENTE ... APURAR EL CHEQUE HASTA AGOTARLO.
            apurarElCheque(nombre);
        }
        
        this.saldo -= saldo;
        System.out.println(nombre + ": -" + saldo+"€");
        consultarSaldo(nombre);
    }
    
    public void consultarSaldo(String nombre) {
        System.out.println(nombre + " ---> EL SALDO DISPONIBLE EN EL CHEQUE ES DE ... " + this.saldo);

        if(saldo == 0) {
            System.out.println("FIN DE PROGRAMA SALDO = 0");
            System.exit(0);
        }        
    }
    
    private void apurarElCheque(String nombre) { // privado, uso interno exclusivamente.
        System.out.println("SE VA A APURAR EL CHEQUE HASTA 0 EUROS");
        while(saldo>0) {
            int gastoAleatorio = (int)(Math.random()*5) + 1; // 1 .. 5;            
            if(gastoAleatorio <= saldo) {
                System.out.println(nombre + " APURA: -" + gastoAleatorio+"€");
                saldo -= gastoAleatorio;

                // EL PROGRAMA TERMINA CUANDO AL CONSULTAR SE VE QUE LA VARIABLE
                // GLOBAL saldo TIENE UN VALOR DE 0.
                consultarSaldo(nombre);
            }            
        }
    }
}