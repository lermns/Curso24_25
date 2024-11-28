package ejercicio_18;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File fichero;
        Scanner sc = new Scanner(System.in);

        System.out.println("dame el nombre del fichero: ");
        String fichNmbr = sc.nextLine();
        fichero = new File("src/ejercicio_18" + File.separator  + fichNmbr + ".dat");

        try {
            if (!fichero.exists() && fichero.createNewFile()){
                System.out.println("fichero creado");
            }else if(fichero.exists()){
                System.out.println("el fichero ya existe");
            }
        } catch (IOException e) {
            System.out.println("problema al crear el fichero");
        }

        try(DataInputStream dis = new DataInputStream(new FileInputStream(fichero));
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(fichero, true))){

            do {
                try{
                    System.out.println(dis.readUTF());
                }catch (EOFException eof){
                    System.out.println("fin del fichero");
                    break;
                }
            }while (true);

            for (int i = 0; i < 2; i++) {
                Vehiculo veh1 = crearVehiculo();
                dos.writeUTF(veh1.toString());
            }
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }

    }
    private static Vehiculo crearVehiculo(){
        Scanner sc = new Scanner(System.in);

        System.out.println("dame la marca: ");
        String marca = sc.nextLine();

        System.out.println("dame el modelo: ");
        String modelo = sc.nextLine();

        System.out.println("dame el color: ");
        String color = sc.nextLine();

        System.out.println("dame el año: ");
        int annio = new Scanner(System.in).nextInt();

        System.out.println("es metalizado?:\n1.Si\n2.No ");
        boolean bandera=true;
        int numOpc = 0;
        do{
            try {
                numOpc = new Scanner(System.in).nextInt();
                if(numOpc<3 && numOpc>0){
                    bandera=false;
                }else
                    System.out.println("tipo de valor no valido, vuelva a intentarlo.");
            }catch (InputMismatchException ime){
                System.out.println("problema con el formato, vuelva a intentarlo");
            }
        }while (bandera);

        return new Vehiculo(marca, modelo, color, annio, (numOpc == 1));
    }
}
