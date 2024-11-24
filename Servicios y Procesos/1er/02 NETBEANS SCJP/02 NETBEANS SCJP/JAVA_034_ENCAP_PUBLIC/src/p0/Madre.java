// Crear una clase Madre que defina un atributo de caracter público y compruebe
// cómo las clases hijas del mismo y distinto paquete al que se definió la clase
// madre, pueden acceder a dichos atributos.
// De igual forma se creará una clase intruso para comprobar cómo sin ser clase
// heredera e independientemente del paquete dónde se defina ésta, puede acceder a
// los atributos públicos de la madre.


package p0;

public class Madre {

    // PUBLIC. CUALQUIER CLASE DESDE CUALQUIER PAQUETE, SE SEA O NO HEREDERA.
    
    public int dinero = 1000;
    
    public static void main(String[] args) {

        Madre madre = new Madre();
        System.out.println("MADRE --> DINERO DE  MADRE ... " + madre.dinero);        
    }   
}