// Crear una clase que NO herede de la clase Madre y comprobar cómo puede acceder al
// atributo public definido en ella (estamos en el mismo paquete que la madre p0).


package p0;

public class Intruso1 {

    public static void main(String[] args) {
        
        Madre madre = new Madre();
        System.out.println("INTRUSO1 -> DINERO DE MADRE ... " + madre.dinero);
    }   
}