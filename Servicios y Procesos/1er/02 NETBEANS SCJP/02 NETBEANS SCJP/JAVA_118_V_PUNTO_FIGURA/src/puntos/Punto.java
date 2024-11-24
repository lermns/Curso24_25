// Crear un clase de tipo JavaBean, denominada Punto, que establezca como atributos
// las coordenadas de un determinado punto espacial [x,y,z]. Sobrescribir el toString
// para informar sobre las mismas.


package puntos;

public class Punto {

    private int x;
    private int y;
    private int z;

    public Punto(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + ", " + z + "]";
    }   

}