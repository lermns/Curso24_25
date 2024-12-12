package MySQL_Docker.Ejemplos.Actividades.Actividad_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MainV_uno {
    public static void main(String[] args) {
        Properties conf = new Properties();

        try{
            //  Cargamos el properties conf con los datos en el fichero properties
            conf.load(new BufferedReader(new FileReader("src/MySQL_Docker/Ejemplos/Actividades/Actividad_1/parametrosConexion/parametros.properties")));
        }catch (IOException ioe){
            System.out.println("error al intentar encontrar el fichero properties");
        }

        String user = conf.getProperty("user");
        String passwd = conf.getProperty("password");
        String dbName = conf.getProperty("dbName");

        //  creamos una cadena de string que tendra la conexion, usando los datos escritos en el properties

        String conURL = "jdbc:mysql://localhost:3306/"
                + dbName
                + "?user=" + user
                + "&password=" + passwd
                + "&useUnicode=true&characterEncoding=UTF-8";

        //por ultimo establecemos la conexion con la base de datos usando la cadena

        try (Connection con = DriverManager.getConnection(conURL)){
            System.out.println("conexion establecida");
        } catch (SQLException e) {
            System.out.println("problema al intentar conectar a la base de datos.");
        }
    }
}
