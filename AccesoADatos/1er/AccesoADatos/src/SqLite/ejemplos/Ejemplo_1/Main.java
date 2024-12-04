package SqLite.ejemplos.Ejemplo_1;

import java.io.File;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        mostrarDatos();
        agregarDatos();
        mostrarDatos();
    }

    private static Connection conexion() throws SQLException {
        String url= "jdbc:sqlite:/media/leo/USB_de_Leo/Curso24_25/Curso24_25/AccesoADatos/1er/actAlumn.db";
        Connection con = DriverManager.getConnection(url);
        System.out.println("conectado con exito");
        return con;
    }

    private static void mostrarDatos(){
        try(Connection con = conexion()){
            PreparedStatement ps = con.prepareStatement("select * from articulos");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.print(rs.getString("codigo") + "\t");
                System.out.print(rs.getString("descripcion") + "\t");
                System.out.print(rs.getString("precio") + "\n");
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("problema al conectarte a la base de datos.");
        }
    }

    private static void agregarDatos(){
        Scanner sc = new Scanner(System.in);
        try(Connection con = conexion()){
            System.out.println("dame le numero de la columna codigo:");
            int cod = sc.nextInt();
            sc.nextLine();

            System.out.println("descripcion sobre el producto:");
            String desc = sc.nextLine();
            sc.nextLine();

            System.out.println("dame el precio del producto:");
            double precio = sc.nextDouble();
            sc.nextLine();

            PreparedStatement ps = con.prepareStatement("insert into articulos values (" + cod + ",'" + desc +"'," + precio +")");
            int fil = ps.executeUpdate();

            System.out.println("columnas afectadas: " + fil);

        }catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("problema al conectarte a la base de datos.");
        }

    }
}
