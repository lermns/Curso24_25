package Threads.EjemplosClase.ejemplo_2;

public class Main {
    public static void main(String[] args) {
        Thread[] arryPers = new Persona[4];
        for (int i = 0; i < arryPers.length; i++) {
            arryPers[0]=new Persona(String.valueOf(i+1), (int)(Math.random()*10)+1);
            arryPers[0].start();
        }
    }
}
