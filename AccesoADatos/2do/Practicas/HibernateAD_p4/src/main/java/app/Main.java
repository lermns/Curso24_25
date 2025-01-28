package app;

import java.util.logging.*;
import org.hibernate.*;
import orm.*;


public class Main {
    public static void main(String[] args) {
        
        //  Para que no salgan los mensajes de INFO al ejecutar el programa
        //  Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
        
        SessionFactory sf = null;
        Session s = null;
        Transaction t = null;
        
        try{
            sf = HibernateUtil.getSessionFactory();
            s = HibernateUtil.abrirSesion();
            t = s.beginTransaction();
            
            Sede sede1 = new Sede("MALAGA");
            s.save(sede1);
            
            Departamento dept = new Departamento(sede1, "I+D");
            s.save(dept);
            
            Empleado e = new Empleado("123456789", dept, "SAMPER");
            s.save(e);
            
            t.commit();
            
        }catch(HibernateException he){
            System.err.println("Error Hibernate: " + he.getMessage());
            
            if(t!=null)t.rollback();
        }finally{
            HibernateUtil.cerrarSession(s);
            HibernateUtil.cerrarSessionFactory();
        }
    }
}
