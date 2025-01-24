/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import orm.Libro;

/**
 *
 * @author lermns
 */
public class Main {
    public static void main(String[] args) {
        
        //  Creamos la factoria de sesiones
        SessionFactory sf = HibernateUtil.getSessionFactory();
        
        //  Creamos/Abrimos la sesion
        Session s = sf.openSession();
        
        //  Creamos la transaccion
        Transaction t = s.beginTransaction();
        
        //  Hacemos lo que tengamos que hacer con la BDD. En este caso
        //  añadir un objeto libro
        Libro d = new Libro(978013188, "Thinking in Java2", "Bruce Eckel2");
        
        //  Guardamos el objeto en la base de datos
        s.save(d);
        
        //  Hacemos commit de la transacción
        t.commit();
        
        //  Cerramos la sesió
        s.close();
    }
}
