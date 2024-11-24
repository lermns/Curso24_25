// Crear un objeto de cada tipo de calculadora (básica y científica) y a partir de
// ellos, probar los métodos que cada uno tiene disponibles.


package pruebas;

import clases.CalcBasica;
import clases.CalcCientifica;
import interfaces.InterfazCalcBasica;
import interfaces.InterfazCalcCientifica;

public class PruebaCalculadora {

    public static void main(String[] args) {

        double x = 8;
        double y = 2;        
        
        InterfazCalcBasica calculadoraBasica = new CalcBasica();

        //////// MÉTODOS BÁSICOS ///////////       
        
        System.out.println(x + " + " + y + " = " +
            calculadoraBasica.sumar(x,y) + "\n");
        
        System.out.println(x + " - " + y + " = " +
            calculadoraBasica.restar(x,y) + "\n");
        
        System.out.println(x + " * " + y + " = " +
            calculadoraBasica.multiplicar(x,y) + "\n");
        
        System.out.println(x + " / " + y + " = " +
            calculadoraBasica.dividir(x,y) + "\n");
        
        
        System.out.println("\n__________________________\n");

        
        InterfazCalcCientifica calculadoraCientifica = new CalcCientifica();

        //////// MÉTODOS BÁSICOS ///////////
                
        System.out.println(x + " + " + y + " = " +
            calculadoraCientifica.sumar(x,y) + "\n");
        
        System.out.println(x + " - " + y + " = " +
            calculadoraCientifica.restar(x,y) + "\n");
        
        System.out.println(x + " * " + y + " = " +
            calculadoraCientifica.multiplicar(x,y) + "\n");
        
        System.out.println(x + " / " + y + " = " +
            calculadoraCientifica.dividir(x,y) + "\n");
        
        //////// MÉTODOS AVANZADOS ///////////
        
        System.out.println("raiz cuadrada de " + x + " = " +
            calculadoraCientifica.raizCuadrada(x) + "\n");
        
        System.out.println(x + " elevado a " + y + " = " +
            calculadoraCientifica.exponenciacion(x,y) + "\n");
    }    
}