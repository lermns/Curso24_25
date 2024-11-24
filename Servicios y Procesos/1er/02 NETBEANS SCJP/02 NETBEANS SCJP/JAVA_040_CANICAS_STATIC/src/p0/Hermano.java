// Crear una clase Hermano con objeto de simular una pareja de hermanos que poseen en
// común una bolsa con canicas. Se dispondrá de una variable estática en la clase
// que lleve la cuenta de cuántas canicas tienen actualmente y de una variable de
// instancia para almacenar el nombre. A través de diversos métodos, se podrá
// consultar, añadir o quitar un determinado número de canicas, observándose como
// lo que haga un hermano afectará al otro, por ser recurso compartido (estático).


package p0;

public class Hermano {

    private String nombre; // PROPIA DE CADA OBJETO, PORQUE ES VARIABLE DE INSTANCIA.
    private static int bolsaCanicas; // COMPARTIDO POR TODAS LAS INTANCIAS PORQUE ES ESTÁTICO.
    
    public Hermano(String nombre) {
        this.nombre = nombre.toUpperCase();
    }
    
    public void comprarCanicas(int cuantas) {
        System.out.println(nombre + " HA COMPRADO " + cuantas + " CANICAS");
        bolsaCanicas += cuantas;
    }
    
    public void perderCanicas(int cuantas) {
        if ((bolsaCanicas - cuantas) < 0) {
            System.out.println("ERROR, NO SE PUEDEN PERDER MAS DE LAS QUE SE TIENEN");
            System.exit(bolsaCanicas - cuantas);
        }
        System.out.println(nombre + " HA PERDIDO " + cuantas + " CANICAS");
        bolsaCanicas -= cuantas;
    }
        
    public void consultarCanicas() {
        System.out.println(nombre + " MIRA LA BOLSA Y VE " + bolsaCanicas + " CANICAS");
    }
}