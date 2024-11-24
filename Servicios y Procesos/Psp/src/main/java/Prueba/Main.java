package Prueba;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //long tiempo1 = mostrarContenido1(new File(System.getProperty("user.home") + File.separator + "prueba ejercicio2"));
        //List<Prueba.Documento> listDocs =seleccionContenido(new File(System.getProperty("user.home") + File.separator + "prueba ejercicio2"));

        //listDocs.forEach(System.out::println);
        //escribirDatos(listDocs);

        //List<Prueba.Documento> documentosLeidos = leerDatos();//lee los documentos del archivo
        //documentosLeidos.forEach(System.out::println);//imprime los documentos leidos

        //System.out.println((double)tiempo1/1000);//el metodo 1 tarda mas en procesar
        //System.out.println((double)tiempo2/1000);//el metodo 2 tarda menos
        //mostrarContenido2(new File(System.getProperty("user.home") + File.separator + "prueba ejercicio2"));

        //regular expressions, es necesarios para ciertos caracteres usar 2 barras invertidas para hacer referencia
        //a estos caracteres para poder usarlos dentro del split asi como cierto tipo de patrones que podemos usar para
        //delimitar la condicion.
    }
    /*
    //primera version, tarda un par de milisegundos más
    private static long mostrarContenido1(File directorio){
        long lngInic = System.currentTimeMillis();
        if(directorio.isDirectory()){
            File[] arryFiles = directorio.listFiles();
            if (arryFiles != null) {
                for (File s : arryFiles) {
                    mostrarContenido1(s);
                }
            }
        }else if(directorio.isFile()) {
            String[] arryTipo = directorio.getName().split("\\.");
            String valor = arryTipo[arryTipo.length-1];
            if(valor.equals("txt") || valor.equals("pdf") || valor.contains("do")){
                System.out.println("\tArchivo --> " + directorio.getName());
            }
        }
        long lngFin = System.currentTimeMillis();

        return lngFin-lngInic;
    }*/
    private static List<Documento> seleccionContenido(File directorio) {
        List<Documento> listDocus = new ArrayList<>();
        //long lngInic = System.currentTimeMillis();
        if (directorio.isDirectory()) {
            File[] archivos = directorio.listFiles();
            if (archivos != null) {
                for (File archivo : archivos) {
                    listDocus.addAll(seleccionContenido(archivo));
                }
            }
        } else if (directorio.isFile()) {
            String nombreArchivo = directorio.getName();
            int indChar = nombreArchivo.lastIndexOf('.');
            if (indChar > 0 && indChar < nombreArchivo.length() - 1) {
                String strExtens = nombreArchivo.substring(indChar + 1);
                if (strExtens.equals("txt") || strExtens.equals("pdf") || strExtens.startsWith("do")) {
                    //System.out.println("\tArchivo --> " + nombreArchivo);
                    listDocus.add(new Documento(nombreArchivo, directorio.getAbsolutePath(),strExtens));
                }
            }
        }
        //listDocus.forEach(System.out::println);
        //long lngFin = System.currentTimeMillis();
        return listDocus;
    }
    private static void escribirDatos(List<Documento> listDocus){
        try(ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(System.getProperty("user.home") + File.separator + "Directorio_prueba" + File.separator + "datos.dat"))){
            for(Documento doc : listDocus){
                oo.writeObject(doc);
            }
            oo.flush();
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }

    private static List<Documento> leerDatos() {
        List<Documento> listDocus = new ArrayList<>();
        try (ObjectInputStream oi = new ObjectInputStream(
                new FileInputStream(System.getProperty("user.home") + File.separator + "Directorio_prueba" + File.separator + "datos.dat"))) {
            while (true) {
                try {
                    Documento doc = (Documento) oi.readObject();
                    listDocus.add(doc);
                } catch (EOFException eof) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("error al leer los datos: " + e.getMessage());
        }
        return listDocus;
    }
}
