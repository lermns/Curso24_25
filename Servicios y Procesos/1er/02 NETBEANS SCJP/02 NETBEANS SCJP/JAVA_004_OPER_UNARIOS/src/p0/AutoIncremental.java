// Crear una clase que ponga de manifiesto el funcionamiento de los operadores
// de autoincrementación-decrementación tanto en su versión pre como post incremental.


package p0;

public class AutoIncremental {

    public static void main(String[] args) {

        int contador = 10;
        System.out.println("contador = " + contador);
        
        contador++;     // POST-INCREMENTADOR.   
        //++contador;       // PRE-INCREMENTADOR. 
        
        System.out.println("contador = " + contador);

        contador--;     // POST-DECREMENTADOR.   
        //--contador;       // PRE-DECREMENTADOR. 
        
        System.out.println("contador = " + contador);                  
    }
}