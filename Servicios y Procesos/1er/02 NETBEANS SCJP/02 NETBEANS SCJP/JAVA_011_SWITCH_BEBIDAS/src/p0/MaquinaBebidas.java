// Crear una clase que simule una máquina de bebidas, en la que podremos elegir la
// opción que más nos guste, imprimiéndose por pantalla el precio de aquello que 
// hemos elegido.


package p0;

public class MaquinaBebidas {

    public static void main(String[] args) {
        
        // LAS VARIABLES A USAR EN LOS CASE DEL SWITCH DEBEN POR FUERZA SER final.
        
        final char cafe   = 'c'; // de cara a mantenimiento, cafe es mejor que 'c'.
        final char te     = 't';
        final char limon  = 'l';
        final char pepsi  = 'p';
                
        //char opcion = cafe;        
        char opcion = limon; 
        
        switch(opcion) {

        // LAS SENTENCIAS CASE UTILIZAN IMPLÍCITAMENTE == CON RESPECTO A UN VALOR
        // CONSTANTE ... de ahí que la variable deba ser constante.
        // SE HAN DE DECLARAR LAS VARIABLES DE COMPARACIÓN FUERA DEL switch.
        // PODEMOS HACER USO DE VARIABLES LOCALES CUYO ÁMBITO DE EXISTENCIA SE
        // LIMITARÁ AL ÚNICAMENTE BLOQUE case EN EL QUE SE DEFINIERON.
            
            case cafe: // el compilador sustituirá cafe por su valor real ... 'c'.
                System.out.println("HAS ELEGIDO CAFE ... 1,20€");
                break;
                
            case te:
                System.out.println("HAS ELEGIDO TE ... 0,90€");                
                break;
                
            case limon:
                System.out.println("HAS ELEGIDO LIMON ... 1€");                
                break;
                
            case pepsi:
                System.out.println("HAS ELEGIDO PEPSI ... 0,80€");                
                break;
                
            default:
                System.out.println("BEBIDA INCORRECTA");            
        }        
    }
}