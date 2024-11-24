// Crear una clase de prueba que instancie distintos objetos de tipo Envase y
// Botella, imprimiéndose por pantalla el valor de su estado.


package p0;

public class PruebaHasA {

    public static void main(String[] args) {
        
        Envase envase = new Botella("PLASTICO", 50, "BLANCO", "AGUA SOLAN DE CABRAS");
        
        System.out.println(envase);
                
        Botella botella = new Botella("CRISTAL", 100, "AMARILLA", "CERVEZA");
        
        System.out.println(botella);        
    }    
}