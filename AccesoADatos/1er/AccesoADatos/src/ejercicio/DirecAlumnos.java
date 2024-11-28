package ejercicio;

import java.io.*;
import java.util.*;

public class DirecAlumnos {
    private static final File fleRuta;
    private static final String NOTAS_FILE;

    static {
        fleRuta = new File(System.getProperty("user.home"),"Alumnos");
        NOTAS_FILE = "notas.txt";
        try {
            if(!fleRuta.exists() && fleRuta.mkdirs()){
                System.out.println("fichero " + fleRuta.getName() + " creado.");
            }else
                throw new IOException("problema al crear el directorio " + fleRuta.getName() + " este ya existe");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    void crearAlumnos(String strNombre) {
        File alumnoDir = new File(fleRuta, strNombre.toUpperCase());  // Usar alumnoDir para el directorio del alumno
        File ficheroNotas = new File(alumnoDir, NOTAS_FILE);

        try {
            if (alumnoDir.exists() && ficheroNotas.exists()) {
                System.out.println("El directorio del alumno " + alumnoDir.getName() + " ya existe con su fichero de notas.");
            } else {
                if (!alumnoDir.exists() && alumnoDir.mkdirs()) {
                    System.out.println("Directorio del alumno " + alumnoDir.getName() + " fue creado.");
                }
                if (ficheroNotas.createNewFile()) {
                    System.out.println("Fichero de notas creado para el alumno " + alumnoDir.getName() + ".");
                }
            }
        } catch (IOException ioe) {
            System.out.println("El directorio " + ioe.getMessage());
        }
    }

    void anniadirAsignNotas(String strNombre){
        String strNombreUp = strNombre.toUpperCase();
        String rutaNotas = strNombreUp + File.separator + NOTAS_FILE;
        File[] fileAlum = fleRuta.listFiles();
        ArrayList<String> listNombres = new ArrayList<>();

        try {
            if(fileAlum!=null) {
                for (File f : fileAlum) {
                    listNombres.add(f.getName());
                }
            }else {
                throw new Exception("el directorio alumnos esta vacio");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if (listNombres.contains(strNombreUp)) {
            File ficheroNotas = new File(fleRuta, rutaNotas);// Usar alumnoDir para el directorio del alumno
            asignaturasNotas(ficheroNotas);
        } else
            System.out.println("el alumno " + strNombreUp + " no existe.");

    }

    private void asignaturasNotas(File fleNotas){
        Map<String, Double> mapAsignNotas = leerFichero(fleNotas);
        Map<String, Double> mapLocalAsign = new TreeMap<>();
        String[] aryyNombre = fleNotas.getPath().split("/");
        String nombre = aryyNombre[aryyNombre.length-2];
        String strAsign;
        boolean blnBandera = true;
        boolean blnNotaValida;
        double dblNota = 0;
        Scanner scDouble = new Scanner(System.in);
        Scanner scInt = new Scanner(System.in);
        Scanner scStr = new Scanner(System.in);

        do {
            System.out.println("dame el nombre de la asignatura para " + nombre + ": ");
            strAsign = scStr.nextLine();
            strAsign=strAsign.toUpperCase();

            if(!mapAsignNotas.containsKey(strAsign)){
                blnNotaValida = false;
                do {
                    System.out.println("dame la nota de la asignatura 0,0-10,0: ");
                    try {
                        dblNota = scDouble.nextDouble();
                        if (dblNota >= 0.0 && dblNota <= 10.0) {
                            blnNotaValida = true;
                        } else {
                            System.out.println("nota fuera de rango, intenta nuevamente");
                        }
                    } catch (InputMismatchException ime) {
                        System.out.println("tipo de dato no válido, intenta nuevamente.");
                        scDouble.next();
                    }
                } while (!blnNotaValida);

                mapLocalAsign.put(strAsign.replace(" ", "_"), dblNota);
                System.out.println("añadir mas asignaturas?\n1.Si\n2.No");
                if (scInt.nextInt() != 1){
                    blnBandera=false;
                }
            }else {
                System.out.println("esta asignatura ya existe, quieres intentar nuevamente..?\n1.Si\n2.No");
                int intOpc = scInt.nextInt();
                if(intOpc!=1){
                    blnBandera=false;
                }
            }
        }while (blnBandera);
        escribirFichero(fleNotas, mapLocalAsign);
    }

    private Map<String, Double> leerFichero(File fleNotas){
        Map<String, Double> mapAsigNotas = new TreeMap<>();

        try (Scanner sc = new Scanner(new FileReader(fleNotas))){
            while(sc.hasNext()){
                mapAsigNotas.put(sc.next(), Double.parseDouble(sc.next()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("problema al leer el fichero notas");
        }catch (NumberFormatException nfe){
            System.out.println("problema con el formato de la nota");
        }
        return mapAsigNotas;
    }

    private void escribirFichero(File fichNotas, Map<String, Double> mapAsign){

        try(BufferedWriter bfWrt = new BufferedWriter(new FileWriter(fichNotas, true))){
            mapAsign.forEach((x,y) -> {
                try {
                    bfWrt.write(x + " " + y);
                    bfWrt.newLine();
                } catch (IOException e) {
                    System.out.println("problema al escribir en el fichero");
                }
            });
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }

    void notaMediaxAlumno(){
        File fichNotas;
        Map<String, Double> mapNotas;
        double media;
        File[] fileAlum = fleRuta.listFiles();

        if(fileAlum != null) {
            for (File s : fileAlum) {
                media = 0.0;
                fichNotas = new File(s.getPath(), NOTAS_FILE);
                mapNotas = leerFichero(fichNotas);
                if (!mapNotas.isEmpty()) {
                    System.out.println("\n---------------------------------------------");
                    System.out.println("notas de " + s.getName());
                    for (String k : mapNotas.keySet()) {
                        media += mapNotas.get(k);
                        System.out.println("\t" + k + " " + mapNotas.get(k));
                    }
                    System.out.printf("nota media de " + s.getName() + ": %.2f", (media / mapNotas.size()));
                    System.out.println("\n---------------------------------------------");
                } else
                    System.out.println("\nel fichero notas de " + s.getName() + " esta vacio");
            }
        }else
            System.out.println("No existen directorios alumnos");
    }

    void notasMediaxAsign(){
        Map<String, ArrayList<Double>> mapaMedia = new TreeMap<>();
        File fichNotas;
        Map<String, Double> mapNotas;
        File[] fileAlum = fleRuta.listFiles();

        if(fileAlum!=null) {
            for (File s : fileAlum) {
                fichNotas = new File(s.getPath(), NOTAS_FILE);
                mapNotas = leerFichero(fichNotas);

                if (mapNotas.isEmpty()) {
                    System.out.println("\nel fichero notas de " + s.getName() + " esta vacio");
                    System.exit(0);
                }
                for (String k : mapNotas.keySet()) {
                    if (mapaMedia.containsKey(k)) {
                        mapaMedia.get(k).add(mapNotas.get(k));
                    } else {
                        mapaMedia.put(k, new ArrayList<>(List.of(mapNotas.get(k))));
                    }
                }
            }
        }else {
            System.out.println("No existen directorios alumnos");
            System.exit(0);
        }

        for (String s: mapaMedia.keySet()){
            System.out.print(s+":\n\t\tNotas: ");
            mapaMedia.get(s).forEach(x -> System.out.print(x + " "));
            double suma = mapaMedia.get(s).stream().mapToDouble(Double::doubleValue).sum();
            System.out.printf("\n\t\tSuma total: " + suma + "\n\t\tMedia: %.2f", suma/mapaMedia.get(s).size());
            System.out.println();
        }
    }
}