package org.example.Examen.actividad_2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Server {
    private ServerSocket serverSocket;  // Servidor que escucha conexiones de clientes
    private static final File fichero = new File("src/main/java/org/example/Examen/actividad_2/servidorMensajes/ejercicio2.txt");
    // Archivo donde se almacenarán los mensajes recibidos

    private DataInputStream dis;  // Para leer datos del cliente
    private DataOutputStream dos; // Para enviar datos al cliente
    private Socket socket; // Socket del cliente conectado

    //Método que inicia el servidor y espera conexiones de clientes.
    private void ejecutarServidor(){
        try{
            serverSocket = new ServerSocket(5050);  // Se inicia el servidor en el puerto 5050
            System.out.println("Esperando conexion con el servidor en el puerto 5050...");

            socket = serverSocket.accept();  // Espera hasta que un cliente se conecte
            String name = "C1";  // Nombre asignado al cliente
            System.out.println("Conexión establecida con: " + name + "\n\n\n");

            // Se crean los flujos de entrada y salida para comunicarse con el cliente
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());

            recibir(name);  // Se inicia la comunicación con el cliente
        } catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }


    //  Método que recibe mensajes del cliente y los procesa.
    private void recibir(String name){
        String s;  // Mensaje recibido
        String cifrado;  // Hash del mensaje recibido
        try {
            while (true) {
                s = dis.readUTF();  // Se lee el mensaje enviado por el cliente
                cifrado = dis.readUTF();  // Se lee el hash enviado por el cliente

                if (s.equals("salir")){  // Si el cliente envía "salir", se cierra la conexión
                    cerrarConexion();
                    break;
                }

                if (descifrado(cifrado, s)) {  // Se verifica la integridad del mensaje comparando su hash
                    System.out.println("\n[Cliente-" + name + "] => " + s);
                    if (s.length() > 20) {  // Si el mensaje tiene más de 20 caracteres, se guarda en el archivo
                        dos.writeUTF(escribirMensaje(s));
                    } else {
                        dos.writeUTF("Longitud no válida.");  // Se rechazan mensajes cortos
                    }
                } else {
                    System.out.println("Mensaje no válido.");
                    dos.writeUTF("Mensaje alterado");  // Si el hash no coincide, el mensaje ha sido modificado
                }
                dos.flush();  // Se vacía el buffer de salida
            }
        } catch (IOException e) {
            System.out.println("Error comunicación con cliente: " + e.getMessage());
        }
    }


     // Método que escribe el mensaje recibido en un archivo de texto.
    private synchronized String escribirMensaje(String s){
        String mensjConf;
        try {
            if (fichero.createNewFile()){  // Si el archivo no existe, se crea
                System.out.println("Fichero creado");
            }
        } catch (IOException e) {
            System.out.println("Problema al crear el fichero...!");
        }

        try(FileWriter pr = new FileWriter(fichero, true)){  // Se abre el archivo en modo append (agregar contenido)
            pr.write(s + "\n");  // Se escribe el mensaje en el archivo
            return "OK";  // Se envía una confirmación al cliente
        } catch (IOException e){
            System.out.println("Problema al escribir en el fichero... ");
            mensjConf = "Problema al escribir el fichero";
        }
        return mensjConf;
    }

     //   Método que verifica si el mensaje recibido es válido comparando su hash SHA con el proporcionado por el cliente.
    private static boolean descifrado(String cifrado, String mensaje){
        MessageDigest md;
        boolean bandera = false;
        try {
            md = MessageDigest.getInstance("SHA");  // Se obtiene una instancia del algoritmo SHA

            byte[] dataBytes = mensaje.getBytes();  // Se convierte el mensaje a bytes
            md.update(dataBytes);  // Se introduce el mensaje en el algoritmo
            byte[] resumen = md.digest();  // Se genera el hash del mensaje

            bandera = Hexadecimal(resumen).equals(cifrado);  // Se compara el hash generado con el proporcionado por el cliente
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        return bandera;  // Devuelve true si los hashes coinciden, false si no
    }

     //   Método que convierte un array de bytes en una cadena hexadecimal.
    private static String Hexadecimal(byte[] resumen) {
        String hex = "";
        for (int i = 0; i < resumen.length; i++) {
            String h = Integer.toHexString(resumen[i] & 0xFF);  // Se convierte cada byte a hexadecimal
            if (h.length() == 1)
                hex += "0";  // Se agrega un cero si la representación hexadecimal tiene un solo carácter
            hex += h;
        }
        return hex.toUpperCase();  // Se devuelve el hash en formato hexadecimal y en mayúsculas
    }

    //  Método que cierra la conexión con el cliente.
    public void cerrarConexion() {
        try {
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
        new Server().ejecutarServidor();
    }
}
