// Crear la clase UsarMovil para que a partir de una pareja de hilos HiloAmigos
// e HiloUrgencias, se compruebe cómo actúa la llave de sincronización sobre los
// métodos estáticos. Verificar como el primer hilo que haga uso de la clase a
// través de un método estático sincronizado, adquiere dicha llave "estática"
// constituída por la propia clase (Class), bloqueando el acceso al resto de 
// métodos estáticos y sincronizados de la misma.


package Threads.Clase.JAVA_158_HS_MOVIL_ESTATICO.p0;


public class UsarMovil {

    public static void main(String[] args) {
        
        Thread h1 = new HiloUrgencias();
        
        Thread h2 = new HiloAmigos();
        
        // El orden en el que se arrancarán los hilos no se puede asegurar
        // al 100% por el simple hecho de colocar h1 por delante de h2. Lo
        // habitual es que sea así, pero no siempre sucede.
        
        // Una forma de asegurar el orden de arranque es introducir un pequeño
        // retardo a continuación del hilo que escribamos en primer lugar. También
        // podemos colocar lógica en el run() de cada hilo, pero eso "ensucia" el
        // código verdadero del hilo.
        
        h1.start();        
        h2.start();   
    }   

}