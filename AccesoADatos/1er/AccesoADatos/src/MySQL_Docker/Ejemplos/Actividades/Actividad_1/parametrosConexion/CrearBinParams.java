package MySQL_Docker.Ejemplos.Actividades.Actividad_1.parametrosConexion;

import java.io.*;

public class CrearBinParams {
    public static void main(String[] args) {
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("src/MySQL_Docker/Ejemplos/Actividades/Actividad_1/parametrosConexion/parametros.bin"))){
            dos.writeUTF("LermnsDB");
            dos.writeUTF("leoramos");
            dos.writeUTF("actividadUnoDB");
            dos.writeUTF("true");
            dos.writeUTF("UTF-8");
        }catch(IOException eof){
            System.out.println(eof.getMessage());
        }
    }
}
