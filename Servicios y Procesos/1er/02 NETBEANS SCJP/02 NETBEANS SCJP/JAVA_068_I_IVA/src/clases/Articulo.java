// Crear una clase abstracta Articulo que constituya la madre de los distintos productos
// que podamos crear. La clase hará uso de las interfaces InterfazMetodos e InterfazPrecios.
// Dispondrá de los atributos precio(cada subclase dará un precio obtenido de la interfaz sin
// llegar a implementar la misma) y nombre (que se obtendrá por introspección).

// Nota: no se usa encadenamiento de constructores de la hija a la madre para establecer
// el precio (la hija impone el valor a su atributo heredado directamente).

package clases;

import interfaces.InterfaceIVA;
import interfaces.InterfaceMetodos;

public abstract class Articulo implements InterfaceMetodos {

    protected double precio;
    protected String nombre;
    
    protected Articulo(double precio) {
        this.precio = precio;
        nombre = getClass().getSimpleName().toUpperCase();
    }
        
    @Override
    public void imprimirPrecioSinIVA() {
        System.out.println("EL " + nombre + " VALE ... " + precio + " €");
    }
    
    @Override
    public void imprimirPrecioConIVA() {
        
        double parteIVA = precio * InterfaceIVA.IVA/100;
        
        double precioConIva = precio + parteIVA;
        
        System.out.println("EL " + nombre + " CON IVA (" 
                + InterfaceIVA.IVA + "%) VALE ... " + precioConIva + " € \n");
        
        System.out.println("EL IVA CORRESPONDIENTE ES DE ... " + parteIVA + " €");   
    }
}