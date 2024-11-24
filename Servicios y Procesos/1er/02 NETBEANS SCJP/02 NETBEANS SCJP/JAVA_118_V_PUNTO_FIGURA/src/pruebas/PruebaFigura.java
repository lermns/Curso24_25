// Crear una clase que compruebe el funcionamiento de las clases Punto y Figura,
// para lo cuál se generarán instancias de las mismas.


package pruebas;

import figuras.Figura;
import puntos.Punto;


public class PruebaFigura {

    public static void main(String[] args) {
        
        Figura f1 = new Figura();
        
        Punto p1 = new Punto(1,2,3);
        Punto p2 = new Punto(4,5,6);
        Punto p3 = new Punto(7,8,9);
        
        f1.definirPuntos(p1,p2,p3);
        
        f1.visualizarPuntos();   
    }   

}