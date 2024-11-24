// Crear la clase HiloPersona que representa al cliente que va a usar el recurso
// compartido Fotocopiadora (obtiene éste como parámetro de entrada en su constructor
// y lo guardará como atributo privado de la clase). Se define un constructor de
// tipo parametrizado para solicitar el nombre, el objeto Fotocopiadora y el número
// de fotocopias que se desean realizar. Se sobrescribe el método run para invocar
// al método fotocopiar del recurso Fotocopiadora, indicándole cuántas se desean.


package Threads.Clase.JAVA_157_HS_FOTOCOPIADORA.p0;


public class HiloPersona extends Thread {

    Fotocopiadora fotocopiadora;
    int cuantas;
        
    public HiloPersona(String nombre, Fotocopiadora fotocopiadora, int cuantas) {
        super(nombre);
        this.fotocopiadora = fotocopiadora;
        this.cuantas = cuantas;
    }
    
    @Override
    public void run() {
        fotocopiadora.fotocopiar(cuantas);
    }

}