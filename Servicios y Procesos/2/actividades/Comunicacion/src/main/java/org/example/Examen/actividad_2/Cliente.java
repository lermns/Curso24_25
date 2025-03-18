package org.example.Examen.actividad_2;

import java.io.*;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Cliente {
    private Socket socket; // Socket para la conexión con el servidor
    private DataInputStream dis; // Para recibir datos del servidor
    private DataOutputStream dos; // Para enviar datos al servidor
    private MessageDigest md; // Para generar el hash SHA del mensaje

    //   Método que establece la conexión con el servidor.
    private void ejecutarSocket() {
        try {
            socket = new Socket("localhost", 5050); // Conecta con el servidor en el puerto 5050
            dis = new DataInputStream(socket.getInputStream()); // Flujo de entrada
            dos = new DataOutputStream(socket.getOutputStream()); // Flujo de salida
            dos.flush(); // Limpia el buffer de salida
            md = MessageDigest.getInstance("SHA"); // Inicializa el algoritmo de hashing SHA
            enviar(); // Inicia el proceso de envío de mensajes
            recibir(); // Inicia el proceso de recepción de mensajes
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Problema con el algoritmo: " + e.getMessage());
        }
    }

    //   Método que envía mensajes al servidor en un hilo separado.
    private void enviar() {
        new Thread(() -> {
            while (true) {
                String s;
                byte[] dataBytes;
                byte[] resumen;
                try {
                    System.out.print("\n[CLIENTE] => ");
                    s = new Scanner(System.in).nextLine(); // Captura el mensaje del usuario

                    dataBytes = s.getBytes(); // Convierte el mensaje en bytes
                    md.update(dataBytes); // Introduce los bytes en el algoritmo SHA
                    resumen = md.digest(); // Genera el hash del mensaje

                    dos.writeUTF(s); // Envía el mensaje al servidor

                    // Si se quiere simular un error en la verificación del hash, descomentar esta línea:
                    // dos.writeUTF(s + "ad");

                    dos.writeUTF(Hexadecimal(resumen)); // Envía el hash en formato hexadecimal
                    if (s.equals("salir")) { // Si el mensaje es "salir", se cierra la conexión
                        cerrarConexion();
                        break;
                    }
                    dos.flush(); // Limpia el buffer de salida
                } catch (IOException ioe) {
                    System.out.println(ioe.getMessage());
                }
            }
        }).start(); // Inicia el hilo para el envío de datos
    }


     //   Método que recibe mensajes del servidor en un hilo separado.
    private void recibir() {
        new Thread(() -> {
            String s;
            while (true) {
                try {
                    s = dis.readUTF(); // Recibe el mensaje del servidor
                    System.out.println("\n" + s);
                    System.out.print("\n[CLIENTE] => ");
                } catch (IOException ioe) {
                    System.out.println(ioe.getMessage());
                    cerrarConexion(); // Si hay un error, se cierra la conexión
                    break;
                }
            }
        }).start(); // Inicia el hilo para la recepción de datos
    }

     //   Método que convierte un array de bytes en una cadena hexadecimal.
    private static String Hexadecimal(byte[] resumen) {
        String hex = "";
        for (int i = 0; i < resumen.length; i++) {
            String h = Integer.toHexString(resumen[i] & 0xFF); // Convierte cada byte a hexadecimal
            if (h.length() == 1)
                hex += "0"; // Agrega un cero si el valor es de un solo dígito
            hex += h;
        }
        return hex.toUpperCase(); // Devuelve el hash en mayúsculas
    }

    //   Método que cierra la conexión con el servidor.
    public void cerrarConexion() {
        try {
            dis.close();
            dos.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Excepción en cerrarConexion(): " + e.getMessage());
        } finally {
            System.out.println("Escritura finalizada");
        }
    }

    public static void main(String[] args) {
        new Cliente().ejecutarSocket();
    }
}
