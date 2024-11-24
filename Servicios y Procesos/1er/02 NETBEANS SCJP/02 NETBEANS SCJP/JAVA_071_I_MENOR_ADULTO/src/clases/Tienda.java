// Crear la clase Tienda que contendrá los métodos reales de negocio, produciéndose
// así una "delegación de funcionalidad" desde las clases Menor y Adulto hacia ella
// Es dicha clase Tienda la que realmente realizará el trabajo, las otras, simplemente
// se limitaran a invocarlo.

// Se establecen en la clase 3 contadores (golosinas, tabco y alcohol) para generar el
// balance de ventas. Así mismo, se dispone de un método que realiza el balance de
// ventas global del conjunto de tiendas recibidas (parámetros variables). 

// Sobrescribir el método toString para indicar el balance de ventas parcial (sólo
// aquello que ha vendido una determinada tienda, no todas).


package clases;

import interfaces.InterfazAdulto;

public class Tienda implements InterfazAdulto {

    private String  nombre;
    private int contadorGolosinas;
    private int contadorTabaco;    
    private int contadorAlcohol;
       
    public Tienda(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public void comprarAlcohol(int cuantas) {
        System.out.println("LA TIENDA ESTA VENDIENDO ... " +
                cuantas + " ... BOTELLAS DE ALCOHOL");
        contadorAlcohol += cuantas;
    }

    @Override
    public void comprarTabaco(int cuantas) {
        System.out.println("LA TIENDA ESTA VENDIENDO ... " +
                cuantas + " ... CAJETILLAS DE TABACO");
        contadorTabaco += cuantas;
    }

    @Override
    public void comprarGolosinas(int cuantas) {
        System.out.println("LA TIENDA ESTA VENDIENDO ... " +
                cuantas + " ... GOMINOLAS");
        contadorGolosinas += cuantas;
    }
    
    public static void balanceVentas(Tienda ... tiendas) { // distintos objetos Tienda.
        
        String nombres = "";
        int totalGolosinas = 0;
        int totalAlcohol = 0;
        int totalTabaco = 0;
        
        
        for(Tienda tienda : tiendas) {
            nombres += tienda.nombre + " ";
            totalGolosinas += tienda.contadorGolosinas;
            totalAlcohol += tienda.contadorAlcohol;
            totalTabaco += tienda.contadorTabaco;
        }
        
        String texto = "BALANCE TOTAL DE VENTAS DE TODAS LAS TIENDAS ... " + nombres + "\n";
        
        texto += "TOTAL GOLOSINAS ---> " + totalGolosinas + "\n";
        texto += "TOTAL BOTELLAS DE ALCOHOL ---> " + totalAlcohol + "\n";
        texto += "TOTAL CAJETILLAS DE TABACO ---> " + totalTabaco + "\n";        
        
        System.out.println("\n_____________________________________________\n");
        System.out.println(texto);       
    }

    @Override
    public String toString() {
        String texto = "\n" + "TOTAL DE VENTAS DE LA TIENDA ... " + nombre + "\n";
        texto += "GOLOSINAS ---> " + contadorGolosinas + "\n";
        texto += "BOTELLAS DE ALCOHOL ---> " + contadorAlcohol + "\n";
        texto += "CAJETILLAS DE TABACO ---> " + contadorTabaco + "\n";        
        
        return texto;
    }    
}