/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author lermns
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
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
            System.err.println("Error al cerrar sessionFactory " + he.getMessage());
        }
    }
    
    public static void cerrarSession(Session session){
        try{
            if(session != null && !session.isOpen()){
                session.close();
            }
        }catch(HibernateException he){
            System.err.println("Error al cerrar session " + he.getMessage());
        }
    }
}
