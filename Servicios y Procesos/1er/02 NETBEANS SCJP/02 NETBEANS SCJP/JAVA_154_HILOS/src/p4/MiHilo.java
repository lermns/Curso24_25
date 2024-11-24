// Crear un hilo heredando de Thread que en su método run imprima un mensaje
// avisando del inicio de ejecución del mismo. A continuación, genere un 
// retardo por sleep de 2 segundos y finalice imprimiento un nuevo mensaje
// en el que deje constancia de que el mismo ha finalizado.


package p4;


public class MiHilo extends Thread {

    @Override
    public void run () {        
        System.out.println("INICIO DE EJECUCION DE MIHILO");        

        try {
            Thread.sleep(2000);
        } catch(InterruptedException ie) {
            System.out.println("ERROR ... " + ie);
        }
                
        System.out.println("TERMINO EL MIHILO H1");
    }   

}