/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0;

/**
 *
 * @author Andrés Chillón
 */

// Obtener los números pares que hay entre 1 y 100 con for* y con while
// hacer lo mismo pero ordenándolos al revés (100 -> 1)  --> i--

//Obtener 20 numeros pares aleatorios comprendidos entre 2 y 100

public class PruebaContadores {
   public static void main(String[] args) {
       
       java.util.ArrayList listaNumeros=new java.util.ArrayList();
        for(int i=1;i<100;i++){
            listaNumeros.add(i);
        }
        System.out.println(listaNumeros);
        
        for(Object n : listaNumeros) {
            if((int) n %2==0){
                System.out.println(n+" es PAR");
            }
        }
        
   
        
        
        
        int contador=0;
        for(int i=0;contador<500;i++){
            int numero= (int) (Math.random()*101);
            if (numero%2==0){
                System.out.println(numero+" es par");
                contador++;
            }else{
                continue;        
            }
        }
        
        
        
        
        
        
        
   }
}
 