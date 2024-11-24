// Crear una clase que genere 10 tarjetas, las muestre por pantalla y finalmente
// las separe en los grupos correctas e incorrectas, para volver a visualizarlas.


package p1;

public class PruebaFabricaTarjetas {

    public static void main(String[] args) {
        
        FabricaTarjetas fabrica = new FabricaTarjetas(10);
        
        fabrica.visualizarTarjetas();
        
        System.out.println("\n_________________________\n");
        
        fabrica.comprobarTarjetas();      
    }    
}