package app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Operations oper = new Operations();
        
        //  probamos los metodos creados en la clase operaciones
        System.out.println("--------------------CREAMOS 3 LIBROS----------------------");
        oper.crearLibro(2, "Java, How to program", "Deitel");
        oper.crearLibro(3, "Titulo 3", "Autor 3");
        oper.crearLibro(4, "Titulo 4", "Autor 4");
        
        System.out.println("---------------LEEMOS LIBRO POR ID---------------");
        oper.leerLibro(2);
        
        System.out.println("---------------MODIFICAR LIBRO---------------");
        //  Modificamos el libro, pidiendo al usuario el titulo y el autor
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduce el ISBN del libro que quieres modificar: ");
        int isbn = new Scanner(System.in).nextInt();
        System.out.println("Introduce el nuevo titulo: ");
        String nuevoTitulo = sc.nextLine();
        System.out.println("Introduce el nuevo autor: ");
        String nuevoAutor = sc.nextLine();
        
        oper.modificarLibro(isbn, nuevoTitulo, nuevoAutor);
        
        //  Comprobamos la modificacion
        oper.leerLibro(isbn);
        
        System.out.println("---------------------BORRAR LIBRO---------------------");
        System.out.println("Introduce el ID del libro que quieres borrar: ");
        isbn = new Scanner(System.in).nextInt();
        
        //  Borramos el libro pidiendo al usuario el isbn del libro que se quiere borrar
        oper.borrarLibro(isbn);
        
        HibernateUtil.cerrarSessionFactory();
    }
}
