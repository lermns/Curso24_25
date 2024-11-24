// Crear una clase que evalúe el peso de un boxeador a partir de un bloque de sentencias
// if-else-if e imprima por pantalla la categoría a la que pertenece.


package p4;

public class BoxeoIfElseIf {

    public static void main(String[] args) {

        // VERSIÓN QUE NO USA LA LINEALIDAD DEL if. ES POCO EFICIENTE EN LAS CONDICIONES:
        
        int peso = 19;
        
        if(peso <40) {
            System.out.println("PESO PALILLO");
        } else if(peso >= 40 && peso <= 59) {
            System.out.println("PESO PLUMA");
        } else if(peso >= 60 && peso <= 79) {
            System.out.println("PESO MEDIO");
        } else if(peso >= 80 && peso <= 119) {
            System.out.println("PESO PESADO");
        } else {
            System.out.println("PESO MAZACOTE");
        }
        
        System.out.println("\n______OTRA FORMA______\n");
        
        
        // VERSIÓN QUE APROVECHA LA LINEALIDAD CRECIENTE DEL if, NO USANDO LOS && (MÁS EFICIENTE):
        
        if(peso <40) {
            System.out.println("PESO PALILLO");
        } else if(peso <= 59) {
            System.out.println("PESO PLUMA");
        } else if(peso <= 79) {
            System.out.println("PESO MEDIO");
        } else if(peso <= 119) {
            System.out.println("PESO PESADO");
        } else {
            System.out.println("PESO MAZACOTE");
        }        
    }    
}