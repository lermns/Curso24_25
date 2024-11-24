// Crear una clase Realidad que instancie un objeto de la Clase Madre y la clase
// Hija e invoque a los métodos estudiar, ahorrar y divertirse de cada una de ellas,
// para comprobar como la definición que incialmente da la madre, no es seguida por
// la hija gracias a la sobrescritura de métodos.

// Se busca que cada clase hija defina, si así  se necesita, su propia implementación de
// un método que se hereda desde la madre (si se coloca abstracto, dicha definición o código
// se convierte en el cumplimiento de la obligación contraida).


package p0;

public class Realidad {

    public static void main(String[] args) {
        
        MadreNormas madre = new MadreNormas();
        Hija hija = new Hija();
        
        madre.estudiar();
        madre.ahorrar();
        madre.divertirse();

        System.out.println("\n________________\n");

        hija.estudiar();
        hija.ahorrar();
        hija.divertirse();   
    }   
}