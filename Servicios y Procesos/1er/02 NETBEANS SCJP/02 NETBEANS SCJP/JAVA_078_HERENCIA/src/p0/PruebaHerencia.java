// Crear una clase que instancie una pareja de objetos Hija. Imprimir el valor de sus
// atributos para a continuación tratar de cambiarlos (directamente o por medio del
// método setX) observando cómo los cambios para la x (variable de instancia) son 
// independientes de un objeto a otro, mientras que para la y (variable de clase o
// estática) afectan a ambos por igual.

// Nota: dado que la encapsulación con la que se definieron los atributos es protected
// y la clase de prueba está en el mismo paquete que el resto (nivel "default") podremos
// modificar el valor de estos actuando directamente sobre ellos, sin ser necesario el
// uso de métodos puente. Se definió el setX como parte del estudio de métodos en herencia.


package p0;

public class PruebaHerencia {
    public static void main(String[] args) {
        Hija h1 = new Hija();
        Hija h2 = new Hija();
        
        System.out.println("h1.x ... " + h1.x);
        System.out.println("h2.x ... " + h2.x);

        System.out.println("\n\n");
        
        h1.setX(100); // cada objeto la suya ... independientes entre sí.

        System.out.println("h1.x ... " + h1.x);
        System.out.println("h2.x ... " + h2.x);
        
    }
}