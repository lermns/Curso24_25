package app;

import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.*;
import orm.Libro;

public class OperationsHQL {
    private SessionFactory sf;
    private Session s;
    private Transaction t;
    
    public OperationsHQL(){
        //  Creamos la factoria de sesiones
        sf = HibernateUtil.getSessionFactory();
    }
    
    public void leerTodosLosLibrosHQL(){
        System.out.println("****************  DATOS  ****************");
        
        try{
            s = HibernateUtil.abrirSesion();
            
            String hql = "FROM libro";
            Query q = s.createQuery(hql);
            
            //  Version con list() se cargan todos los resultados ne memoria y se procesan despues
            List <Libro> listResultados = q.list();
            
            //  Recorremos la lista directamente
            listResultados.forEach(System.out::println);
        
        }catch(HibernateException he){
            System.out.println("Excepcion generada en leer Libros " + he.getMessage());
        }finally{
            HibernateUtil.cerrarSession(s);
        }
    }
    
    public void modificarLibroHQL(int isbn, String nuevoTitulo, String nuevoAutor){
        System.out.println("**************** MODIFICAR LIBRO ****************");
        
        String hql = "update libro l set l.autor = :NUEVOAUTOR, " + 
                     "l.titulo = :NUEVOTITULO where l.isbn = :ISBN";
        
        try{
            s = HibernateUtil.abrirSesion();
            t = s.beginTransaction();
            
            Query q = s.createQuery(hql);
            
            q.setParameter("NUEVOAUTOR", nuevoAutor);
            q.setParameter("NUEVOTITULO", nuevoTitulo);
            q.setParameter("ISBN", isbn);
            
            int filasAfectadas = q.executeUpdate();
            
            if(filasAfectadas > 0){
                System.out.println("El libro ha sido modificado. Lineas afectadas: " + filasAfectadas);
            }else
                System.out.println("No se encontro ningun libro con el ISBN proporcionado.");
        
            t.commit();
        
        }catch(HibernateException he){
            System.out.println("Excepcion generada en modificar Libro " + 
                    he.getMessage());
            
            if(t != null)t.rollback();
        }finally {
            HibernateUtil.cerrarSession(s);
        }
    }
    
    public void borrarLibroHQL(int isbn){
        System.out.println("**************** BORRAR LIBRO ****************");
        String hql = "delete from Libro l where l.isbn = :isbnId";
        
        try{
            s = HibernateUtil.abrirSesion();
            t = s.beginTransaction();
            
            Query query = s.createQuery(hql);
            
            query.setParameter("isbnId" , isbn);
            
            int rowsAffct = query.executeUpdate();
            
            if(rowsAffct > 0){
                System.out.println("El libro ha sido borrado.");
            }else
                System.out.println("No se encontro ningun libro con el ISBN proporcionado.");
        
            t.commit();
            
        }catch(HibernateException he){
            System.out.println("Error al abrir sesion en el metodo borrar " + he.getMessage());
            if(t != null)t.rollback();
        }finally{
            HibernateUtil.cerrarSession(s);
        }
    }
    
    public void leerLibrosConFiltroHQL(String cadena){
        System.out.println("************** METODO LEER LIBRO FILTRO **************");
        
        String hql = "from Libro where titulo like :CAD";
        
        try{
            s = HibernateUtil.abrirSesion();
            t = s.beginTransaction();
            
            Query query = s.createQuery(hql);
            
            query.setParameter("CAD", "%" + cadena + "%");
            
            List<Libro> listLibros = query.list();
            
            listLibros.forEach(System.out::println);
           
        }catch(HibernateException he){
            System.out.println("Error al sesion en el metodo leer libro filtro " 
                    + he.getMessage());
            if(t != null)t.rollback();
        }finally{
            HibernateUtil.cerrarSession(s);
        }
        
    }
}
