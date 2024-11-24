// Crear una clase que simule la tirada repetitiva de un dado, de forma que cada valor obtenido se
// acumule a los anteriores (a modo de ganancias) hasta que resulte el denominado como valor prohibido
// que terminará la ejecución (es elegido aleatoriamente por el sistema y está dentro del rango de valores
// posibles). Llegado dicho momento, se nos debe informar de cuántas tiradas se han realizado y cuánto
// dinero hemos acumulado (el número prohibido no cuenta ni para los totales ni de jugadas ni de dinero).


package p2;

public class DadosApuesta {

    public static void main(String[] args) {
        
        final int rangoMaximo = 6;
        
        final int numeroProhibido = (int)(Math.random()*rangoMaximo) +1 ;
        System.out.println("EL NUMERO PROHIBIDO ES EL ... " + numeroProhibido + "\n");
        
        int dado;
        int veces = 0;
        int totalDinero = 0;
        
        // NO SE CONSIDERA EL DINERO NI LA VEZ CORRESPONDIENTE AL NUMERO PROHIBIDO.
        
        while ( (dado = (int)(Math.random()*rangoMaximo) + 1) != numeroProhibido ) {
            veces++;
            totalDinero += dado;
            System.out.println("HA SALIDO EL ... " + dado + "\n");
            //System.out.println("DINERO ACUMULADO HASTA AHORA... " + totalDinero + "\n");
            
        }
        
        System.out.println("FIN DE PARTIDA, HA SALIDO EL ... " + numeroProhibido);
        
        System.out.println("\n_______________________________________\n");
        
        System.out.println("NUMERO DE JUGADAS ... " + veces);
        System.out.println("DINERO TOTAL ACUMULADO ... " + totalDinero);        
    }    
}