package org.example.Examen.actividad_1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private static int cont=1;  // contador para darles los distintos nombres a los clientes
    private static final File fichero =  new File("src/main/java/org/example/Examen/actividad_1/servidorMensajes");
    //  ruta de la carpeta donde estan los ficheros de los clientes
    private String name="";

    private void ejecutarServidor(){
        try{
            serverSocket = new ServerSocket(5050);
            System.out.println("Esperando conexion con el servidor en el puerto 5050...");

            while (true){
                Socket socket = serverSocket.accept();
                //  asigna el nombre
                name = "Cli"+cont++;
                System.out.println("Conexión establecida con: " + name + "\n\n\n");
                //  se lo asigna a un thread y este con el metodo para que se ejecute por su lado
                new Thread(()->{
                    recibir(socket, name);
                }).start();
            }
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }

    private void recibir(Socket sock, String name){
        String s;   // variable que almacena el mensaje
        String contenido = "";  //  contenido que se va a devolver al cliente
        String[] arryString;    //  para almacenar el array spliteado del comando guardar:mensaje

        // flujos de entrada y salido
        DataInputStream dis;
        DataOutputStream dos;
        try {
            //  se inicializan
            dis = new DataInputStream(sock.getInputStream());
            dos = new DataOutputStream(sock.getOutputStream());
            while (true) {
                s = dis.readUTF();
                System.out.println("\n[Cliente-" + name + "] => " + s);
                // spliteamos el texto recibido
                arryString = s.split(":");

                //  en caso contener los ":" este tiene una longitud de mas de 1 caso contrario es un texto normal, si tiene
                //  los ":" es el comando guardar:mensaje por lo que coge el comando y lo usa en el caso y el mensaje lo manda
                //  al metodo escribirMensaje
                switch (arryString.length>1?arryString[0]:s){
                    case "guardar" -> contenido = escribirMensaje(arryString[1], name);
                    case "leer" -> contenido = leerContenido(name);
                    case "borrar" -> contenido = escribirMensaje(name);
                    case "salir" -> cerrarConexion(dos, dis, sock); // en caso de darle a salir este cierra las conexiones de este socket
                    default -> dos.writeUTF("Comando no valido.");
                }
                //  y envia el texto de proceso terminado y rompe el while
                if (s.equals("salir")) {
                    dos.writeUTF("Terminado proceso");
                    break;
                }

                dos.writeUTF(contenido);
                dos.flush();
            }
        } catch (IOException e) {
            System.out.println("error comunicación con cliente: " + e.getMessage());
        }
    }

    private synchronized String escribirMensaje(String s, String name){
        //  nombre del fichero con el formato pedido
        File FicheroCliente = new File(fichero + File.separator + "messages_" + name + ".txt");
        String cont;
        try {
            //  caso no exista este se crea
            if (FicheroCliente.createNewFile()){
                System.out.println("Se ha creado el fichero.");
            }
        } catch (IOException e) {
            System.out.println("Problema al crear el fichero...!");
            //  en caso tenga problemas al crear el fichero
            return "problema al crear el fichero";
        }

        // lo usamos en modo apend para concatenar
        try(FileWriter pr = new FileWriter(FicheroCliente, true)){
            // escribimos el contenido y enviamos el mensaje de confirmacion
            pr.write(name + "\t" + s + "\n");
            cont = "fichero escrito correctamente";
        }catch (IOException e){
            //  caso contrario se envia el mnsaje del problema
            System.out.println("Problema al escribir en el fichero... " + e.getMessage());
            cont = "Problema al escribir en el fichero";
        }
        return cont;
    }

    //  uso la sobrecarga de metodos para reutilizar el metodo pero con el uso de vaciar el contenido del fichero,
    //  el comando borrar
    private synchronized String escribirMensaje(String name){
        File FicheroCliente = new File(fichero + File.separator + "messages_" + name + ".txt");
        String cont;
        //  en caso no exista el fichero este manda el mensaje de no existencia
        if (!FicheroCliente.exists()){
            return "fichero no existente";
        }

        //  usamos el modo apend false "por defecto" para sobreescribir el contenido y asi borrarlo
        try(FileWriter pr = new FileWriter(FicheroCliente)){
            pr.write("");
            cont = "contenido borrado del fichero";
        }catch (IOException e){
            System.out.println("Problema al escribir en el fichero... " + e.getMessage());
            return "Problema al escribir en el fichero... " + e.getMessage();
        }
        return cont;
    }

    private synchronized String leerContenido(String name){
        File FicheroCliente = new File(fichero + File.separator + "messages_" + name + ".txt");
        StringBuilder sb = new StringBuilder();

        //  abrimos el fichero y leemos el contenido usando stringbuilder para concatenar el contenido
        try (BufferedReader br = new BufferedReader(new FileReader(FicheroCliente))) {
            String linea;
            while ((linea = br.readLine()) != null) { // leer línea a linea
                sb.append(linea).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return "Error al leer el archivo: " + e.getMessage();
        }
        // en caso este vacio este lo envia
        if (sb.toString().isEmpty()){
            return "fichero vacio";
        }
        //  caso contrario se envia el contenido
        return sb.toString();
    }

    private void cerrarConexion(DataOutputStream dos, DataInputStream dis, Socket socket) {
        try {
            //  se cierra la conexion
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
