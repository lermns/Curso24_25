// Crear la clase Coche que define el modelo, precio de serie y el conjunto de
// complementos que se le hayan podido comprar (array). El constructor parametrizado
// de la clase solicitará el valor para los distintos atributos, siendo éste de
// tipo parámetros variables cuando se refiere a los complementos. Se disponde de
// un método generarFichaCoche que nos da la información relativa (incluido el precio
// y nivel de tunning de los complementos) y se sobrescribe el método toString para
// que haga uso de él (forma alternativa de obtener al información sin repetir código).


package coches;

import enumerados.Complementos;

public class Coche {

    private String modelo;
    private int precioSerie;   
    private int nivelTunning; // se calcula en base a los complementos.
    private int precioTunning; // se calcula en base a los complementos.
    private Complementos[] losComplementos;
    
    public Coche(String modelo, int precioSerie, Complementos ... losComplementos) {
        this.modelo = modelo;
        this.precioSerie = precioSerie;
        this.losComplementos = losComplementos;
    }
        
    public String generarFichaCoche() {
        
        String texto = "";
        texto += "MODELO ... " + modelo + "\n";
        texto += "PRECIO DE SERIE ... " + precioSerie + "\n";
        
        for (Complementos complemento : losComplementos) {
            texto += complemento + "\n";
            nivelTunning += complemento.obtenerNivelTunning();
            precioTunning += complemento.obtenerPrecio();            
        }
        
        texto += "NIVEL DE TUNNING ... " + nivelTunning + " estrellas. \n";
        texto += "PRECIO TUNNING ... " + precioTunning + " €. \n";
        texto += "PRECIO TOTAL COCHE ... " + (precioSerie + precioTunning) + " €. \n";
        
        System.out.println(texto);
        
        return texto; // permite además el utilizar el toString 
    }

    @Override
    public String toString() {
        return generarFichaCoche(); // delegamos sobre el método.
    }    
}