package ejercicio;

public class Main {
    public static void main(String[] args) {
        DirecAlumnos dirUno = new DirecAlumnos();

        //dirUno.crearAlumnos("Pepe");
        dirUno.crearAlumnos("Ana");
        dirUno.crearAlumnos("Ernesto");

        //dirUno.anniadirAsignNotas("Pepe");
        dirUno.anniadirAsignNotas("Ana");
        dirUno.anniadirAsignNotas("Ernesto");

        dirUno.notaMediaxAlumno();
        dirUno.notasMediaxAsign();
    }
}