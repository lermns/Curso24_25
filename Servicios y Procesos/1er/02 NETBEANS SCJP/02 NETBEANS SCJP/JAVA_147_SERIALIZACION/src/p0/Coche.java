// Crear la clase Coche como heredera de Automovil. Se hace uso de la serialización,
// por lo que todos los atributos que ella misma defina se deberán poder serializar,
// a excepción de los marcados como estáticos y transient. Así, se definen las 
// propiedades modelo, precio, usado(estático) y código(transient). Se utiliza un
// contructor por defecto para dar valor a todos y cada uno de ellos. Se finaliza
// sobrescribiendo el método toString para informar sobre el objeto.


package p0;

import java.io.Serializable;


public class Coche extends Automovil implements Serializable {

    // EL ESTADO DEL OBJETO ES LO QUE SE GUARDA EN EL FICHERO. ASÍ, TODOS LOS 
    // ATRIBUTOS DEFINIDOS AQUÍ (no así los heredados) TIENEN QUE SER OBLIGATORIAMENTE
    // SERIALIZABLES (que la clase a a la que pertenecen implemente la interfaz Serializable).
    private String modelo;
    private int precio;
    public static boolean usado; // Lo static NO se serializa.
    public transient int codigo; // Lo transient NO se serializa.

    // IMPORTANTE:
    // Probar a descomentar la siguiente línea y obtendremos una excepción, ya que
    // la clase Motor no es Serializable mientra que la clase que lo continene, en
    // este caso Coche, sí lo es, lo que obliga a que todos sus atributos también
    // deban serlo: 
    // Exception in thread "main" java.io.NotSerializableException: p0.Motor
    
    // private Motor motorExtra = new Motor();
    
    public Coche(String modelo, int precio) {
        System.out.println(" --- SE LLAMA AL CONSTRUCTOR DE COCHE ---");
        this.modelo = modelo;
        this.precio = precio;
        usado = true;
        codigo = 12345;
    }

    public String getModelo() {
        return modelo;
    }

    public int getPrecio() {
        return precio;
    }

    public static boolean isUsado() {
        return usado;
    }

    public int getCodigo() {
        return codigo;
    }    
    
    @Override
    public String toString() {
        return modelo + " ---> " + precio + "€" + 
                " USADO = " + usado + " CODIGO = " + codigo + 
                " COMBUSTIBLE = " + combustible + 
                " MOTOR = " + motor;
    }

}