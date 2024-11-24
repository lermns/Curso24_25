// Crear una clase que compruebe la temperatura del aúla, dividiéndo ésta en un
// total de 4 zonas (MUCHO FRIO - FRIO - CALOR - MUCHO CALOR). Para ello utilizar
// if-else anidados (unos dentro de otros).


package p3;

public class FrioCalorIfElseAnidado {

    public static void main(String[] args) {
        
        int temperatura = 13;
                
        if(temperatura >= 22) {
            // PARTE DE LA DERECHA (CALOR)
            if(temperatura >= 32) {
                System.out.println("HACE MUCHO CALOR");
            } else {
                System.out.println("HACE CALOR");
            }             
        } else {
            // PARTE DE LA IZQUIERDA (FRÍO) ... ha de ser <22 o entraría por arriba.
            if(temperatura >= 12) {
                System.out.println("HACE FRIO");
            } else {
                System.out.println("HACE MUCHO FRIO");
            }               
        }
    }    
}