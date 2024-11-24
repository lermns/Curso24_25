// Crear distntos objetos de tipo Sandwich y visualizar su información por
// pantalla. Comprobar como todos y cada uno de ellos tienen la misma fecha
// de envasado (cada ejecución la suya).


package p0;

public class PruebaSandwich {

    public static void main(String[] args) {
        
        Sandwich s1 = new SandwichJAMON();
        Sandwich s2 = new SandwichMAHONESA();
        Sandwich s3 = new SandwichCANGREJO();
        
        System.out.println(s1);
        
        System.out.println("\n______________________________________\n");
        
        System.out.println(s2);
        
        System.out.println("\n______________________________________\n");        
        
        System.out.println(s3);
    }   
}