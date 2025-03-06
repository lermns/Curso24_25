package org.example.Encriptacion.Pruebas.prueba1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.PublicKey;
import java.security.Signature;
import java.util.TreeMap;

public class Server {
    private ServerSocket serverSocket;
    private TreeMap<String, DataOutputStream> listClientes;
    private static int cont=1;

    private void ejecutarServidor(){
        try{
            serverSocket = new ServerSocket(5050);
            System.out.println("Esperando conexion con el servidor en el puerto 5050...");
            listClientes = new TreeMap<>();

            while (true){
                Socket socket = serverSocket.accept();
                String s = "C"+cont++;
                System.out.println("Conexión establecida con: " + s + "\n\n\n");
                listClientes.put(s, new DataOutputStream(socket.getOutputStream()));
                new Thread(()->{
                    recibir(socket, s);
                }).start();
            }
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }

    private void recibir(Socket sock, String name){
        String datosRecibidos;
        DataInputStream dis;
        DataOutputStream dos;
        try {
            dis = new DataInputStream(sock.getInputStream());
            dos = new DataOutputStream(sock.getOutputStream());
            while (true) {
                datosRecibidos = dis.readUTF();
                System.out.println("\n[Cliente] => " + datosRecibidos);
                String[] rec = datosRecibidos.split(":");
                //  Destino:Remitente:Mensaje
                if (rec.length==2) {
                    datosRecibidos = rec[0] + ":" + name + ":" + rec[1];
                    if (!enviarMensajeCliente(datosRecibidos)) {
                        dos.writeUTF(rec[0] + " no existe");
                    }
                }else
                    dos.writeUTF("Formato no  válido.");
                dos.flush();
            }
        } catch (IOException e) {
            System.out.println("error comunicación con cliente: " + e.getMessage());
        }
    }



    private boolean enviarMensajeCliente(String s){
        DataOutputStream dos = listClientes.get(s.split(":")[0]);
        if (dos!=null){
            try {
                dos.writeUTF("\n" + s.split(":",2)[1]);
                dos.flush();
                return true;
            }catch (IOException ioe){
                System.out.println(ioe.getMessage());
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new Server().ejecutarServidor();
    }
}
