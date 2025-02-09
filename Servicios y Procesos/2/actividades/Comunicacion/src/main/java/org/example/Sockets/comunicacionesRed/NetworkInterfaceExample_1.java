package org.example.Sockets.comunicacionesRed;

import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;

public class NetworkInterfaceExample_1 {

    public static void main(String[] args) throws SocketException {
        
        // NetworkInterface implements a static method that returns all the interfaces on the PC,
        // which we add on a list in order to iterate over them.
        ArrayList<NetworkInterface> interfaces = Collections
                .list(NetworkInterface.getNetworkInterfaces());
        
        System.out.println("Printing information about the available interfaces...\n");
        for (NetworkInterface iface : interfaces) {
            
            // Due to the amount of the interfaces, we will only print info
            // about the interfaces that are actually online.
            if (iface.isUp()) {
                
                // Display name
                System.out.println("Interface name: " + iface.getDisplayName());
                
                // Interface addresses of the network interface
                System.out.println("\tInterface addresses: ");
                for (InterfaceAddress addr : iface.getInterfaceAddresses()) {
                    System.out.println("\t\t" + addr.getAddress().toString());
                }
                
                // MTU (Maximum Transmission Unit)
                System.out.println("\tMTU: " + iface.getMTU());
                
                // Subinterfaces
                System.out.println("\tSubinterfaces: " + Collections.list(iface.getSubInterfaces()));
                
                // Check other information regarding the interface
                System.out.println("\tis loopback: " + iface.isLoopback());
                System.out.println("\tis virtual: " + iface.isVirtual());
                System.out.println("\tis point to point: " + iface.isPointToPoint());
            }
        }
    }
}
/*
2. Method explanation
The methods that are used in the above example are the following:

    isUp(): Checks if the interface is up and running.
    getDisplayName(): Returnsthe display name of the interface.
    isLoopback(): Returns a boolean, showing if it is a loopback interface.
    isVirtual(): Returns a boolean, showing if it is a virtualinterface.
    isPointToPoint(): Returns a boolean, showing if it is a point to point interface.
    getSubInterfaces(): Returns a list of all the sub-interfaces of the network 
                        interface, or an empty list if no sub-interfaces are defined.
    getMTU(): Returns the Maximum Transfer Unit of the interface.
    getInterfaceAddresses(): Returns a list of all the interfaces addresses that
                            belong to the network interface, most commonly an 
                            IPv4 and an IPv6 address.
*/