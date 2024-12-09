package ejercicio;

import java.io.*;
import java.util.*;

public class DirecAlumnos {
    // Atributos estáticos: directorio base y nombre de archivo para notas
    private static final File fleRuta;
    private static final String NOTAS_FILE;

    // Bloque estático para inicializar los valores
    static {
        // Define el directorio "Alumnos" en la carpeta del usuario
        fleRuta = new File(System.getProperty("user.home"),"Alumnos");
        // Nombre del archivo de notas
        NOTAS_FILE = "notas.txt";

        try {
            // Si el directorio no existe, intenta crearlo
            if(!fleRuta.exists() && fleRuta.mkdirs()){
                System.out.println("fichero " + fleRuta.getName() + " creado.");
            } else {
                // Si el directorio ya existe, lanza una excepción
                throw new IOException("problema al crear el directorio " + fleRuta.getName() + " este ya existe");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // Método para crear un directorio para un alumno y su archivo de notas
    void crearAlumnos(String strNombre) {
        // Crea un directorio para el alumno usando su nombre (en mayúsculas)
        File alumnoDir = new File(fleRuta, strNombre.toUpperCase());
        // Crea el archivo de notas dentro de ese directorio
        File ficheroNotas = new File(alumnoDir, NOTAS_FILE);

        try {
            // Si el directorio y el archivo de notas ya existen, informa
            if (alumnoDir.exists() && ficheroNotas.exists()) {
                System.out.println("El directorio del alumno " + alumnoDir.getName() + " ya existe con su fichero de notas.");
            } else {
                // Si no existe, crea el directorio y el archivo de notas
                if (!alumnoDir.exists() && alumnoDir.mkdirs()) {
                    System.out.println("Directorio del alumno " + alumnoDir.getName() + " fue creado.");
                }
                if (ficheroNotas.createNewFile()) {
                    System.out.println("Fichero de notas creado para el alumno " + alumnoDir.getName() + ".");
                }
            }
        } catch (IOException ioe) {
            // Si ocurre un error al crear el directorio o el archivo
            System.out.println("El directorio " + ioe.getMessage());
        }
    }

    // Método para añadir asignaturas y notas de un alumno
    void anniadirAsignNotas(String strNombre){
        String strNombreUp = strNombre.toUpperCase();
        String rutaNotas = strNombreUp + File.separator + NOTAS_FILE;
        File[] fileAlum = fleRuta.listFiles();  // Lista los archivos (alumnos) en el directorio
        ArrayList<String> listNombres = new ArrayList<>();

        try {
            // Si la lista de alumnos no es nula, agrega sus nombres a la lista
            if(fileAlum != null) {
                for (File f : fileAlum) {
                    listNombres.add(f.getName());
                }
            } else {
                throw new Exception("el directorio alumnos esta vacio");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Si el alumno existe en el directorio, llama a asignaturasNotas
        if (listNombres.contains(strNombreUp)) {
            File ficheroNotas = new File(fleRuta, rutaNotas);
            asignaturasNotas(ficheroNotas);  // Llama al método para agregar las asignaturas y sus notas
        } else {
            // Si el alumno no existe, muestra un mensaje de error
            System.out.println("el alumno " + strNombreUp + " no existe.");
        }
    }

    // Método para agregar asignaturas y sus notas a un archivo
    private void asignaturasNotas(File fleNotas){
        // Lee las notas existentes
        Map<String, Double> mapAsignNotas = leerFichero(fleNotas);
        Map<String, Double> mapLocalAsign = new TreeMap<>();  // Mapa temporal para las nuevas asignaturas
        String[] aryyNombre = fleNotas.getPath().split("/");  // Extrae el nombre del alumno
        String nombre = aryyNombre[aryyNombre.length-2];
        String strAsign;
        boolean blnBandera = true;
        boolean blnNotaValida;
        double dblNota = 0;

        // Creación de los escáneres para obtener datos del usuario
        Scanner scDouble = new Scanner(System.in);
        Scanner scInt = new Scanner(System.in);
        Scanner scStr = new Scanner(System.in);

        do {
            // Pide al usuario el nombre de la asignatura
            System.out.println("dame el nombre de la asignatura para " + nombre + ": ");
            strAsign = scStr.nextLine();
            strAsign = strAsign.toUpperCase();  // Convierte a mayúsculas

            // Si la asignatura no existe, pide la nota
            if (!mapAsignNotas.containsKey(strAsign)){
                blnNotaValida = false;
                do {
                    System.out.println("dame la nota de la asignatura 0,0-10,0: ");
                    try {
                        dblNota = scDouble.nextDouble();
                        // Verifica si la nota está en el rango correcto
                        if (dblNota >= 0.0 && dblNota <= 10.0) {
                            blnNotaValida = true;
                        } else {
                            System.out.println("nota fuera de rango, intenta nuevamente");
                        }
                    } catch (InputMismatchException ime) {
                        System.out.println("tipo de dato no válido, intenta nuevamente.");
                        scDouble.next();  // Limpia el buffer del escáner
                    }
                } while (!blnNotaValida);

                // Añade la asignatura y su nota al mapa temporal
                mapLocalAsign.put(strAsign.replace(" ", "_"), dblNota);
                System.out.println("añadir mas asignaturas?\n1.Si\n2.No");
                if (scInt.nextInt() != 1) {
                    blnBandera = false;
                }
            } else {
                // Si la asignatura ya existe, ofrece la opción de intentar nuevamente
                System.out.println("esta asignatura ya existe, quieres intentar nuevamente..?\n1.Si\n2.No");
                int intOpc = scInt.nextInt();
                if (intOpc != 1) {
                    blnBandera = false;
                }
            }
        } while (blnBandera);

        // Escribe las nuevas notas en el archivo
        escribirFichero(fleNotas, mapLocalAsign);
    }

    // Método para leer las notas de un archivo y devolverlas como un mapa
    private Map<String, Double> leerFichero(File fleNotas){
        Map<String, Double> mapAsigNotas = new TreeMap<>();

        try (Scanner sc = new Scanner(new FileReader(fleNotas))) {
            // Lee el archivo línea por línea
            while(sc.hasNext()) {
                mapAsigNotas.put(sc.next(), Double.parseDouble(sc.next()));  // Asignatura y su nota
            }
        } catch (FileNotFoundException e) {
            System.out.println("problema al leer el fichero notas");
        } catch (NumberFormatException nfe) {
            System.out.println("problema con el formato de la nota");
        }
        return mapAsigNotas;
    }

    // Método para escribir las nuevas asignaturas y notas en el archivo
    private void escribirFichero(File fichNotas, Map<String, Double> mapAsign){
        try(BufferedWriter bfWrt = new BufferedWriter(new FileWriter(fichNotas, true))) {
            // Escribe las asignaturas y sus notas
            mapAsign.forEach((x, y) -> {
                try {
                    bfWrt.write(x + " " + y);
                    bfWrt.newLine();
                } catch (IOException e) {
                    System.out.println("problema al escribir en el fichero");
                }
            });
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    // Método para calcular y mostrar la nota media de cada alumno
    void notaMediaxAlumno() {
        File fichNotas;
        Map<String, Double> mapNotas;
        double media;
        File[] fileAlum = fleRuta.listFiles();  // Lista de archivos (alumnos)

        if(fileAlum != null) {
            for (File s : fileAlum) {
                media = 0.0;
                fichNotas = new File(s.getPath(), NOTAS_FILE);  // Obtiene el archivo de notas del alumno
                mapNotas = leerFichero(fichNotas);

                if (!mapNotas.isEmpty()) {
                    System.out.println("\n---------------------------------------------");
                    System.out.println("notas de " + s.getName());
                    for (String k : mapNotas.keySet()) {
                        media += mapNotas.get(k);
                        System.out.println("\t" + k + " " + mapNotas.get(k));
                    }
                    // Calcula y muestra la media
                    System.out.printf("nota media de " + s.getName() + ": %.2f", (media / mapNotas.size()));
                    System.out.println("\n---------------------------------------------");
                } else {
                    System.out.println("\nel fichero notas de " + s.getName() + " esta vacio");
                }
            }
        } else {
            System.out.println("No existen directorios alumnos");
        }
    }

    // Método para calcular y mostrar la media de cada asignatura en todos los alumnos
    void notasMediaxAsign() {
        Map<String, ArrayList<Double>> mapaMedia = new TreeMap<>();
        File fichNotas;
        Map<String, Double> mapNotas;
        File[] fileAlum = fleRuta.listFiles();

        if(fileAlum != null) {
            for (File s : fileAlum) {
                fichNotas = new File(s.getPath(), NOTAS_FILE);
                mapNotas = leerFichero(fichNotas);

                if (mapNotas.isEmpty()) {
                    System.out.println("\nel fichero notas de " + s.getName() + " esta vacio");
                    System.exit(0);  // Sale si hay un archivo vacío
                }

                // Agrupa las notas por asignatura
                for (String k : mapNotas.keySet()) {
                    if (mapaMedia.containsKey(k)) {
                        mapaMedia.get(k).add(mapNotas.get(k));
                    } else {
                        mapaMedia.put(k, new ArrayList<>(List.of(mapNotas.get(k))));
                    }
                }
            }
        } else {
            System.out.println("No existen directorios alumnos");
            System.exit(0);
        }

        // Calcula y muestra la media por asignatura
        for (String s : mapaMedia.keySet()) {
            System.out.print(s + ":\n\t\tNotas: ");
            mapaMedia.get(s).forEach(x -> System.out.print(x + " "));
            double suma = mapaMedia.get(s).stream().mapToDouble(Double::doubleValue).sum();
            System.out.printf("\n\t\tSuma total: " + suma + "\n\t\tMedia: %.2f", suma / mapaMedia.get(s).size());
            System.out.println();
        }
    }
}
