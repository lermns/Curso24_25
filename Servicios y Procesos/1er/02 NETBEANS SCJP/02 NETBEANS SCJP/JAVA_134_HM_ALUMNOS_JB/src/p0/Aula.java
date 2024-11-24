// Crear la clase Aula para emular un aula a la que se van a poder añadir
// alumnos. Para ello, se dispone de un atributo de tipo HashMap en el
// que el campo KEY será el nombre del alumno y el campo VALUE será 
// la descripción del alumno (obtenida a partir del método toString y
// compuesta por el nombre, la edad y si es hombre o mujer). Se dispone
// de la sobrecarga de los métodos añadirAlumno, en base a la cuál podremos
// agregar un nuevo alumno, bien como objeto JavaBean o indicando una a
// una sus propiedades (esta forma delega en la anterior). Un método
// listarAlumnos nos indicará por pantalla los alumnos asociados al aula. 


package p0;

import java.util.HashMap;
import java.util.Iterator;


public class Aula {
    
    private HashMap<String,Alumno> losAlumnos;    
    
    public Aula() {
        losAlumnos = new HashMap<String,Alumno>(); // generar la instancia.
    }    

    // Método para constituir el objeto Alumno.
    public void añadirAlumno(String nombre, int edad, boolean hombreMujer) {     
        añadirAlumno(new Alumno(nombre, edad, hombreMujer)); // delegar.     
    }
    
    // Método para añadir el objeto alumno al mapa.
    // Para la KEY se usa el nombre de alumno. Para el VALUE el objeto completo.
    public void añadirAlumno(Alumno alumno) {       // un JavaBean Alumno.
        losAlumnos.put(alumno.getNombre(), alumno); // añadir a mapa.
    }
    
    public void listarAlumnos() {
               
        Iterator<String> it = losAlumnos.keySet().iterator();
        
        while(it.hasNext()) {
            // recuperar los objetos Alumno a partir de su clave (nombre del alumno).
            System.out.println(losAlumnos.get(it.next()));
        }
    }

}