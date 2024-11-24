// Crear una clase que emule un diccionario inglés-español a través de una
// colección de tipo HashMap. Se utilizará la palabra inglesa para el key
// y su correspondiente traducción al español para el value (lógicamente el
// contenido del mapa ha de generarlo el programador).
// Una vez constituido el diccionario, imprimir el total de palabras inglesas
// que contiene, para a continuación utilizar un Scanner con el que solicitar
// al usuario qué palabra, de entre las disponibles, se desea traducir.

// Nota: HashMap a diferencia de Hashtable no está sincronizada y sí admite
//       null tanto para el key como para el value.


package p0;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;


public class Diccionario_UK_SP {

    private HashMap<String,String> diccionario;
        
    public Diccionario_UK_SP() {
        diccionario = new HashMap<String,String>(); 
        inicializarDiccionario();
        imprimirPalabrasInglesas();
        solicitarPalabra();
    }
    
    private void inicializarDiccionario() {
        diccionario.put("cat" , "gato");
        diccionario.put("dog" , "perro");
        diccionario.put("bird" , "pajaro");
        diccionario.put("lion" , "leon");
        diccionario.put("sparrow" , "gorrion");
    }
   
    private void imprimirPalabrasInglesas() {        
        Iterator it = diccionario.keySet().iterator(); // iterador claves.
        while(it.hasNext()) {
            System.out.println("---> " + it.next());
        }        
    }
        
    private void solicitarPalabra() {        
        System.out.print("\nINTRODUCE LA PALABRA A TRADUCIR ... ");
        Scanner sc = new Scanner(System.in); // CREAR SCANNER CON FLUJO DE TECLADO (System.in).
        String palabra = sc.nextLine();      // usar captura de toda la línea.
        System.out.println("\n\n");
        
        if(diccionario.containsKey(palabra)) {
            System.out.println("LA TRADUCCION DE " + palabra + " ES ... " +
                    diccionario.get(palabra));
        } else {       
            System.out.println("NO PUEDO TRADUCIR ... " + palabra);
        }
    }

}