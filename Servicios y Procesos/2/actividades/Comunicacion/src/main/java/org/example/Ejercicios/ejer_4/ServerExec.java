package org.example.Ejercicios.ejer_4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerExec implements Runnable {
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private Server server;
    private String name;

    public ServerExec(Socket socket, String name, Server server) {
        this.socket = socket;
        try {
            this.name = name;
            this.server = server;
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            dos.flush();
        } catch (IOException ioe) {
            System.out.println("Error en el ejecutador...");
        }
    }

    @Override
    public void run() {
        recibir();
    }

    private void recibir(){
        try {
            String datosRecibidos;
            while (true) {
                datosRecibidos = dis.readUTF();
                System.out.println("\n[Cliente] => " + datosRecibidos);
                String[] rec = datosRecibidos.split(":");
                //  Destino:Remitente:Mensaje
                if (rec.length==2) {
                    datosRecibidos = rec[0] + ":" + name + ":" + rec[1];
                    if (!server.enviarMensajeCliente(datosRecibidos)) {
                        dos.writeUTF(rec[0] + " no existe");
                    }
                }else
                    dos.writeUTF("");
                dos.flush();
            }
        } catch (IOException e) {
            System.out.println("error comunicación con cliente: " + e.getMessage());
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
