// Crear una clase que represente el concepto abstracto de persona, dotándola de los
// atributos nombre, apellidos, dni, correo y telefono así como de los contructores por
// defecto y parametrizados, junto a los setters y getters correspondientes.
// Sobrescribir el método toString para proporcionar la información del objeto Persona.


package p0;

public class Persona {

    private String      nombre;
    private String      apellidos;
    private String      dni;
    private String      correo;
    private int         telefono;
    
    public Persona() {}    

    // utilizar la forma automática: ALT + INSERT .. Constructor.
    public Persona(String nombre, String apellidos, String dni, String correo, int telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.correo = correo;
        this.telefono = telefono;
    }
    
    // utilizar la forma automática: ALT + INSERT .. Getters and Setters.
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    
    public void respirar() {
        System.out.println("INHALAS OXIGENO Y EXHALAS DIOXIO DE CARBONO");
    }    
    
    @Override
    public String toString() {
        
        String texto = "";
        
        texto +=    "NOMBRE = \t\t" + nombre + "\n";
        texto +=    "APELLIDOS = \t\t" + apellidos + "\n";
        texto +=    "DNI = \t\t\t" + dni + "\n";
        texto +=    "CORREO = \t\t" + correo + "\n";
        texto +=    "TELEFONO = \t\t" + telefono + "\n";        
        
        return texto;
    }
}