
package data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author PedroBorreganBurgos
 */

public class Cliente {
    
    private String nombre;
    private String apellidos;
    private String edad;
    private Date fechaAlta;
    private String provincia;
    
    SimpleDateFormat sdf = new SimpleDateFormat();

    public Cliente(String nombre, String apellidos, String edad, Date fechaAlta, String provincia) {
        setNombre(nombre);
        setApellidos(apellidos);
        setEdad(edad);
        setFechaAlta(fechaAlta);
        setProvincia(provincia);
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    
    public String[] toArrayString(){
        String[] s = new String[5];
        s[0] = nombre;
        s[1] = apellidos;
        s[2] = edad;
        s[3] = sdf.format(fechaAlta); //Creando previamente SimpleDateFormat sdf
        s[4] = provincia;
        return s;
    }
}
