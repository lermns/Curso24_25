package org.example.Ejercicios.ejer_3;

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
        } catch (IOException e) {
            System.out.println("Error al iniciar conexión con el servidor.");
            cerrarConexion();
        }
    }

    private void enviar() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Contraseña => ");
            String credenciales = sc.nextLine();
            bos.writeUTF(credenciales);
            bos.flush();

            // Esperamos la respuesta del servidor
            String respuesta = bis.readUTF();
            System.out.println("[Servidor] " + respuesta);

            if (respuesta.startsWith("err::")) {
                cerrarConexion();
                return;
            }

            while (true) {
                System.out.print("\nMensaje => ");
                String mensaje = sc.nextLine();

                if (mensaje.equals("fin()")) {
                    cerrarConexion();
                    break;
                }

                bos.writeUTF(mensaje);
                bos.flush();
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

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.ejecutarCliente("127.0.0.1", 5050);
        cliente.enviar();
    }
}
