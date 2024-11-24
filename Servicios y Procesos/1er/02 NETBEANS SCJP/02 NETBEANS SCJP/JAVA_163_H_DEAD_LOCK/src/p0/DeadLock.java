// Crear una clase que simule la situación de un DeadLock (bloqueo permanente).


package p0;

public class DeadLock {

    public static void main(String[] args) {

        // OBJETOS QUE USARÁN DE FORMA COMPARTIDA LOS 2 HILOS.
        A a = new A();
        B b = new B();

        // CREAMOS 2 HILOS Y LES PASAMOS LOS OBJETOS COMPARTIDOS.
        Hilo1 hilo1 = new Hilo1(a,b,"HILO1");
        Hilo2 hilo2 = new Hilo2(a,b,"HILO2");

        hilo1.setPriority(Thread.MAX_PRIORITY); // SOLICITAMOS QUE SE EJECUTE ANTES EL HILO1
        hilo2.setPriority(Thread.MIN_PRIORITY);

        hilo1.start();
        hilo2.start();

        Tester tester = new Tester(hilo1,hilo2);
        tester.start();

        try {
          hilo1.join();
          hilo2.join();
        } catch (InterruptedException ie) {}

        System.out.println("\n*********PROGRAMA FINALIZADO OK*********");

    }
}

////////////////////////////////////////////////////////////////////

class Hilo1 extends Thread {

    A a;
    B b;

    public Hilo1(A a, B b,String nombre) {
        super(nombre);
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        a.m1(b);
    }

}

////////////////////////////////////////////////////////////////////

class Hilo2 extends Thread {

    A a;
    B b;

    public Hilo2(A a, B b, String nombre) {
        super(nombre);
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        b.m2(a);
    }

}

/////////////////////////////////////////////////////////////////////////

class A {

    synchronized public void m1(B b) {
        System.out.println( Thread.currentThread().getName() + " ... ENTRA EN EL MÉTODO a.m1()");

        try {
            System.out.println("PAUSA 2 SEGUNDOS DE " + Thread.currentThread().getName());
            Thread.sleep(2000);
        } catch(InterruptedException ie) {}

        System.out.println(Thread.currentThread().getName() + " LLAMA A b.m2()");

        b.m2(this); // EL OTRO HILO TIENE LA LLAVE DE b, NO PODRÁ ACCEDER.

        System.out.println("MÉTODO a.m1() FINALIZADO");
        System.out.println("SALE DEL MÉTODO a.m1() EL HILO " + Thread.currentThread().getName());
    }
}

///////////////////////////////////////////////////////////////////////////

class B {

    synchronized public void m2(A a) {
        System.out.println( Thread.currentThread().getName() + " ... ENTRA EN EL MÉTODO b.m2()");

        try {
            System.out.println("PAUSA 2 SEGUNDOS DE " + Thread.currentThread().getName());
            Thread.sleep(2000);
        } catch(InterruptedException ie) {}

        System.out.println(Thread.currentThread().getName() + " LLAMA A a.m1()");

        a.m1(this); // EL OTRO HILO TIENE LA LLAVE DE a, NO PODRÁ ACCEDER.

        System.out.println("MÉTODO b.m2() FINALIZADO");
        System.out.println("SALE EN MÉTODO b.m2() EL HILO " + Thread.currentThread().getName());
    }

}

/////////////////////////////////////////////////////////////////////////////////////////

class Tester extends Thread {

    Hilo1 h1;
    Hilo2 h2;

    public Tester(Hilo1 h1, Hilo2 h2) {
        this.h1 = h1;
        this.h2 = h2;
    }

    public void run() {
        try {
            Thread.sleep(4000);
        } catch(InterruptedException ie) {}

        // VEREMOS CÓMO DICE QUE ESTÁN BLOCKED AL ENTRAR EN EL DEADBLOCK
        System.out.println("estado del HILO1 --->  " + h1.getState());
        System.out.println("estado del HILO2 --->  " + h2.getState());

        System.out.println("\n>>>>>>>>>DEBES PARAR LA EJECUCIÓN A MANO ... NUNCA SE ACABA<<<<<<<");

    }
}