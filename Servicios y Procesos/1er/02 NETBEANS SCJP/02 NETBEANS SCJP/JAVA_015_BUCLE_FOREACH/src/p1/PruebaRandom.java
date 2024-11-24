/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;
import java.lang.Math;
/**
 *
 * @author Andrés Chillón
 */
public class PruebaRandom {
    public static void main(String[] args) {
        float aleatorio;
        int contador;
        System.out.println("Prueba del método RANDOM");
        for(int i=0;i<20;i++){
           contador=i+1;
           aleatorio = (float)(Math.random()*101); 
           
           System.out.println("El número aleatorio "+ contador +" es: "+aleatorio);
        }
        
        
        
    }
    
}
