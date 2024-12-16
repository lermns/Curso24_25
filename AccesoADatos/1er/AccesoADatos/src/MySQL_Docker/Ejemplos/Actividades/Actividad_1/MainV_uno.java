package MySQL_Docker.Ejemplos.Actividades.Actividad_1;

import java.io.*;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class MainV_uno {
    public static void main(String[] args) {
        Scanner scStr = new Scanner(System.in);
        Connection con;

        try {
            con = conexion();

            System.out.println("En caso de que la tabla exista esta no se creara");
            System.out.println("Nombre de la tabla que quieres crear: ");
            String tableName = scStr.nextLine();

            crearTabla(con, tableName);

            int num = datosEnTablaCount(con, tableName);
            System.out.println("Cantidad de personas en la tabla: " + num);

            System.out.println("Dame el nombre del alumno: ");
            String nombre = scStr.nextLine();

            System.out.println("Dame el ciclo en el que esta matriculado: ");
            String ciclo = scStr.nextLine();

            insertarAlumno(con, nombre, ciclo, tableName);

            mostrarRegistrosAlumnos(consultarTodosLosAlumnos(con, tableName));

            int idUlt = ultimoIdAlumno(con, tableName);
            System.out.println("id del ultimo alumno es " + idUlt);

            eliminarAlumnoPorId(con, tableName);

            modificarAlumnoPorId(con, tableName);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Connection conexion()throws SQLException{
        System.out.println("1--> Método Conexion");

        //  <------- VERSION 1 -------->
        // version 1 de como usar los valores para abrir la conexion
        // Comentar version 2 para usar esta version

//        Properties conf = new Properties();
//        try{
//            //  Cargamos el properties conf con los datos en el fichero properties
//            conf.load(new BufferedReader(new FileReader("src/MySQL_Docker/Ejemplos/Actividades/Actividad_1/parametrosConexion/parametros.properties")));
//        }catch (IOException ioe){
//            System.out.println("error al intentar encontrar el fichero properties");
//        }
//        String user = conf.getProperty("user");
//        String passwd = conf.getProperty("password");
//        String dbName = conf.getProperty("dbName");
//        String uniCode = conf.getProperty("uniCode");
//        String encodingChar = conf.getProperty("charEncod");
        //  <------- FINAL VERSION 1 -------->


        //  <------- VERSION 2 -------->
        // version 2 de como usar los valores para abrir la conexion
        // Comentar version 1 para usar esta version
        String user="", passwd="", dbName = "", uniCode="", encodingChar="";

        try(DataInputStream dis = new DataInputStream(new FileInputStream("src/MySQL_Docker/Ejemplos/Actividades/Actividad_1/parametrosConexion/parametros.bin"))){
            user = dis.readUTF();
            passwd = dis.readUTF();
            dbName = dis.readUTF();
            uniCode = dis.readUTF();
            encodingChar = dis.readUTF();
        }catch(IOException eof){
            System.out.println(eof.getMessage());
        }
        //  <------- FINAL VERSION 2 -------->


        //  creamos una cadena de string que tendra la conexion, usando los datos escritos en el properties
        String conURL = "jdbc:mysql://localhost:3306/"
                + dbName
                + "?user=" + user
                + "&password=" + passwd
                + "&useUnicode=" + uniCode
                + "&characterEncoding=" + encodingChar;

        //por ultimo establecemos la conexion con la base de datos usando la cadena
        Connection con=null;
        try {
            con = DriverManager.getConnection(conURL);
            System.out.println("1--> COMPLETADO");
        } catch (SQLException e) {
            throw new SQLException("1--> ERROR\n" + e.getMessage());
        }
        return con;

    }


    private static void crearTabla(Connection con, String name)throws SQLException{
        System.out.println("2--> Método crear tabla");
        try {
            Statement ps = con.createStatement();
            ps.execute("create table if not exists " + name + "(\n" +
                    "id int auto_increment primary key,\n" +
                    "nombre varchar(20) not null,\n" +
                    "ciclo varchar(30) not null\n " +
                    ");"
            );
            System.out.println("2--> COMPLETADO");
        }catch (SQLException e){
            throw new SQLException("2--> ERROR\n" + e.getMessage());
        }
    }

    private static void insertarAlumno(Connection con, String name, String ciclo, String tableName) throws SQLException{
        System.out.println("3--> Metodo insertar");

        String sqlSent  = "insert into " + tableName + " (nombre, ciclo) values (?,?);";
        try {
            PreparedStatement preStatment = con.prepareStatement(sqlSent);
            preStatment.setString(1, name);
            preStatment.setString(2, ciclo);
            int filas = preStatment.executeUpdate();
            System.out.println(filas + " fila(s) afectada(s)");

            System.out.println("3--> COMPLETADO");
        }catch (SQLException e){
            throw new SQLException("3--> ERROR\n" + e.getMessage());
        }
    }

    private static ResultSet consultarTodosLosAlumnos(Connection con, String tablename)throws SQLException{
        ResultSet rs;
        try{
            System.out.println("4--> Metodo consultar todos los alumnos");
            PreparedStatement ps = con.prepareStatement("select * from " + tablename + ";");
            rs = ps.executeQuery();
            System.out.println("4--> COMPLETADO");
        }catch (SQLException e) {
            throw new SQLException("4--> ERROR\n" + e.getMessage());
        }
        return rs;
    }

    private static void mostrarRegistrosAlumnos(ResultSet resul) throws SQLException{
        System.out.println("5--> Metodo Mostrar Registros Alumnos\n\n");
        int cont=0;
        try {
            System.out.println("id\tnombre\tciclo");
            while (resul.next()) {
                cont++;
                System.out.println("---------------------");
                System.out.print(resul.getString("id") + "\t");
                System.out.print(resul.getString("nombre") + "\t");
                System.out.print(resul.getString("ciclo") + "\n");
            }
            if (cont==0)
                System.out.println("La tabla esta vacia");

            System.out.println("\n\n5--> COMPLETADO");
        }catch (SQLException e){
            throw new SQLException("5--> ERROR\n" + e.getMessage());
        }
    }

    private static int ultimoIdAlumno(Connection con, String tablename)throws SQLException{
        ResultSet rs;
        int idValue;
        try{
            System.out.println("6--> Metodo ultimoIdAlumno");
            PreparedStatement ps = con.prepareStatement("select max(id) from " + tablename + ";");
            rs = ps.executeQuery();
            rs.next();
            idValue = rs.getInt(1);
            System.out.println("6--> COMPLETADO");
        }catch (SQLException e){
            throw new SQLException("6--> ERROR\n" + e.getMessage());
        }
        return idValue;
    }

    private static int datosEnTablaCount(Connection con, String tablename)throws SQLException{
        ResultSet rs;
        int idValue;
        try{
            System.out.println("7--> Metodo datosEnTablaCount");
            PreparedStatement ps = con.prepareStatement("select count(*) from " + tablename + ";");
            rs = ps.executeQuery();
            rs.next();
            idValue = rs.getInt(1);
            System.out.println("7--> COMPLETADO");
        }catch (SQLException e){
            throw new SQLException("7--> ERROR\n" + e.getMessage());
        }
        return idValue;
    }

    private static void eliminarAlumnoPorId(Connection con, String tablename)throws SQLException{
        System.out.println("8--> Metodo eliminar Alumnos Por ID");
        int idValue;
        System.out.println("Dame el id del alumno que quieras borrar: ");
        int id = new Scanner(System.in).nextInt();
        try{
            PreparedStatement ps = con.prepareStatement("delete from " + tablename + " where id=?;");
            ps.setInt(1, id);
            idValue = ps.executeUpdate();
            if (idValue>0){
                System.out.println("Alumno borrado.");
            }else
                System.out.println("Alumno no encontrado.");

            System.out.println("8--> COMPLETADO");
        }catch (SQLException e){
            throw new SQLException("8--> ERROR\n" + e.getMessage());
        }
    }

    private static void modificarAlumnoPorId(Connection con, String tablename) throws SQLException{
        System.out.println("9--> Metodo modificarAlumnoPorId");
        ResultSet rs;
        int inValue;
        Scanner sc = new Scanner(System.in);

        System.out.println("Dame el id del alumno que quieras modificar: ");
        int id = new Scanner(System.in).nextInt();
        try{
            PreparedStatement ps_two = con.prepareStatement("select * from " + tablename + " where id=?;");
            ps_two.setInt(1, id);
            rs = ps_two.executeQuery();
            rs.next();
            inValue = rs.getInt(1);

            if(inValue>0){
                System.out.println("Dame el nuevo nombre del alumno");
                String name = sc.nextLine();
                System.out.println("Dame el nuevo ciclo del alumno");
                String ciclo = sc.nextLine();

                PreparedStatement ps = con.prepareStatement("update " + tablename + " set nombre=?, ciclo=? where id=?;");
                ps.setString(1, name);
                ps.setString(2, ciclo);
                ps.setInt(3, id);
                inValue = ps.executeUpdate();
                System.out.println(inValue + " fila(s) actualizada(s).");
            }else
                System.out.println("El usuario con el id " + id + " no existe en la base de datos.");

            System.out.println("9--> COMPLETADO");
        }catch (SQLException e){
            throw new SQLException("9--> ERROR\n" + e.getMessage());
        }
    }
}
