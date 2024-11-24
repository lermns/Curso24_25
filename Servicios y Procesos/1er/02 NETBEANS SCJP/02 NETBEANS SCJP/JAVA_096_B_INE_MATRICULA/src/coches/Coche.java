// Crear la clase coche para en función de la sobrecarga de sus constructores
// permita establecer el valor de color, motor y tipo, a la hora de generar la
// instancia. Se dispondrá también de un constructor no parametrizado que asigne
// valores por defecto. En todos los casos, un bloque de inicialización de caracter
// NO ESTÁTICO, dará valor a la matrícula (se llama una vez por cada objeto creado).


package coches;

import enumerados.Colores;
import enumerados.Motores;
import enumerados.Tipos;

public class Coche {

    private Colores color;
    private Motores motor;
    private Tipos tipo;
    private String matricula;    
    
    // BLOQUE INI NO ESTATICO ... se invocado 1 vez por cada instancia.
    // Observar cómo disponemos de 4 constructores en la clase. Todos y cada
    // uno de ellos deberían generar la matricula. Si colocamos el código en
    // cada uno de los constructores, estamos realizando una inútil REPETICIÓN
    // del mismo. Si usamos this(), daríamos valor a atributos en el constructor
    // por defecto que a continuación machacaríamos en el constructor que le
    // invocó, algo tampoco muy acertado. El uso en este caso de un bloque
    // de inicialización no estático, resuelve el problema "gastando" el 
    // mínimo código.
    {
        matricula = "";
        
        for (int i = 0; i < 4; i++) { // 4 números aleatorios de 0 a 9.
            int digito = (int)(Math.random()*10);
            matricula += digito; 
        }
        
        int letra = 'A' + (int)(Math.random()*('Z' - 'A')); // letras [A .. Z].
        matricula += (char)letra;            
    }

    // SOBRECARGA DE CONSTRUCTORES PARA POSIBILITAR LA FABRICACIÓN DE 
    // DISTINTOS TIPOS DE COCHE.
    public Coche() { // valores enumerados por defecto: ROJO, CC1400 Y FAMILIAR.
        color = Colores.ROJO;
        motor = Motores.CC1400;
        tipo = Tipos.FAMILIAR;
    }

    public Coche(Colores color) {
        this.color = color;
        motor = Motores.CC1400;
        tipo = Tipos.FAMILIAR;
    }

    public Coche(Motores motor) {
        color = Colores.ROJO;
        this.motor = motor;
        tipo = Tipos.FAMILIAR;
    }

    public Coche(Tipos tipo) {
        color = Colores.ROJO;  
        motor = Motores.CC1400;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return color + " - " + motor + " - " + tipo + " --MATRICULA--> " + matricula + "\n\n";
    }

    
    public static void main(String[] args) {
        
        Coche c1 = new Coche();
        Coche c2 = new Coche(Colores.VERDE);
        Coche c3 = new Coche(Motores.CC2000);
        Coche c4 = new Coche(Tipos.DEPORTIVO);        
        
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);   
    }   
}