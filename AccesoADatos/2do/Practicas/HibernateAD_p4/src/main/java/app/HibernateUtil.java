package app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;


public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void cerrarSessionFactory(){
        try{
            if(sessionFactory != null && !sessionFactory.isClosed()){
                sessionFactory.close();
            }
        }catch(HibernateException he){
            System.err.println("Error al cerrar sessionFactory, posible valor nulo " 
                    + he.getMessage());
        }
    }
    
    public static void cerrarSession(Session session){
        try{
            if(session != null && session.isOpen()){
                session.close();
                System.out.println("************** Sesion Cerrada **************");
            }
        }catch(HibernateException he){
            System.err.println("Error al cerrar session " + he.getMessage());
        }
    }
    
    //  Metodo abrirSesion
    public static Session abrirSesion(){
        try{
            return sessionFactory.openSession();
        }catch(HibernateException he){
            System.err.println("Error al abrior Session: " + he.getMessage());
            return null;
        }
    }
}
