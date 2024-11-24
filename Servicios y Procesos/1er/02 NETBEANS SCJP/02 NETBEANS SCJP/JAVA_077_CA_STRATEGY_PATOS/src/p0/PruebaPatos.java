// El patrón STRATEGY viene a decirnos "ENCAPSULA AQUELLO QUE DE UNA A OTRA CLASE
// VARIA". En el caso de los patos es el comportamiento del método volar, de forma
// que si de las clases Pato EXTRAEMOS eso que hace que sean diferentes, encapsulándolo
// en una nueva clase (que se usara a través de composición y delegación), lo que
// queda es lo mismo para todas ellas (igual para todas las implementaciones de la
// clase abstracta).

// Usar STRATEGY nos va a permitir añadir nuevas clases sin tener que alterar el
// comportamiento de las ya existentes. Además, permite realizar futuras modificaciones
// con gran sencillez.

package p0;

public class PruebaPatos {

    public static void main(String[] args) {
        
        Pato pato1 = new PatoGoma(); // utilizar supertipos siempre que sea posible.
        pato1.volar();
        
        System.out.println("\n__________________________________________________\n");        
        
        PatoReal pato2 = new PatoReal();
        pato2.volar();        
    }    
}
