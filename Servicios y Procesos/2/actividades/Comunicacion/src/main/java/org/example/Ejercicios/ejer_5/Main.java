package org.example.Ejercicios.ejer_5;

public class Main {
    public static void main(String[] args) {
        try{
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
                if ((int)(Math.random()*2)+1 == 1){
                    throw new Exception("Error Linea " + i);
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
