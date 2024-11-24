// Crear una clase Tienda en la que se van a definir distintas variables de caracter
// no estático(de instancia) que llevarán la cuenta del total de productos que se
// han vendido en la misma a lo largo del día (1 ejecución). Se dispondrá también de
// de su equivalente en formato estático para contabilizar el total de productos 
// vendidos entre todas las tiendas.

// En el conjunto de productos disponible tenemos Donuts, Chicles, CocaColas. El total
// de ventas parciales y totales se mostrarán por pantalla mediante la sobrescritura
// del método toString. Las tiendas disponen de una variable de instancia denominada
// "dirección" que permite distinguirlas en el conjunto.


package p0;

public class Tienda {

    // VARIABLES DE INSTANCIA:
    private String  direccion;
    private int     contadorChicles;
    private int     contadorCocaColas;
    private int     contadorDonuts;
        
    // VARIABLES ESTÁTICAS:
    static private int     totalContadorChicles;
    static private int     totalContadorCocaColas;
    static private int     totalContadorDonuts;

    public Tienda(String direccion) {
        this.direccion = direccion;
    }
        
    public void comprarChicle(int cuantos) {
        contadorChicles += cuantos;
        totalContadorChicles += cuantos;
    }
    
    public void comprarCocaCola(int cuantos) {
        contadorCocaColas += cuantos;
        totalContadorCocaColas += cuantos;
    }
    
    public void comprarDonut(int cuantos) {
        contadorDonuts += cuantos;
        totalContadorDonuts += cuantos;
    }
    
    public String consultarVentasParciales() { // NO es estático.
        String texto = "\nEN LA TIENDA DE " + direccion + " LAS VENTAS SON\n";

        texto += "CHICLES = " + contadorChicles + "\n";
        texto += "COCACOLAS = " + contadorCocaColas + "\n";
        texto += "DONUTS = " + contadorDonuts + "\n";

        return texto;    
    }
    
    public static String consultarVentasTotales() { // Estático (no depende de ninguna tienda).
        String texto = "\nEN TOTAL LAS TIENDAS HAN VENDIDO\n";

        texto += "TOTAL CHICLES = " + totalContadorChicles + "\n";
        texto += "TOTAL COCACOLAS = " + totalContadorCocaColas + "\n";
        texto += "TOTAL DONUTS = " + totalContadorDonuts + "\n";

        return texto;    
    }
    
    
    @Override
    public String toString() {     // SI QUEREMOS LA PARCIAL + LAS TOTALES.
        
        String texto = "";
        
        texto += consultarVentasParciales();
        texto += "\n.........................................\n";
        texto += consultarVentasTotales();
        
        return texto;
    }
}