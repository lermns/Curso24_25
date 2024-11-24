// Crear una clase que compruebe el funcionamiento de la Serialización en herencia.
// Hacer uso de los flujos modo objeto en alto nivel tanto para lectura como para 
// escritura y comprobar cómo al no disponerse de flujos de bajo nivel propios de
// dicho modo, se debe recurrir a los de bajo nivel del modo binario (los del modo
// texto no son compatibles). Escribir y leer un objeto Coche, examinando lo que
// se "vería" a través del fichero generado (serializar) que luego será utilizado
// para reconstruir (deserializar) el objeto.


package p0;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class PruebaSerializacion {

    public static void main(String[] args) throws Exception {
        
        // crear el objeto a serializar, a persistir su estado en un fichero
        // de modo que podemos apagar la alimentación del sistema sin perder
        // la información (la información de la memoria RAM se pierde, lo
        // que tengamos en el disco duro no).
        System.out.println("INSTANCIAR UN OBJETO DE LA CLASE COCHE:\n");
        Coche coche = new Coche("PORSCHE 911", 80000); 
        
        System.out.println(coche + "\n\n");
        
        ////// SERIALIZARLO //////
        
        // dispositivo I/O.
        String fichero = "ficheroSerializacion";
        
        // escritor modo binario bajo nivel.
        FileOutputStream fos = new FileOutputStream(fichero);
        
        // escritor modo objeto alto nivel.
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        // serializar.
        oos.writeObject(coche);
        
        // verter los datos.
        oos.flush();
        
        System.out.println("... SE HA SERIALIZADO UN COCHE.\n\n");
        
        // SALE ALGO CÓMO LO SIGUIENTE (usar WordPad para abrirlo, NetBeans no muestra nada):
        //í  sr  p0.CocheK/)PúXò   I  precioL  modelot  Ljava/lang/String;xp  8€t 
        //PORSCHE 911
        
        ////// DESERIALIZARLO //////
        
        System.out.println("\nRECUPERAR EL OBJETO COCHE:\n");
        
        // lector modo binario bajo nivel.
        FileInputStream fis = new FileInputStream(fichero);
        
        // lector modo objeto alto nivel.
        ObjectInputStream ois = new ObjectInputStream(fis);        
        
        // se devuelve Object. Si se quiere trabajar con él, hacer casting.
        Object objetoRecuperado = ois.readObject();
        System.out.println("\nVERIFICAR QUE LO RECUPERADO ES UN COCHE:");
        System.out.println(objetoRecuperado.getClass().getSimpleName());
        System.out.println(objetoRecuperado);
        
        Coche cocheRecuperado = (Coche)objetoRecuperado;
        
        System.out.println("\nPROPIEDADES DEL COCHE RECUPERADO:\n");
        System.out.println("MODELO ... " + cocheRecuperado.getModelo());
        System.out.println("CODIGO ... " + cocheRecuperado.getCodigo() +
                           " -> era transient ... le asigna su valor por defecto.");
        System.out.println("PRECIO ... " + cocheRecuperado.getPrecio());
        System.out.println("USADO .... " + cocheRecuperado.isUsado() +
                           " -> era static ... preguntar a la clase por su valor actual.");
        
        System.out.println("\nFIN DE IMPRESION\n");
    }

}