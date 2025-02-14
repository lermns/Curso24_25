package org.example.Ejercicios.PruebaPropia;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

public class Servidor {
    private ServerSocket serverSocket;
    private ArrayList<Thread> listClientes = new ArrayList<>();

    private void ejecutarServidor(int puerto){
        try{
            serverSocket = new ServerSocket(puerto);
            System.out.println("Esperando conexión entrante en el puerto " + puerto + "...");

            while (true){
                //  para coger todos los clientes que se conecten
                Socket socket = serverSocket.accept();
                System.out.println("Conexión establecida con: " + socket.getInetAddress() + "\n\n\n");

                Thread hiloExec = new Thread(new ServerExec(socket));
                hiloExec.start();
                listClientes.add(hiloExec);
                //listClientes.forEach(x -> System.out.println(x.getName()));
            }
        }catch (IOException ioe){
            System.out.println("error al iniciar el servidor...");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Servidor().ejecutarServidor(5050);
    }
}
