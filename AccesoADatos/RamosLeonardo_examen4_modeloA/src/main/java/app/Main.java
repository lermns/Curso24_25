package app;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class Main {
    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
        SessionFactory sf = null;
        Session s = null;
        Transaction t = null;
        try{
            sf = HibernateUtil.getSessionFactory();
            s = HibernateUtil.abrirSesion();
            t = s.beginTransaction();
            
            OperationsHQL operHql =  new OperationsHQL();

              //2
//            operHql.mostrarPlanes();
              //3
//            operHql.mostrarFormaPago();
              //4
//            operHql.mostrarSocios();
             
            //5
              OperationsNoHQL operNoHql = new OperationsNoHQL();
//            operNoHql.insertarPlan("Familiar", 120);        
//            operHql.mostrarPlanes();

            //6
            
//            operNoHql.mostrarSociosPorPlan(3);

            //7
//           operHql.aplicarDescuentoPagoAnual(10, 1);
//           operHql.mostrarSocios();
            
           t.commit();    
        }catch(HibernateException e){
            System.out.println(e.getMessage());
            HibernateUtil.cerrarSesion(s);
        }
    }
}
