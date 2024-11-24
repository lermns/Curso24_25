// Crear la clase abstracta Pizza como punto de inicio de la jerarquía de clases.
// Dispondrá de un constructor que solicite como argumento el tipo de masa con la
// que se quiere crear (es un Ingrediente), de forma que las subclases (Margarita,
// Vegetal y Barbacoa) lo puedan elegir. Se hace uso de una ArrayList marcado con
// genero <Ingrediente> para contener los distintos ingredientes de la pizza, teniendo
// todas ellas, a partir de la primera posición: Masa + Tomate + Queso.
// Se crea un método generarTicket y se sobrescribe el toString para que haga uso de él.


package pizzas;

import ingredientes.Ingrediente;
import ingredientes.Queso;
import ingredientes.Tomate;
import ingredientes.masas.MasaFina;
import ingredientes.masas.MasaNormal;
import ingredientes.masas.MasaPan;
import interfaces.InterfazNombres;
import java.util.ArrayList;


public abstract class Pizza { // SUPERTIPO. PUNTO DE INICIO DE LÍNEA DE HERENCIA.
    
    protected String nombre;
    protected double precio;
    protected ArrayList<Ingrediente> losIngredientes;    
            
    protected Pizza(char tipoMasa) {

        // No debemos olvidar crear el objeto ArrayList.
        losIngredientes = new ArrayList<Ingrediente>();
        
        switch(tipoMasa) { // 'F' - 'N' - 'P'.
            case InterfazNombres.FINA:
                losIngredientes.add(new MasaFina());
                break;
            case InterfazNombres.NORMAL:
                losIngredientes.add(new MasaNormal());
                break;
            case InterfazNombres.PAN:
                losIngredientes.add(new MasaPan());
                break;
            default:
                System.err.println("TIPO DE MASA ... " + tipoMasa + "INCORRECTO");
                System.exit(0); // FIN DE PROGRAMA.   
        }
        
        losIngredientes.add(new Tomate());
        losIngredientes.add(new Queso());
    }    
    
    public String generarTicket() {
        String ticket = "";
        
        ticket += "\n______________________________________________\n";
        
        // Revisar todos y cada uno de los ingredientes del ArrayList que se ha
        // definido con el supertipo Ingrediente (podemos introducir cualquier
        // tipo de ingrediente ... así no programamos en base a ninguna implementación
        // en particular ... código más universal, más reutilizable y mantenible).
        for(Ingrediente i : losIngredientes) {
            ticket += "---> " + i + "\n";
            precio += i.obtenerPrecio(); // método polimorfico.
        }
        
        ticket += "\n\nPRECIO DE LA PIZZA ... " + precio + "€";
        ticket += "\n______________________________________________\n";
        
        return ticket;
    }
       
    @Override
    public String toString() {
        return generarTicket();
    }
}