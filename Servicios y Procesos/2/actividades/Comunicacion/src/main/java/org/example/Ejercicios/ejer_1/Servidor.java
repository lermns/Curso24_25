package org.example.Ejercicios.ejer_1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Servidor {
    private Socket socket;
    private ServerSocket serverSocket;
    private DataInputStream bufferDeEntrada = null;
    private DataOutputStream bufferDeSalida = null;

    public void levantarConexion(int puerto) {
        try {
            serverSocket = new ServerSocket(puerto);
            mostrarTexto("Esperando conexión entrante en el puerto " + puerto + "...");
            socket = serverSocket.accept();
            mostrarTexto("Conexión establecida con: " + socket.getInetAddress().getHostName() + "\n\n\n");
        } catch (Exception e) {
            mostrarTexto("Error en levantarConexion(): " + e.getMessage());
            System.exit(0);
        }
    }
    public void flujos() {
        try {
            bufferDeEntrada = new DataInputStream(socket.getInputStream());
            bufferDeSalida = new DataOutputStream(socket.getOutputStream());
            bufferDeSalida.flush();
        } catch (IOException e) {
            mostrarTexto("Error en la apertura de flujos");
        }
    }

    public String recibirDatos() {
        String st = "";
        try {
                st = bufferDeEntrada.readUTF();
                mostrarTexto("\n[Cliente] => " + st);
        } catch (IOException e) {
            cerrarConexion();
        }
        return st;
    }


    public void enviar(String s) {
        try {
            bufferDeSalida.writeUTF(s);
            bufferDeSalida.flush();
        } catch (IOException e) {
            mostrarTexto("Error en enviar(): " + e.getMessage());
        }
    }

    public static void mostrarTexto(String s) {
        System.out.print(s);
    }

    public void escribirDatos(String s) {
        System.out.print("[Usted] => " + s);
        enviar(s);
    }

    public void cerrarConexion() {
        try {
            bufferDeEntrada.close();
            bufferDeSalida.close();
            socket.close();
        } catch (IOException e) {
            mostrarTexto("Excepción en cerrarConexion(): " + e.getMessage());
        } finally {
            mostrarTexto("\nConversación finalizada....");
            System.exit(0);
        }
    }

    public void ejecutarConexion(int puerto) {
        Thread hilo = new Thread(() -> {
            while (true) {
                try {
                    levantarConexion(puerto);
                    flujos();
                    tratamientoNotas(recibirDatos());
                    escribirDatos("Alumnos Guardados..!");
                } finally {
                    cerrarConexion();
                }
            }
        });
        hilo.start();
    }
    public static void main(String[] args) throws IOException {
        Servidor s = new Servidor();
        Scanner sc = new Scanner(System.in);

        mostrarTexto("Ingresa el puerto [5050 por defecto]: ");
        String puerto = sc.nextLine();
        if (puerto.length() <= 0) puerto = "5050";
        s.ejecutarConexion(Integer.parseInt(puerto));
    }

    private void tratamientoNotas(String notas){
        System.out.println("\nMetodo Tratamiento notas: ");
        String[] arryNotas = notas.split("-");
        List<String> listNotasAprob = Stream.of(arryNotas).filter(x -> Integer.parseInt(x.split(" ")[1])>=5).toList();

        try(BufferedWriter bfw = new BufferedWriter(new FileWriter("src/main/java/org/example/Ejercicios/ejer_1/aprobados.txt"))){
            for (String s : listNotasAprob){
                bfw.write(s);
                bfw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero...!");
        }
    }
}
