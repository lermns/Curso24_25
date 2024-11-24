// Crear una clase en la que se ponga de manifiesto cómo y a qué valor el compilador
// incializa las variables globales (los atributos de la clase).

package p2;

public class InicializaVariablesCompilador {

    int variableDeclaradaInicializada = 5;    
    int variableBLANKED; // Las inicializa el compilador.
    
    // LAS FINALES SIEMPRE HAN DE SER INICIALIZADAS POR EL PROGRAMADOR, BIEN EN
    // LA PROPIA DECLARACIÓN O BIEN EN EL CONSTRUCTOR (SIEMPRE Y CUANDO NO SEAN
    // DE NATURALEZA ESTÁTICA, YA QUE EL CONSTRUCTOR OCURRE CON POSTERIORIDAD A
    // LA CARGA DE LOS ELEMENTOS ESTÁTICOS ... EL OBJETO QUEDARÍA INCOMPLETO).

    // SI HAY SOBRECARGA DE CONSTRUCTORES, TODOS ELLOS DEBERAN DAR VALOR A LA
    // VARIABLES DECLARADA COMO final Y NO INICIALIZADA EN SU DECLARACIÓN. SI
    // ALGUNO DE ELLOS NO LO HACE, SE GENERARÁ UN ERROR DE COMPILACIÓN.
    
    boolean v1;     
    byte v2;
    short v3;
    char v4;
    int v5;
    long v6;
    float v7;
    double v8;
    
    public static void main(String[] args) {
        
        InicializaVariablesCompilador variables 
                = new InicializaVariablesCompilador();
        
        System.out.println("v1 = " + variables.v1);
        System.out.println("v2 = " + variables.v2);
        System.out.println("v3 = " + variables.v3);
        System.out.println("v4 = " + variables.v4);
        System.out.println("v5 = " + variables.v5);
        System.out.println("v6 = " + variables.v6);
        System.out.println("v7 = " + variables.v7);
        System.out.println("v8 = " + variables.v8);        
    }
}