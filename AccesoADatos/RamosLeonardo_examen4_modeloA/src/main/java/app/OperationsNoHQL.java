/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import orm.Planes;
import orm.Socios;

/**
 *
 * @author lermns
 */
public class OperationsNoHQL {
    private SessionFactory sf;
    private Session s;
    private Transaction t;
    
    
    public OperationsNoHQL(){
        sf = HibernateUtil.getSessionFactory();
        s = HibernateUtil.abrirSesion();
        t = s.beginTransaction();
    }
    
    public void insertarPlan(String nombre, int cuota){
        try{
            System.out.println("*** METODO Insertar Planes ***");
            Planes p = new Planes(nombre, cuota);
            s.save(p);
            s.refresh(p);
            t.commit();
        }catch(HibernateException e){
            System.out.println("Error en el metodo insertar Planes "+e.getMessage());
        }
        
    }
    
    public void mostrarSociosPorPlan(int cod_plan){
        try{
            System.out.println("*** METODO mostrarSociosPorPlan ***");
            System.out.println("*** CONTENIDO DE LA TABLA PLANES ***");
            Planes pln = s.get(Planes.class, cod_plan);
            Set<Socios> listPlan = pln.getSocioses();
            
            if(listPlan.size()>0){
                listPlan.forEach(System.out::println);
            }else
                System.out.println("No existe valores con este plan...!");
            
        }catch(HibernateException e){
            System.out.println("Error en el metodo mostrarSociosPorPlan "+e.getMessage());
        }
       
    }
}
