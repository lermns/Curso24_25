// Crear una clase que ponga de manifiesto cómo distintos objetos de tipo Pintor, que
// recibiran, todos ellos, el mismo objeto de tipo BotePintura, pueden consultar y 
// realizar cambios sobre su atributo color, siendo dichos cambios los mismos para
// todos los pintores (mismo recurso compartido).


package p3;

public class PruebaPintores {

    public static void main(String[] args) {
        
        // EL OBJETO TENDRÁ UN COMPORTAMIENTO ESTÁTICO SIN REALMENTE SERLO (como los Servlets).
        BotePintura botePintura = new BotePintura("VERDE");

        // ES EL MISMO BOTE DE PINTURA A USAR POR LOS 2 PINTORES.
        Pintor p1 = new Pintor(botePintura);
        Pintor p2 = new Pintor(botePintura);
        
        System.out.println("P1 DICE QUE EL COLOR ES ... " + p1.consultarColor());
        System.out.println("P2 DICE QUE EL COLOR ES ... " + p2.consultarColor());

        System.out.println("\n__________________________________\n");
        
        p1.cambiarColorBote("ROJO");
        System.out.println("P1 DICE QUE EL COLOR ES ... " + p1.consultarColor());
        System.out.println("P2 DICE QUE EL COLOR ES ... " + p2.consultarColor());

        System.out.println("\n__________________________________\n");
        
        p1.cambiarColorBote("AZUL");
        System.out.println("P1 DICE QUE EL COLOR ES ... " + p1.consultarColor());
        System.out.println("P2 DICE QUE EL COLOR ES ... " + p2.consultarColor());
    }   
}