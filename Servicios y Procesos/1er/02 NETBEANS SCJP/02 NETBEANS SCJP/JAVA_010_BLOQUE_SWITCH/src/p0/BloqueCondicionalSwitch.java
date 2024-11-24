// Crear una clase que evalúe si una persona es mayor o menor de edad a través
// de un bloque condición switch.


package p0;

public class BloqueCondicionalSwitch {

    public static void main(String[] args) {
        
        byte edad = 17;     
        
        switch(edad) { // UTILIZA INTERNAMENTE EL OPERADOR RELACIONAL ==, NADA MÁS.
            case 17:
                System.out.println("TIENES 17, MENOR DE EDAD");                
                break;                

            case 18:
                System.out.println("TIENES 18, MAYOR DE EDAD");                                
                break;

            default:
                System.out.println("NO TIENES NI 17 NI 18, NO SE");                                
        }
        
        System.out.println("\nFIN DE IMPRESION");        
    }    
}