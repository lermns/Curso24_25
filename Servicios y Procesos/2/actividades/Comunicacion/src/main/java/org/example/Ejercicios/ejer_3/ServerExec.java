package org.example.Ejercicios.ejer_3;

import java.io.*;
import java.net.Socket;

public class ServerExec implements Runnable{
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private int cont;

    public ServerExec(Socket socket) {
        this.socket = socket;
        try{
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            dos.flush();
        }catch (IOException ioe){
            System.out.println("error en el ejecutador...");
        }
    }

    @Override
    public void run() {
        try {
            String datosRecibidos;
            boolean bandera;
            do {
                //  nos mantenemos a la escucha de mensajes entrantes del cliente para guardarlos
                datosRecibidos = dis.readUTF();
                System.out.println("[Cliente] " + datosRecibidos);

                if (cont==0){
                    bandera = verificarPasswd(datosRecibidos);
                    if (!bandera){
                        dos.writeUTF("err::Passwd incorrecto..!");
                        break;
                    }
                    cont++;
                    dos.writeUTF("Empieza a escribir..!");
                }

                //System.out.println("");

                dos.flush();
            }while (!datosRecibidos.equals("salir()"));
        } catch (IOException e) {
            System.out.println("Error en la comunicación con el cliente: " + e.getMessage());
        } finally {
            cerrarConexion();
        }
    }

    private synchronized boolean verificarPasswd(String s){
        String[] strLinea = s.split("=>");
        try(BufferedReader bfw = new BufferedReader(new FileReader("src/main/java/org/example/Ejercicios/ejer_3/psswd.txt"))){
            String linea;
            while ((linea=bfw.readLine())!=null){
                if (linea.equals(strLinea[1].trim())){
                    return true;
                }
            }
        }catch (IOException ioe){
            System.out.println("error al escribir en el fichero...!");
        }
        return false;
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
