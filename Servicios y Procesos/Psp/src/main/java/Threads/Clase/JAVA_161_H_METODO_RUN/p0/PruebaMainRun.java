// Crear una clase que compruebe cómo el invocar al método run de un
// determinado hilo como simple instancia, NO LO CONVIERTE EN UN HILO
// REAL DE EJECUCIÓN (ni está planificado por el Scheduler ni éste
// le va a entregar una pila de ejecución). Única y exclusivamente
// la llamada al método start es capaz de arrancar el hilo.

// Llamar a run directamente es equivalente a invocar a cualquier 
// otro método disponible en la clase. De hecho, al consultar su
// estado a través del método getState de la clase que hereda
// de Thread, se obtendrá NEW (nacido o nuevo) lo cuál justifica
// que no es aún un verdadero hilo de ejecución.


package Threads.Clase.JAVA_161_H_METODO_RUN.p0;


public class PruebaMainRun {

    public static void main(String[] args) {
        
        Hilo h1 = new Hilo();

// CONSTITUYE UN HILO DE EJECUCIÓN (se le asocia una pila de ejecución).        
// ARRANCADO EL HILO, EL SISTEMA INDICA PARA getState() ---> RUNNABLE.
//        h1.start();
//        System.out.println("estado h1 ---> " + h1.getState());

        
// NO CONSTITUYE UN HILO DE EJECUCIÓN, SINO SIMPLEMENTE LA INVOCACIÓN A UN MÉTODO.
// ... no se le asocia una pila de ejecución.
// ARRANCADO EL HILO, EL SISTEMA INDICA PARA getState() ---> NEW.        
        h1.run();
        System.out.println("estado h1 ---> " + h1.getState());
    }   

}