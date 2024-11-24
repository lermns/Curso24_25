// Repetición del ejercicio anterior utilizando en este caso como nivel de encapsulación
// protected.


package p1;

import p0.Madre;

public class Intruso2 {

    public static void main(String[] args) {
        
        Madre madre = new Madre();
        
        // ERROR. El paquete de definición original de la variable dinero(p0) no es
        // el actual(p1), luego los privilegios de "entrada por default" con respecto
        // a la variable original de la madre, se pierden.        
        //System.out.println("INTRUSO2 --> DINERO DE MADRE " + madre.dinero);

        Hija2 hija2 = new Hija2();
        
        // ERROR. Lo mismo sucede con la variable heredada por la hija (se blinda el
        // atributo heredado con respecto al paquete original).
        //System.out.println("INTRUSO2 --> DINERO DE MADRE " + hija2.dinero);
        
        // Sin embargo, la variable dirección es propia de hija y se ha creado en el
        // paquete actual(p1), luego aquí si se aplica la "entrada por default".
        System.out.println("INTRUSO2 --> DIRECCION DE HIJA2 " + hija2.direccion);
        
        System.out.println("\n_______________________________________\n");
        
        // Podemos establecer métodos "puente" para rodear/evitar la encapsulación,
        // pero tales métodos deben establecerse bien en la clase madre o bien la 
        // la clase hija (la clase intruso sólo puede utilizarlos, crearlos sería
        // inútil ya que no podrían acceder al atributo por si mismos).
        System.out.println(hija2.obtenerDinero());
        System.out.println(hija2.obtenerDineroThis());
        System.out.println(hija2.obtenerDineroSuper());   
    }
}