// Crear una clase que demuestre como el operador de autoasignación += fuerza el
// tipo resultante final al valor de la variable que recogerá el resultado de la
// operación.


package p6;

public class AutoAsignacion {

    public static void main(String[] args) {
        
        byte x = 1;
        int y = 2;
        
        // ERROR POR AUTOPROMOCION:
        //byte resultado1 = x + y;
        
        byte resultado2 = (byte)(x + y);
        
        x += y; // lleva un autocasting implícito.
        
        x += (int)y; // ... x = (byte)(x + int(y));
    }    
}