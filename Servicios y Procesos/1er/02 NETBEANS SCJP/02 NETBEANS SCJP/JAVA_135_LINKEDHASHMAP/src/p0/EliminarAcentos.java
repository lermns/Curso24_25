// Crear una clase de tipo LinkedHashMap (mapa) para dada una cadena de texto,
// reemplazar las letras acentuadas en minúsculas por su correspondiente, sin
// acentuar, en mayúsculas

// Nota: Tratar de convertir la cadena original en un array de caracteres,
// producir el reemplazo de los acentuados e ir construyendo una nueva cadena
// con su sucesiva concatenación.


package p0;

import java.util.LinkedHashMap;


public class EliminarAcentos {

    private LinkedHashMap<Character,Character> mapaAcentos;
 
    public EliminarAcentos() {
        mapaAcentos = new LinkedHashMap<Character,Character>();
        crearMapaAcentos();
    }
        
    public final void crearMapaAcentos() {
        
        // Reemplazamos los acentos por letras en mayúsculas:
        
        mapaAcentos.put('á','A');
        mapaAcentos.put('é','E');
        mapaAcentos.put('í','I');
        mapaAcentos.put('ó','O');
        mapaAcentos.put('ú','U');
    }
    
    public void revisarCadena(String cadena) {
        char[] caracteres = cadena.toCharArray(); // cadena a array de caracteres.
        String cadenaSinAcentos = "";
        
        for (int i = 0; i < caracteres.length; i++) { // recorrer el array.
            if(mapaAcentos.containsKey(caracteres[i])) {
                // obtener el value a partir del char de la clave e
                // ir construyendo la cadena caracter a caracter.
                cadenaSinAcentos += mapaAcentos.get(caracteres[i]);
            } else {
                // coger el caracter original sin más.
                cadenaSinAcentos += caracteres[i];   
            }
        }
        
        System.out.println("CADENA ORIGINAL ... ");
        System.out.println(cadena);
        
        System.out.println("\n\nCADENA SIN ACENTOS ... ");
        System.out.println(cadenaSinAcentos);
    }

    
    public static void main(String[] args) {       
        EliminarAcentos limpiador = new EliminarAcentos();
        limpiador.revisarCadena("allí está el camión y " +
                                "éste es su conductor, ¿lo conoces tú?");        
    }   

}