package app;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import orm.Departamento;
import orm.Empleado;
import orm.Sede;

public class Main2 {
    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
        
        SessionFactory sf = null;
        Session s = null;
        Transaction t = null;
        
        try{
            sf = HibernateUtil.getSessionFactory();
            s = HibernateUtil.abrirSesion();
            t = s.beginTransaction();
            
            Sede sede = new Sede("Sevilla");
            s.save(sede);
            System.out.println("1");
            Departamento dep = new Departamento(sede, "I+D");
            s.save(dep);
            System.out.println("2");
            Empleado e1 = new Empleado("123456789", dep, "SAM");
            Empleado e2 = new Empleado("123456788", dep, "PER");
            Empleado e3 = new Empleado("123456787", dep, "SAMPER");
            
            s.save(e1);
            s.save(e2);
            s.save(e3);
            System.out.println("3");
            s.refresh(dep);
            System.out.println("4");
            Set<Empleado> listEmp = dep.getEmpleados();
            
            System.out.println("************** DATOS DE EMPLEADOS **************");
            s.refresh(sede);
            System.out.println("5");
            listEmp.forEach(x -> System.out.println(x.getNomEmp()));
            
            String hql = "FROM departamento";
            Query q = s.createQuery(hql);
            
            System.out.println("**************LEEMOS TODOS LOS DEPARTAMENTOS**************");
            System.out.println("************** DATOS **************");
            
            List <Departamento> listResultados = q.list();
            
            listResultados.forEach(System.out::println);
        
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
