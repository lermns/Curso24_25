// Crear la interfaz InterfazPrecios que establezca los precios para los distintos
// tipos de masa e ingredientes. Para poder usarla, no es necesario que la clase
// la implemente, ya que en este caso se usa como "catálogo de constantes" y no cómo
// "contrato u obligatoriedad de métodos".


package interfaces;

public interface InterfazPrecios {

    // TODAS LAS "variables" SON DE TIPO public + static + final, LO QUE LAS
    // CONVIERTE EN CONSTANTES PÚBLICAS Y ESTÁTICAS.
    
    double PRECIO_MASA_FINA         = 10;
    double PRECIO_MASA_NORMAL       = 11;
    double PRECIO_MASA_PAN          = 12;

    double PRECIO_TOMATE            = 1;
    double PRECIO_QUESO             = 1.20;
    double PRECIO_ACEITUNA          = 0.70;
    double PRECIO_CEBOLLA           = 0.50;
    double PRECIO_CHAMPI            = 0.90;
    double PRECIO_SALSA_BARBACOA    = 2;
    double PRECIO_TERNERA           = 4.25;
    double PRECIO_BACON             = 2.70;        
}