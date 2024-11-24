// Crear una clase que genere una instancia de las clases hilo anteriormente 
// descritas y las ejecute, observando como actúa la SOLICITUD (el Scheduler
// es el que en última instancia decide lo qué se debe hacer) de conmutación
// del hilo de ejecución actúal hacia otro de su misma o mayor prioridad.

// Nota: Se diseñó el sistema para que sean los hilos de mayor prioridad los
//       que traten de terminar siempre por delante de los otros. Así, si desde
//       un hilo se invoca a yield() y el resto de hilos en estado RUNNABLE son
//       de menor prioridad, se volverá a elegir el de mayor prioridad.


package Threads.Clase.JAVA_154_HILOS.p5;


public class PruebaConmutacionYield {

    public static void main(String[] args) {
        
        Thread miHilo = new MiHilo("MI_HILO");
        Thread otroHilo = new OtroHilo("OTRO_HILO");
        
        // PROBAR DISTINTAS EJECUCIONES ... NO HAY NADA SEGURO SOBRE QUIÉN
        // ARRANCARÁ PRIMERO.
        
        miHilo.start();
        otroHilo.start();   
    }
    
}

// SE BUSCA UNA EJECUCIÓN QUE MUESTRE POR PANTALLA:

//EJECUCION DEL HILO ... MI_HILO
//SOLICITUD DE CONMUTACION POR PARTE DE ... MI_HILO
//EJECUCION DEL HILO ... otro_hilo
//FINALIZACION DEL HILO ... otro_hilo
//FINALIZACION DEL HILO ... MI_HILO
