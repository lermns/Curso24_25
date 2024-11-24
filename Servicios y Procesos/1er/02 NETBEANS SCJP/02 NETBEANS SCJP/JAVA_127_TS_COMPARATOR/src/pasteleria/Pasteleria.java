// Crear la clase Pasteleria que dispondrá de un atributo Vitrina a través
// del cuál se mostrará por pantalla el conjunto de pasteles ya colocados.


package pasteleria;


public class Pasteleria {

    private Vitrina vitrina; // La vitrina hace uso de un comparador en su constructor.

    public Pasteleria() {        
        vitrina = new Vitrina();        
    }
        
    public static void main(String[] args) {

        new Pasteleria();   
    }   

}