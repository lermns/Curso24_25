// Crear la clase GuardiaCivil que defina el método darElAlto, que recibirá un
// objeto del tipo Conductor, sobre el cuál, se comprobará la posible infracción
// cometida por éste. Para ello, se invoca al método comprobarPosibleInfracción,
// que a través de un bloque switch revisa el valor del enumerado tipoInfracción
// y en el caso de ser distinto de NINGUNA, generar la excepción personalizada
// de tipo GRAVE, MEDIA o LEVE correspondiente y lanzarla como el tipo general
// personalizado Infracción (el método declara el throws necesario). Así, la
// invocación se encierra en un bloque try con diversos catch, aplicándose la
// granularidad en base a los 3 subtipos de Infracción. Para no repetir código
// de gestión de la excepción (mensaje, retirada de puntos ... etc), se establece
// éste en lugar de en los catch, en el propio método comprobarPosibleInfracción,
// ejecutándose el mismo sólo si realmente ha habido una infracción.

// Cada subtipo de infracción conlleva un mensaje, puntos a retirar y multa económica
// acorde con la gravedad de la misma.


package trafico;

import conductores.Conductor;
import enumerados.EnumInfracciones;
import infracciones.Infraccion;
import infracciones.InfraccionGRAVE;
import infracciones.InfraccionLEVE;
import infracciones.InfraccionMEDIA;

public class GuardiaCivil {

    private static void comprobarPosibleInfraccion(Conductor conductor) 
        throws Infraccion { // Declaramos el posible lanzamiento de Infraccion.
        
        // PROCESO PARA CONSULTAR LA POSIBLE INFRACCIÓN DEL CONDUCTOR:        
        
        Infraccion infraccion = null; // Partimos de que no hay objeto excepción.
        
        EnumInfracciones tipoInfraccion = conductor.consultarInfraccion(); // tipo enumerado
        
        System.out.println("=> " + tipoInfraccion + "\n");        
                
        // En función del tipo enumerado de infracción, generar el tipo de 
        // excepción personalizada correspondiente y finálmente, lanzárla.
        switch (tipoInfraccion) {
            
            // Creación del objeto excepción en tipo de ejecución.
            
            case LEVE:
                infraccion = new InfraccionLEVE();
                break;
            case MEDIA:
                infraccion = new InfraccionMEDIA();
                break;
            case GRAVE:
                infraccion = new InfraccionGRAVE();
                break;
            default: // no ha cometido ninguna infracción.
                System.out.println("GRACIAS, PUEDE USTED CONTINUAR.");
        }      
        
        // A continuación y sólo si dicho objeto no es nulo, lanzarlo. 
        
        if(infraccion != null) {
            // Mirar el objeto de excepción personalizada al que apunta la
            // referencia cargada a través del anterior bloque switch (G,M,L).
            
            // Se utiliza lazy-binding en la invocación de los métodos.            
            int puntosARetirar = infraccion.consultarPuntosARestar();
            int multa = infraccion.consultarMulta();
            
            System.out.println("SE LE VAN A RETIRAR LOS SIGUIENTES PUNTOS DEL CARNE ... "
                    + puntosARetirar);
            
            conductor.restarPuntosCarne(puntosARetirar);
            
            System.out.println("SE LE VA A SANCIONAR CON ... " + multa + " €");
            
            throw infraccion; // LANZAR LA EXCEPCIÓN AL BLOQUE DE GRANULARIDAD.
        } 
        
    }
    
    
    public static void darElAlto(Conductor conductor) {
        try {
            
            System.out.println("BUENOS DÍAS, COMPROBAMOS SI HA COMETIDO UNA INFRACCIÓN ... \n");                    
            
            // El método declara lanzamiento de la excepción personalizada
            // Infraccion (se usa el supertipo para encerrar uno de los 3
            // tipos grave, media o leve. Si el tipo enumerado utilizado 
            // fué NINGUNA, no se generará ninguna excepción.
            comprobarPosibleInfraccion(conductor);
            
            // *** AQUÍ PODEMOS ESTAR RECIBIENDO UNA EXCEPCIÓN LANZADA POR
            //          EL MÉTODO comprobarPosibleInfraccion *** 
                        
        // GRANULARIDAD DE LA POSIBLE EXCEPCIÓN - LEVE(fina) - MEDIA - GRAVE(gruesa).    
        } catch(InfraccionLEVE leve) {
            System.out.println("DEBE USTED COMPRAR LOS TRIANGULOS REGLAMENTARIOS");
            // ÉSTO SERÍA REPETIR CÓDIGO EN CADA UNO DE LOS CATCH.
            
            //            conductor.restarPuntosCarne(leve.consultarPuntosARestar());
            //            System.out.println("multa ---> " + leve.consultarMulta());
            
            // ... POR ESO HEMOS CÓLOCADO EL CÓDIGO ARRIBA.
            
        } catch(InfraccionMEDIA media) {
            System.out.println("DEBE USTED COLOCARSE EL CINTURON DE SEGURIDAD ANTES DE INICIAR LA MARCHA");
            //
            //
        } catch(InfraccionGRAVE grave) {
            System.out.println("DEBE USTED DARME LAS LLAVES DEL COCHE Y COLOCAR LA CABEZA BAJA. AVISAMOS A LA AMBULANCIA");
            //
            //        
        } catch(Infraccion i) {
            System.out.println("********** INFRACCION DESCONOCIDA **********");
        }
        
        System.out.println("\n\nINFORME FINAL DEL CONDUCTOR " + conductor);
        
        System.out.println("\nFIN DE IMPRESION\n");   
    }   
}