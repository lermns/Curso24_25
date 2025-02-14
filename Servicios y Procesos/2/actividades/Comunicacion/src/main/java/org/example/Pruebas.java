package org.example;

import java.net.*;

public class Pruebas {
    public static void main(String[] args) throws SocketException, UnknownHostException {
        String s = "C1:C2:Mensaje";
        System.out.println(s.split(":",2)[1]);
    }
}
