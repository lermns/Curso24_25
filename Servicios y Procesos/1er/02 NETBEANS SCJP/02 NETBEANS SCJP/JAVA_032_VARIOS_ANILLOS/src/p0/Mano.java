// Crear la clase Mano que por composición fuerte, contendrá un array de dedos, que
// se crearán e inicializarán en el constructor de Mano (se les dá una posición y 
// nombre: PULGAR-1 ... MEÑIQUE-5). Se sobrescribe el método toString para que informe
// sobre cada uno de los dedos (nombre, posición y posible añillo contenido).


package p0;

public class Mano {
    
    private Dedo[] losDedos; // array de dedos (composición fuerte).
    
    public Mano() {
        losDedos = new Dedo[5];
                
        losDedos[0] = new Dedo("PULGAR",1);
        losDedos[1] = new Dedo("INDICE",2);
        losDedos[2] = new Dedo("CORAZON",3);
        losDedos[3] = new Dedo("ANULAR",4);
        losDedos[4] = new Dedo("MEÑIQUE",5);        
        
    }
    
    @Override
    public String toString() {
    
        String texto = "";
        
        for(Dedo dedo : losDedos) {
            texto += dedo.toString() + "\n";
        }
        
        return texto;
    }
}