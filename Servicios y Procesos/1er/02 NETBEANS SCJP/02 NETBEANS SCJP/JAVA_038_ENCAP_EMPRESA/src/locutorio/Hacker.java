// Clase Hacker. NO Hereda de la clase Jefe y NO está en el mismo paquete.


package locutorio;

import empresa.EmpleadoEmpresa; // importación.
import empresa.Jefe;

public class Hacker {

    public static void main(String[] args) {
        
        Jefe jefe = new Jefe();
        
        //System.out.println("llavesCajaFuerte ---> " + jefe.llavesCajaFuerte);
        //System.out.println("intranet ---> " + jefe.intranet);
        //System.out.println("llavesPuertaEntrada ---> " + jefe.llavesPuertaEntrada);
        System.out.println("paginaWeb ---> " + jefe.paginaWeb);
                
        Hacker Hacker = new Hacker(); // EL HACKER NO ES CLASE HEREDERA, LUEGO NO PUEDE TENER NADA.

//        System.out.println("llavesCajaFuerte ---> " + Hacker.llavesCajaFuerte);
//        System.out.println("intranet ---> " + Hacker.intranet);
//        System.out.println("llavesPuertaEntrada ---> " + Hacker.llavesPuertaEntrada);
//        System.out.println("paginaWeb ---> " + Hacker.paginaWeb);
                
        // TODO IGUAL AL USAR ... EmpleadoEmpresa o EmpleadoCasa o EmpleadoLimpieza.
        
        EmpleadoEmpresa empleadoEmpresa = new EmpleadoEmpresa(); // usamos ésta como ejemplo.
        
        //System.out.println("llavesCajaFuerte ---> " + empleadoEmpresa.llavesCajaFuerte);
        //System.out.println("intranet ---> " + empleadoEmpresa.intranet);
        //System.out.println("llavesPuertaEntrada ---> " + empleadoEmpresa.llavesPuertaEntrada);  // PROTECTED ... PRIVATE QUE SE HEREDA.
        System.out.println("paginaWeb ---> " + empleadoEmpresa.paginaWeb);
    }      
}