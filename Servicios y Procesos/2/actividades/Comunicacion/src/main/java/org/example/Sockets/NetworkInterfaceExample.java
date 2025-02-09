package org.example.Sockets;

import java.net.*;
import java.util.ArrayList;
import java.util.Collections;

public class NetworkInterfaceExample {

    public static void main(String[] args) throws SocketException {
        
        // NetworkInterface implementa un método estático que devuelve todas las interfaces del PC,
        // las cuales podemos añadir a la lista en lugar de iterar sobre ellas.
        ArrayList<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
        
        System.out.println("Printing information about the available interfaces...\n");
        for (NetworkInterface iface : interfaces) {
            
            // Debido a la cantidad de interfaces, solo imprimiremos información
            // sobre las interfaces que están realmente en línea
            if (iface.isUp()) {
                
                // mostramos el nombre
                System.out.println("Interface name: " + iface.getDisplayName());
                
                // Direcciones de interfaz de la interfaz de red
                System.out.println("\tInterface addresses: ");
                for (InterfaceAddress addr : iface.getInterfaceAddresses()) {
                    System.out.println("\t\tZZ->" + addr.getAddress().toString());
                }
                
                // MTU (Maximum Transmission Unit)
                System.out.println("\tMTU: " + iface.getMTU());
                
                // Subinterfaces
                ArrayList<NetworkInterface> nwi = Collections.list(iface.getSubInterfaces());
                System.out.println("\tSubinterfaces: ");
                nwi.forEach(x -> System.out.println("\t\tsub" + x));
                
                // Consultar otra información sobre la interfaz
                System.out.println("\tis loopback: " + iface.isLoopback());
                System.out.println("\tis virtual: " + iface.isVirtual());
                System.out.println("\tis point to point: " + iface.isPointToPoint());
            }
        }
    }
}