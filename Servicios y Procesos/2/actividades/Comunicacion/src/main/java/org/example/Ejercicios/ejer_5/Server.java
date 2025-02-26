package org.example.Ejercicios.ejer_5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
    private ServerSocket serverSocket;
    private static int cont=1;
    private static final File fichero =  new File("src/main/java/org/example/Ejercicios/ejer_5/servidorMensajes/Mensajes.txt");

    private void ejecutarServidor(){
        try{
            serverSocket = new ServerSocket(5050);
            System.out.println("Esperando conexion con el servidor en el puerto 5050...");

            while (true){
                Socket socket = serverSocket.accept();
                String s = "C"+cont++;
                System.out.println("Conexión establecida con: " + s + "\n\n\n");
                new Thread(()->{
                    recibir(socket, s);
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
                if(escribirMensaje(sb.toString(), name)){
                    dos.writeUTF("OK");
                }else
                    System.out.println("Problema al escribir en el fichero");
                dos.flush();
            }
        } catch (IOException e) {
            System.out.println("error comunicación con cliente: " + e.getMessage());
        }
    }

    private boolean escribirMensaje(String s, String name){
        if (!fichero.exists()){
            try {
                fichero.createNewFile();
            } catch (IOException e) {
                System.out.println("Problema al crear el fichero...!");
                return false;
            }
        }

        try(FileWriter pr = new FileWriter(fichero, true)){
            pr.write(name + "::\n\t\t " + s);
            return true;
        }catch (IOException e){
            System.out.println("Problema al escribir en el fichero... " + e.getMessage());
        }
        return false;
    }



    public static void main(String[] args) {
        new Server().ejecutarServidor();
    }
}
