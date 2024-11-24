// Crear la clase Cliente, la cúal dispone de los atributos nombre y array de tipo
// Bebidas. Definir diversos métodos para poder realizar la compra de un lote de 
// bebidas (1 de cada tipo), comprar aleatoriamente un conjunto determinado de ellas
// (bien indicando el número total (mínimo 1, máximo 10) o dejando al sistema elegirlo),
// o, indicar qué bebidas en concreto se desean adquirir (utilizar parámetros variables).
// Finalmente, se define un método generarTicket que informe del precio total de compra
// y los grados en suma del licor adquirido(en esta ocasión no se hace uso del toString).


package p0;

public class Cliente {

    private String nombre;    
    private Bebidas[] cesta;
        
    public Cliente(String nombre) {
        this.nombre = nombre;
    }
    
    public void comprarUnaDeCada() { // array de Bebidas con una de cada.
        cesta = Bebidas.comprarUnaDeCada();
    }
    
    public void comprarAleatoriamente() { // número aleatorio y delegar funcionalidad.
        comprarAleatoriamente( (int)(Math.random()*10)+1 ); // [1 .. 10]
    }
     
    public void comprarAleatoriamente(int cuantas) { // array de Bebidas aleatorias.
        cesta = Bebidas.comprarAleatoriamente(cuantas);
    }
       
    public void comprarSeleccion(Bebidas ... cesta) { // array de Bebidas seleccionadas. 
        this.cesta = cesta;
    }
    
    public void imprimirTicket() { // información de la compra.
        int importeTotal = 0;
        int gradosTotales = 0;
        
        System.out.println("\nCLIENTE ... " + nombre + " TOTAL BOTELLAS ... " +
                cesta.length + "\n");
        
        for (Bebidas bebida : cesta) {
            System.out.println(bebida);
            importeTotal += bebida.obtenerPrecio();
            gradosTotales += bebida.obtenerGrados();
        }
        System.out.println("\nGRADOS TOTALES ... " + gradosTotales + " grados");
        System.out.println("\nIMPORTE TOTAL ... " + importeTotal + " €");
    }

}