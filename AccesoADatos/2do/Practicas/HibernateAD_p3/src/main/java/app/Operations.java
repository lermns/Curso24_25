package app;

import org.hibernate.*;
import orm.Libro;

public class Operations {
    SessionFactory sf;
    Session s;
    Transaction t;
    
    public Operations(){
        sf = HibernateUtil.getSessionFactory();
    }
    
    //  Metodo para inicializar los valores de session y Transaction
    private void abrirSesionYTransaccion(){
        try{
            
            //  Creamos/Abrimos la sesion
            s = sf.openSession();
            
            //  Creamos una transaccion
            t = s.beginTransaction();
            
        }catch(HibernateException he){
            System.out.println("Excepcion generada en abrir sesion " + he.getMessage());
        }
    }
    
    //  Metodo para insertar crear un libro
    public void crearLibro(int isbn, String titulo, String autor){
        abrirSesionYTransaccion();
        
        try{
            
            //  Hacemos lo que tengmos que hacer con BDD en este caso
            //  añadir un libro (create)
            Libro libro = new Libro(isbn, titulo, autor);
            s.save(libro);
            
            //  commit de la transaccion
            t.commit();
            
        }catch(HibernateException he){
            
            //  Si hay algun error hacemos rolback
            if(t != null)t.rollback();
            
            System.out.println("Excepcion generada en crear libro " + he.getMessage());
        }finally{
            
            //  Cerramos la sesion
            HibernateUtil.cerrarSession(s);
        }
    }
    
    //  Metodo para leer un libro (facilitando el isbn)
    public void leerLibro(int isbn){
        abrirSesionYTransaccion();
        try{
            
            //  Leemos una fila de nuestra tabla con el metodo get de la clase
            //  session lo guardamos pasandola a la clase libro y el isbn
            //  Seria como un select * from libro where isbn=?
            Libro libro = s.get(Libro.class, isbn);
            
            System.out.println(libro + "\nAutor: " + libro.getAutor());
        }catch(HibernateException he){
            System.out.println("Excepcion generada en leer libro" + he.getMessage());
        }finally{
            //  Cerramos la sesion
            HibernateUtil.cerrarSession(s);
        }
    }
    
    public void modificarLibro(int isbn, String nuevoTitulo, String nuevoAutor){
        abrirSesionYTransaccion();
        try{
            Libro l = s.get(Libro.class, isbn);
            
            l.setTitulo(nuevoTitulo);
            l.setAutor(nuevoAutor);
            
            s.update(l);
            
            t.commit();
        
        }catch(HibernateException he){
            System.out.println("Error generado en modificar libro " + he.getMessage());
            
            if(t != null)t.rollback();
        }finally{
            HibernateUtil.cerrarSession(s);
        }
    }
    
    public void borrarLibro(int isbn){
        abrirSesionYTransaccion();
        try{
            Libro d = s.get(Libro.class, isbn);
            
            s.delete(d);
            
            t.commit();
        
        }catch(HibernateException he){
            if(t != null) t.rollback();
            
            System.out.println("Excepcion generada en borrar Libro " + he.getMessage());
        }finally{
            HibernateUtil.cerrarSession(s);
        }
        
    }
}
