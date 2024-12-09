package Ejercicio_1;

public class Main {
    public static void main(String[] args) {
        Botella botella = new Botella();
        Thread amigo1 = new Amigo("Amigo1", botella);
        Thread amigo2 = new Amigo("Amigo2", botella);
        Thread amigo3 = new Amigo("Amigo3", botella);
        Thread amigo4 = new Amigo("Amigo4", botella);
        Thread amigo5 = new Amigo("Amigo5", botella);

        System.out.println("------------------------INICIA EL BOTELLON------------------------");

        amigo3.start();
        amigo4.start();
        amigo1.start();
        amigo2.start();
        amigo5.start();

        // joins para ver el inicio y el fin del main habiendo acabado con los hilos
        try {
            amigo1.join();
            amigo2.join();
            amigo3.join();
            amigo4.join();
            amigo5.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }


        System.out.println("------------------------TERMINA EL BOTELLON :(------------------------");
    }
}
