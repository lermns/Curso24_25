/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3;

/**
 *
 * @author Andrés Chillón
 */




enum PokerAvanzado {

    CORAZONES("soy carta corazones"), DIAMANTES("soy carta diamantes"), PICAS("soy carta picas"),
    TREBOLES("soy carta treboles"); // ojo a este ; separa valores del resto.


    ////ATRIBUTOS ////////////////////////////////////////
    private String queSoy;
    private static int cantidad = 52; 
    ////CONSTRUCTORES ////////////////////////////////////////
    private PokerAvanzado(String queSoy) {
        this.queSoy = queSoy;
    }

    private PokerAvanzado(int x) { System.out.println("numero = " + x);
    }


    ////MÉTODOS ////////////////////////////////////////
    public void definirCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public static int cuantasCartas() {
        return cantidad;
    }

    public String quePalo() {
        return queSoy;
    }
}




public class PruebaEnum {
    
    public static void main(String[] args) {
        PokerAvanzado pa = PokerAvanzado.CORAZONES; 
        System.out.println("pa = " + pa); 
        System.out.println(pa.cuantasCartas());
        System.out.println(pa.quePalo());
        System.out.println(" - - - cuantas cartas = " + PokerAvanzado.cuantasCartas());             // se definió como public y static.
    }
}