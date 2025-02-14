package org.example.Ejercicios.ejer_3;

import java.io.*;
import java.net.Socket;

public class ServerExec implements Runnable {
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private boolean autenticado = false;

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
        try {
            String datosRecibidos;
            while (true) {
                datosRecibidos = dis.readUTF();

                if (!autenticado) {
                    if (verificarPasswd(datosRecibidos)) {
                        autenticado = true;
                        dos.writeUTF("Puede escribir.");
                    } else {
                        dos.writeUTF("err::passwd incorrecto");
                        cerrarConexion();
                        return;
                    }
                }
                System.out.println("[Cliente] => " + datosRecibidos);
                dos.flush();
            }
        } catch (IOException e) {
            System.out.println("error comunicación con cliente: " + e.getMessage());
        } finally {
            cerrarConexion();
        }
    }

    private boolean verificarPasswd(String s) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/org/example/Ejercicios/ejer_3/psswd.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.equals(s)) {
                    return true;
                }
            }
        } catch (IOException ioe) {
            System.out.println("error verificar Passwd");
        }
        return false;
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
