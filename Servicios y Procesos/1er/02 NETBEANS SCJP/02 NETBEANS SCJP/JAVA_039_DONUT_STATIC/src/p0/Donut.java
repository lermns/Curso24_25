// Crear una clase que represente un Donut (rosquilla). Se dispondrá de un constructor
// público de tal forma que por cada objeto que se instancie, se incremente el valor
// de una variable estática denominada contador.

// Se creará adicionalmente una clase que constituya un total de 10 donuts, para comprobar
// cómo el valor de la variable contador se va incrementando sucesivamente con cada
// donut creado. Probar a definir dicha variable como no estática y ver cómo cambia
// el comportamiento del sistema.


package p0;

public class Donut {

    static int contador; // estática = la misma para todos. No depende de la instancia.
    //int contador; // no estática = cada instancia tiene su propia copia.        
    
    public Donut() {
        contador++;
    }
}


class Homer {

    public static void main(String[] args) {
        
        for (int i = 0; i < 10; i++) {
            new Donut();
            System.out.println("HOMER SE COME LA ROSQUILLA NUMERO " + i);            
        }
        
        System.out.println("\nSE HA COMIDO UN TOTAL DE " + Donut.contador);
        //System.out.println("SE HA COMIDO UN TOTAL DE " + new Donut().contador);
    }    
}