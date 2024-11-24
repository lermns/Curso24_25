// Crear una clase que pruebe la clase Avion mediante la invocación a su método
// despegar (crear una instancia para poder hacer uso de él).


package p0;

public class Aerodromo {

    public static void main(String[] args) {
        
        Avion avion = new Avion();
        
        avion.despegar();
                
        System.out.println("- - - FIN DE PROGRAMA - - - ");
    }
}