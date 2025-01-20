package PruebaUbntServerDockerMysql;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        // URL JDBC para conectarse a la base de datos
        //String url = "jdbc:mysql://localhost:3306/prueba";
        String connectURL = "jdbc:mysql://192.168.0.36:3307/ZooPruebaFinal?user=root&password=admin&useUnicode=true&characterEncoding=UTF-8";
        String username = "root";  // O el usuario que hayas configurado
        String password = "admin";  // La contraseña para el usuario

        try {
            // Establecer la conexión
            Connection connection = DriverManager.getConnection(connectURL);
            System.out.println("Conexión exitosa a la base de datos.");

            // Aquí puedes agregar tu lógica para trabajar con la base de datos
            PreparedStatement pr = connection.prepareStatement("select * from gatos;");
            //int num = pr.executeUpdate();
            //System.out.println("prueba realizada " + num);
            ResultSet rs = pr.executeQuery();
            System.out.println("prueba");
            while (rs.next()){
                System.out.println("--------");
                System.out.println(rs.getString(1) + "\t");
                System.out.println(rs.getString(1) + "\t");
                //System.out.println(rs.getString("nombre")+ "\t");
            }


            // Cerrar la conexión
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error al conectarse a la base de datos: " + e.getMessage());
        }
    }
}
