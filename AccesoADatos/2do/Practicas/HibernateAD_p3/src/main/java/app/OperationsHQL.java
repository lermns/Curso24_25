package app;

import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.*;
import orm.Libro;

public class OperationsHQL {
    SessionFactory sf;
    Session s;
    Transaction t;
    
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
}
