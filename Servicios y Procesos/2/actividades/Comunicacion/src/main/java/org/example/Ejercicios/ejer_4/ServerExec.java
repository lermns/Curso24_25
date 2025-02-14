package org.example.Ejercicios.ejer_4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ServerExec implements Runnable {
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;

    public ServerExec(Socket socket) {
        this.socket = socket;
        try {
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            dos.flush();
        } catch (IOException ioe) {
            System.out.println("Error en el ejecutador...");
        }
    }

    @Override
    public void run() {
        new Thread(this::enviar).start();
        recibir();
    }

    private void recibir(){
        try {
            String datosRecibidos;
            while (true) {
                datosRecibidos = dis.readUTF();
                System.out.println("\n[Cliente] => " + datosRecibidos);
                System.out.print("[SERVER] => ");
            }
        } catch (IOException e) {
            System.out.println("error comunicación con cliente: " + e.getMessage());
        } finally {
            cerrarConexion();
        }
    }

    public void enviar(){
        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                System.out.print("[SERVER] => ");
                String credenciales = sc.nextLine();
                dos.writeUTF(credenciales);
                dos.flush();
            }
        } catch (IOException e) {
            System.out.println("Error al enviar datos: " + e.getMessage());
        } finally {
            cerrarConexion();
        }
    }

    private void cerrarConexion() {
        try {
            dis.close();
            dos.close();
            socket.close();
            System.out.println("cliente cerrado");
        } catch (IOException e) {
            System.out.println("error cerrar Conexion");
        }
    }
}
