// Utilizar el condicional if para comparar 2 cadenas de texto que representan un
// color, teniendo en cuenta que String requiere el método equalsXXX para comparar
// contenido (en caso contrario se comparan los objetos físicos en sí).


package p2;

public class ColorPintura {

    public static void main(String[] args) {
        
        String color = "VERDE";
        
        //if(color == "VERDE" ) { // COMPARAR DIRECCIONES DE MEMORIA.
        if(color.equalsIgnoreCase(new String("VERDE"))) {
        
        //if(color.equalsIgnoreCase("vErDe")) {            
            System.out.println("EL BOTE DE PINTURA ES VERDE");
        } else {
            System.out.println("EL BOTE DE PINTURA NO ES VERDE");
        }        
    }    
}