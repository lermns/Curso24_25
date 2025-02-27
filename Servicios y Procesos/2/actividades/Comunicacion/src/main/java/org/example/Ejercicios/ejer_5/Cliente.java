package org.example.Ejercicios.ejer_5;

import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Cliente {
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private static final File fichero =  new File("src/main/java/org/example/Ejercicios/ejer_5/ClienteErrores");

    private void ejecutarSocket(){
        try {
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
                    s = tratarResp(s);
                    System.out.println("\n" + s);
                    System.out.print("\n[CLIENTE] => ");
                }catch (IOException ioe){
                    System.out.println(ioe.getMessage());
                }
            }
        }).start();
    }

    private synchronized void escribirMensaje(String s, String name){
        File FicheroCliente = new File(fichero + File.separator + name + ".txt");

        try {
            if (FicheroCliente.createNewFile()){
                System.out.println("Se ha creado el fichero.");
            }
        } catch (IOException e) {
            System.out.println("Problema al crear el fichero...!");
        }

        try(FileWriter pr = new FileWriter(FicheroCliente, true)){
            pr.write(name + " " + new Date() + "::\n\t\t " + s + "\n");
        }catch (IOException e){
            System.out.println("Problema al escribir en el fichero... " + e.getMessage());
        }
    }

    private String tratarResp(String s){
        if (!s.contains("::")){
            return s;
        }
        String[] resumenCont = s.split("::");
        escribirMensaje(resumenCont[2], resumenCont[0]);

        return resumenCont[1];
    }

    public static void main(String[] args) {
        new Cliente().ejecutarSocket();
    }
}