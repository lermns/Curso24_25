package org.example.Ejercicios.Calculadora;

import java.io.*;
import java.net.*;

public class Server {
    private ServerSocket serverSocket;

    private void ejecutarServidor() {
        try {
            serverSocket = new ServerSocket(5050);
            System.out.println("Esperando conexion con el servidor en el puerto 5050...");
            Socket socket = serverSocket.accept();
            System.out.println("Conexión establecida");
            recibir(socket);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    private void recibir(Socket sock) {
        String datosRecibidos;
        try (DataInputStream dis = new DataInputStream(sock.getInputStream());
             DataOutputStream dos = new DataOutputStream(sock.getOutputStream())) {
            while (true) {
                datosRecibidos = dis.readUTF();
                System.out.println("[Cliente] => " + datosRecibidos);
                String resultado = calcularOperacion(datosRecibidos);
                dos.writeUTF(resultado);
                dos.flush();
            }
        } catch (IOException e) {
            System.out.println("Error en la comunicación con el cliente: " + e.getMessage());
        }
    }

    private String calcularOperacion(String operacion) {
        try {
            String[] partes = operacion.split(",");
            if (partes.length != 3) return "formato no válido, usa: num1,num2,operador";

            double num1 = Double.parseDouble(partes[0]);
            double num2 = Double.parseDouble(partes[1]);
            String operador = partes[2].trim();

            switch (operador) {
                case "+": return "resultado: " + (num1 + num2);
                case "-": return "resultado: " + (num1 - num2);
                case "*": return "resultado: " + (num1 * num2);
                case "/": return (num2 != 0) ? "resultado: " + (num1 / num2) : "error: División por 0";
                default: return "operador inválido. Usa +, -, * o /";
            }
        } catch (NumberFormatException e) {
            return "error: Entrada no válida";
        }
    }

    public static void main(String[] args) {
        new Server().ejecutarServidor();
    }
}
