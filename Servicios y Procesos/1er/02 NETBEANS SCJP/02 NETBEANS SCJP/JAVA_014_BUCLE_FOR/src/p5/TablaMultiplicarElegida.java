/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p5;

import java.util.Scanner;



/**
 *
 * @author Andrés Chillón
 */
public class TablaMultiplicarElegida {
     

    public static void main(String[] args) {
        
        System.out.println("Introduce la tabla de multiplicar:");
        Scanner entrada = new Scanner(System.in);
        int tabla = Integer.parseInt(entrada.nextLine());
        
       

        for (int indice = 1; indice <= 10; indice++) {
                System.out.println(tabla + " * " + indice + " = " + (indice*tabla));
        }  
    }
    
    
    
}
