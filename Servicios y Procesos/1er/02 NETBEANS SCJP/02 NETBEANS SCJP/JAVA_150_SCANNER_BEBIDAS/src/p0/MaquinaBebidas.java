// Crear una clase que emule el comportamiento de una máquina de bebidas.
// Se mostrará por pantalla un menú con las bebidas disponibles, su precio,
// y el número de opción que se les ha asignado. Elegida una, se introducirá
// por teclado el valor correspondiente a su precio. De introducirse menos,
// el sistema requerirá el saldo restante y en el caso de que sea más, se
// devolverá el cambio. Utilizar un flujo Scanner tanto para elegir la bebida
// a través de su número de opción (1,2, ... n) cómo para designar el dinero
// entregado a la máquina.


package p0;

import java.util.Scanner;


public class MaquinaBebidas {
    
    private final Bebidas[] bebidas = Bebidas.values();
    private int cual = -1; // simboliza que no se ha elegido ninguna.
    
    // NOTA: Utilizamos una variable global (cual) para facilitar el código, pero lo
    // más conveniente es hacer uso de variables locales. Si la misma es requerida
    // en distintos métodos, enviarla y devolverla en forma de parámetro de entrada
    // y/o salida de los métodos implicados.
    
    // De igual forma, no se hace uso del redondeo de cantidades ni la comprobación
    // del valor de la monedas introducidas.


    private void mostrarMenu() {
        for (int i = 0; i < bebidas.length; i++) {
            System.out.println((i+1) + ". " + bebidas[i]);            
        }
        System.out.println("\n");
    }
    
    
    private void solicitarBebida() {

        while(cual == -1){

            Scanner sc = new Scanner(System.in); // flujo de entrada de teclado.
            
            // la numeración de las bebidas empieza en 1.
            System.out.print("\nINTRODUCE EL NUMERO DE LA BEBIDA >>> ");
            
            try {
                cual = Integer.parseInt(sc.nextLine());
                if(cual<1 || cual>bebidas.length) {
                    System.out.println("\nERROR, SOLO PUEDES ELEGIR ENTRE 1 Y " + bebidas.length + "\n");
                    cual = -1;
                }
            } catch(NumberFormatException nfe) {
                System.out.println("\nERROR, EL VALOR INTRODUCIDO NO ES CORRECTO \n");            
            }
        }

        System.out.println("\n- - - HAS ELEGIDO ... " + bebidas[cual - 1] + " - - - \n");
        
        introducirDinero();
    }    
    
    
    private void introducirDinero() {
        
        double saldo = 0;
        // los elementos del array empiezan en la posición 0 ... (cual - 1).
        double precio = bebidas[cual - 1].getPrecio();
        String nombre = bebidas[cual - 1].getNombre();
        
        // Introducir dinero en la máquina y repetir hasta que sea suficiente.
        while (saldo < precio) {
            try {
                System.out.print("\nINTRODUCE " + (precio - saldo) + " €   >>> ");
                Scanner sc = new Scanner(System.in); // flujo de entrada de teclado.
                saldo += Double.parseDouble(sc.nextLine()); // conversión texto a número.
            } catch(NumberFormatException nfe) {
                System.out.println("\nERROR, EL VALOR INTRODUCIDO NO ES CORRECTO \n");
            }            
        }
        
        // Si sobra, devolver el cambio.        
        if(saldo > precio) {
            System.out.println("RECOGE TU CAMBIO DE ... " + (saldo - precio) + " €");
        }
        
        System.out.println("DISFRUTA DE TU ... " + nombre);
    }
    
    
    public static void main(String[] args) {
        MaquinaBebidas maquina = new MaquinaBebidas();
        maquina.mostrarMenu();
        maquina.solicitarBebida();
    }
    
}