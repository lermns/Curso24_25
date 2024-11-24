// Crearla clase MapaMonedas para poder generar y añadir distintos objetos Moneda
// a una colección del tipo Hashtable(mapa). Se utilizará para el campo KEY el 
// nombre de la moneda y para el campo VALUE la descripción de la misma.

// Puede utilizarse la siguiente forma: put(moneda, moneda.obtenerDescripcion()).
// Observar cómo al colocar la referencia moneda en el KEY, se llamará automáticamente
// al método toString, que a su vez devolverá el atributo nombre.

// Nota: Los métodos hashCode y equals actúan sobre el KEY (no sobre el VALUE).
//       Mapa == conjunto de parejas clave, valor, donde ambos son objetos.


package p0;

import java.util.Hashtable;


public class MapaMonedas {

    private Hashtable<Moneda,String> miColeccion;

    public MapaMonedas() {
        miColeccion = new Hashtable<Moneda,String>();
    }
    
    public void añadirMoneda(Moneda moneda) {
        // (KEY = Objeto moneda , VALUE = Descripción String = nombre + valor + pais))
        miColeccion.put(moneda, moneda.obtenerDescripcion());
    }
    
    public void imprimir() {
        System.out.println(miColeccion);
    }
    
        
    public static void main(String[] args) {
        
        MapaMonedas mapaMonedas = new MapaMonedas();
        
        Moneda peseta_1 = new Moneda("PESETA", 100, "ESPAÑA");
        
        System.out.println("\nSE VA A AÑADIR peseta_1 ... 100pts");
        mapaMonedas.añadirMoneda(peseta_1);
        
        mapaMonedas.imprimir();
        
        
        System.out.println("\n______________________________________________\n");
        
        // Físicamente es otro objeto pero en contenido, resulta igual que el anterior
        // y por tanto, se considera REPETIDO.
        System.out.println("\nSE VA A AÑADIR peseta_2 ... 100pts");
        Moneda peseta_2 = new Moneda("PESETA", 100, "ESPAÑA");
        
        mapaMonedas.añadirMoneda(peseta_2);
        
        System.out.println("\n--- ELEMENTOS EN LA COLECCION {K1=V1,K2=V2,...} ---");
        mapaMonedas.imprimir();
        System.out.println("\n\n");
        
        
        System.out.println("\n___________COMPROBACIÓN FÍSCA Y DE CONTENIDO ____________\n");
        
        
        System.out.println("¿SON IGUALES peseta1 == peseta2 ? ... " +
                (peseta_1 == peseta_2) + "\n");          // NO
        
        System.out.println("¿SON IGUALES peseta1.equals(peseta2) ? ... " +
                peseta_1.equals(peseta_2) + "\n");  // SI.
    }    

}