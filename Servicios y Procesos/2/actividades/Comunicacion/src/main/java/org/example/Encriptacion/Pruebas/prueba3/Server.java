package org.example.Encriptacion.Pruebas.prueba3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.*;
import java.util.Scanner;

public class Server {
    private ServerSocket serverSocket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private PublicKey serverPublicKey;
    private PrivateKey serverPrivKey;
    private Signature dsa;

    private PublicKey clientePublicKey;
    private Socket socket;

    public Server() {
        KeyPairGenerator keyGen;
        try {
            //  Se instancia el KeyGen con el algoritmo DSA, este nos servira para generar las claves publicas y privadas
            keyGen = KeyPairGenerator.getInstance("DSA");
            //  SE INICIALIZA EL GENERADOR DE CLAVES que nos dara mayor seguridad al momento de generar estas
            SecureRandom numero = SecureRandom.getInstance("SHA1PRNG");
            keyGen.initialize (1024, numero);

            //  SE CREA EL PAR DE CLAVES PRIVADA Y PUBLICA
            KeyPair par = keyGen.generateKeyPair();
            serverPrivKey = par.getPrivate();
            serverPublicKey = par.getPublic();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
    }

    private void enviarClavePublica(){
        try {

            //  Acá el OutPutStream del Socket que recibimos instanciamos un ObjectOutStream para escribirle nuestra clave publica
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            oos.writeObject(serverPublicKey);
            oos.flush();

            //  tanto en este metodo como en el de recibir lo usamos para que ambos chat puedan descifrar las firmas que se envien junto a los mensajes con el fin
            //  de verificar la autenticidad de estos y que no se hayan alterado en su envio.

        } catch (Exception e) {
            System.out.println("Error al recibir clave pública: " + e.getMessage());
        }
    }

    private void recibirClavePublica(){
        try {
            //  con el InputStream del Socket que recibimos instanciamos un ObjectInpStream para leer su clave publica
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            clientePublicKey = (PublicKey) ois.readObject();

        } catch (Exception e) {
            System.out.println("Error al recibir clave pública: " + e.getMessage());
        }
    }

    private void ejecutarServidor() {
        try {
            serverSocket = new ServerSocket(5050);
            System.out.println("Esperando conexión con el cliente en el puerto 5050...");
            //  esperamos conexion de un socket
            socket = serverSocket.accept();
            //  inicializamos los flujos de entrada y salida
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            dos.flush();

            //  Creamos la instancia de la Firma con el algoritmo especificado
            dsa = Signature.getInstance("SHA1withDSA");
            //  creamos la firma pasandole nuestra clave privada
            dsa.initSign (serverPrivKey);

            // Enviamos la clave pública del servidor
            enviarClavePublica();
            // Recibir la clave pública del cliente
            recibirClavePublica();

            //  Metodos enviar y recibir que estaran constantemente ejecutandose
            enviar();
            recibir();
        } catch (IOException | NoSuchAlgorithmException | InvalidKeyException e) {
            System.out.println(e.getMessage());
        }
    }

    private byte[] cifrar(String mensaje){
        byte[] arryBytes=new byte[0];
        try {
            //  le pasamos el mensaje a enviar al metodo update de la nuestra Signature que viene previamente
            //  cargada de la clave privada cifrada
            dsa.update(mensaje.getBytes());
            //  cogemos el arry de bytes que nos genera para enviarlo con el mensaje
            arryBytes = dsa.sign();
        } catch (SignatureException e) {
            System.out.println(e.getMessage());
        }
        return arryBytes;
    }

    private void recibir() {
        new Thread(() -> {
            byte[] mensajeCifrado;
            String mensaje;
            int len;
            while (true) {
                try {
                    mensaje = dis.readUTF(); // Recibimos el mensaje
                    len = dis.readInt();  // Calculamos la longitud del arry de bytes
                    mensajeCifrado = dis.readNBytes(len);  // Recibimos el mensaje cifrado

                    // en caso las los hashes coincidan este enviara un mensaje u otro
                    if (descifrar(mensaje, mensajeCifrado)){
                        System.out.println("\n[CLIENTE] => " + mensaje + "::OK");
                    }else
                        System.out.println("\n[CLIENTE] => " + mensaje + "::KO");

                    System.out.print("\n[SERVIDOR] => ");
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    break;  // Salimos del loop si la conexión falla
                }
            }
        }).start();
    }

    private void enviar() throws IOException {
        new Thread(() -> {
            while (true) {
                String s;
                byte[] cifrado;
                try {
                    System.out.print("\n[SERVIDOR] => ");
                    s = new Scanner(System.in).nextLine();
                    cifrado = cifrar(s); // Cifrar el mensaje antes de enviarlo
                    dos.writeUTF(s);  //  Enviamos el mensaje a pelo
                    dos.writeInt(cifrado.length);  //  enviamos la longitud de este
                    dos.write(cifrado);  //  y luego el cifrado que es un arry de bytes
                    dos.flush();
                } catch (Exception e) {
                    System.out.println("Error al cifrar el mensaje: " + e.getMessage());
                }
            }
        }).start();
    }

    private boolean descifrar(String mensaje, byte[] mensajeCifrado){
        Signature verf;
        try {
            //  creamos la instancia de la firma
            verf = Signature.getInstance("SHA1withDSA");
            //  Le pasamos la clave publica del Receptor
            verf.initVerify (clientePublicKey);
            //  A esta le pasamos el mensaje a pelo convertido a un arry de bytes que recibimos
            verf.update(mensaje.getBytes());
            //  con el mensaje cargado en la firma usamos el metodo verify y le pasamos el mensaje cifrado para que este
            //  se compare y verifique que coincidan
            return verf.verify(mensajeCifrado);

        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
            System.out.println("[ERROR] No se pudo verificar la firma: " + e.getMessage());
        }
        return false;
    }

    public static void main(String[] args) {
        new Server().ejecutarServidor();
    }
}

