// Crear una clase que instancie 2 objetos de tipo Hilo a los que se les pasará
// un único objeto Periodico como recurso compartido. Arrancar ambos hilos y comprobar
// cómo se produce un bloqueo o espera por parte del segundo hilo entrante al
// leer la sección DEPORTES del periódico (sincronización por bloque), pero no así
// con NOTICIAS (va por delante de DEPORTES y no pertenece al bloque sincronizado, 
// lo mismo que PUBLICIDAD, pero ésta requiere haber leído previamente DEPORTES). 


package Threads.Clase.JAVA_159_HS_POR_BLOQUE.p0;


public class PruebaLectura {

    public static void main(String[] args) {
        
        // Creamos una llave externa y se la asociamos al recurso compartido.
        // Puede ser cualquier objeto Java (todas las instancias, sean de la
        // clase que sean, constituyen por si mismas una llave de sincronización).
        String llave = "llave";
        
        // Sincronizaremos el acceso a la lectura del objeto Periodico en base a
        // la llave externa.
        Periodico periodico = new Periodico(llave);
        
        // Entregamos el recurso compartido Periodico a cada uno de los hilos.
        Hilo h1 = new Hilo(periodico);
        Hilo h2 = new Hilo(periodico);
        
        // Bautizar los hilos.
        h1.setName("ANA");
        h2.setName("JUAN");
        
        h1.start();
        h2.start();
    }    

}