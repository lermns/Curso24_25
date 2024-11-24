// Crear una clase que disponga de un método generarNumeros, el cuál imprimirá
// por pantalla infinitos números elegidos al azar hasta que se obtenga un 5.


package p0;

public class MetodoInstancia {

    public void generarNumeros() {

        while (true) { // bucle infinito.

            int aleatorio = (int) (Math.random() * 10) + 1;

            if (aleatorio == 5) {
                return; // *** SIENDO VOID LA DEVOLUCION PUEDO USAR ESTO ***.
            }

            System.out.println("---> " + aleatorio);
        }
    }
 
    
    public static void main(String[] args) {
        
        // El método de instancia requiere de un objeto, una instancia,
        // para poder ser usado. En este caso, creamos un objeto anómino,
        // es decir, sin referencia, de forma que inmediatamente después
        // de crearse el objeto, se marca cómo candidato a recolección.
        new MetodoInstancia().generarNumeros();        
    }
}