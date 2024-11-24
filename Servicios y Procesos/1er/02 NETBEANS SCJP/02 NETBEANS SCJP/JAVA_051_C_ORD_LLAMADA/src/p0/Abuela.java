// Crear la clas Abuela como punto de inicio de la jerarquía de clases (para este
// ejercicio no es necesario que se abstracta, pero igualmente constituye un 
// supertipo con respecto a sus clases hijas y por supuesto, se puede aplicar
// polimorfismo para cargar una referencia de la misma).

// Utilizar en el constructor de las distintas clases un mensaje que nos avise de
// cuál es exactamente el que se está llamando, para ver el orden del encadenamiento.


package p0;

public class Abuela {

    public Abuela() {
        //Implícitamente está puesto lo siguiente:
        //super();
        System.out.println("CONSTRUCTOR DE LA ABUELA");
    }    
}