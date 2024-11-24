// Crear una clase en la que se refleje qué nombres son válidos para la declaración y cuales no, se vea la
// diferencia entre locales y globales, haga uso de estáticas y finales tanto en primitivas como referenciadas,
// en definitiva, compruebe de forma general las opciones posibles.


package p0;

public class Variables {
    
    // VARIABLE ESTÁTICA:
    static int contador;
    
    // VARIABLE ESTÁTICA Y FINAL:
    static final int IVA = 21; // requiere valor ... "eagerly declaration" ... ansiosa o inmediata.
    
    // VARIABLES GLOBALES PRIMITIVAS:
    int valorArriba = 99;
    int x=234;
    int z = 9;
    int y = z + 8;       
    final int PUNTUACION = 66;
    
    // VARIABLES GLOBALES REFERENCIADAS ... APUNTA A UN OBJETO:
    String color;
    final String forma = "CIRCULAR";
    
        
    public void establecerColor(String color) {
        this.color = color; // resuelve ambiguedad de tipos.
    }

    public void metodo0() {    
        int x = 777; // variable LOCAL.
        
        if(true) {
            //int x; // error, la variable LOCAL x ya existe.
            int r = 99; // r sólo existirá dentro de este bloque, no fuera.
            System.out.println("x = " + x); // imprimirá la x LOCAL no la GLOBAL.
        }
        
        //System.out.println("r = " + r); // error, la variable r está fuera de ámbito.        
    }
    
    public void metodo1() {        
        final String TAMAÑO = "grande"; // fijamos la referencia a un objeto.
        //TAMAÑO = "pequeño"; // error, no se puede referencdia a otro objeto
    }
       
    
    public static void main(String[] args) {
       
        // NO PUEDE HACERSE USO DE this NI super EN UN CONTEXTO ESTÁTICO.
        
        System.out.println("VARIABLE CONTADOR = " + contador);
        System.out.println("VARIABLE CONTADOR = " + new Variables().contador); // objeto anónimo.
        System.out.println("VARIABLE IVA = " + Variables.IVA);              
        
        Variables variables = new Variables(); // hay que crear un objeto en el contexto estático ...
        System.out.println("puntuacion = " + variables.PUNTUACION); // ... para poder usar sus propiedades.
        
        // NOMBRES VÁLIDOS PARA DECLARAR VARIABLES:        
        String silla = "una silla";
        String sillaDeMadera = "una silla de madera";
        int _valor = 55;
        int $valor = 66;
        int valorA2 = 22;
        int _$_____ABC = 44;
        int pesetas€ = 166;

        

        // NOMBRES DE VARIABLES NO VÁLIDOS:
        //int un Valor = 99;    hay un espacio
        //int 111ABC = 444;     empieza por un numero
        //int class = 99;       palabra reservada
        //int @cantidad = 77;   simbolos espèciales
        //int #cantidad = 77;   simbolos espèciales
        //int >cantidad = 77;   simbolos espèciales
        System.out.println("");
        System.out.println("_valor: "+_valor);
        System.out.println("$valor: "+$valor);
        System.out.println("valorA2:  "+valorA2);
        System.out.println("_$_____ABC: "+_$_____ABC);
        System.out.println("pesetas€: "+pesetas€);
        
        
        
        
        // MODIFICACIÓN DE LAS PROPIEDADES DE UN OBJETO REFERENCIADO CON VARIABLE FINAL:
        variables.establecerColor("ROJO"); // correcto, la propiedad no es final. Usamos un método.
        System.out.println("COLOR ANTES DE MODIFICACION = " + variables.color);
        variables.color = "VERDE"; // Ahora cambiamos la variable directamente (estamos en la propia clase).
        System.out.println("COLOR DESPUES DE MODIFICACION = " + variables.color);
        
        // IMPOSIBILIDAD DE MODIFICAR LAS PROPIEDADES DEL OBJETO SI SON FINALES:
        //variables.forma = "ALARGADA"; // error, la propiedad se declaró como final.
        
   }
        
    int valorAbajo = 199; // Válido pero inadecuado el colocar los atributos de la clase aquí.   
    
    
}