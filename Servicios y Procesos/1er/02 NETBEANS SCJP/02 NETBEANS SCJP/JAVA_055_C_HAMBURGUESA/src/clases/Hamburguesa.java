// Crear una clase Hamburguesa que contendrá un total de 3 a 6 ingredientes (utilizar
// polimorfismo a partir del supertipo - clase abstracta Ingrediente) de los cuáles
// los 3 primeros son los obligatorios (Pan+Carne+Queso) y el resto se consignarán en
// base al constructor empleado (4, 5 o 6 Ingredientes) eligiendo de entre los posibles
// declarados en la interfaz ConjuntoIngredientes. Se dispondrá además de un método
// público y estático generarHamburguesaAleatoria (6 ingredientes al azar) y un método
// de instancia generarTicket que nos informará del total de ingredientes, precio de
// éstos y precio total a pagar. Utilizar encadenamiento horizontal de constructores.


package clases;

import interfaces.ConjuntoIngredientes;

public final class Hamburguesa { // Instanciable directamente (no hemos creado subtipos de Hamburguesa).

    // Hacemos una eagerly declaration para el array, pero sería más correcto introducirlo
    // en el constructor por defecto (todos los otros constructores hacen uso de él).
    private Ingrediente[] ingredientes = new Ingrediente[6];
    
    // HAMBURGUESA DE 3 INGREDIENTES (LOS DE POR DEFECTO = Pan + Carne + Queso).    
    public Hamburguesa() {
        ingredientes[0] = new Pan();
        ingredientes[1] = new Carne();
        ingredientes[2] = new Queso();
    }
    {
        ingredientes[0] = new Pan();
        ingredientes[1] = new Carne();
        ingredientes[2] = new Queso();
        System.out.println("bloque");
    }
    // HAMBURGUESA DE 3 + 1 = 4 INGREDIENTES.    
    public Hamburguesa(Ingrediente ingrediente3) {
       
        /* // NO ES LA MANERA ADECUADA ... REPETIMOS CÓDIGO SIN NECESIDAD.
        ingredientes[0] = new Pan();
        ingredientes[1] = new Carne();
        ingredientes[2] = new Queso();
        */

        this(); // ... ES MUCHO MEJOR ASÍ.
         System.out.println("ini clase");
        
        ingredientes[3] = ingrediente3;
        System.out.println("fin clase");
    }
    

    // HAMBURGUESA DE 3 + 2 = 5 INGREDIENTES.
    public Hamburguesa(Ingrediente ingrediente3, Ingrediente ingrediente4) {
        this(ingrediente3);        
        ingredientes[4] = ingrediente4;
    }
    
    // HAMBURGUESA DE 3 + 3 = 6 INGREDIENTES.    
    public Hamburguesa(Ingrediente ingrediente3, Ingrediente ingrediente4, Ingrediente ingrediente5) {
        this(ingrediente3, ingrediente4);        
        ingredientes[5] = ingrediente5;
    }
    
    // GENERAR HAMBURGUESA ALEATORIA DE 6 INGREDIENTES:
    public static Hamburguesa generarHamburguesaAleatoria() {
        
        // 3 ingredientes básicos + 3 aleatorios (todos sin incluir el PAN).
        
        Hamburguesa h0 = new Hamburguesa();
        
        for (int i = 3; i <= 5; i++) { // en la posición 0 está el PAN (no puede ser un extra)
            // elegir aleatoriamente uno de los ingredientes extras:
            // 0 .. 4 // Carne[0],Queso,Tomate,Cebolla,Pepinillo[4].
            
            int aleatorio = (int)(Math.random()*5); // valores posibles: [0..5]
            Ingrediente ingrediente = ConjuntoIngredientes.todos[aleatorio];
            // colocarlos a partir de la posición 3 (la 0,1 y 2 están ocupadas).
            h0.ingredientes[i] = ingrediente;
        }
        
        return h0;
    }
       
    // IMPRESIÓN DEL TICKET CON LOS INGREDIENTES, PRECIOS Y PRECIO TOTAL.
    public void imprimirTicket() {
        
        double precioTotal = 0;
        
        for (Ingrediente ingrediente: ingredientes) {
            if(ingrediente == null) {
                break;
            }
            System.out.println("---> " + ingrediente);
            precioTotal += ingrediente.obtenerPrecio();
        }
        
        System.out.println("\n_______________________________");
        System.out.println("PRECIO TOTAL ... " + precioTotal + "€");
        System.out.println("_______________________________\n");
    }
}