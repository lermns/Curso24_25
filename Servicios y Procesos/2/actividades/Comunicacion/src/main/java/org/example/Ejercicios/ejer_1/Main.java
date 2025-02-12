package org.example.Ejercicios.ejer_1;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.net.Socket;
import java.util.Scanner;

/**
 * El cliente (Profe) pilla los alumnos que hay en un fichero (notasAlumnos.dat),
 * luego se los manda al servidor para que el servidor
 * filtre a los alumnos que tienen mas de un 5 y que los guarde en un fichero llamado Aprobados.txt
 * y luego le mande una connfirmacion al cliente.
 */
public class Main {
    private Socket socketCliente;
    private DataInputStream bufferDeEntrada = null;
    private DataOutputStream bufferDeSalida = null;
    Scanner teclado = new Scanner(System.in);
    final String COMANDO_TERMINACION = "salir()";

    public void levantarConexion(String ip, int puerto) {
        try {
            socketCliente = new Socket(ip, puerto);
            mostrarTexto("Conectado a :" + socketCliente.getInetAddress().getHostName());
        } catch (Exception e) {
            mostrarTexto("Excepción al levantar conexión: " + e.getMessage());
            System.exit(0);
        }
    }

    public static void mostrarTexto(String s) {
        System.out.println(s);
    }

    public void abrirFlujos() {
        try {
            bufferDeEntrada = new DataInputStream(socketCliente.getInputStream());
            bufferDeSalida = new DataOutputStream(socketCliente.getOutputStream());
            bufferDeSalida.flush();
        } catch (IOException e) {
            mostrarTexto("Error en la apertura de flujos");
        }
    }

    public void enviar(String s) {
        try {
            bufferDeSalida.writeUTF(s);
            bufferDeSalida.flush();
        } catch (IOException e) {
            mostrarTexto("IOException on enviar");
        }
    }

    public void cerrarConexion() {
        try {
            bufferDeEntrada.close();
            bufferDeSalida.close();
            socketCliente.close();
            mostrarTexto("Conexión terminada");
        } catch (IOException e) {
            mostrarTexto("IOException on cerrarConexion()");
        }finally{
            System.exit(0);
        }
    }

    public void ejecutarConexion(String ip, int puerto) {
        Thread hilo = new Thread(() -> {
            try {
                levantarConexion(ip, puerto);
                abrirFlujos();
                recibirDatos();
            } finally {
                cerrarConexion();
            }
        });
        hilo.start();
    }

    public void recibirDatos() {
        String st;
        try {
            do {
                st = bufferDeEntrada.readUTF();
                mostrarTexto("\n[Servidor] => " + st);
                System.out.print("\n[Usted] => ");
            } while (!st.equals(COMANDO_TERMINACION));
        } catch (IOException e) {}
    }

    public void escribirDatos() {
        String entrada;
        while (true) {
            System.out.print("[Usted] => ");
            entrada = teclado.nextLine();
            if(!entrada.isEmpty())
                enviar(entrada);
        }
    }
    public static void main(String[] args) {
        //ArrayList<String> listaAlunmos= new ArrayList<>(List.of("Pepe 7", "Sofia 10", "Alan 5", "Juan 4", "Zara 2"));
        //escribir(listaAlunmos);
        Servidor s = new Servidor();
        Scanner sc = new Scanner(System.in);

        mostrarTexto("Ingresa el puerto [5050 por defecto]: ");
        String puerto = sc.nextLine();
        if (puerto.length() <= 0) puerto = "5050";
        s.ejecutarConexion(Integer.parseInt(puerto));
        s.escribirDatos();
        s.enviar(leer());
    }
/*
    private static void escribir(ArrayList<String> listNotas){

        try(BufferedOutputStream bfo = new BufferedOutputStream(new FileOutputStream("src/main/java/org/example/Ejercicios/ejer_1/notasAlumnos.dat"))){
            for (String s : listNotas){
                byte[] arry = s.getBytes();
                for (int i = 0; i < arry.length; i++) {
                    bfo.write(arry[i]);
                    //bfo.write(45);
                }
                bfo.write(45);
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero...!");
        }
    }
*/
    private static String leer(){
        StringBuilder s = new StringBuilder();
        try(BufferedInputStream bfo = new BufferedInputStream(new FileInputStream("src/main/java/org/example/Ejercicios/ejer_1/notasAlumnos.dat"))){
            byte[] arryByte = bfo.readAllBytes();
            for (byte b : arryByte){
                s.append((char)b);
            }
            String[] sSpli = s.toString().split("-");
            //List.of(sSpli).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero...!");
        }
        return s.toString();
    }
}
