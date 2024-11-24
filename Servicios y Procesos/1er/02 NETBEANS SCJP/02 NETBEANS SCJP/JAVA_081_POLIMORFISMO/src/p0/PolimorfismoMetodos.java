// Crear una clase para demostrar cómo cuando el método es NO polimórfico (método
// estático), se busca su definición a en la clase del tipo de la referencia que
// maneja el objeto, no en el objeto (no hay lazy-binding, se resuelve en tiempo
// de compilación por el compilador), mientras que con los métodos polimórficos,
// también llamados de instancia (los no estáticos), el comportamiento se busca en
// el objeto con el que se rellena, o al que apunta la referencia (hay lazy-binding,
// se resuelve en tiempo de ejecución por parte de la máquina virtual - JVM).


package p0;

public class PolimorfismoMetodos {

    public static void main(String[] args) {
        
        Madre m = new Hija(); // referencia de tipo Madre, cargada con objeto tipo Hija.
 
        System.out.println("HIJA ES MADRE ..." + (m instanceof Madre));
        
        m.cocinar(); // METODO ESTATICO, NO DEPENDE DE LA INSTANCIA 
                     // MANDA LA REFERENCIA SOBRE EL OBJETO CON LA QUE LA ESTEMOS RELLENANDO.
        
        Madre.cocinar();

        System.out.println("\n_________________________* DOWN-CASTING *_______________________________\n");        
        
        ((Hija)m).cocinar(); // ahora la referencia es de tipo Hija, no Madre.
        
        
        
        System.out.println("\n___________________________________________________________\n");
        
        m.trabajar();   // METODO NO ESTATICO == METODO POLIMORFICO, DEPENDE DE LA INSTANCIA CON
                        // LA QUE RELLENAMOS LA REFERENCIA. MANDA EL OBJETO SOBRE LA REFERENCIA.
    }
}