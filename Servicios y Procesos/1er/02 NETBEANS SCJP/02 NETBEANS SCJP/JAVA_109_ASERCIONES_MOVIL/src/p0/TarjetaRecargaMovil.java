// Crear la clase TarjetaRecargaMovil que dispone de los atributos numeroSerie,
// que será un número aleatorio entre 1 y 1000 y saldo, que será un número
// aleatorio entre 1 y 10, ambos establecidos en el cuerpo del constructor.
// Se dispone en la clase de los métodos para consultar los atributos y se
// sobrescribe el método toString para obtener información del objeto.


package p0;

public class TarjetaRecargaMovil {

    private int numeroSerie;
    private int saldo;

    // CONSTRUCTOR DE LA TARJETA DEL MÓVIL.
    public TarjetaRecargaMovil() {
        numeroSerie     = (int)(Math.random()*10000 + 1);   // [1..1000]
        saldo           = (int)(Math.random()*10 + 1);      // [1 .. 10]
    }
        
    public int getNumeroSerie() {
        return numeroSerie;
    }

    public int getSaldo() {
        return saldo;
    }
        
    @Override
    public String toString() {
        return "NUMERO DE SERIE = " + numeroSerie + " ... SALDO = " + saldo + " €";
    }
    
}