// Crear la clase Cliente que haga uso de las interfaces I1, I2 o I3 para la invocación
// de los métodos m1(), m2() y/o m3(), según el tipo de interfaz obtenida.

// El cliente DESCONOCE la existencia de la ClaseImplementación, ya que lo que únicamente
// vé son referencias de tipo interfaz (I1,I2 o I3), y los métodos manejados por ellas.


package externo;

import clases.FalsaFactoria;
import interfaces.I1;
import interfaces.I2;
import interfaces.I3;

public class Cliente {
  
    public static void main(String[] args) {

        // Error, no podemos importar la clase. Imposible usar método m4().
        //ClaseImplementacion a = new ClaseImplementacion();
        
        // Error, es clase abstracta (usar y tirar).
        //I1 i1 = new FalsaFactoria().obtenerI1();
        
        I1 i1 = FalsaFactoria.obtenerI1(); // devuelve objeto visto como interfaz.
        i1.m1();
        System.out.println("\n_______________________________\n");
        
        I2 i2 = FalsaFactoria.obtenerI2();
        i2.m1();
        i2.m2();
        System.out.println("\n_______________________________\n");        
        
        I3 i3 = FalsaFactoria.obtenerI3();
        i3.m1();
        i3.m2();
        i3.m3();
        
        System.out.println("\n___________CONVERSION DE I1 A I3 POR CASTING____________\n");        
        
        i3 = (I3)i1;    // todos los métodos conocidos por 13 quedan al descubierto.
        i3.m1();        // así, si el cliente conoce las interfaces, puede superar la
        i3.m2();        // limitación en la visibilidad de métodos (sólo los expuestos).
        i3.m3();   

    }   
}