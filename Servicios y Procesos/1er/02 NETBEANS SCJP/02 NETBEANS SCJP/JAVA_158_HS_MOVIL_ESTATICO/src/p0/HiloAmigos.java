// Crear HiloAmigos como clase heredera de Thread. Se sobrescribe su método run
// para que invoque al método estático llamarAmigos de la clase Movil, el cuál
// está sincronizado. Observar cómo en este caso no se necesita pasar un parámetro
// al constructor del hilo para poder referenciar al recurso compartido Movil, ya
// que al ser sus métodos estáticos, podemos, siendo de hecho lo más correcto,
// escribir su nombre y a continuación hacer uso del miembro de la clase, que
// consideremos necesario (si la visibilidad así nos lo permite).


package p0;


public class HiloAmigos extends Thread {
   
    @Override
    public void run() {
        Movil.llamarAmigos();
    }    

}