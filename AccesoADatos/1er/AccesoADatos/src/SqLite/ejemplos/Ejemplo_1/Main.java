package SqLite.ejemplos.Ejemplo_1;

import java.io.File;
import java.sql.*;
import java.util.Scanner;

public class Main {
    private static int contID;
    public static void main(String[] args) {
        Scanner scStr = new Scanner(System.in);
        Connection con;
        System.out.println("Nombre de la base de datos a la que quieras conectarte");
        String nameDB = "./src/SqLite/ejemplos/DB/" + scStr.nextLine() + ".db";

        if(!new File(nameDB).exists()){
            System.out.println("la base de datos " + nameDB + " no existe");
            System.exit(0);
        }

        String conexionURL="jdbc:sqlite:"+nameDB;

        try {
            con = abreConexion(conexionURL);
            System.out.println("En caso de que la tabla exista esta no se creara");
            System.out.println("Nombre de la tabla que quieres crear: ");
            String tableName = scStr.nextLine();
            crearTabla(con, tableName);
            int num = datosEnTablaCount(con, tableName);
            System.out.println(num);

            System.out.println("Dame el nombre del alumno: ");
            String nombre = scStr.nextLine();

            System.out.println("Dame el ciclo en el que esta matriculado: ");
            String ciclo = scStr.nextLine();
            insertarAlumno(con, ++contID, nombre, ciclo, tableName);

            mostrarRegistrosAlumnos(consultarTodosLosAlumnos(con, tableName));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Connection abreConexion(String url) throws  SQLException{
        System.out.println("1--> Metodo crear conexion");
        Connection con;
        try {
            con = DriverManager.getConnection(url);
        }catch (SQLException e){
            throw new SQLException("Problema en el metodo abreConexion");
        }
        System.out.println("1--> conectado con exito");
        return con;
    }

    private static void crearTabla(Connection con, String name)throws SQLException{
        System.out.println("2--> Metodo crear tabla");
        try {
            Statement ps = con.createStatement();
            ps.execute("create table if not exists " + name + "(\n" +
                    "id int AUTO_INCREMENT primary key,\n" +
                    "nombre varchar not null,\n" +
                    "ciclo varchar not null);"
            );

        }catch (SQLException e){
            throw new SQLException("Problema en el metodo crearTabla\n" + e.getMessage());
        }
        System.out.println("2--> tabla " + name + " creada correctamente");
        if(datosEnTablaCount(con, name)>0){
            contID=ultimoIdAlumno(con, name);
        }
    }

    private static void insertarAlumno(Connection con, String name, String ciclo, String tableName) throws SQLException{
        System.out.println("3--> Metodo insertar");
        String sqlSent  = "insert into " + tableName + " values (?,?,?);";
        PreparedStatement preStatment = con.prepareStatement(sqlSent);
        preStatment.setString(1, name);
        preStatment.setString(2, ciclo);
        int filas = preStatment.executeUpdate();
        System.out.println(filas + " fila(s) afectada(s)");
        System.out.println("3--> Metodo insertar terminado");
    }

    private static ResultSet consultarTodosLosAlumnos(Connection con, String tablename)throws SQLException{
        ResultSet rs;
        try{
            System.out.println("4--> Metodo consultar todos los alumnos");
            PreparedStatement ps = con.prepareStatement("select * from " + tablename + ";");
            rs = ps.executeQuery();
        }catch (SQLException e) {
            throw new SQLException("Problema en el metodo consultarTodosLosAlumnos\n" + e.getMessage());
        }
        System.out.println("4--> Consulta realizada con exito");
        return rs;
    }

    private static void mostrarRegistrosAlumnos(ResultSet resul) throws SQLException{
        System.out.println("5--> Metodo Mostrar Registros Alumnos");
        int cont=0;
        try {
            System.out.println("id\tnombre\tciclo");
            while (resul.next()) {
                cont++;
                System.out.println("--------------------------------------------");
                System.out.print(resul.getString("id") + "\t");
                System.out.print(resul.getString("nombre") + "\t");
                System.out.print(resul.getString("ciclo") + "\n");
            }
            if (cont==0){
                System.out.println("La tabla esta vacia");
            }

        }catch (SQLException e){
            throw new SQLException("Problema con el metodo mostrarRegistrosAlumnos\n" + e.getMessage());
        }
        System.out.println("5--> Consulta de datos realizada con exito.");
    }

    private static int ultimoIdAlumno(Connection con, String tablename)throws SQLException{
        ResultSet rs;
        int idValue;
        try{
            System.out.println("6--> Metodo consultar todos los alumnos");
            PreparedStatement ps = con.prepareStatement("select max(id) from " + tablename + ";");
            rs = ps.executeQuery();
            idValue = rs.getInt(1);
        }catch (SQLException e){
            throw new SQLException("Problema con el metodo consultarUltID");
        }
        System.out.println("6--> Metodo de idValue terminado");
        return idValue;
    }

    private static int datosEnTablaCount(Connection con, String tablename)throws SQLException{
        ResultSet rs;
        int idValue;
        try{
            System.out.println("7--> Metodo datosEnTablaCount cantidad alumnos");
            PreparedStatement ps = con.prepareStatement("select count(*) from " + tablename + ";");
            rs = ps.executeQuery();
            idValue = rs.getInt(1);
        }catch (SQLException e){
            throw new SQLException("Problema con el metodo datosEnTablaCount");
        }
        System.out.println("7--> Metodo de datosEnTablaCount terminado");
        return idValue;
    }

    private static void eliminarAlumnoPorId(Connection con, String tablename)throws SQLException{
        System.out.println("8 --> Metodo eliminar Alumnos Por ID");
        int idValue;
        System.out.println("Dame el id del alumno que quieras borrar: ");
        int id = new Scanner(System.in).nextInt();
        try{
            System.out.println("7--> Metodo datosEnTablaCount cantidad alumnos");
            PreparedStatement ps = con.prepareStatement("delete from ? where id=?;");
            ps.setString(1, tablename);
            ps.setInt(2, id);
            idValue = ps.executeUpdate();
        }catch (SQLException e){
            throw new SQLException("Problema con el metodo datosEnTablaCount");
        }
        System.out.println("8 --> Metodo eliminar Alumnos Por ID");
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
