/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ramosleonardo_examen2_modelob;

import com.mysql.cj.jdbc.DatabaseMetaData;
import java.io.*;
import static java.lang.Float.parseFloat;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class RamosLeonardo_examen2_modeloB {

    public static void main(String[] args) {
        Connection con = abrirConexion();
        
        mostrarInfoSistema(con);
        
        crearTablasPlanes(con);
        
        crearTablasUsuarios(con);
        
        insertarPlanes(con);
        
        mostrarUsuarios(con);
        
        cerrarConexion(con);
    }
    
    private static Connection abrirConexion(){
        System.out.println("1--> Metodo Connection");
        Properties proper = new Properties(); 
        Connection con=null;
        
        try{    
            //abrimos la conexion a la vez que cogemos los datos de user y password del properties
            proper.load(new BufferedReader(new FileReader("src/ramosleonardo_examen2_modelob/properties.properties")));
           
            String user = proper.getProperty("user");
            String passwd = proper.getProperty("password");
            
            String url = "jdbc:mysql://localhost:3306/plataforma?user=" + user + 
                    "&password="+passwd+"&useUnicode=true&characterEncoding=UTF-8";
            
            
            con = DriverManager.getConnection(url);
            System.out.println("1--> COMPLETADO");
        }catch(SQLException|IOException e){
            System.out.println("1--> ERROR\n" + e.getMessage());
        }
        return con;
    }
    
    private static void cerrarConexion(Connection con){
        System.out.println("2--> Metodo cerrarConexion");
        try{
            con.close();
            System.out.println("2--> COMPLETADO");
        }catch(SQLException e){
            System.out.println("2--> ERROR\n" + e.getMessage());
        }
    }
    
    private static void mostrarInfoSistema(Connection con){
        System.out.println("3--> Metodo mostrarInfoSistema");
        try{
            // clase usada para coger los valores requeridos, usamos sus metodos que recuperan los valores
            DatabaseMetaData dameTa = (DatabaseMetaData) con.getMetaData();
            System.out.println("Url " + dameTa.getURL());
            System.out.println("SGBD " + dameTa.getDatabaseProductName());
            System.out.println("Driver " + dameTa.getDriverName());
        
            System.out.println("3--> COMPLETADO");
        }catch(SQLException e){
            System.out.println("3--> ERROR\n" + e.getMessage());
        }
    }
    
    private static void crearTablasPlanes(Connection con){
        System.out.println("4--> Metodo crearTablasPlanes");
        try{
            // crea la tabla en caso de que no exista
            PreparedStatement pr = con.prepareStatement("create table if not exists planes("+
                    "cod_plan int auto_increment primary key,\n"+
                    "nom_plan varchar(10) not null,\n"+
                    "cuota_plan float not null\n"+
                    ");");
            
            //en caso que devuelva 0 es porque la tabla se ha creado correctamente
           if( pr.executeUpdate()==0)
                System.out.println("tabla planes creada");
           
            System.out.println("4--> COMPLETADO");
        }catch(SQLException e){
            System.out.println("4--> ERROR\n" + e.getMessage());
        }
    }
    
    private static void crearTablasUsuarios(Connection con){
        System.out.println("5--> Metodo crearTablasUsuarios");
        try{
            //lo mismo que el anterior metodo con la diferencia que tiene una clave foranea a planes
            PreparedStatement pr = con.prepareStatement("create table if not exists usuarios("+
                    "user_id int auto_increment primary key,\n"+
                    "user_name varchar(15) not null,\n"+
                    "forma_pago varchar(10) not null,\n"+
                    "id_plan int not null,\n" + 
                    "cuota_usuario float not null,\n" +
                    "foreign key (id_plan) references planes(cod_plan)\n"+
                    ");");
            
           if( pr.executeUpdate()==0)
                System.out.println("tabla planes creada");
           
            System.out.println("5--> COMPLETADO");
        }catch(SQLException e){
            System.out.println("5--> ERROR\n" + e.getMessage());
        }
    }
    
    private static void insertarPlanes(Connection con){
        // lista donde se guardan los planes leidos del fichero binario
        ArrayList<String> listaDatos = new ArrayList<>();
        
        try(DataOutputStream bfw = new DataOutputStream(new FileOutputStream("src/ramosleonardo_examen2_modelob/opcines.bin"));
                DataInputStream bfr = new DataInputStream(new FileInputStream("src/ramosleonardo_examen2_modelob/opcines.bin"))){
            System.out.println("6--> Metodo insertarPlanes");
            //escribimos en binario los planes separados por un espacio
            bfw.writeUTF("Estandar 30");
            bfw.writeUTF("Premium 10");
            bfw.close();
            
            // los agregamos a la lista
            listaDatos.add(bfr.readUTF());
            listaDatos.add(bfr.readUTF());
           
            PreparedStatement pr = con.prepareStatement("insert into planes (nom_plan, cuota_plan) values (?,?);");
            String[] arryString = new String[2];
            int rowsAffect =0;
            
            //lo iteramos y hacemos un split para coger los valores por separado e insertarlos
            for(String  s: listaDatos){
                arryString = s.split(" ");
                pr.setString(1, arryString[0]);
                pr.setFloat(2, parseFloat(arryString[1]));
                rowsAffect += pr.executeUpdate();
            }
            
            System.out.println(rowsAffect + " columna(s) afectada(s)");
            
            System.out.println("6--> COMPLETADO");
            
        }catch(IOException|SQLException e){
            System.out.println("6--> ERROR\n" + e.getMessage());
        }   
    }
    
    private static void mostrarUsuarios(Connection con){
        System.out.println("7--> Metodo mostrarUsuarios");
        try{
            //  subconsulta para mostrar los valores
            PreparedStatement pr = con.prepareStatement("select user_id, user_name, forma_pago, nom_plan, cuota_usuario from usuarios, planes where cod_plan=id_plan;");
            ResultSet rs = pr.executeQuery();
            
            System.out.println("user_id\t\tuser_name\t\tforma_pago\t\tnom_plan\t\tcuotaUsuario");
            
            while(rs.next()){
                System.out.println(rs.getString(1) + "\t\t" + rs.getString(2)+ "\t\t\t" + rs.getString(3)+ "\t\t\t" + rs.getString(4)+ "\t\t" + rs.getString(5));
            }
            
            System.out.println("7--> COMPLETADO");
        }catch(SQLException e){
            System.out.println("7--> ERROR\n" + e.getMessage());
        }
    }
    
    
}
