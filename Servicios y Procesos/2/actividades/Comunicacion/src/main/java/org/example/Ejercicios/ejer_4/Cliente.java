package org.example.Ejercicios.ejer_4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;

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
                    //System.out.print("\n[SERVIDOR] => ");
                    s = dis.readUTF();
                    System.out.println("\n" + s);
                    System.out.print("\n[CLIENTE] => ");
                }catch (IOException ioe){
                    System.out.println(ioe.getMessage());
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        new Cliente().ejecutarSocket();
    }
}