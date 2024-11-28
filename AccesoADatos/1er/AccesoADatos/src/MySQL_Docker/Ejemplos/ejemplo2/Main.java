package MySQL_Docker.Ejemplos.ejemplo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        String connectURL = "jdbc:mysql://localhost:3306/BDPrueba";
        Properties info = new Properties();

        info.setProperty("user", "root");
        info.setProperty("password", "admin");
        info.setProperty("useUnicode", "true");
        info.setProperty("characterEncoding", "UTF-8");

        try (Connection con = DriverManager.getConnection(connectURL, info)){
            System.out.println("conexion establecida");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
