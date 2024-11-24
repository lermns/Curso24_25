// Clase EmpleadoLimpieza. Hereda de la clase Jefe y NO está en el mismo paquete.


package subcontrata;

import empresa.Jefe;

public class EmpleadoLimpieza extends Jefe {

    public static void main(String[] args) {
        
        Jefe jefe = new Jefe();
        
        //System.out.println("llavesCajaFuerte ---> " + jefe.llavesCajaFuerte);
        //System.out.println("intranet ---> " + jefe.intranet);
        //System.out.println("llavesPuertaEntrada ---> " + jefe.llavesPuertaEntrada);
        System.out.println("paginaWeb ---> " + jefe.paginaWeb);
                
        EmpleadoLimpieza EmpleadoLimpieza = new EmpleadoLimpieza();

        //System.out.println("llavesCajaFuerte ---> " + MujerLimpieza.llavesCajaFuerte);
        //System.out.println("intranet ---> " + MujerLimpieza.intranet);
        System.out.println("llavesPuertaEntrada ---> " + EmpleadoLimpieza.llavesPuertaEntrada);
        System.out.println("paginaWeb ---> " + EmpleadoLimpieza.paginaWeb);     
    }      
}