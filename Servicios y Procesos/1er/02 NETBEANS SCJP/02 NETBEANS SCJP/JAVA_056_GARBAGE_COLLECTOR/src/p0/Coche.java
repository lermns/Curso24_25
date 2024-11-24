// Crear una clase que muestre como el sistema utiliza el hilo de recolección
// automática (Garbage Collector) para eliminar aquellos objetos marcados 
// como candidatos a recolección cuando se detecta que es sistema está falto
// de recurso. Así, la clase dispondrá de diversos atributos que indiquen el
// número de Coche creado y llegado el momento eliminado.

// Se sobrescribe el método toString y el método finalize (heredados ambos de
// la clase Object).

// Nota: Para forzar que el nuevo elemento creado consuma una mayor proporción
// de memoria física, se asigna al atributo fecha, la nueva fecha y todas las
// anteriores ya creadas ... fecha += new Date().toString();

package p0;

import java.util.Date;

public class Coche {

    private static int contador;        // variables estática (igual para todos).
    private static String fecha = "";   // variable estática (cada objeto su copia).
    
    private int matricula;
    private String fechaObjeto;         // variable de instancia para hacer pesado el objeto.

    public Coche() {
        matricula = ++contador;
        fecha += new Date().toString(); // vamos creando elementos String de un
        fechaObjeto = fecha;            // tamaño cada vez mayor (consumo de recursos).
    }

    public String getFecha() {
        return fecha;
    }

    public int getMatricula() {
        return matricula;
    }
    
    @Override
    public void finalize() {
        System.out.println("   >>>>> SE VA A ELIMINAR EL COCHE NUMERO " + matricula);
    }
    
    @Override
    public String toString() {
        return "COCHE NUMERO ... " + matricula + " ...... " + fecha;
    }    
}