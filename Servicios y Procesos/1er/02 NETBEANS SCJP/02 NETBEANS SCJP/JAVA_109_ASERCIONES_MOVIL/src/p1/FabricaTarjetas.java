// Crear una clase FabricaTarjetas que genere objetos TarjetaRecargaMovil con
// un número de serie y saldo aleatorios. El constructor de la clase nos
// permitirá elegir el número de tarjetas a crear e invocará a un método
// fabricar que almacenará, sobre un atributo de tipo array de Tarjetas, los
// distintos objetos creados. Se dispone de un método para visualizar el
// citado array y de un comprobador que en base al uso de aserciones, detecte
// si el saldo de la tarjeta es inferior a 5 (situación que vamos a definir
// como erronea). Así, con saldos menores de 5, se lanzará una AssertionError
// que, sólo de cara a este ejemplo, capturaremos, para poder separar las
// tarjetas erroneas de las correctas (utilizamos colecciones marcadas con
// género, aunque ésto es algo que se explicará en proyectos posteriores) y
// finalmente las visualizamos.


package p1;

import java.util.ArrayList;
import java.util.Collection;
import p0.TarjetaRecargaMovil;

public class FabricaTarjetas {

    private TarjetaRecargaMovil[] lasTarjetas;
    
    // CONSTRUCTOR:
    public FabricaTarjetas(int cuantas) {
        lasTarjetas = new TarjetaRecargaMovil[cuantas];
        fabricarTarjetas(cuantas);
    }
    
    // MÉTODO:
    private void fabricarTarjetas(int cuantas) {
        for (int i = 0; i < cuantas; i++) {
            lasTarjetas[i] = new TarjetaRecargaMovil();
        }
    }    
    
    // MÉTODO:
    public void visualizarTarjetas() {
        int contador = 0;
        for (TarjetaRecargaMovil tarjeta: lasTarjetas) {
            System.out.println("Tarjeta " + ++contador + ". ---> " + tarjeta);
        }
    }
    
    // MÉTODO:
    public void comprobarTarjetas() {        
       
                
        Collection<TarjetaRecargaMovil> tarjetasErroneas = 
                                    new ArrayList<TarjetaRecargaMovil>();
        
        Collection<TarjetaRecargaMovil> tarjetasCorrectas = 
                                    new ArrayList<TarjetaRecargaMovil>();
        
        for (TarjetaRecargaMovil tarjeta: lasTarjetas) {            
            
            // *** NO OLVIDAR ACTIVAR LAS ASSERTION ... VM OPTIONS -ea ***
            try {
                assert (tarjeta.getSaldo() >= 5) : " LA TARJETA NUMERO " + 
                        tarjeta.getNumeroSerie() + " TIENE UN SALDO INCORRECTO ... " +
                        tarjeta.getSaldo() + " €";
            } catch(AssertionError ae) { // LAS ASERCIONES NO SE DEBEN CAPTURAR ... 
                                         // ...ESTO ES SÓLO UN EJEMPLO.
                
                //System.out.println("**************> " + ae.getMessage());
                System.out.println(ae);
                tarjetasErroneas.add(tarjeta); // ÉSTA ES ERRONEA.
                continue; // proceder con la siguiente tarjeta.
            }
            
            tarjetasCorrectas.add(tarjeta); // ÉSTA ES CORRECTA.
        }
        
        System.out.println("\n\n-----------TARJETAS ERRONEAS-----------\n");        

        for (TarjetaRecargaMovil tarjeta : tarjetasErroneas) {
            System.out.println("ERRONEA ---> " + tarjeta);
        }

        System.out.println("\nSE HAN DETECTADO UN TOTAL DE " + tarjetasErroneas.size() +
                " TARJETAS ERRONEAS");
        
        System.out.println("\n\n-----------TARJETAS CORRECTAS-----------\n");        

        for (TarjetaRecargaMovil tarjeta : tarjetasCorrectas) {
            System.out.println("CORRECTA ---> " + tarjeta);
        }

        System.out.println("\nSE HAN DETECTADO UN TOTAL DE " + tarjetasCorrectas.size() +
                " TARJETAS CORRECTAS");
    }    
}