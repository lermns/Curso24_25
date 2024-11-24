// Crear una clase Hija que sobrescriba a su conveniencia los métodos que indicaban
// las normas de buen comportamiento dictadas por la clase Madre.


package p0;

public class Hija extends MadreNormas {
    
    @Override
    public void estudiar() {
        System.out.println("YO CON ESTUDIAR EL ULTIMO DIA ME BASTA Y SOBRA");
    }
    
    @Override
    public void ahorrar() {
        System.out.println("PARA QUE LO TENGA EL BANCO PREFIERO INVERTIRLO ... EN FIESTAS");
    }

    @Override
    public void divertirse() {
        System.out.println("A LAS 11:00 SI, PERO EL DOMINGO, VIERNES Y SABADO NO HAY LÍMITE");
    }
}