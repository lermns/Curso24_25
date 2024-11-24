// Crear una referencia de InterfazTV y asignarla a la instancia de la clase
// Televisor. Comprobar cómo nos es imposible de utilizar el método de visionado
// de películas MKV a través de dicha referencia. Generar una nueva referencia pero
// en este caso de InterfazTVConMKV y cargarla con la anterior InterfazTV (se hace
// necesario el uso de casting). Demostrar cómo en este caso SÍ es posible el uso
// del método de visualización de MKV haciendo uso del mismo objeto Televisor.

// Nota: Este ejercicio hace un simil con el conocido proceso de actualización del 
// firmware de un determinado modelo de televisión, al que el fabricante "capa" por
// software cierta funcionalidad, a cambio de vendérnoslo por un precio más bajo.
// El proceso de actualización a la firmware del modelo superior (el hardware es
// en ambos casos el mismo) invalida la garantía del fabricante.


package pruebas;

import clases.Televisor;
import interfaces.InterfazTVConMKV;
import interfaces.InterfazTVSinMKV;

public class PruebaTV {

    public static void main(String[] args) {

        // El uso de una u otra interfaz se podría entender como el empleo de
        // una u otra firmware en la televisión (la que se haya grabado en
        // fábrica y que queremos cambiar para habilitar TODA la funcionalidad
        // del televisor que hemos comprado).
        
        Televisor tv = new Televisor(); // objeto televisor. EL MISMO TODO EL EJERCICIO.
        
        // POLIMORFISMO, RELLENAMOS LA INTERFAZ CON UN OBJETO DE LA CLASE QUE LA IMPLEMENTA.
        InterfazTVSinMKV iTV = tv; // interfaz limitada.
        iTV.verCanalTelevision(10);        
        // ERROR.
        //iTV.verPeliculaMKV("SPHERE"); // modelo más barato (función MKV capada en fábrica).
        
        
        
        // HACKEAR LA FIRMWARE DEL TELEVISOR (nos quedamos sin garantía):
        
        // A. Interfaz sin MKV vista como clase Televisor (tiene accesible todos los métodos).
        ((Televisor)iTV).verPeliculaMKV("SPHERE"); 
                
        System.out.println("\n_____________\n");
        
        // B. Interfaz con MKV rellena con objeto televisor.
        InterfazTVConMKV iTVMKV_1 = tv; 
        iTVMKV_1.verCanalTelevision(10);
        iTVMKV_1.verPeliculaMKV("SPHERE");       

        System.out.println("\n_____________\n");        

        // HACKEO:
        // C. Conversión de interfaces sin MKV a con MKV (DownCasting .. conversión a tipo inferior).        
        InterfazTVConMKV iTVMKV_2 = (InterfazTVConMKV)iTV;
        iTVMKV_2.verCanalTelevision(10);
        iTVMKV_2.verPeliculaMKV("SPHERE");
        
        // NOTA: ver el ejercicio 73 FALSA_FACTORIA, en el que se encapsula
        // la clase a nivel de paquete y se proporciona una "factoria" que la
        // devuelve vista como una determinada interfaz (limitar los métodos
        // en función de la que se use). Al ser la encapsulación de paquete,
        // ninguna clase fuera del paquete de definición original podrá hacer
        // un uso directo de la clase (la implementación).
        
    }    
}