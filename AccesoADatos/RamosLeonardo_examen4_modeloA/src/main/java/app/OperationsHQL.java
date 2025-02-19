/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import orm.FormaPago;
import orm.Planes;
import orm.Socios;

/**
 *
 * @author lermns
 */
public class OperationsHQL {
    private SessionFactory sf;
    private Session s;
    private Transaction t;
    
    
    public OperationsHQL(){
        sf = HibernateUtil.getSessionFactory();
        s = HibernateUtil.abrirSesion();
        t = s.beginTransaction();
    }
    
    public void mostrarPlanes(){
        System.out.println("*** METODO MOSTRAR_PLANES ***");
        System.out.println("*** CONTENIDO DE LA TABLA PLANES ***");
        String hql = "From Planes";
        try{
            List<Planes> listaPlanes = s.createQuery(hql, Planes.class).getResultList();
            listaPlanes.forEach(x -> System.out.println(x.toStringSelectForm()));
        }catch(Exception e){
            System.out.println("Error metodo mostrar planes" + e.getMessage());
        }
    }
    
    public void mostrarFormaPago(){
        System.out.println("*** METODO FORMA_PAGO***");
        System.out.println("*** CONTENIDO DE LA TABLA FORMA PAGO ***");
        String hql = "From FormaPago";
        try{
            List<FormaPago> listaFormaPago = s.createQuery(hql, FormaPago.class).getResultList();
            listaFormaPago.forEach(x -> System.out.println(x.toStringSelectForm()));
        }catch(Exception e){
            System.out.println("Error metodo forma pago" + e.getMessage());
        }
    }
    
    public void mostrarSocios(){
        System.out.println("*** METODO Mostrar Socios***");
        System.out.println("*** CONTENIDO DE LA TABLA Socios***");
        String hql2 = "From Socios";
        try{
            List<Socios> listaSocios = s.createQuery(hql2, Socios.class).getResultList();
            listaSocios.forEach(System.out::println);
           
        }catch(Exception e){
            System.out.println("Error metodo forma pago" + e.getMessage());
        }
    }
    
    public void aplicarDescuentoPagoAnual(float desc, int cod){
        System.out.println("*** METODO Aplicar Descuento***");
        float descuento = desc/100;
        
        try{
        String hql = "update socios set cuota_cli=cuota_cli*:desc"
                + "where id_pago = :pago";
        
       
        Query query = s.createSQLQuery(hql);
        query.setParameter(":desc", descuento);
        query.setParameter(":pago", cod);
        int resUpdate = query.executeUpdate();
        t.commit();
        System.out.println("CAntidad de filas Actualizadas: " + resUpdate);
        }catch(Exception e){
            System.out.println("Error metodo aplicar descuento" + e.getMessage());
        }
    }
}