// Crear el hilo lector de forma similar al anterior hilo escritor pero
// llamándose en este caso al método leer de cuaderno.


package p1;


public class HiloLectura extends Thread {

    private Cuaderno cuaderno;
    
    public HiloLectura(Cuaderno cuaderno) { 
        this.cuaderno = cuaderno;
    }    
    
    @Override
    public void run() {
        cuaderno.leer();
    }

}