// Comprobar el funcionamiento de la variable estática bolsaCanicas de la clase anterior, creando 2 objetos
// Hermano e invocando a los distintos métodos de negocio de cada uno de ellos, añadiendo o quitando canicas
// de la variable bolsaCanicas que es la misma para ambos.


package p0;

public class PruebaCanicas {

    public static void main(String[] args) {
        
        Hermano luis = new Hermano("luis");
        Hermano juan = new Hermano("juan");
        
        luis.consultarCanicas();
        System.out.println("\n_____________________\n");
        
        juan.consultarCanicas();        
        System.out.println("\n_____________________\n");
        
        luis.comprarCanicas(10);
        System.out.println("\n_____________________\n");        
        
        luis.consultarCanicas();
        System.out.println("\n_____________________\n");
        
        juan.consultarCanicas();
        System.out.println("\n_____________________\n");
        
        juan.perderCanicas(4);
        System.out.println("\n_____________________\n");        

        juan.consultarCanicas();
        System.out.println("\n_____________________\n");
        
        luis.consultarCanicas();
        System.out.println("\n");
    }   
}