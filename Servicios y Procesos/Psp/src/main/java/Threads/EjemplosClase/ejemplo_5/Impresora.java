package Threads.EjemplosClase.ejemplo_5;


class Impresora {
    private final Object lock = new Object(); // Objeto para sincronización

    public void imprimir(int num) {
        synchronized (lock) {
            while (num < 100) {
                System.out.println("agregando 30 a " + Thread.currentThread().getName());
                num += 30;
                System.out.println("ahora tiene " + num);
                try {
                    lock.notifyAll(); // Despierta a todos los hilos en espera
                    System.out.println("duerme");
                    lock.wait(); // Espera hasta ser notificado
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("despierta " + Thread.currentThread().getName());
            }
             lock.notifyAll(); // Asegura que los hilos en espera no se queden bloqueados
            System.out.println("termina " + Thread.currentThread().getName());
        }
    }
}
