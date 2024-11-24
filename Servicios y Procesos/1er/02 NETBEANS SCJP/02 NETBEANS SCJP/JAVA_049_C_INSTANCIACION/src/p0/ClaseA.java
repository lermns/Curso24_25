// Crear una clase que estudie las distintas maneras de crear un constructor. Comprobar
// los niveles de encapsulación admitidos, parámetros de entrada de cara a la sobrecarga,
// la posibilidad de emplear super() y this() para llamar a otros constructores (de la 
// madre y los propios respectivamente), así cómo el uso de new cuándo deseamos instanciar
// un objeto en el interior de un método.


package p0;

public class ClaseA {
    
    // Se admiten los 4 niveles de encapsulación para el constructor (es miembro de clase).
    // private ClaseA() {}    
    // ClaseA() {}
    // protected ClaseA() {}
    // public ClaseA() {}
        
    public ClaseA() {
        this(5);    // invocación a otro constructor local (sobrecarga de constructores).
    }               // se busca la reutilización de código (es posible usar bloque inicialización).
    
    private ClaseA(int x) {}    

    private ClaseA(Long x) {}    
    
    public void otroMetodo() {
        new ClaseA(5); // invocación a constructor desde método ... usar new y nombre de la clase.
    }
    
    public void metodo() {
        //this();   // error. this() y super() sólo pueden invocarse desde un constructor.
        //super();  // NO CONFUNDIRLO CON this.xxx y super.xxx.
        
        ClaseA();        // ésto sería la llamada a un método (mirar más abajo);
        new ClaseA();    // ésto sería la llamada a un constructor (lleva el new).
    }   
            
    public int ClaseA() { return 45; } // A-T-E-N-C-I-Ó-N, ésto es un método, no un constructor (devuelve algo).
}