// La clase Mano. Dispone de un método comprarAnillo que se encarga de generar el
// objeto anillo y a continuación asignarlo a uno de los objetos Dedo, elegido de 
// forma aleatoria.


package p0;

public class Mano {
    
    private Dedo[] losDedos;
    
    public Mano() {
        
        losDedos = new Dedo[5];  
        
        losDedos[0] = new Dedo("PULGAR",1);
        losDedos[1] = new Dedo("INDICE",2);
        losDedos[2] = new Dedo("CORAZON",3);
        losDedos[3] = new Dedo("ANULAR",4);
        losDedos[4] = new Dedo("MEÑIQUE",5);        
        
        comprarAnillo(); // invocación al método que genera el anillo.        
    }
        
    private void comprarAnillo() {
        
        Anillo anillo = new Anillo().obtenerTipoAnillo();
        
        System.out.println("HE COMPRADO UN ANILLO DE ... " + anillo);
        
         // Decidir en qué dedo se pone.
        int enQueDedo = (int)(Math.random()*losDedos.length);
        
        System.out.println("QUE VOY A COLOCAR EN EL DEDO ... " + 
                losDedos[enQueDedo].obtenerNombreDedo() + "\n\n");
        
        // Invocar al método de la clase Dedo para cargar su variable privada Anillo.
        losDedos[enQueDedo].asignarAnillo(anillo);
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