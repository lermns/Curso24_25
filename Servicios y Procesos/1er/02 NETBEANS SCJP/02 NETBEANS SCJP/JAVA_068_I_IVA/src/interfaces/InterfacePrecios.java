// Crear la interfaz que define el precio de las subclases de Articulo, Televisor y
// Ordenador. Dicha interfaz se emplea a modo de "catálogo de constantes", no siendo
// necesaria su implementación por parte de dichas subclases (de hecho, no sería
// adecuado el hacerlo ya que no se busca obligación de métodos ni uso de polimorfismo).


package interfaces;

public interface InterfacePrecios {

    //public static final    
    double PRECIO_TELEVISOR = 2500;
    double PRECIO_ORDENADOR = 1800;
    double PRECIO_PLAY5 = 499;
    double PRECIO_IPAD = 300;
    

}