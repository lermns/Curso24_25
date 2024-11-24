// Crear una clase que imprima todos los caracteres que existen entre la A y la z,
// utilizando un bucle for convencional (los char son números, luego podremos usarlos
// directamente en el for).


package p0;

public class LetrasNumeros {

    public static void main(String[] args) {
      /*  
        for (char letra = 'A'; letra <= 'z'; letra++) {
         
            if(letra >= 91 && letra <= 96) { // eliminamos unos caracteres intermedios "molestos".
                continue;
            //me lguardo cada elemento extraño en una lista
            }
           
            System.out.println("LA LETRA " + letra + " ES EL NUMERO ... " + (int) letra);            
        }
        //muestro la lista
      
        System.out.println("\n___________OTRA FORMA ____________\n");

        for (char letra = 'A'; letra <= 'z'; letra++) {
         
            if( !(letra >= 91 && letra <= 96) ) {
                System.out.println("LA LETRA " + letra + " ES EL NUMERO ... " + (int)letra);            
            }        
        }
*/
          
        System.out.println("\n___________OTRA FORMA ____________\n");
        
        
        for (char letra = 'A'; letra <= 'z'; letra++) {
         
            if(letra < 91 ||  letra > 96) {
                System.out.println("LA LETRA " + letra + " ES EL NUMERO ... " + (int)letra);            
            }        
        }
       
    }
}

/* -- CARACTERES ELIMINADOS --
LA LETRA \ ES EL NUMERO ... 92
LA LETRA ] ES EL NUMERO ... 93
LA LETRA ^ ES EL NUMERO ... 94
LA LETRA _ ES EL NUMERO ... 95
LA LETRA ` ES EL NUMERO ... 96
*/