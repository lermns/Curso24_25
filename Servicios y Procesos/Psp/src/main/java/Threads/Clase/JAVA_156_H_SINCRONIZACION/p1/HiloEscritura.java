// Crear el hilo escritor a partir de una clase que herede de Thread y que
// defina un atributo privado de tipo Cuaderno (se carga a través de su 
// constructor). Sobrescribir el método run para que llame al método 
// escribir del objeto Cuaderno contenido.


package Threads.Clase.JAVA_156_H_SINCRONIZACION.p1;


public class HiloEscritura extends Thread {

    private Cuaderno cuaderno;
    
    public HiloEscritura(Cuaderno cuaderno) { 
        this.cuaderno = cuaderno;
    }    
    
    @Override
    public void run() {
        cuaderno.escribir();
    }

}