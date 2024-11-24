// Crear una clase que haga uso de las constantes definidas anteriormente, para
// simplemente mostrarlas por pantalla.


package p1;

import static p0.Constantes.GRAVEDAD;
import static p0.Constantes.PI;
import static p0.Constantes.VELOCIDAD_LUZ;

public class Alumno {
    
    public static void main(String[] args) {
        
        System.out.println("LA CONSTANTE PI ES ... " + PI);
        System.out.println("LA VELOCIDAD DE LA LUZ EN EL VACIO ES ... " + VELOCIDAD_LUZ + " Km/s");
        System.out.println("LA ACELERACIÓN DE LA GRAVEDAD ES ... " + GRAVEDAD + " m/s2");   
    }
}