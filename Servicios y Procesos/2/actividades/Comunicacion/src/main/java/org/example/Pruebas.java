package org.example;

import java.net.*;

public class Pruebas {
    public static void main(String[] args) throws SocketException, UnknownHostException {
        //DatagramSocket socketServidor = new DatagramSocket();
        InetAddress ia = InetAddress.getLocalHost();
        String host = ia.getHostAddress();
        System.out.println(host);
    }
}
