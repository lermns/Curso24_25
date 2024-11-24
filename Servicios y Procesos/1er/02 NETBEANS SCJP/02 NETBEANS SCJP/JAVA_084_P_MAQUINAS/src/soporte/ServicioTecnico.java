// Crear la clase ServicioTecnico que será la encargada de reparar el objeto de
// tipo Maquina (se emplea polimorfismo) recibido como parámetro. Una vez reparada
// la máquina, se realiza una prueba básica y se asignan los costes de la reparación
// (básico + piezas). Observar qué partes del código son independientes del tipo de
// objeto empleado para cargar la referencia del supertipo Maquina.


package soporte;

import interfaces.InterfazPrecios;
import maquinas.Maquina;
import maquinas.MaquinaBocadillos;
import maquinas.MaquinaTuercas;

public class ServicioTecnico {

    // EL SERVICIO TECNICO RECIBE UNA MAQUINA, SIN IMPORTARLE DE QUÉ TIPO SEA.
    // SE LLAMARÁ AL MÉTODO reparar() DEL OBJETO MÁQUINA RECIBIDO Y SE EJECUTARÁ
    // EL CÓDIGO DE REPACIÓN QUE TENGA ASOCIADO.
    
    // ASÍ, VEMOS CÓMO GRACIAS AL POLIMORFISMO Y EL ENLACE TARDÍO, CON 1 ÚNICO
    // MÉTODO PODEMOS DAR SOPORTE A TODAS LAS POSIBLES IMPLEMENTACIONES DE LA
    // CLASE MÁQUINA ... REUTILIZACIÓN, MANTENIMIENTO, CLARIDAD ... !!!VENTAJAS!!!.
    public static void repararMaquina(Maquina maquina) {

        int costeBasico;
        int costePiezas;
        int fallo = maquina.obtenerFallo();

        // Código independiente de la implementación (tipo de máquina utilizada).
        System.out.println("\n__________________________");
        System.out.println("SE HA RECIBIDO UNA MAQUINA ... " + maquina.obtenerNombre());
        System.out.println("FALLO EN EL LOTE/PIEZA NUMERO ... " + fallo);
        System.out.println("SE INICIA SU REPARACION");
        maquina.reparar(); // LAZY BINDING.

        // Comprobar tipo exacto de objeto para realizar down-casting adecuado.
        // Quedan visibles los métodos propietarios de cada subclase de Maquina.
        // El siguiente código depende de la implementación utilizada.
        
        // PRUEBA DEL instanceof ... AUNQUE TAMBIÉN SE PODRÍA HABER DOTADO A LAS
        // CLASES DE MÉTODOS GETTER QUE NOS DIERAN TAL INFORMACIÓN, DE FORMA QUE
        // YA NO SE NECESITARÍA HACER USO DE DICHO OPERADOR (invocación Lazy-Binding).
        if(maquina instanceof MaquinaBocadillos) {
            costeBasico = InterfazPrecios.COSTE_REPARACION_BASICO_MB;
            costePiezas = InterfazPrecios.COSTE_REPARACION_PIEZA_MB * fallo;
            MaquinaBocadillos mb = (MaquinaBocadillos)maquina;
            mb.pruebaPan();
        } else {
            costeBasico = InterfazPrecios.COSTE_REPARACION_BASICO_MT;
            costePiezas = InterfazPrecios.COSTE_REPARACION_PIEZA_MT * fallo;
            MaquinaTuercas mt = (MaquinaTuercas)maquina;
            mt.pruebaMetal();
        }
        
        System.out.println("LA MAQUINA FUNCIONA CORRECTAMENTE ... ARREGLADA");        
        
        System.out.println("__________________________\n");
        
        // código independiente de implementación.
        maquina.asignarCosteReparacion(costeBasico + costePiezas);        
    }    
}