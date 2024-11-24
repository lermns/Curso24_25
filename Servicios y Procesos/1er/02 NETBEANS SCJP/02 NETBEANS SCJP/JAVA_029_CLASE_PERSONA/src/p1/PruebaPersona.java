// Crear una clase que compruebe el funcionamiento de la clase Persona y el hecho
// de cómo no se puede acceder directamente a sus atributos (son privados).


package p1;

import p0.Persona;

public class PruebaPersona {
    
    public static void main(String[] args) {
        
        Persona ana = new Persona(  "ANA", "GARCIA PEREZ", "123456789F",
                                    "a.perez@gmail.com" , 617883344);
        
        System.out.println(ana);
        
        System.out.println("\n-------------- CAMBIO DE TELEFONO ---------------\n");
        
        ana.setTelefono(777555555);
        
        // ERROR
        //ana.telefono = 777555555;
                       
        System.out.println(ana);        
    }
}