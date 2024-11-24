// Crear la subclase TarjetaCredito y sobrescribir el método gastar sabiendo que en
// este tipo de tarjeta si se admite un saldo final negativo (a pagar con intereses).


package p0;

public class TarjetaCredito extends Tarjeta {

    // Se permite saldo negativo ... porque es de CRÉDITO.
    
    @Override
    protected void gastar(int cantidad) {
        System.out.println("QUIERES GASTAR ... " + cantidad);
        saldo -= cantidad;
        System.out.println("ACEPTADO. HAS GASTADO ... " + cantidad);
    }    
}