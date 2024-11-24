// Crear una interfaz que extienda a la interfaz básica de métodos para proporcionar
// funcionalidad avanzada (recordar que sólo es declaración, NO definición).

// Métodos raizCuadrada(double x) y exponenciacion(double x, double y).


package interfaces;

public interface InterfazCalcCientifica extends InterfazCalcBasica {

    public double raizCuadrada(double x);
    
    public double exponenciacion(double x, double y);   
}