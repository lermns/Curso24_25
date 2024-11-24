// Crear la clase Supermercado para emular un centro comercial. Se dispone de
// diversos métodos estáticos para visualizar el total de artículos en la 
// cesta del cliente, imprimir el ticket de compra del mismo, en cuyo caso
// se elegirá aleatoriamente si la máquina se quedó o no sin papel (lanzar la
// excepción SinPapelException), así cómo realizar la suma de los distintos
// artículos de la cesta generándose una excepción NullPointerException si
// se trata de la cebolla, ya que no le dimos precio. Aambas excepciones se
// solucionan en su bloque try-catch correspondiente.

// Finálmente se establece el método cobrar que hará uso de los anteriores.


package supermercados;

import clientes.Cliente;
import excepciones.SinPapelException;
import supermercado.Articulo;


public class Supermercado {

    private static final int posibilidadErrorPapel = 50;
    
    private static void visualizarCesta(Cliente cliente) {
        for (Articulo articulo : cliente.obtenerCesta()) {
            System.out.println("---> " + articulo);
        } 
    }

    
    private static void imprimirTicket(Cliente cliente) {

        // aleatoriamente, decidir si la máquina se ha quedado o no, sin papel.
        int sinPapel = (int)(Math.random()*100 + 1);

        try {       
            if(sinPapel <= posibilidadErrorPapel) {            
                throw new SinPapelException(); // lanzar la excepción.
            }
        } catch(SinPapelException spe) { // solución a "sin papel".
            System.out.println("\n" + spe.getMessage());
            System.out.println(">>>>> SE LE CAMBIA EL PAPEL A LA MAQUINA <<<<<\n");
        }
        
        // UNA VEZ DESACTIVA(CAPTURADA) LA EXCEPCIÓN, SE CONTINÚA CON LA EJECUCIÓN NORMAL DEL PROGRAMA.
                
        System.out.println(generarTicket(cliente));
    }

    
    private static String generarTicket(Cliente cliente) {
        
        // REVISAR LOS PRECIOS:
        String ticket = "\n____________________________________________\n";

        // IMPORTE TOTAL DE LA CESTA:
        double precioTotal = 0;        
        
        for (Articulo articulo : cliente.obtenerCesta()) {
            // se pasa cada artículo paso por el lector de infrarrojos.
            System.out.println("\n . . . MARCANDO . . . [" + articulo.obtenerNombre() + "]\n");
            
            try {
                 // obtenemos los wrappers Double y sacamos su valor.
                precioTotal += articulo.obtenerPrecio();
            } catch(NullPointerException npe) { // sin wrapper(precio), lanzar excepción.
                //System.out.println("************** " + npe + " ************");
                System.out.println("\nEL ARTICULO " + articulo.obtenerNombre() +
                        " NO DISPONE DE PRECIO");
                System.out.println("SE CONSULTA EL PRECIO A LA PATINADORA Y SE"
                        + " DETERMINA QUE EL PRECIO ES DE 0.99€ \n");
                
                // la cajera ya sabe que la Cebolla debe valer 0.99€.
                // si aparece algún otro artículo Cebolla no se llamará
                // nuevamente a la patinadora.
                articulo.establecerPrecio(0.99);
                
                // corregido el problema, se vuelve a preguntar el precio.
                precioTotal += articulo.obtenerPrecio();
            }

            ticket += articulo.toString() + "\n";
        }

        ticket += "\n";
        ticket += "PRECIO TOTAL DE LA CESTA ... " + precioTotal;
        ticket += "\n____________________________________________\n";        
        
        return ticket;
    }
    
    public static void cobrar(Cliente cliente) {
        //visualizarCesta(cliente);
        imprimirTicket(cliente);
    }   
}