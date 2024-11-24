// Clase EmpleadoCasa. Hereda de la clase Jefe pero NO está en el mismo paquete.


package casa;

import empresa.Jefe; // importación.

public class EmpleadoCasa extends Jefe {

    public static void main(String[] args) {
        
        Jefe jefe = new Jefe();
        
        //System.out.println("llavesCajaFuerte ---> " + jefe.llavesCajaFuerte);
        //System.out.println("intranet ---> " + jefe.intranet);
        //System.out.println("llavesPuertaEntrada ---> " + jefe.llavesPuertaEntrada);
        System.out.println("paginaWeb ---> " + jefe.paginaWeb);
                
        EmpleadoCasa EmpleadoCasa = new EmpleadoCasa();

        //System.out.println("llavesCajaFuerte ---> " + EmpleadoCasa.llavesCajaFuerte);
        //System.out.println("intranet ---> " + EmpleadoCasa.intranet);
        System.out.println("llavesPuertaEntrada ---> " + EmpleadoCasa.llavesPuertaEntrada);
        System.out.println("paginaWeb ---> " + EmpleadoCasa.paginaWeb);     
    }         
}