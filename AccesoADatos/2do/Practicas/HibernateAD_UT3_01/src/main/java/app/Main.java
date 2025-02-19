package app;

import java.util.*;
import java.util.logging.*;
import org.hibernate.*;
import org.hibernate.query.Query;
import orm.Tareas;

public class Main {
    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
        
        SessionFactory sf = null;
        Session s = null;
        Transaction t = null;
        
        //  Clase calendar para definir la fecha de la clase Date
        Calendar cal = Calendar.getInstance();
        Date date = new Date();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, -9);
        cal.add(Calendar.MONTH, -1);
        cal.add(Calendar.YEAR, -55);
        try{
            sf = HibernateUtil.getSessionFactory();
            s = HibernateUtil.abrirSesion();
            t = s.beginTransaction();
            
            
            //  A) agregamos las 5 tareas usando hibernate
            date = cal.getTime();           
            for(int i=1; i<6; i++){
                s.save(new Tareas("Tarea"+i, new Date(), date, false));
            }

            
            //  B) HQL para agregar los valores de una tabla definida con la misma 
            // estructura que la principal
            String hql = "insert into tareas (id, descripcion, fecha_inicio, fecha_fin, \n" +
                     "finalizada) select v.id, v.descripcion, v.fecha_inicio, \n" +
                     "v.fecha_fin, v.finalizada from tareasValues v";
            
            Query query = s.createSQLQuery(hql);
            int cant = query.executeUpdate();
            System.out.println("Cantidad de tareas agregada: " + cant);

            
            //  C) Consulta usando HQL del contenido de Tareas
            String hqlConsulta = "from Tareas";
            List<Tareas> listaTareas = s.createQuery(hqlConsulta, Tareas.class).getResultList();
            listaTareas.forEach(System.out::println);
            
            
            //  D) guardamos las tareas con ID pedidos
            Tareas t1 = s.get(Tareas.class, 2);
            Tareas t2 = s.get(Tareas.class, 4);
            
            //  contamos la cantidad de tareas que podremos actualizar
            int contAct = actualizarTarea(t1);
            contAct += actualizarTarea(t2);
            
            //  Las actualizamos
            s.update(t1);
            s.update(t2);
            
            System.out.println("Filas Actualizadas: " + contAct);
            
            //  Imprimimos la lista que ya teniamos definida y solo cogemos las 2 tareas que queriamos
            listaTareas.stream().filter(x -> (x.getId()%2==0&&x.getId()<5)).forEach(System.out::println);
  
            
            //  E) Actualizamos de la misma manera pero usando HQL
            String hqlUpdate = "update tareas set fecha_fin=:fe, finalizada=:fin where id in (7,9)";
            Query queryUp = s.createSQLQuery(hqlUpdate);
            queryUp.setParameter("fe", new Date());
            queryUp.setParameter("fin", true);
            
            int resUpdate = queryUp.executeUpdate();
            
            System.out.println("Cantidad de filas actualizadas: " + resUpdate);
            
            
            //  F) Aprovechando la lista que ya teniamos usando hql, la volvemos a mostrar con los valores
            //  que nos interesa
            s.clear();
            listaTareas = s.createQuery(hqlConsulta, Tareas.class).getResultList();
            listaTareas.stream().filter(x -> (x.getId()==7||x.getId()==9)).forEach(System.out::println);

            
            //  G)  usando HQL eliminamos la terea por el id pedido por consola
            System.out.println("Dame el id para eliminar del registro: ");
            short id = new Scanner(System.in).nextShort();
            
            int existe = (int)listaTareas.stream().filter(x -> (x.getId()==id)).count();
            
            if(existe>0){
                String hqlDelete = "delete from tareas where id=:id";
                Query queryDelete = s.createSQLQuery(hqlDelete);
                queryDelete.setParameter("id", id);
                int del = queryDelete.executeUpdate();
                System.out.println("Filas borradas: (" + del + ")...");
            }else
                System.out.println("No existe el id introducido...!");
            
            
//              H)  Mostramos las tareas sin la terea borrada, algo curioso es que 
//              cuando hacemos actualizaciones o inserciones una misma consulta HQL nos sirve
//              pero cuando borramos un registro este no lo ve, por lo que lo vuevlo a definir
//              para cargarlo con los valores borrados.

            listaTareas = s.createQuery(hqlConsulta, Tareas.class).getResultList();
            listaTareas.forEach(System.out::println);
            
            t.commit();
        }catch(HibernateException he){
            System.err.println("Error Hibernate: " + he.getMessage());
            if(t!=null)t.rollback();
        }finally{
            HibernateUtil.cerrarSession(s);
            HibernateUtil.cerrarSessionFactory();
        }
    }
    
    private static int actualizarTarea(Tareas t){
        if(t!=null){
            t.setFechaFin(new Date());
            t.setFinalizada(true);
            return 1;
        }
        return 0;
    }
}
            //  Tabla auxiliar para insertar valores a la principal usando HQL
            /*
            create table tareasValues(
                id integer primary key,
                descripcion char(7) not null,
                fecha_inicio date not null,
                fecha_fin date,
                finalizada boolean not null
            );
            //  Inserts para los datos que se van a agregar usando HQL
            insert into tareasValues values(6, 'Tarea6', '2025-02-10', '1970-01-01', false);
            insert into tareasValues values(7, 'Tarea7', '2025-02-10', '1970-01-01', false);
            insert into tareasValues values(8, 'Tarea8', '2025-02-10', '1970-01-01', false);
            insert into tareasValues values(9, 'Tarea9', '2025-02-10', '1970-01-01', false);
            insert into tareasValues values(10, 'Tarea10', '2025-02-10', '1970-01-01', false);
            */