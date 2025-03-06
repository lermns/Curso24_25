package org.example.Encriptacion.Pruebas.prueba3;

import java.io.*;
import java.net.Socket;
import java.security.*;
import java.util.Scanner;

public class Cliente {
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private PublicKey clientePublicKey;
    private PrivateKey clientePrivKey;
    private Signature dsa;

    private PublicKey serverPublicKey;


    public Cliente() {
        KeyPairGenerator keyGen;
        try {
            keyGen = KeyPairGenerator.getInstance("DSA");
            //SE INICIALIZA EL GENERADOR DE CLAVES
            SecureRandom numero = SecureRandom.getInstance("SHA1PRNG");
            keyGen.initialize (1024, numero);

            //SE CREA EL PAR DE CLAVES PRIVADA Y PÚBLICA
            KeyPair par = keyGen.generateKeyPair();
            clientePrivKey = par.getPrivate();
            clientePublicKey = par.getPublic();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
    }

    private void enviarClavePublica(){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            oos.writeObject(clientePublicKey);
            oos.flush();

        } catch (Exception e) {
            System.out.println("Error al recibir clave pública: " + e.getMessage());
        }
    }

    private void recibirClavePublica(){
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            serverPublicKey = (PublicKey) ois.readObject();

        } catch (Exception e) {
            System.out.println("Error al recibir clave pública: " + e.getMessage());
        }
    }

    private void ejecutarSocket() {
        try {
            socket = new Socket("localhost", 5050);
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            dos.flush();
            dsa = Signature.getInstance("SHA1withDSA");
            dsa.initSign (clientePrivKey);


            // Recibir la clave pública del servidor
            recibirClavePublica();
            enviarClavePublica();
            enviar();
            recibir();
        } catch (IOException | NoSuchAlgorithmException | InvalidKeyException e) {
            System.out.println(e.getMessage());
        }
    }

    private byte[] cifrar(String mensaje){
        byte[] arryBytes=new byte[0];
        try {
            dsa.update(mensaje.getBytes());
            arryBytes = dsa.sign();
        } catch (SignatureException e) {
            System.out.println(e.getMessage());
        }
        return arryBytes;
    }

    private void enviar() {
        new Thread(() -> {
            while (true) {
                String s;
                byte[] cifrado;
                try {
                    System.out.print("\n[CLIENTE] => ");
                    s = new Scanner(System.in).nextLine();
                    cifrado = cifrar(s); // Cifrar el mensaje antes de enviarlo
                    dos.writeUTF(s);
                    dos.writeInt(cifrado.length);
                    dos.write(cifrado);
                    dos.flush();
                } catch (Exception e) {
                    System.out.println("Error al cifrar el mensaje: " + e.getMessage());
                }
            }
        }).start();
    }

    private void recibir() {
        new Thread(() -> {
            byte[] mensajeCifrado;
            String mensaje;
            int len;
            while (true) {
                try {
                    mensaje = dis.readUTF();  // Recibimos el mensaje
                    len = dis.readInt();
                    mensajeCifrado = dis.readNBytes(len);  // Recibimos el mensaje cifrado

                    if (descifrar(mensaje, mensajeCifrado)){
                        System.out.println("\n[SERVIDOR] => " + mensaje + "::OK");
                    }else
                        System.out.println("\n[SERVIDOR] => " + mensaje + "::KO");

                    System.out.print("\n[CLIENTE] => ");
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    break;  // Salimos del loop si la conexión falla
                }
            }
        }).start();
    }

    private boolean descifrar(String mensaje, byte[] mensajeCifrado){
        Signature verf;
        try {
            verf = Signature.getInstance("SHA1withDSA");
            verf.initVerify (serverPublicKey);
            verf.update(mensaje.getBytes());

            return verf.verify(mensajeCifrado);

        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
            System.out.println("[ERROR] No se pudo verificar la firma: " + e.getMessage());
        }
        return false;
    }

    public static void main(String[] args) {
        new Cliente().ejecutarSocket();
    }
}
