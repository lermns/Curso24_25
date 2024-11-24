// Crear una interfaza que defina un array que contendrá un objeto para cada uno de 
// los tipos de bebida del ejercicio. Se utilizará este para generar una compra aleatoria.


package interfacesbebida;

import bebidas.*;

public interface InterfazBebidas {

    //public static final 
    
    Bebida[] bebidas = {
                            new CocaCola(),
                            new JB(),
                            new Brugal(),
                            new Larios(),
                            new Absolut()         
                        };    
}