// Crear una clase que muestre el funcionamiento de las clase internas. 
// Observar cómo es o no necesario la instanciación y declaración de la
// clase contenedora, según estemos o no en la clase de definición y si
// según sea o no la clae contenida estática.


package Threads.Clase.JAVA_164_CLASES_INTERNAS.p0;

public class Contenedora { // clase TOP-LEVEL (public, "default")

    private int x = 10;
    
    
    public class Interna_A {} // clase INNER-CLASS (public, protected, "default", private)    
    protected class Interna_B {}
    class Interna_C {}
    private class Interna_D {}


    
    public void metodo() {
        class InternaMetodo { // clase INNER-CLASS en un método.
        }
    }
    
    
    public static class InternaEstatica { // clase INNER-CLASS estática.
        public void saludar() {
            System.out.println("clase interna estatica");
        }
    }
       

// 1. UTILIZACIÓN DESDE EL main DE LA PROPIA CLASE:    
    
    public static void main(String[] args) {


        // Se necesita instanciar un objeto de la contenedora para poder
        // instanciar un objeto de la contenida (interna).
        Interna_A ia = new Contenedora().new Interna_A();
        
        // Si es estática sólo necesito instanciar la interna.
        InternaEstatica ie = new InternaEstatica();
        ie.saludar();
    }    

}



// ........................................................................ //



// 2. UTILIZACIÓN DESDE EL main DE OTRA CLASE:

class PruebaDesdeOtraClase {

    public static void main(String[] args) {
        
        // Si no estamos en la propia clase se necesitará referenciar a la
        // clase contenedora seguido de la contenida, debiéndose generar
        // un objeto de la contenedora para poder instanciar a la contenida.
        Contenedora.Interna_A ia = new Contenedora().new Interna_A();
        
        // En el caso de las internas estáticas sólo se necesita un objeto
        // de la contenida, pero referenciándolo siempre a través de la
        // clase contenedora (en el caso de estar en la propia clase
        // bastaría con nombrar la contenida estática).
        Contenedora.InternaEstatica iestatica = new Contenedora.InternaEstatica();
    }

}