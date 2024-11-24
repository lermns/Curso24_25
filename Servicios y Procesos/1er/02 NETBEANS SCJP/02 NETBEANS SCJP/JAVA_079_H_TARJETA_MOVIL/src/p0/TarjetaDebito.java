// Crear la subclase TarjetaDebito y sobrescribir el método gastar sabiendo que en
// este tipo de tarjeta NO se admite un saldo final negativo. Si la petición de gasto
// es superior al saldo, no se permitirá realizar la operación.


package p0;

public class TarjetaDebito extends Tarjeta {

    // No se permite saldo negativo ... porque es de DÉBITO.

    @Override
    protected void gastar(int cantidad) {
        System.out.println("QUIERES GASTAR ... " + cantidad);        
        if(cantidad > saldo) {
            System.out.println("NO PUEDES GASTAR ... " + cantidad + " €");
        } else {        
            saldo -= cantidad;
            System.out.println("ACEPTADO. HAS GASTADO ... " + cantidad);
        }
    }    
}