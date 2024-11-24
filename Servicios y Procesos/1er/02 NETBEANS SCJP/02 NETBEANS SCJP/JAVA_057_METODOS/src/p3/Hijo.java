// Crear la clase Hijo que hereda de Madre. Comprobar la obligatoriedad de 
// IMPLEMENTAR (dar código) al método abstracto de la madre, dormir. El método
// comer se hereda vacio y al no ser final, se puede sobrescribir.


package p3;

public class Hijo extends MadreMetodoAbstracto {

    @Override
    public void dormir() {
        System.out.println("ZZZZZzzzzz");
    }    
    
    
    @Override
    public void comer() {
        System.out.println("MI MADRE DICE QUE COMA ... ");
        super.comer();
        System.out.println("NO DICE NADA, LUEGO YO ELIJO HAMBURGUESAS");
    }
    
    public static void main(String[] args) {
        
        Hijo hijo = new Hijo();
        hijo.dormir();
        System.out.println("\n");
        hijo.comer();
    }
}