// Crear una clase JavaBean para encapsular la información de una persona. Utilizar
// un constructor parametrizado para establecer los valores en lugar de setters y 
// getters. Sobrescribir el método toString para visualizar los datos.


package p2;

public class Persona {

    

    public String direccion;
    private String nombre;
    private int telefono;
    private double altura;
    private boolean rico;
    private boolean pelon;
    private int edad;
    private char sexo;
    
    
    //constructores
    public Persona() {} // constructor público sin argumentos ... JavaBean.
    
    public Persona(String nombre, int telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
        
        
        
    }

    public Persona(String direccion, String nombre, int telefono, double altura, boolean rico, boolean pelon, int edad, char sexo) {
        this.direccion = direccion;
        this.nombre = nombre;
        this.telefono = telefono;
        this.altura = altura;
        this.rico = rico;
        this.pelon = pelon;
        this.edad = edad;
        this.sexo = sexo;
    }
    

    @Override
    public String toString() {
        return nombre + " \nTeléfono " + telefono
                + " \nTiene Pelo: " + pelon
                + " \nTiene " + edad+" años"
                + " \nSu sexo es: " + sexo;
    }    

    
    public boolean isPelon() {
        return pelon;
    }

    public void setPelon(boolean pelon) {
        this.pelon = pelon;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
   
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    public boolean isRico() {
        return rico;
    }

    public void setRico(boolean rico) {
        this.rico = rico;
    }

}
