// Crear la clase Madre que defina los atributos protegidos x e y, siendo este último
// de caracter estático. Establecer el método setX para modificar el valor de la 
// variable de instancia x anteriormente definida.


package p0;

public class Madre {
    
    protected int x = 1;
    
    protected static int y = 3;
    
    public Madre() {
        super();
    }
    
    public void setX(int x) {
        this.x = x;
    }
}