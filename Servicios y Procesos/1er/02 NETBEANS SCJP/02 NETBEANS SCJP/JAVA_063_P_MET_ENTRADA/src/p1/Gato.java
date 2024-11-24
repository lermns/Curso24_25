// Crear la clase Gato para demostrar cómo el paso de elementos a un método es siempre
// por valor, incluso tratándose de tipos referenciados. Para ello, la clase dispondrá
// del atributo colorPelo y los métodos para asignar y consultar el valor de dicho 
// atributo. Consultarlo antes, durante y después de la invocación al método que lo
// modificará (los cambios se realizan sobre el objeto, la referencia es simplemente la
// forma de llegar a él en el Heap de memoria). Anular explicitamente la referencia que
// recibió el objeto Gato en la entrada del método, comprobando como la referencia original
// sigue apuntando a él.


package p1;

public class Gato {

    private String colorPelo; // null inicialmente, se designa en el constructor.
    
    public Gato() {
        colorPelo = "BLANCO";
    }

    public String consultarColorPelo() {
        //System.out.println("---> " + this.hashCode()); // valor int de identificación.
        return colorPelo;
    }
    
    public void establecerColorPelo(String colorPelo) {
        this.colorPelo = colorPelo;
    }    
}




class Prueba {

    public static void cambiarColorPelo(Gato g) {
        System.out.println("COLOR DE PELO ORIGINAL AL ENTRAR AL METODO = " +
                g.consultarColorPelo());
        //System.out.println("------> " + g.hashCode()); // se verá que es el mismo objeto.
        
        g.establecerColorPelo("NEGRO");
        
        System.out.println("COLOR DE PELO CAMBIADO AL FINALIZAR EL METODO = " +
                g.consultarColorPelo());
        //System.out.println("------> " + g.hashCode()); 
        
        System.out.println("ANULAR LA REFERENCIA DEL METODO cambiarColorPelo");
        g = null; // esta g se borra automáticamente del Stack al finalizar el método.
        //g.consultarColorPelo(); // excepción en ejecución, g es nula.        
    }
    
    
    public static void main(String[] args) {
        
        Gato g = new Gato();
        System.out.println("COLOR DE PELO ORIGINAL EN EL MAIN = " + g.consultarColorPelo());
        cambiarColorPelo(g);
        System.out.println("COLOR DE PELO AL FINALIZAR EL MAIN = " + g.consultarColorPelo());
        //System.out.println("---> " + g.hashCode());        
    }    
}