// Crear una clase abstracta Automovil como punto de inicio en la jerarquía de clases.
// Se definen en ella los atributos combustible, motor y contador(éste último estático).
// Se utiliza el constructor por defecto para dar valor a los atributos combustible y
// motor y se incrementa en +1 el contador para que lleve la cuenta de los objetos hija
// creados. La clase no hace uso de la serialización, es decir, no implementa Serializable.


package p0;

// LA CLASE MADRE NO IMPLEMENTA Serializable, luego no todas sus hijas serán
// ya serializables, cada una tendrá que decidirlo por cuenta propia.

// Será necesario llamar al constructor de Automovil (madre) cada vez que se
// instancie un objeto de la clase hija, para obtener a través de dicho constructor
// el valor de los atributos heredados.
public abstract class Automovil {

    protected String combustible; // STRING implementa Serializable.
    
    protected Motor motor; // Atributo de tipo Motor. NO ES SERIALIZABLE.
    
    protected static int contador; // Lo estático no se serializa.
       
    protected Automovil() {  
        System.out.println(contador+"********************************");
        System.out.println(++contador + " ... SE INVOCA AL CONSTRUCTOR DE LA MADRE " +
                                        " PARA OBTENER VALOR DE combustible Y motor");
        
        
        combustible = "GASOLINA";
        motor = new Motor();
    }   

}