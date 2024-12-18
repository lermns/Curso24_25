package MySQL_Docker.Ejemplos.Actividades.Actividad_2.MetodosConexion;

import java.io.*;

public class CrearFichDepart {
    public static void main(String[] args) {
        // src/MySQL_Docker/Ejemplos/Actividades/Actividad_2/MetodosConexion/properties.properties
        System.out.println("Inicio");
        String linea;
        try(BufferedWriter bfw = new BufferedWriter(new FileWriter("src/MySQL_Docker/Ejemplos/Actividades/Actividad_2/MetodosConexion/departamentos.txt"));
            BufferedReader bfr = new BufferedReader(new FileReader("src/MySQL_Docker/Ejemplos/Actividades/Actividad_2/MetodosConexion/departamentos.txt"))){

            bfw.write("Contabilidad\n");
            bfw.write("RRHH\n");
            bfw.write("Despacho\n");
            bfw.write("Almacen\n");
            bfw.close();

            while((linea=bfr.readLine()) != null){
                System.out.println(linea);
            }
            System.out.println("Completado");
        }catch (IOException ioe){
            System.out.println();
        }
    }
}
