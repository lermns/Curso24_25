package app;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.*;
import org.hibernate.query.Query;
import orm.*;

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
            
            //  Creacion Sede y Departamento
//            Sede sede = new Sede("Sevilla");
//            s.save(sede);
//            Departamento dep = new Departamento(sede, "I+D");
//            s.save(dep);
//            
//            Empleado e1 = new Empleado("111111111", dep, "Pepe");
//            Empleado e2 = new Empleado("222222222", dep, "Ana");
//            Empleado e3 = new Empleado("333333333", dep, "Fiona");
//            
//            s.save(e1);
//            s.save(e2);
//            s.save(e3);
            
            
            /* Datos Prueba
            Sede sede = new Sede("Sevilla");
            s.save(sede);
            Departamento dep = new Departamento(sede, "I+D");
            s.save(dep);
            
            Empleado e1 = new Empleado("111111111", dep, "Pepe");
            Empleado e2 = new Empleado("222222222", dep, "Ana");
            Empleado e3 = new Empleado("333333333", dep, "Fiona");
            
            s.save(e1);
            s.save(e2);
            s.save(e3);
            */
            
            //  Consulta a 2 tablas prueba, creamos una consulta adaptada a HQL sobre 2 tablas relacionadas y este
	    //	nos devolvera un array de Object con las clases de las tablas seleccionadas, en este caso Empleado y
	    //	Departamento que luego iteramos para ver los datos de estos con la relacion que queriamos.
//            String hqlCons = "FROM Empleado e, Departamento d WHERE e.departamento.idDepto=d.idDepto";
//            List<Object[]> empleados = s.createQuery(hqlCons, Object[].class).getResultList(); 
//            empleados.forEach(a -> System.out.println(a[0]+"-"+a[1]));
            
            //  Mostrar todos los empleados del departamento (1) en este caso le pasamos el id para que nos devuelva
	    //	el objeto con el id, so podria comprobar con un if() si este existe pero paso de ponerlo xd
            Departamento depto = s.get(Departamento.class, 1);
            s.refresh(depto);
            
            System.out.println("************** DATOS DE EMPLEADOS **************");
            List<Empleado> empleados = s.createQuery("FROM Empleado WHERE departamento.idDepto = :id", Empleado.class).setParameter("id", depto.getIdDepto()).getResultList(); 
            System.out.println("empleados totales: " + empleados.size()); 
            empleados.forEach(emp -> System.out.println(emp.getNomEmp()));

            //  Mostrar Departamentos sobreescribiendo el metodo toString()
            String hql = "FROM Departamento";
            Query q = s.createQuery(hql);

            System.out.println("************** LEEMOS TODOS LOS DEPARTAMENTOS **************");
            System.out.println("*************************** DATOS **************************");

            List <Departamento> listResultados = q.list();

            listResultados.forEach(System.out::println);

            
            //  Primera forma aprendida en clase, el problema es que en la misma ejecucion no te coge el departamento
            //  que acabas de crear, mientras que con la consulta manual HQL esta si la reconoce.
//            Departamento deptoPrueba = s.get(Departamento.class, 10);
//            s.refresh(deptoPrueba);
//            
//            if(deptoPrueba != null){
//                System.out.println("************** DATOS DE EMPLEADOS **************");
//                
//                List<Empleado> empleados2 = new ArrayList<>(deptoPrueba.getEmpleados());
//                empleados2.forEach(emp -> System.out.println(emp.getNomEmp()));
//
//                String hql2 = "FROM Departamento";
//                Query q2 = s.createQuery(hql2);
//
//                System.out.println("************** LEEMOS TODOS LOS DEPARTAMENTOS **************");
//                System.out.println("*************************** DATOS **************************");
//
//                List <Departamento> listResultados2 = q2.list();
//
//                listResultados2.forEach(System.out::println);
//    
//            }else
//                System.out.println("El departamento no existe en la base de datos");
//            
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
