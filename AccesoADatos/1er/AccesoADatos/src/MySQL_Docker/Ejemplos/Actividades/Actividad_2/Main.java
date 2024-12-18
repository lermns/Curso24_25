package MySQL_Docker.Ejemplos.Actividades.Actividad_2;

import java.io.*;
import java.sql.*;
import java.util.*;

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

            //  recibe la ruta de un fichero con los nombres de los departamentos para insertarlos en la tabla
            String fich = "src/MySQL_Docker/Ejemplos/Actividades/Actividad_2/MetodosConexion/departamentos.txt";
            //insertarDepartamentos(con, "departamentos", fich);

            //  inserta un empleado en la tabla recibiendo sus datos por el metodo
            //insertarEmple(con, "juan", 1200, 1, "empleados");

            //  Muestra los registros de un resulset, viendo primero la cantidad de columnas para recuperar los nombres
            mostrarRegistros(consultarDepartamentos(con, "departamentos"));
            mostrarRegistros(consultarEmpleados(con, "departamentos", "empleados"));

            //  Modifica los salarios de los empleados que tengan un salario menor a 1200, se les actualiza el salario
            //  incrementandolo de entre un 3-10%, este se ingresa por consola
            modificarSalarios(con, "empleados");

            //  Eliminar un empleado de la tabla, al que se le pasa un id
            eliminarEmplePorId(con, "empleados");

            //  metodo al que se le pasa la conexion y la cierra
            cierraConexion(con);

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String crearUrl()throws IOException{
        System.out.println("1--> Metodo Crear URL");

        //  creamos la instancia de Properties
        Properties confProp = new Properties();

        //  StringBuilder para anidar de forma más sencilla los properties
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
            //  Establece la conexion recibiendo un string como el url
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
            //  Se usa los metodos para coger el MetaData y recuperar el SGBD, etc.
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
            //  creamos una tabla de departamentos con el nombre que le pasamos como parametro
            PreparedStatement pr = con.prepareStatement("create table if not exists " + tName + "(\n" +
                    "dep_id int auto_increment primary key,\n" +
                    "dep_nombre varchar(15) not null\n" +
                    ");");

            //  En caso de que la tabla se cree, esta devuelve 0
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
                    "dep_idTEmp int not null,\n" +
                    "constraint fk_this_depIdTEmp_to_dept_depId foreign key (dep_idTEmp) references " + tDep + "(dep_id)\n" +
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

            //  Recupera en un Resulset las claves importadas, exportadas y pk del nombre de la tabla que se le pasa
            ResultSet rsImp = dbmetaData.getImportedKeys(null,null,tNname);
            ResultSet rsExp = dbmetaData.getExportedKeys(null,null,tNname);
            ResultSet rsPK = dbmetaData.getPrimaryKeys(null,null,tNname);

            System.out.print("Clave Primaria: ");
            while(rsPK.next()){
                //  Recupera la PK
                System.out.print(rsPK.getString("COLUMN_NAME") + " ");
            }

            System.out.println();

            while(rsImp.next()){
                //  Recupera la columna que hace la fk, la tabla y pk de donde la importa
                System.out.println("Clave foránea " + rsImp.getString("FKCOLUMN_NAME"));
                System.out.println("Clave importada de tabla " + rsImp.getString("PKTABLE_NAME") +
                        "("+ rsImp.getString("PKCOLUMN_NAME") + ")");
            }

            while(rsExp.next()){
                //  Recupera la clave que se exporta a otra tabla, a la tabla a la que exporta y su pk
                System.out.println("Clave exportada " + rsExp.getString("PKCOLUMN_NAME"));
                System.out.println("Clave exportada a tabla " + rsExp.getString("FKTABLE_NAME") +
                        "("+ rsExp.getString("FKCOLUMN_NAME") + ")");
            }

            System.out.println("7--> COMPLETADO");
        }catch (SQLException e){
            throw new SQLException("7--> ERROR\n" + e.getMessage());
        }
    }

    private static void insertarDepartamentos(Connection con, String tName, String fich)throws SQLException{
        System.out.println("8--> Metodo insertar Departamentos");
        ArrayList<String> listaDepts = new ArrayList<>();
        int rowAfects=0;

        try(BufferedReader bfr = new BufferedReader(new FileReader(fich))){
            String lineaDep;

            //  Lee la linea y si es distinto de null la agrega a una lista
            while((lineaDep=bfr.readLine()) != null){
                listaDepts.add(lineaDep);
            }

            //  Prepara el preparestatement con el insert
            PreparedStatement pr = con.prepareStatement("insert into " + tName + " (dep_nombre) values (?);");
            for (String s : listaDepts){
                //  establece el parametro a la consulta y la ejecuta
                pr.setString(1, s);
                rowAfects += pr.executeUpdate();
            }

            System.out.println(rowAfects + " Filas agregadas a la talba " + tName);

            System.out.println("8--> COMPLETADO");
        }catch (IOException|SQLException e){
            throw new SQLException("8--> ERROR\n" + e.getMessage());
        }
    }

    private static ResultSet consultarDepartamentos(Connection con, String deptName)throws SQLException{
        System.out.println("9--> Metodo Consultar Departamentos");
        ResultSet rs;
        try{
            PreparedStatement pr = con.prepareStatement("select * from " + deptName + ";");
            rs = pr.executeQuery();
            System.out.println("9--> COMPLETADO");
        }catch (SQLException e){
            throw new SQLException("9--> ERROR\n" + e.getMessage());
        }
        return rs;
    }

    private static void insertarEmple(Connection con, String apellidos, int salario, int dep_id, String tName)throws SQLException{
        System.out.println("10--> Metodo insertar Emple");
        try{
            PreparedStatement pr = con.prepareStatement("insert into " + tName +
                    " (apellido,salario,dep_idTEmp) values (?,?,?);");
            pr.setString(1, apellidos);
            pr.setInt(2, salario);
            pr.setInt(3, dep_id);
            int rowsAfect = pr.executeUpdate();

            if(rowsAfect>0)
                System.out.println(rowsAfect + " Fila agregada a la tabla " + tName);
            else
                System.out.println("No se agrego nada a la tabla " + tName);

            System.out.println("10--> COMPLETADO");
        }catch (SQLException e){
            throw new SQLException("10--> ERROR\n" + e.getMessage());
        }
    }

    private static ResultSet consultarEmpleados(Connection con, String tDep, String tEmp)throws SQLException{
        System.out.println("11--> Metodo Consultar Empleados");

        ResultSet rs;
        try{
            PreparedStatement pr = con.prepareStatement("select emp_id, apellido, salario, dep_nombre from " +
                    tEmp + ", " + tDep + " where dep_idTEmp=dep_id;");
            rs = pr.executeQuery();
            System.out.println("11--> COMPLETADO");
        }catch (SQLException e){
            throw new SQLException("11--> ERROR\n" + e.getMessage());
        }
        return rs;
    }

    private static void mostrarRegistros(ResultSet resul)throws SQLException{
        System.out.println("12--> Metodo mostrarRegistros");
        try{
            //  Recupera el resulsetMetaData
            ResultSetMetaData rsmd = resul.getMetaData();

            //  Recupera la cantidad de columnas de la tabla
            System.out.println("Cantidad de columnas -> " + rsmd.getColumnCount());

            //  Recupera el nombre de la columna pasandole el indice desde 1
            for (int i = 1; i <= rsmd.getColumnCount() ; i++) {
                System.out.print(rsmd.getColumnName(i) + "\t\t");
            }

            System.out.println();

            //  Imprime el contenido del ResulSet haciendo el salto de línea  cuando termina con el largo de columnas
            while(resul.next()){
                for (int i = 1; i <= rsmd.getColumnCount() ; i++) {
                    System.out.print(resul.getString(i) + "\t\t\t");
                }
                System.out.println();
            }
            System.out.println("\n12--> COMPLETADO");
        }catch (SQLException e){
            throw new SQLException("12--> ERROR\n" + e.getMessage());
        }
    }

    private static void modificarSalarios(Connection con, String tName)throws SQLException{
        System.out.println("13--> Metodo modificarSalarios");
        byte porcentaje;

        do {
            //  Mientras el valor sea menor a 3 o mayor a 10
            System.out.println("dame el porcetaje a subir que este entre 3-10");
            porcentaje = new Scanner(System.in).nextByte();
        }while (porcentaje < 3 || porcentaje > 10);

        //  lo divide entre 100 y le suma 1 para coger el porcentaje entre 3-10
        float numMult = 1 + (porcentaje/100.0f);

        try{
            PreparedStatement pr = con.prepareStatement("update " + tName + " set salario=salario*? where salario<1200");
            pr.setFloat(1, numMult);
            int rowsAfect = pr.executeUpdate();

            System.out.println(rowsAfect + " fila(s) actualizada(s) en la tabla " + tName);
            System.out.println("13--> COMPLETADO");
        }catch (SQLException e){
            throw new SQLException("13--> ERROR\n" + e.getMessage());
        }
    }

    private static void eliminarEmplePorId(Connection con, String tName)throws SQLException{
        System.out.println("14--> Metodo eliminarEmplePorId");
        try{
            System.out.println("Dame el id del empleado que quiere borrar:");
            int intID = new Scanner(System.in).nextInt();

            PreparedStatement pr = con.prepareStatement("delete from " + tName + " where emp_id=?;");
            pr.setInt(1, intID);

            intID = pr.executeUpdate();

            System.out.println(intID + " Fila(s) afectadas");
            System.out.println("14--> COMPLETADO");
        }catch (SQLException e){
            throw new SQLException("14--> ERROR\n" + e.getMessage());
        }
    }
}
