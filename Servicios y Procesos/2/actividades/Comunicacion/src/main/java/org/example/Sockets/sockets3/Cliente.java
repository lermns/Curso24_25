/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Sockets.sockets3;

/**
 *
 * @author achil
 */
import java.io.*;
import java.net.*;
 
public class Cliente {
 
    private static String HOST = "localhost";
    private static int PUERTO = 1234;
 
    public static void main(String args[]) {
         
        Socket socket;
        DataOutputStream mensaje;
         
        try {
            //Creamos nuestro socket
            socket = new Socket(HOST, PUERTO);
            System.out.println("Cliente 1");
            mensaje = new DataOutputStream(socket.getOutputStream());
            System.out.println("Cliente 2");
            //Enviamos un mensaje
            mensaje.writeUTF("Hola soy un cliente!!");
            System.out.println("Cliente 3");
            //Cerramos la conexión
            socket.close();
 
        } catch (UnknownHostException e) {
            System.out.println("El host no existe o no está activo.");
        } catch (IOException e) {
            System.out.println("Error de entrada/salida.");
        }
         
    }
}
