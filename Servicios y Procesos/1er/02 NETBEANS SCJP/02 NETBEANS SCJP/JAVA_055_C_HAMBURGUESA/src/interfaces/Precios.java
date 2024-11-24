// Centralizamos los precios de los ingredientes de la Hamburguesa, lo que nos permite
// una fácil localización, reutilización y futura modificación del código.

// Usamos una interfaz para declarar en ella CONSTANTES.


package interfaces;

public interface Precios {

    //todas son implícitamente public static final:
    
    double PRECIO_PAN       = 0.50;
    double PRECIO_CARNE     = 3.15;
    double PRECIO_QUESO     = 1.00;
    double PRECIO_TOMATE    = 0.45;    
    double PRECIO_CEBOLLA   = 0.30;
    double PRECIO_PEPINILLO = 0.85;    
}