package SqLite.ejemplos.Ejemplo_1;

import java.io.File;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection con;
        System.out.println("Nombre de la base de datos a la que quieras conectarte");
        String nameDB = "./src/SqLite/ejemplos/DB/" + sc.nextLine() + ".db";

        if(!new File(nameDB).exists()){
            System.out.println("la base de datos " + nameDB + " no existe");
            System.exit(0);
        }

        String conexionURL="jdbc:sqlite:"+nameDB;
        try {
            con = AbreConexion(conexionURL);
            System.out.println("Nombre de la tabla que quieres crear: ");
            String tableName = sc.nextLine();
            crearTabla(con, tableName);
            System.out.println("ID del alumno");
            //insertarAlumno(con);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        /*
        if (con != null) {
            mostrarDatos(con);
            agregarDatos(con);
            mostrarDatos(con);
        }*/
    }
    ///home/leo/Escritorio/Windwos_Git/AccesoADatos/1er
    private static Connection AbreConexion(String url) throws SQLException {
        System.out.println("crear conexion");
        Connection con = DriverManager.getConnection(url);
        System.out.println("conectado con exito");
        return con;
    }

    private static void crearTabla(Connection con, String name)throws SQLException{
        System.out.println("crear tabla");
        Statement ps = con.createStatement();
        ps.execute("create table " + name + "(\n" +
                       "id int primary key,\n" +
                       "nombre varchar not null,\n" +
                       "ciclo varchar not null);"
        );
        System.out.println("tabla " + name + " creada correctamente");

    }

    private static void mostrarDatos(Connection con){
        try{
            PreparedStatement ps = con.prepareStatement("select * from articulos");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.print(rs.getString("nia") + "\t");
                System.out.print(rs.getString("descripcion") + "\t");
                System.out.print(rs.getString("precio") + "\n");
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("problema al conectarte a la base de datos.");
        }
    }

    private static void insertarAlumno(Connection con, int id, String name, String ciclo, String tableName) throws SQLException{
        String sqlSent  = "insert into " + tableName + " values (?,?,?);";
        PreparedStatement preStatment = con.prepareStatement(sqlSent);
        preStatment.setInt(1, id);
        preStatment.setString(2, name);
        preStatment.setString(3, ciclo);
        int filas = preStatment.executeUpdate();
        System.out.println(filas + " afectadas");
    }
}
/*
COMANDOS SQLITE BASICOS

sqlite3 = abre el sqlite sin ninguna base de datos, ya dentro tendriamos que ejecutar el siguiente comando.
.open "nombre de la db".db = Esta seria la manera ya dentro del sqlite3.
sqlite3 "nombre de la base de datos".db = En caso de no existir este crea la base de datos.
.schema "nombre_de_la_tabla" = Estructura de la tabla.
.quit = Salir de la db.
.tables = Muestra las tablas creadas.
.mode column = Cambia la forma en la que el select nos muestra la tabla.

---------------------------------------------------------------------------------------------------------------------

COMANDOS SQL BASICOS

create table "nombre"(
  nia int primary key,
  nombre varchar not null,
  precio REAL,
);

//  en caso que no queramos que la tabla se sobreescriba
create table if not exists coches(
  "parametros de la tabla"
);
*/
