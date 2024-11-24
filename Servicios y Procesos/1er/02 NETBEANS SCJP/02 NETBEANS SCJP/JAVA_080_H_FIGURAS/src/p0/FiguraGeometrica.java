// Crear la clase abstracta FiguraGeometrica, en la que se definirán las propiedades
// area y perimetro. Se declaran los métodos abstractos calcularArea y calcularPerimetro
// y se sobrescribe el método toString para informar del resultado de los mismos.
// Cada subclase dará su implementación particular de cómo se deben realizar los cálculos
// para dichas propiedades.


package p0;

public abstract class FiguraGeometrica {

    protected double area;
    protected double perimetro;
    
    protected abstract void calcularArea();    
    protected abstract void calcularPerimetro();
    
    @Override
    public String toString() {
        calcularArea();
        calcularPerimetro();
        return getClass().getSimpleName().toUpperCase() + "---> \n" + 
                "area = " + area + ", perimetro = " + perimetro + "\n\n";
    }    
}