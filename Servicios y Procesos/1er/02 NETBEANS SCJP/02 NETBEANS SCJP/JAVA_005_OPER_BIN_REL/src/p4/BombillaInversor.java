// Crear una clase que declarado un atributo, presente por pantalla el valor de
// dicho atributo invertido y sin invertir.


package p4;

public class BombillaInversor {

    public static void main(String[] args) {
        
        //boolean interruptor = false;
        boolean interruptor = true;   
        
        System.out.println("¿LA BOMBILLA_1 ESTA ENCENDIDA? ... " + interruptor);
        System.out.println("¿LA BOMBILLA ESTA APAGADA? ... " + !interruptor);        
    }    
}