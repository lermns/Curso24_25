// Crear una clase que constituya una pareja de hilos utilizando tanto la 
// propia clase Thread en la que se sobrescribirá el método run, como una
// implementación de la interfaz Runnable. En ambas formas se deberá utilizar
// la declaración en línea que a efectos prácticos, generará una clase interna
// que herede de Thread ó que implemente dicha interfaz Runnable.


package Threads.Clase.JAVA_162_H_CLASE_INTERNA.p0;


public class HiloClaseInterna {

    public static void main(String[] args) {
        
        /// USANDO HERENCIA DE THREAD:
        
        Thread hilo1 =  new Thread() {
                            @Override
                            public void run() {
                                System.out.println("SOY HILO POR CLASE INTERNA"
                                        + " HEREDANDO DE THREAD");
                            }
                        };
        
        hilo1.start();

        
        
        /// USANDO RUNNABLE:
        
        Thread hilo2 = new Thread(  new Runnable(){
                                            @Override
                                            public void run() {
                                                System.out.println("SOY HILO POR CLASE INTERNA"
                                                        + " QUE IMPLEMENTA RUNNABLE");
                                            }
                                    }
                                 );        

        hilo2.start();               
    }   
    
}