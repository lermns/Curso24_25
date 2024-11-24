// Crear una interfaz I1 que declare un método m1(). A continuación crear una interfaz
// I2 que extienda a I1 y declare otro método m1(double). Para finalizar crear una clase
// que implemente tan sólo a I2 y comprobar como ésta debe cumplir tanto con el contrato
// de I2 cómo con el de I1(por heredar I2 de I1), para poder ser instanciada.


package p0;

abstract interface I1 {             // todas las interfaces son implícitamente abstractas.
    //public abstract void m1() {}  // error, no se pueden definir métodos {}.
    public abstract void m1();      // ... sólo declararlos ;.
}

interface I2 extends I1{
    int m1(double z);
}

public class ClaseImplementadora implements I2 {
    //void m1() {}
    
    @Override
    public int m1(double z) {
        return 0;
    }

    @Override
    public void m1() {} // sobrecarga al "heredado" de la interfaz madre I1.   
}