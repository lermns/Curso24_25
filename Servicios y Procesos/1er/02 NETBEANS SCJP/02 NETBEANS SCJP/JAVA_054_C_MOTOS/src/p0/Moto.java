// Crear un clase que mediante la sobrecarga de constructores permita la instanciación
// de objetos Moto de distintas formas, ya sea indicando el tipo y/o la cilindrada y/o
// el color o bien ninguno de ellos. Se utilizará la invocación local de constructores
// con el fin de reutilizar código.

// Sobrescribir el método toString para visualizar os atributos del objeto Moto creado,
// instanciando uno por cada forma de constructor.


package p0;

public class Moto {

    private String  tipo;
    private int     cilindrada;
    private String  color;
    
    public Moto() { // constructor que da valores por defecto.
        tipo            = "CAMPO";
        cilindrada      = 600;
        color           = "ROJA";
    }
    
    public Moto(String tipo) { // constructor que pide el parámetro tipo.
        this(); // invocación a constructor local para obtener los otros valores por defecto.
                // this() o super() han de estar en la primera línea y sólo puede usarse uno.

        this.tipo       = tipo; // sobrescribir el valor asignado por defecto para el tipo.
        //cilindrada    = 600;
        //color         = "ROJA";
    }
    
    public Moto(String tipo, int cilindrada) { // pide 2 parámetros.
        this();
        this.tipo       = tipo;
        this.cilindrada = cilindrada;
        //color         = "ROJA";
    }
    
    public Moto(String tipo, int cilindrada, String color) { // pide los 3 parámetros.
        this.tipo       = tipo;
        this.cilindrada = cilindrada;
        this.color      = color;
    }
    
    @Override
    public String toString() {
    
        String texto = "\n_______________________________________\n";
        
        texto += "TIPO = " + tipo + "\n";
        texto += "CILINDRADA = " + cilindrada + "\n";
        texto += "COLOR = " + color + "\n";        
        texto += "_______________________________________\n";
        
        return texto;
    }    
    
    public static void main(String[] args) {
        
        Moto m1 = new Moto();
        Moto m2 = new Moto("CARRETERA");
        Moto m3 = new Moto("CARRETERA", 1000);
        Moto m4 = new Moto("CARRETERA", 1000, "VERDE");
        
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);
        System.out.println(m4);        
    }
}