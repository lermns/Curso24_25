package org.example.Ejercicios.ejer_5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
    private ServerSocket serverSocket;
    private static int cont=1;
    private static final File fichero =  new File("src/main/java//nsajes/Mensajes.txt");
    //  src/main/java/org/example/Ejercicios/ejer_5/servidorMensajes/Mensajes.txt
    private String name="";

    private void ejecutarServidor(){
        try{
            serverSocket = new ServerSocket(5050);
            System.out.println("Esperando conexion con el servidor en el puerto 5050...");

            while (true){
                Socket socket = serverSocket.accept();
                name = "C"+cont++;
                System.out.println("Conexión establecida con: " + name + "\n\n\n");
                new Thread(()->{
                    recibir(socket, name);
                }).start();
            }
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }

    private void recibir(Socket sock, String name){
        StringBuilder sb = new StringBuilder();
        DataInputStream dis;
        DataOutputStream dos;
        try {
            dis = new DataInputStream(sock.getInputStream());
            dos = new DataOutputStream(sock.getOutputStream());
            while (true) {
                sb.append(dis.readUTF());
                System.out.println("\n[Cliente-" + name + "] => " + sb);
                sb.insert(0, new Date() + " -> ");
                dos.writeUTF(escribirMensaje(sb.toString(), name));
                dos.flush();
                sb.setLength(0);
            }
        } catch (IOException e) {
            System.out.println("error comunicación con cliente: " + e.getMessage());
        }
    }

    private synchronized String escribirMensaje(String s, String name){
        String mensjConf;
        try {
            if (fichero.createNewFile()){
                System.out.println("Fichero creado");
            }
        } catch (IOException e) {
            System.out.println("Problema al crear el fichero...!");
        }

        try(FileWriter pr = new FileWriter(fichero, true)){
            pr.write(name + "\t\t " + s + "\n");
            return "OK";
        }catch (IOException e){
            System.out.println("Problema al escribir en el fichero... ");
            mensjConf=name+"::KO::"+e.getMessage();
        }
        return mensjConf;
    }



    public static void main(String[] args) {
        new Server().ejecutarServidor();
    }
}
