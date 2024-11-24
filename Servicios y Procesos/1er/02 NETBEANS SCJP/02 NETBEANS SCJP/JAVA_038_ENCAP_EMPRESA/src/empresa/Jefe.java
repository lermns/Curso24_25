// Crear una clase Jefe que defina los siguientes atributos permitiéndo su acceso
// en base al siguiente criterio (comprobar si el compilador da o no error):

// Las llaves de la caja fuerte sólo están disponible por la clase Jefe (private).
// La intranet de la empresa sólo es accesible desde la propia empresa ("default").
// Las clases empleado tienen una copia de las llaves de la puerta (protected).
// La web de la empresa puede consultarse por cualquiera (public).

// Se crean las siguientes clases y paquetes:

// paquete empresa ....... clase Jefe y clase EmpleadoEmpresa.
// paquete casa .......... clase EmpleadoCasa.
// paquete subcontrata ... clase EmpleadoLimpieza.
// paquete locutorio ..... clase Hacker.

// Instanciar un objeto de Jefe y de la clase a prueba para comprobar si se accede
// o no a cada uno de dichos atributos.


package empresa;

public class Jefe {

    private     boolean llavesCajaFuerte = true;
                boolean intranet = true;    
    protected   boolean llavesPuertaEntrada = true;
    public      boolean paginaWeb = true;
    
    public static void main(String[] args) {
        
        Jefe jefe = new Jefe();
        
        System.out.println("llavesCajaFuerte ---> " + jefe.llavesCajaFuerte);
        System.out.println("intranet ---> " + jefe.intranet);
        System.out.println("llavesPuertaEntrada ---> " + jefe.llavesPuertaEntrada);
        System.out.println("paginaWeb ---> " + jefe.paginaWeb);
    }
}