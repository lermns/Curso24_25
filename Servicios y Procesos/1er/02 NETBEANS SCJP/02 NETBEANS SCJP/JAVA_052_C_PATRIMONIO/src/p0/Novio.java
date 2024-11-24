// Crear una clase Novio que instancie un objeto de la clase Hija. Utilizará el método
// casamiento para decidir si le es o no de interes con la Hija.


package p0;

public class Novio {

    private static final int NIVELDEINTERES = 600000;

    private static void casamiento(int patrimonio) {
       
        if(patrimonio >= NIVELDEINTERES) {
            System.out.println("... ME CASO");
        } else {
            System.out.println("... NO ME CASO");
        }
    }
    
    public static void main(String[] args) {
        
        Hija hija = new Hija();
        
        int patrimonio = hija.calcularPatrimonio();
        
        System.out.println("\n---> PATRIMONIO = " + patrimonio);
        
        System.out.println("\n");
        
        // DECIDIR SI SE CASA O NO SE CASA.
        casamiento(patrimonio);        
    }   
}