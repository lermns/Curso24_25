package org.example.Ejercicios.ejer_5;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private static final File fichero =  new File("src/main/java/org/example/Ejercicios/ejer_5/ClienteErrores");
    private static int cont=1;
    private String name;

    private void ejecutarSocket(){
        try {
            name += "C"+cont++;
            socket = new Socket("localhost", 5050);
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            dos.flush();
            enviar();
            recibir();
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }

    private void enviar(){
        new Thread(()->{
            while (true){
                String s;
                try {
                    System.out.print("\n[CLIENTE] => ");
                    s = new Scanner(System.in).nextLine();
                    dos.writeUTF(s);
                    dos.flush();
                }catch (IOException ioe){
                    System.out.println(ioe.getMessage());
                }
            }
        }).start();
    }

    private void recibir(){
        new Thread(()->{
            String s;
            while (true){
                try {
                    s = dis.readUTF();
                    System.out.println("\n" + s);
                    System.out.print("\n[CLIENTE] => ");
                }catch (IOException ioe){
                    System.out.println(ioe.getMessage());
                }
            }
        }).start();
    }

    private boolean escribirMensaje(String s){
        File FicheroCliente = new File(fichero + File.separator + name + ".txt");
        if (!FicheroCliente.exists()){
            try {
                FicheroCliente.createNewFile();
            } catch (IOException e) {
                System.out.println("Problema al crear el fichero...!");
                return false;
            }
        }

        try(FileWriter pr = new FileWriter(FicheroCliente, true)){
            pr.write(name + "::\n\t\t " + s);
            return true;
        }catch (IOException e){
            System.out.println("Problema al escribir en el fichero... " + e.getMessage());
        }
        return false;
    }

    public static void main(String[] args) {
        new Cliente().ejecutarSocket();
    }
}