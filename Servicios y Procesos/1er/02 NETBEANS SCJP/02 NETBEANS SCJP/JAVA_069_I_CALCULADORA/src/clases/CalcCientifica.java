// Crear la clase CalculadoraCientifica para dar implementación a la totalidad de
// métodos, tanto los básicos como los avanzados (heredar de CalculadoraBasica e
// implementar a InterfazCalculadoraCientifica). Sólo se habrá de definir los métodos
// avanzados, los básicos los obtenemos de la clase madre ... REUTILIZACIÓN DE CÓDIGO.


package clases;

import interfaces.InterfazCalcCientifica;

public class CalcCientifica  extends CalcBasica 
                             implements InterfazCalcCientifica {

    @Override
    public double raizCuadrada(double x) {
        return Math.sqrt(x);
    }

    @Override
    public double exponenciacion(double x, double y) {
        return Math.pow(x, y);
    }   
}