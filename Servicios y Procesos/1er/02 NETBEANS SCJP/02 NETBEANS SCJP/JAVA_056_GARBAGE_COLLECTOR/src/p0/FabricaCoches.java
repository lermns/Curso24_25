// Generar una clase que trate de crear un total de 10000 objetos Coche, llamando
// al colector de basura cada 50 objetos coches creados (se activará o no a voluntad
// propia, nosotros sólo podemos invocarlo). Realizar comprobación sobre la memoria
// disponible con Runtime.getRuntime().freeMemory();


package p0;

public class FabricaCoches {

    public static void main(String[] args) throws InterruptedException {
        
        /*
        
        // PRUEBA DE CÓMO QUEDARIA UNA PAREJA DE COCHES CREADOS:
        
        Coche c1 = new Coche();
        System.out.println(c1);
        
        System.out.println("\n________________\n");        
        
        Coche c2 = new Coche();
        System.out.println(c2);
        */
        
        // MEMORIA INICIAL:
        long memoriaInicial = Runtime.getRuntime().freeMemory();
        System.out.println("MEMORIA INICIAL = " + memoriaInicial);
    
        // VAMOS A TRATAR DE CREAR UN TOTAL DE 10000 objetos Coche, PARA VER
        // EN QUE MOMENTO ENTRA EN ACCIÓN EL RECOLECTOR DE BASURA Y QUÉ ELEMENTOS
        // ELIMINA (lo iremos llamando cada 50 coches creados). 
        
        // NOTA: ABORTAR LA EJECUCIÓN CUÁNDO SE DESEE.
        
        for (int i = 1; i <= 10000; i++) {
            System.out.println(new Coche());
            Thread.sleep(1); // retardo temporal del hilo main.
                       
            if(i%50 == 0) {
                // POSIBLES FORMAS DE "TRATAR" DE INVOCAR AL RECOLECTOR.
                
                //A: 
                //Runtime.getRuntime().gc(); // método estático que nos devuelve el objeto Runtime (único).
                
                //B:
                System.gc();

                //B. MEMORIA DISPONIBLE EN ESTE MOMENTO:
                System.out.println("\nMEMORIA EN i = " + i +
                        "   ----> "  + Runtime.getRuntime().freeMemory() + "\n");                
            }
        }
        
        // COMPROBACIÓN DE LA MEMORIA EMPLEADA TRAS FINALIZAR EL PROCESO:
        long memoriaFinal = Runtime.getRuntime().freeMemory();
        System.out.println("MEMORIA FINAL = " + memoriaFinal);
        
        System.out.println("\n\n");
        
        System.out.println("DIFERENCIA INICIAL - FINAL = " +
                (memoriaInicial - memoriaFinal));
    }   
}