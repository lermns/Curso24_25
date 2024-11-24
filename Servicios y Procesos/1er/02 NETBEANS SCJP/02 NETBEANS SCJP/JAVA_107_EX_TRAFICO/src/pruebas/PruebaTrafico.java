// Crear una clase que instancie un par de objetos Conductor, Ana y Juan, 
// y establezca con ellos un control de carretera. Observar el resultado
// de cometer o no una infracción y en caso de cometerla, el mensaje, los
// puntos que se le retiran del carné y el importe de la sanción económica.


package pruebas;

import conductores.Conductor;
import trafico.GuardiaCivil;

public class PruebaTrafico {

    public static void main(String[] args) {
        
        Conductor ana = new Conductor("ANA");
        System.out.println("CONDUCTOR ... " + ana + "\n");        
        System.out.println("\n---> CONTROL DE CARRETERA <---\n");
        GuardiaCivil.darElAlto(ana);
        
        System.out.println("\n_______________________________________________\n");
        
        Conductor juan = new Conductor("JUAN");
        System.out.println("CONDUCTOR ... " + juan + "\n");
        System.out.println("\n---> CONTROL DE CARRETERA <---\n");
        GuardiaCivil.darElAlto(juan);
    }   
}