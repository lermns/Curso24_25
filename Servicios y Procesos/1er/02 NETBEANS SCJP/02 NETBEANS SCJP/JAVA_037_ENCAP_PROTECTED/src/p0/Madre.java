// Repetición del ejercicio anterior utilizando en este caso como nivel de encapsulación
// protected.


package p0;

public class Madre {
  
    //PROTECTED. ACCESO SÓLO POR LAS CLASES DEL MISMO PAQUETE (DEFAULT ES MÁS RESTRICTIVO 
    //QUE PROTECTED) Y POR LAS CLASES HIJAS, A TRAVÉS DE UNA INSTANCIA DE LA HIJA, NO DE
    //LA MADRE, CUANDO DICHAS HIJAS SE DEFINEN EN UN PAQUETE DISTINTO AL DE LA MADRE.
    
    protected int dinero = 4000;
    
    public static void main(String[] args) {
        Madre madre = new Madre();
        System.out.println("MADRE --> DINERO DE MADRE = " + madre.dinero);
    }    
}