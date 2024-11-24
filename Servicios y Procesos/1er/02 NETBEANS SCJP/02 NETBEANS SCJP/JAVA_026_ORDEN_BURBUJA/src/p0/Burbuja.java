/*
 no está bien hecho
 */

package p0;

public class Burbuja {

    public static void imprimir(int[] numeros) {
        for(int numero : numeros) {
            System.out.print(numero + " ");
        } 
    }
    
    public static void main(String[] args) {
        
        final int num = 10; // ordenaremos un total de 10 elementos.
        int[] numeros = new int[num];
        for (int i=0;i<num-1;i++){
            int aleatorio = (int) ((Math.random()*num)+1);
            numeros[i]= aleatorio;
        }
        for(int i=0;i<num;i++){
            System.out.print(" "+numeros[i]);
            
        } 
        
        System.out.println(" -----------------");
        for(int i=0;i<num-1;i++){
            int aux=numeros[i+1];
            if (numeros[i]>aux && i<numeros.length){
                numeros[i]=numeros[i+1];
                numeros[i+1]=aux;
            }
        }
        for(int i=0;i<num;i++){
            System.out.print(" "+numeros[i]);
            
        }        
        
        
    }
}