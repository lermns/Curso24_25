package Ejercicio_1;

public class Amigo extends Thread{
    private String name;
    private final Botella btlla;

    public Amigo(String name, Botella btlla) {
        super(name);
        this.btlla=btlla;
    }

    @Override
    public void run() {
        synchronized (btlla){
            int trago = (int) ((Math.random() * 2) + 1);
            // en caso que la botella este llena es que es nueva y el primero que entra la abre y lo avisa
            if(btlla.getTragosDisp()==10){
                System.out.println(this.getName() + " abre la botella y la desprecinta");
            }
            while(btlla.getTragosDisp()>0){
                // mientras los tragos disponibles sean mayores o iguales a los que se quiere beber se podra realizar
                // en caso contrario solo se tomara el restante
                if (btlla.getTragosDisp()>= trago) {
                    btlla.setTragosDisp(btlla.getTragosDisp() - trago);
                    System.out.println(this.getName() + " da " + trago + " tragos y quedan en la botella " + btlla.getTragosDisp());
                }else {
                    trago -=1;
                    btlla.setTragosDisp(btlla.getTragosDisp() - trago);
                    System.out.println(this.getName() + " quiere dar 2 tragos y quedan en la botella 1 trago, por eso " +
                            this.getName() + " da " + trago + " tragos y quedan en la botella " + btlla.getTragosDisp());
                }
                // el ultimo hilo que vacie la botella enviara el mensaje de que se ha tirado a la basura
                if(btlla.getTragosDisp()==0){
                    System.out.println(this.getName() + " da el ultimo trago y tira la botella en la papelera");
                }

                try {
                    // notificas para que otro amigo beba
                    btlla.notifyAll();
                    btlla.wait();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
            //notifica a los hilos restantes si queda algo en  la botella
            btlla.notifyAll();
        }
    }
}
