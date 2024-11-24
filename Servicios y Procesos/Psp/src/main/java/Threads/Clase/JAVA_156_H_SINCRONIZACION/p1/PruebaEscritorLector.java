// Crear la clase que compruebe el funcionamiento de los hilos escritor y lector
// y por tanto, del mecanismo de sincronización de métodos en la clase Cuaderno.


package Threads.Clase.JAVA_156_H_SINCRONIZACION.p1;

public class PruebaEscritorLector {

    public static void main(String[] args) {
        
        Cuaderno cuaderno = new Cuaderno();
        
        HiloLectura lectura = new HiloLectura(cuaderno);
        HiloEscritura escritura = new HiloEscritura(cuaderno);
        
        escritura.start();
        lectura.start();
    }    

}