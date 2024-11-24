// Crear la subclase Rectangulo, en la que se define las propiedades base y altura. Se
// dispone además de un constructor parametrizado para asignar valor a dichas propiedades
// y poder a continuación, determinar el area y el perímetro.


package p0;

public class Rectangulo extends FiguraGeometrica {

    // Varibles propias de esta implementación.
    protected double base;
    protected double altura;
    
    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }
    
    @Override
    protected void calcularArea() {
        area = base * altura;
    }

    @Override
    protected void calcularPerimetro() {
        perimetro = 2*(base+altura);
    }
}