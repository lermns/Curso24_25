// Crear la clase Cocinero que simbolice a la persona que va a recibir los
// distintos pedidos y que procederá a su preparación en el orden en el que
// llegaron (implementación FIFO - COLA, al primero que pidió es al primero que
// le sirve). Para ello, utilizar una colección de tipo LinkedList y hacer uso
// del método offerLast (añadimos el nuevo pedido al final de la lista, con 
// lo que se respeta el orden buscado). Los platos a cocinar serán elegidos
// de forma aleatoria y no se podrán repetir. Se cocinará 1 de cada tipo.


package p0;

import java.util.LinkedList;

public class Cocinero {

    // colección LinkedList que contiene objetos de tipo Plato (el enumerado).
    private LinkedList<Plato> pedidos;
        
    
    public Cocinero() {
        pedidos = new LinkedList<Plato>(); // NO OLVIDAR INSTANCIAR LA COLECCIÓN.
    }    
    
    
    public void admitirPedidos() {
    
        // array de valores del tipo enumerado.
        final Plato[] losPlatos = Plato.values();
        
        // rellenar la colección en orden aleatorio.
        while(pedidos.size() < losPlatos.length) {
            int aleatorio = (int)(Math.random()*losPlatos.length);
            
            Plato plato = losPlatos[aleatorio];
            
            // no repetir los platos.
            if( ! pedidos.contains(plato)) {
                pedidos.offerLast(plato); // añadir al final (quiero orden FIFO - COLA).
                System.out.println("AÑADIDO EL PEDIDO " + plato);
            }        
        }
        
        System.out.println("PEDIDOS ADMITIDOS ---> " + pedidos);
    }
    
    
    public void cocinarPedidos() {    
        while(! pedidos.isEmpty()) {
            //cocinar el primer plato y eliminarlo de la colección.
            System.out.println("COCINANDO EL PLATO ... " + pedidos.poll());
        }    
    }
    
    
    public static void main(String[] args) {
        
        Cocinero cocinero = new Cocinero();
        
        cocinero.admitirPedidos();
        
        System.out.println("\n______________________________________\n");
        
        cocinero.cocinarPedidos();   
    }   
}