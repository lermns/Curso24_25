package org.example.Ejercicios.ejer_2;

import java.io.*;
import java.net.Socket;

public class ServerExec implements Runnable{
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;

    public ServerExec(Socket socket) {
        this.socket = socket;
        try{
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            dos.flush();
        }catch (IOException ioe){
            System.out.println("error en el ejecutador...");
            cerrarConexion();
        }
    }

    @Override
    public void run() {
        try {
            String datosRecibidos;
            do {
                //  nos mantenemos a la escucha de mensajes entrantes del cliente para guardarlos
                datosRecibidos = dis.readUTF();
                System.out.println("[Cliente] " + datosRecibidos);
                escribirFichero(datosRecibidos);
                System.out.println("Mensaje guardado..!");
                dos.flush();
            }while (!datosRecibidos.equals("salir()"));
        } catch (IOException e) {
            System.out.println("Error en la comunicación con el cliente: " + e.getMessage());
        } finally {
            cerrarConexion();
        }
    }

    private synchronized void escribirFichero(String s){
        try(BufferedWriter bfw = new BufferedWriter(new FileWriter("src/main/java/org/example/Ejercicios/ejer_2/mensajes.txt",true))){
            bfw.write(s);
            bfw.newLine();
        }catch (IOException ioe){
            System.out.println("error al escribir en el fichero...!");
            cerrarConexion();
        }
    }

    private void cerrarConexion() {
        try {
            dis.close();
            dos.close();
            socket.close();
            System.out.println("Cliente desconectado...");
        } catch (IOException e) {
            System.out.println("error al cerrar conexion con el cliente");
        }
    }
}
