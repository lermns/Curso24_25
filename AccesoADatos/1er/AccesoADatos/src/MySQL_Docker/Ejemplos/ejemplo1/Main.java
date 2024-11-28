package MySQL_Docker.Ejemplos.ejemplo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String connectURL = "jdbc:mysql://localhost:3306/BDPrueba?user=root&password=admin&useUnicode=true&characterEncoding=UTF-8";
        try (Connection con = DriverManager.getConnection(connectURL)){
            System.out.println("conexion establecida");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
