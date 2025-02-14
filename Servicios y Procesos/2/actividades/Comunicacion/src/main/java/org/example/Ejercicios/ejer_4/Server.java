package org.example.Ejercicios.ejer_4;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.TreeMap;

public class Server {
    private ServerSocket serverSocket;
    private TreeMap<String, DataOutputStream> listClientes;

    private void ejecutarServidor(){
        try{
            serverSocket = new ServerSocket(5050);
            System.out.println("Esperando conexion con el servidor en el puerto 5050...");
            listClientes = new TreeMap<>();
            int cont=1;

            while (true){
                Socket socket = serverSocket.accept();
                String s = "C"+cont++;
                System.out.println("Conexión establecida con: " + s + "\n\n\n");
                Thread hiloCliente = new Thread(new ServerExec(socket, s, this));
                listClientes.put(s, new DataOutputStream(socket.getOutputStream()));
                hiloCliente.start();
            }
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }

    public TreeMap<String, DataOutputStream> getListClientes() {
        return listClientes;
    }

    public boolean enviarMensajeCliente(String s){
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
