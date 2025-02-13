package org.example.Ejercicios.ejer_2;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    private Socket socket;
    private DataInputStream bis;
    private DataOutputStream bos;

    private void ejecutarCliente(String ip, int puerto){
        try{
            socket = new Socket(ip, puerto);
            bis = new DataInputStream(socket.getInputStream());
            bos = new DataOutputStream(socket.getOutputStream());
            bos.flush();
        }catch (IOException ioe){
            System.out.println("error al iniciar los flujos en Cliente => " + socket.getInetAddress().getHostName());
            cerrarConexion();
        }
    }

    private void enviar() {
        StringBuilder sb = new StringBuilder();
        try{
            while (true) {
                sb.append(socket.getInetAddress());
                sb.append(" => ");
                System.out.print("\nCliente => ");
                Scanner scanner = new Scanner(System.in);
                String linea = scanner.nextLine();

                if (linea.equals("fin()"))System.exit(0);

                sb.append(linea);
                bos.writeUTF(sb.toString());
                bos.flush();
                sb.setLength(0);
            }
        } catch (IOException e) {
            System.out.println("Error al enviar datos: " + e.getMessage());
        } finally {
            cerrarConexion();
        }
    }

    private void cerrarConexion() {
        try {
            bis.close();
            bos.close();
            socket.close();
            System.out.println("Conexión cerrada.");
        } catch (IOException e) {
            System.out.println("Error al cerrar la conexión.");
        }
    }

    public static void main(String[] args) throws IOException {
        Cliente cliente = new Cliente();
        cliente.ejecutarCliente("127.0.0.1", 5050);
        cliente.enviar();
        // 127.0.0.1
        // 127.0.0.2
        // 127.0.0.3
    }
}
