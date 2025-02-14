package org.example.Ejercicios.PruebaPropia;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    private Socket socket;
    private DataInputStream bis;
    private DataOutputStream bos;

    private void ejecutarCliente(String ip, int puerto) {
        try {
            socket = new Socket(ip, puerto);
            bis = new DataInputStream(socket.getInputStream());
            bos = new DataOutputStream(socket.getOutputStream());
            bos.flush();

            recibir();
            new Thread(this::enviar).start();
        } catch (IOException e) {
            System.out.println("Error al iniciar conexión con el servidor.");
            cerrarConexion();
        }
    }

    private void enviar() {
        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                System.out.print("[CLIENTE] => ");
                String credenciales = sc.nextLine();
                bos.writeUTF(credenciales);
                bos.flush();
            }
        } catch (IOException e) {
            System.out.println("Error al enviar datos: " + e.getMessage());
        } finally {
            cerrarConexion();
        }
    }

    private void recibir(){
        new Thread(()->{
            try {
                String s;
                while (true) {
                    s = bis.readUTF();
                    System.out.println("\n[SERVER] => " + s);
                    System.out.print("[CLIENTE] => ");
                }
            } catch (IOException e) {
                System.out.println("Error al enviar datos: " + e.getMessage());
            } finally {
                cerrarConexion();
            }
        }).start();
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

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.ejecutarCliente("127.0.0.1", 5050);
    }
}
