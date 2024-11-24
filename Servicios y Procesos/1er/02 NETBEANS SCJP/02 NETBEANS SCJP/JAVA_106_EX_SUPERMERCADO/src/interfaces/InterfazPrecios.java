// Crear una interfaz que defina los precios de los distintos artículos que
// podemos adquirir en el supermercado. Para la cebolla NO HAY PRECIO (null),
// lo cual supondrá un error en ejecución. Utilizar valores Double (wrapper).


package interfaces;

public interface InterfazPrecios {
    
    // OBSERVAR QUE UTILIZAMOS EL WRAPPER Double EN LUGAR DE EL PRIMITIVO double.
    // DE ESTA FORMA ES SENCILLO SIMBOLIZAR QUE LA CEBOLLA NO TIENE LA ETIQUETA DEL PRECIO.
    
    Double PRECIO_CEBOLLA     = null; // A LA CEBOLLA NO LE PUSIERON PRECIO.
    Double PRECIO_TOMATE      = 1.20D;
    Double PRECIO_PIMIENTO    = 2.25D;
    Double PRECIO_PAN         = 1D;
    Double PRECIO_LECHUGA     = 0.90D;   
}