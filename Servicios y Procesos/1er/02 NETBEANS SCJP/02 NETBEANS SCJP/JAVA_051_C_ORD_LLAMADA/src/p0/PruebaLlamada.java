// Crear distintos objetos, comenzando por la Abuela hasta llegar a la Hija, para
// demostrar cómo el encadenamiento de constructores empieza SIEMPRE por la clase
// de más alto nivel en la jerarquía (la clase Object) para a continuación ir 
// descendiendo por la línea de clases hasta llegar a la que en concreto se quiere 
// instanciar (se sube hacia arriba a través de la línea implícita o explicita que
// todo constructor (salvo Object) debe tener ... super(xxx)).

// Nota: Todo objeto que se creé de una determinada clase REQUIERE de la información
// contenida en su clase madre (y ésta a su vez de su madre ... hasta Object) para 
// poder ser constituido (de lo contrario quedaría incompleto). El encadenamiento
// de los constructores nos permite inicializar dicha información/valores para poder
// dar plena forma al objeto deseado (su estado).


package p0;

public class PruebaLlamada {

    public static void main(String[] args) {
        
        new Abuela();   // llamada a constructor de Object -> Abuela.
        
        System.out.println("\n___________________________\n");
        
        new Madre();    // llamada a constructor de Object -> Abuela -> Madre.
        
        System.out.println("\n___________________________\n");

        new Hija();     // llamada a constructor de Object -> Abuela -> Madre -> Hija.
    }    
}