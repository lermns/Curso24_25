// Definir un par de interfaces I1 e I2 (cada una debe declarar su correspondiente 
// método mx()), heredando I2 de I1 y una clase abstracta A que realizará la
// implementación de tan sólo la interfaz I2 (cumple con el contrato de I2).
// Comprobar cómo la clase concreta B (no abstracta) que hereda de la clase A,
// está obligada a satisfacer(implementar) el método que no definió su clase madre,
// para poder ser finalmente instanciada.

// NOTA: La anotación @Override se emplea tanto con sobrescritura como con la
// implementación de métodos abstractos de interfaz y/o clase abstracta.


package p1;

interface I1 {
    void m1();
}

interface I2 extends I1 { // una interfaz núnca puede implementar a otra.
    void m2();
}

abstract class ClaseMadre implements I2 { // una clase puede implementar 0 o infinitas interfaces.
    @Override
    public void m2() {}
}

public class ClaseHija extends ClaseMadre { // una clase sólo puede heredar directamente de otra.       
    @Override
    public void m1() {}
}