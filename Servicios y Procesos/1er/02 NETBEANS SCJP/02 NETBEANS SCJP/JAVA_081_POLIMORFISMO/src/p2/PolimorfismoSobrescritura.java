// Crear una clase que demuestre cómo al llamar al método m1 sobre un objeto
// de tipo Hija, este llamará a su vez a la versión sobrescrita de m2 (definido
// en la clase heredera) y no a la versión original de la madre. Ambos métodos
// son de instancia y por tanto, se resuelven a través de la máquina virtual en
// tiempo de ejecución, es decir, por lazy-binding. Si se utilizase un objeto de
// tipo Madre o si los métodos fuesen estáticos, entonces si se llamaría a la
// versión m2 original de Madre.


package p2;

public class PolimorfismoSobrescritura {

    public static void main(String[] args) {

        System.out.println("\n___ CON REFERENCIA HIJA CARGADA CON OBJETO HIJA ___\n");
        
        Hija h1 = new Hija();
        h1.m1();
        
        System.out.println("\n___ CON REFERENCIA MADRE CARGADA CON OBJETO HIJA ___\n");
        
        Madre madre = new Hija();        
        madre.m1();        

        System.out.println("\n___ CON REFERENCIA MADRE CARGADA CON OBJETO MADRE ___\n");
        
        Madre m = new Madre();        
        m.m1();        
        
    
    }    
}