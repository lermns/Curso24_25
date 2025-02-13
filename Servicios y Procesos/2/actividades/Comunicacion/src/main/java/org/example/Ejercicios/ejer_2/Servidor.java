package org.example.Ejercicios.ejer_2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
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
                listClientes.add(hiloExec);
                hiloExec.start();
                listClientes.forEach(x -> System.out.println(x.getName()));
            }
        }catch (IOException ioe){
            System.out.println("error al iniciar el servidor...");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        int puerto = 5050;
        Servidor servidor = new Servidor();
        servidor.ejecutarServidor(puerto);
    }
}
