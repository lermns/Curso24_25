// Crear la clase Taller para generar distintos tipos de coche y asociarles complementos.
// Imprimir por pantalla la información de cada uno de ellos.


package talleres;

import coches.Coche;
import enumerados.Complementos;

public class Taller {

    public static void main(String[] args) {
 
        // "MODELO", PRECIO, COMPLEMENTOS(en parámetros variables de tipo enumerado). 
        Coche c1 = new Coche("CITROEN SARA",20000,Complementos.MOTOR_V8,Complementos.ALERONES);
        c1.generarFichaCoche();
        
        System.out.println("\n__________________________________________________\n");
        
        Coche c2 = new Coche("SEAT IBIZA",17000,Complementos.LLANTAS_ALEACION);
        c2.generarFichaCoche();
                
        System.out.println("\n__________________________________________________\n");        
        
        Coche c3 = new Coche("RENAULT EXPRESS",16000,Complementos.comprarTodos());
        c3.generarFichaCoche();   
    }    

}