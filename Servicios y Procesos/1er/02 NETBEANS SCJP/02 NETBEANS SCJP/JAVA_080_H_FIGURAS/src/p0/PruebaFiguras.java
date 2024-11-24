package p0;

public class PruebaFiguras {

    public static void main(String[] args) {
        
        FiguraGeometrica rectangulo = new Rectangulo(2, 4);
        FiguraGeometrica cuadrado = new Cuadrado(3);
        FiguraGeometrica circulo = new Circulo(5);
        
        System.out.println(rectangulo);
        System.out.println(cuadrado);
        System.out.println(circulo);
        
        
    }
    
}
