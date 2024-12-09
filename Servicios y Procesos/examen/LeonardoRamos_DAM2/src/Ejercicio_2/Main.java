package Ejercicio_2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    //array donde guardaremos los string de directorios y archivops
    private static final ArrayList<String> listaRuta=new ArrayList<>();
    public static void main(String[] args) {
        // D:\Users\pedro.rambar\Desktop\EjerciciosExamenAndres\EjerciciosExamenAndres
        Scanner sc = new Scanner(System.in);
        File directorios;
        File f1 = new File("./src/Ejercicio_2/MiSistema.txt");
        //  creamos el fichero
        try {
            f1.createNewFile();
        } catch (IOException e) {
            System.out.println("no se pudo crear el fichero");
        }

        //  en caso de que la ruta no exista te la vuelve a preguntar
        do {
            System.out.println("dame la ruta");
            String ruta = sc.nextLine();
            directorios = new File(ruta);
            if (!directorios.exists()){
                System.out.println("ruta no existe");
            }
        }while (!directorios.exists());

        //contador con la cantidad de veces que entra a directorio para hacer un tabulador
        int cont=0;
        //lee el contenido
        leeContenido(directorios,cont);
        //escribe dentro del fichero MiSistema
        escribirFichero(f1, listaRuta);
    }

    private static void leeContenido(File directorio, int cont){
        //tabs que usarremos un for para anidarlo
        String tab="";
        //para guardar lo que se lea del directorio para pasarlo al array
        String contenido;
        // tab que se ira incrementando cada que entre en un directorio
        cont++;
        for (int i = 1; i <= cont; i++) {
            tab+="\t";
        }

        //  si es un directorio y hay algo dentro nos metemos para imprimir y mostrarlo
        if(directorio.isDirectory() && Objects.requireNonNull(directorio.list()).length>0){
            contenido = tab+"Directorio --> " + directorio.getName();
            listaRuta.add(contenido);
            //  como es un directorio con contenido entonces muestra lo que tiene dentro aplicando recursividad
            for(String s : Objects.requireNonNull(directorio.list())){
                File f1 = new File(directorio + File.separator + s);
                leeContenido(f1,cont);
            }
        }else {
            contenido=tab + "Archivo --> " + directorio.getName();
            listaRuta.add(contenido);
        }

    }

    private static void escribirFichero(File fichero, ArrayList<String> texto){
        // metodo sencillo para hacer un bufferWriter y escrir lo que tiene la lista Arry
        //  !Ah usando Try-WithResources
        try (BufferedWriter bfwrite =new BufferedWriter( new FileWriter(fichero))){
            for (String s : texto){
                bfwrite.write(s);
                bfwrite.newLine();
            }
            System.out.println("el fichero ha sido escrito");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
