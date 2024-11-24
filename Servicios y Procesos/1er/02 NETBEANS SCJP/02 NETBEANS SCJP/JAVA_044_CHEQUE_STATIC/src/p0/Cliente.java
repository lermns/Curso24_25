// Crear la clase Cliente que hará uso del objeto ChequeRegalo (lo generará a través
// de su constructor). La clase dispone de métodos para consumir y visualizar el 
// saldo, que a su vez, harán uso de los métodos para consultar y consumir
// definidos en la clase ChequeRegalo.


package p0;

public class Cliente {

    private String nombre;
    private ChequeRegalo chequeRegalo;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.chequeRegalo = ChequeRegalo.obtenerChequeRegalo();
    }    
    
    public void consumirSaldo(int saldo) {
        // DELEGACIÓN DE FUNCIONALIDAD.
        chequeRegalo.consumirSaldo(nombre, saldo);
    }

    public void consultarSaldo() {
        // DELEGACIÓN DE FUNCIONALIDAD.
        chequeRegalo.consultarSaldo(nombre);
    }       
}