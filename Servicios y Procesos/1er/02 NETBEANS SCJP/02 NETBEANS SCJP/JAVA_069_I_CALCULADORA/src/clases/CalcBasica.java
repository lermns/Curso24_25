// Crear la clase CalculadoraBasica para implementar la interfaz de métodos básicos.


package clases;

import interfaces.InterfazCalcBasica;

public class CalcBasica implements InterfazCalcBasica {

    @Override
    public double sumar(double x, double y) {
        return x + y;
    }

    @Override
    public double restar(double x, double y) {
        return x - y;
    }

    @Override
    public double multiplicar(double x, double y) {
        return x * y;
    }

    @Override
    public double dividir(double x, double y) {
        return x / y;
    }
}