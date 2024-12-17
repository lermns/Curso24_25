package MySQL_Docker.Ejemplos.Actividades.Actividad_2;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        try {
            //  metodo que abre la conexion recibiendo un string que es la url
            Connection con = abreConexion(crearUrl());

            //  ver info de la base de datos pasandole la conexion
            verInfoDB(con);

            //  crea una tabla si no existe con parametros pero pasandole el nombre de la tabla
            crearTablaDepartamentos(con, "departamentos");

            //  crea una tabla si no existe con parametros con una refencia a un pk de la tabla creada recientemente
            crearTablaEmpleados(con, "empleados", "departamentos");

            //  ver claves de una tabla que le pasamos como parametro, usando DataBaseMetaData.getImportedKeys y getExportedKeys
            verClaves(con, "empleados");

            //  metodo al que se le pasa la conexion y la cierra
            cierraConexion(con);
        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String crearUrl()throws IOException{
        System.out.println("1--> Metodo Crear URL");
        Properties confProp = new Properties();
        StringBuilder strUrl = new StringBuilder();
        try {
            confProp.load(new BufferedReader(new FileReader("src/MySQL_Docker/Ejemplos/Actividades/Actividad_2/MetodosConexion/properties.properties")));
            strUrl.append("jdbc:mysql://localhost:3306/")
                    .append(confProp.getProperty("dbName"))
                    .append("?user=").append(confProp.getProperty("user"))
                    .append("&password=").append(confProp.getProperty("password"))
                    .append("&useUnicode=").append(confProp.getProperty("uniCode"))
                    .append("&characterEncoding=").append(confProp.getProperty("charEncod"));
            System.out.println("1--> COMPLETADO");
        }catch (IOException fnfe){
            throw new IOException("1--> ERROR\n" + fnfe.getMessage());
        }
        return strUrl.toString();
    }

    private static Connection abreConexion (String url)throws SQLException{
        System.out.println("2--> Metodo abreConexion");
        Connection con;
        try{
            con = DriverManager.getConnection(url);
            System.out.println("2--> COMPLETADO");
        }catch (SQLException e){
            throw new SQLException("2--> ERROR\n" + e.getMessage());
        }
        return con;
    }

    private static void cierraConexion(Connection con)throws SQLException{
        try {
            System.out.println("3--> Metodo cierra Conexion");
            con.close();
            System.out.println("3--> COMPLETADO");
        } catch (SQLException e) {
            throw new SQLException("3--> ERROR\n" + e.getMessage());
        }
    }

    private static void verInfoDB(Connection con)throws SQLException{
        System.out.println("4--> Metodo verInfo");
        try{
            DatabaseMetaData dameTa = con.getMetaData();
            System.out.println("SGBD = " + dameTa.getDatabaseProductName());
            System.out.println("NombreDriver = " + dameTa.getDriverName());
            System.out.println("URL = " + dameTa.getURL());
            System.out.println("Usuario = " + dameTa.getUserName());

            System.out.println("4--> COMPLETADO");
        }catch (SQLException e){
            throw new SQLException("4--> ERROR\n" + e.getMessage());
        }
    }

    private static void crearTablaDepartamentos(Connection con, String tName)throws SQLException{
        System.out.println("5--> Metodo crearTablaDepartamentos");
        try{
            PreparedStatement pr = con.prepareStatement("create table if not exists " + tName + "(\n" +
                    "dep_id int auto_increment primary key,\n" +
                    "dep_nombre varchar(15) not null\n" +
                    ");");

            if(pr.executeUpdate()==0)
                System.out.println("Creada tabla " + tName);

            System.out.println("5--> COMPLETADO");
        }catch (SQLException e){
            throw new SQLException("5--> ERROR\n" + e.getMessage());
        }
    }

    private static void crearTablaEmpleados(Connection con, String tEmple, String tDep)throws SQLException{
        System.out.println("6--> Metodo crearTablaEmpleados");
        try{
            PreparedStatement pr = con.prepareStatement("create table if not exists " + tEmple + "(\n" +
                    "emp_id int auto_increment primary key,\n" +
                    "apellido varchar(15) not null,\n" +
                    "salario float(9,2) not null,\n" +
                    "dep_id int not null,\n" +
                    "constraint fk_this_depId_to_dept_depId foreign key (dep_id) references " + tDep + "(dep_id)\n" +
                    ");");

            if(pr.executeUpdate()==0)
                System.out.println("Creada la tabla " + tEmple + " con referecia a la tabla " + tDep);

            System.out.println("6--> COMPLETADO");
        }catch (SQLException e){
            throw new SQLException("6--> ERROR\n" + e.getMessage());
        }
    }

    private static void verClaves (Connection con, String tNname)throws SQLException{
        System.out.println("7--> Metodo verClaves");

        try{
            DatabaseMetaData dbmetaData = con.getMetaData();
            ResultSet rs = dbmetaData.getImportedKeys(null,null,tNname);
            while(rs.next()){
                System.out.println("Tabla " + rs.getString("FKTABLE_NAME") +
                        "(" + rs.getString("FKCOLUMN_NAME") + ")" +
                        " refenrencia a tabla " + rs.getString("PKTABLE_NAME") +
                        "(" + rs.getString("PKCOLUMN_NAME") + ")");
            }

            System.out.println("7--> COMPLETADO");
        }catch (SQLException e){
            throw new SQLException("7--> ERROR\n" + e.getMessage());
        }
    }
}
