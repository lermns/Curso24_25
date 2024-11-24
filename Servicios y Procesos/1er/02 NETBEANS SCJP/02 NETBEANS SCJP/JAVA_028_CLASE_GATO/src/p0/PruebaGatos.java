// Crear un clase que compruebe el funcionamiento de la clase Gato. Instanciar 2 objetos
// mediante el constructor parametrizado y modificar sus valores.


package p0;

public class PruebaGatos {

    public static void main(String[] args) {
        
        Gato g1 = new Gato("ISIDORO", "SIAMES", 3);
        Gato g2 = new Gato("GARFIELD", "DIBUJOS", 14);                
        
        System.out.println("LOS GATOS SON: \n");
        System.out.println(g1);
        System.out.println(g2);
        
        System.out.println("\n__________________________________\n");
        
        g1.maullar();
        
        System.out.println("\n__________________________________\n");
        
        g2.comer("sardinas");
        
        System.out.println("\n__________________________________\n");
        
        g2.comer("cristales");
        
        System.out.println("\n__________________________________\n");
        
        //g1.setEdad(500); // error, el método comprueba que 500 no es un valor adecuado.
        //g1.edad = 500;
        //System.out.println("g1 ---> " + g1);
    }
}