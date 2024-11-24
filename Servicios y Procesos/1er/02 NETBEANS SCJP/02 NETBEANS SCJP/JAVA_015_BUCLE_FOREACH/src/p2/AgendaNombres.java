// Crear una clase que genere una array de objetos Persona (JavaBean) e imprima los
// datos de cada una de ellas mediante el uso de un bucle for-each.


package p2;

public class AgendaNombres {
    
    public static void main(String[] args) {
        
        Persona p1 = new Persona("PEDRO", 617883344);
        Persona p2 = new Persona("ANA"  , 916783377);
        Persona p3 = new Persona("JUAN",  238998866);
        Persona p4 = new Persona("LUIS",  725421788);
        
        Persona[] amigos = {p1, p2, p3, p4};

        for(Persona p : amigos) {
            System.out.println("---> " + p);
            System.out.println("---> " + p.getClass().getSimpleName());
        }
    }
}

