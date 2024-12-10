package SqLite.ejemplos;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Prueba {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:sqlite:./src/SqLite/ejemplos/DB/alumnos.db");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        System.out.println("conectado");
    }
}
