package Threads.EjemplosClase.ejemplo_3;

public class Coche extends Thread{
    private int num;

    public Coche(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 1; i < num; i++) {
            System.out.println("corre coche"+ this.getName() + ": " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("termina hilo: " + this.getName());
    }
}
