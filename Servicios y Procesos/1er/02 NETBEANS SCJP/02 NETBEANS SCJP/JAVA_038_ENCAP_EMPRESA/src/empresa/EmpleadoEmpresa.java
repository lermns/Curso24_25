// Clase EmpleadoEmpresa. Hereda de la clase Jefe y SÍ está en el mismo paquete.


package empresa;


public class EmpleadoEmpresa extends Jefe {

// CONSTRUCTOR IMPLÍCITO QUE COLOCARÁ EL COMPILADOR AL GENERAR EL .class.    
//    public EmpleadoEmpresa() {
//        super();
//    } 
    
    public static void main(String[] args) {
        
        Jefe elJefe = new Jefe();
        
        //System.out.println("llavesCajaFuerte ---> " + elJefe.llavesCajaFuerte);
        System.out.println("intranet ---> " + elJefe.intranet);
        System.out.println("llavesPuertaEntrada ---> " + elJefe.llavesPuertaEntrada);
        System.out.println("paginaWeb ---> " + elJefe.paginaWeb);
        
        
        EmpleadoEmpresa empleadoEmpresa = new EmpleadoEmpresa();

        //System.out.println("llavesCajaFuerte ---> " + empleadoEmpresa.llavesCajaFuerte);
        System.out.println("intranet ---> " + empleadoEmpresa.intranet);
        System.out.println("llavesPuertaEntrada ---> " + empleadoEmpresa.llavesPuertaEntrada);
        System.out.println("paginaWeb ---> " + empleadoEmpresa.paginaWeb);       
    }       
}