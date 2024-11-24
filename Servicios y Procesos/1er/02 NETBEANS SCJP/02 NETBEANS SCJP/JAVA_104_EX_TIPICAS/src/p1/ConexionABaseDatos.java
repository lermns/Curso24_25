// Crear una clase que establezca la típica conexión con una base de datos
// a través de tecnología JDBC (Java Data Base Connectivity). Comprobar cómo
// los métodos para cargar el driver del conector en memoria o establecer la
// conexión en si a través del objeto Connection, pueden lanzar excepciones de
// tipo comprobativo. Gestionar las excepciones a través de un bloque de captura
// try-catch.


package p1;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionABaseDatos {

    public static void main(String[] args) {
                
        try {
            // CARGAR EL DRIVER EN MEMORIA
            // Proceso inicial: Carpeta Libraries del proyecto - add JAR/Folder
            // - buscar el jar que contenga mysql-connector-java-5.0.5-bin.jar
            // EL EMPAQUETADO NOS PROPORCIONA LA CLASE Driver.class.            
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("ERROR AL CARGAR EL DRIVER DE CONEXION");
        }
        
        System.out.println("DRIVER CARGADO EN MEMORIA CORRECTAMENTE\n");
        
        // CREAR LA CONEXIÓN:
        try {
            DriverManager.getConnection("urlBBDD","usuario","password");
        } catch (SQLException sqle) {
            System.out.println("ERROR AL INTENTAR CONECTAR CON LA BASE DE DATOS");
            System.out.println(sqle);
        }   
    }   

}