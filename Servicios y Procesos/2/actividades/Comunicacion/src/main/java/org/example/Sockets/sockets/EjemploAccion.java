package org.example.Sockets.sockets;

import java.io.*;
import java.security.PrivilegedAction; 

public class EjemploAccion implements PrivilegedAction { 
      
      public Object run() { 
            
            File f = new File("fichero.txt"); 
            if (f.exists()) { 
                  
                  System.out.println("EL FICHERO EXISTE ... "); 
                  //Si existe se muestra su contenido 
                  FileReader fic; 
                  try { 
                        fic = new FileReader(f); 
                        int i; 
                        System.out.println("Su contenido es: ");
                        while ((i = fic.read()) != -1) 
                             System.out.print((char) i); 
                        fic.close(); 
                  } catch (Exception e) { e.printStackTrace();}
                  
            }else {
                  
                  //Si no existe se crea y se insertan datos 
                  System.out.println("EL FICHERO NO EXISTE, LO CREO ... "); 
                  try { 
                        FileWriter fic = new FileWriter(f); 
                        String cadena = "Esto es una linea de texto"; 
                        fic.append(cadena); fic.close();// cerrar fichero 
                        System.out.println("Fichero creado con datos..."); 
                  } catch (IOException e) { 
                        System.out.println("ERROR ==> " + e.getMessage()); 
                  } 
            }// fin de if 
            
            return null; 
            
      }// Fin de run 
}// Fin de EjemploAccion
