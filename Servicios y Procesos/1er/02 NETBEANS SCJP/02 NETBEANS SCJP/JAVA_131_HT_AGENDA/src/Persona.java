
public class Persona {

    private int nif;
    private String nombre;
    private String apellido;
    private int telefono;
    
    public Persona(int nif, String nombre, String apellido, int telefono) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    
    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    
}
