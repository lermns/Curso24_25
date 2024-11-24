// Crear la subclase Circulo, en la que se define la propiedad radio. A partir de ella
// se calculan el area y el perimetro.


package p0;

public class Circulo extends FiguraGeometrica {

    // Varible propia de esta implementación.
    protected double radio;
    
    public Circulo(double radio) {
        this.radio = radio;
    }
    
    @Override
    protected void calcularArea() {
        area = Math.PI * Math.pow(radio,2);
    }

    @Override
    protected void calcularPerimetro() {
        perimetro = 2 * Math.PI * radio;
    }    
}