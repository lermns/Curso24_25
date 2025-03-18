package org.example.Examen.actividad_1;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;

    private void ejecutarSocket(){
        try {
            //  abrimos los flujos y conectamos el socket al server
            socket = new Socket("localhost", 5050);
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            dos.flush();
            enviar();
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }

    private void enviar(){
        new Thread(()->{
            while (true){
                String s;
                try {
                    //  mostramos el menu cada que vayamos a escribir algo
                    menu();
                    System.out.print("\n[CLIENTE] => ");
                    s = new Scanner(System.in).nextLine();
                    //  enviamos el texto al servidor
                    dos.writeUTF(s);
                    dos.flush();
                    //  solo se mostrara el contenido del server cada que el cliente escriba, caso contrario no
                    recibir();

                    //  en caso se escriba salir este en el server cierra los flujos y tambien se cierra el cliente
                    if (s.equals("salir")){
                        cerrarConexion();
                        break;
                    }
                }catch (IOException ioe){
                    System.out.println(ioe.getMessage());
                }
            }
        }).start();
    }

    private void recibir(){
        String s;
        try {
            //  como solo se recibe en casos concretos solo se le llama cuando es necesario
            s = dis.readUTF();
            System.out.println("\n[SERVER] => " + s);
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }

    private void menu(){
        //  bloque de texto del menu
        System.out.println("""
                1. Guardar mensaje -> guardar:mensaje
                2. Leer mensajes -> leer
                3. Borrar mensajes -> borrar
                4. Salir -> salir
                """);
    }

    private void cerrarConexion() {
        try {
            //  metodo para cerrar los flujos
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