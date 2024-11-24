// Crear HiloUrgencias cómo el anterior HiloAmigos pero de manera que en este
// caso, la sobrescritura de su método run invoque a llamarUrgencias, método
// también definido como estático.


package Threads.Clase.JAVA_158_HS_MOVIL_ESTATICO.p0;


public class HiloUrgencias extends Thread {
   
    @Override
    public void run() {
        Movil.llamarUrgencias();
    }   

}