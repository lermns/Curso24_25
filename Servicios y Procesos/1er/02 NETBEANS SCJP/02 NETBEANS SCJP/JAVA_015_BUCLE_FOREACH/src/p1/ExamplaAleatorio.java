/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;

/**
 *
 * @author Andrés Chillón
 */
public class ExamplaAleatorio {
    public static void main(String[] args) {
        
        int num=1;
        int aleatorio = (int)(Math.random()*num+1);
        
        System.out.println("El número aleatorio comprendido entre 0 y "+num + " es: "+ aleatorio);
        
        
    }
}
