// Crear una clase que defina un array de la clase Gato de 3 posiciones que contendrán
// el mismo elemento (sólo se guarda la referencia no el objeto). Imprimir el contenido
// del array. Cambiar el nombre de tan sólo uno de dichos elementos, para a continuación
// comprobar cómo se ha cambiado en todos.


package p1;

public class ArrayAnimalesRepetidos {

    public static void main(String[] args) {

        Gato[] misGatos = new Gato[3]; //está inicializado a null
        
        Gato elGatoIsidoro = new Gato("ISIDORO", true);
        
        misGatos[0] = new Gato("ISIDORO", true);
        misGatos[1] = new Gato("ISIDORO", true);
        misGatos[2] = new Gato("ISIDORO", true);
        
        System.out.println("---> " + misGatos[0]);
        System.out.println("---> " + misGatos[1]);
        System.out.println("---> " + misGatos[2]);        
     
        System.out.println("\n_____ ELEGIMOS LLAMARLOS CON EL NOMBRE FELIX _______\n");
        
        misGatos[1].cambiarNombre("FELIX");

        System.out.println("---> " + misGatos[0]);
        System.out.println("---> " + misGatos[1]);
        System.out.println("---> " + misGatos[2]);          
        
        // SI NO QUIERO QUE ÉSTO OCURRA, TENDRÉ QUE CREAR 3 GATOS DISTINTOS O LO QUE
        // ES LO MISMO, INVOCAR AL CONSTRUCTOR DE GATO 3 VECES ... new Gato().
    }
}

class Animal {
}


class Gato extends Animal {
    
    private String nombre; 
    private boolean perilla;  /// Crear un gato que se llame Nacho y que tenga perilla
    
    public Gato(String elnombre, boolean perilla) {   // Gato gatoDeAli = new Gato("Nacho", true)
        this.nombre = elnombre;
        this.perilla = perilla;
        
    }
    
    public void cambiarNombre(String nombre) {
        this.nombre = nombre;    
    }
        
    @Override
    public String toString() {
        String mensaje = "";
        if(perilla){
            mensaje = nombre + " y tiene perilla";
        }else{
            mensaje = nombre + " y NO tiene perilla";
        }
        return mensaje;
    }
}