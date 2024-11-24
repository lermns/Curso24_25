// Crear una clase que pruebe el funcionamiento de la clase Aula. Para ello,
// utilizar la sobrecarga de métodos añadirAlumno y finalmente, mostrar por
// pantalla el contenido de la misma.


package p0;

public class PruebaAula {

    public static void main(String[] args) {
        
        Aula aula = new Aula();

        // 1 forma  (creando el objeto alumno)
        Alumno ana = new Alumno("ANA", 25, true);
        aula.añadirAlumno(ana);
                
        // 2 forma  (usando los atributos que le pasamos)
        // internamente el método llamará la que pide un Alumno (sobrecarga).
        aula.añadirAlumno("JUAN",30,false);
        
        aula.listarAlumnos();        
    }

}