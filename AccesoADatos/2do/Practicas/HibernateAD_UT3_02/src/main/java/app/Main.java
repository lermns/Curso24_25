package app;


import java.util.List;
import java.util.Scanner;
import java.util.logging.*;
import org.hibernate.*;
import orm.Fabricante;
import orm.Producto;
import org.hibernate.query.Query;

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
            
            //  3)  
            String hqlConsulta = "select p.codigo, p.nombre, p.precio, p.codigoFabricante, p.fabricante.nombre"
                               + "from producto p join p.fabricante f";
            List<Object[]> productoList = s.createQuery(hqlConsulta, Object[].class).getResultList();
            
           
            productoList.forEach(x -> System.out.println("Fabricante: " + x[0] + " Producto: " + x[1]));
           
            //  4)
//            String hql = "from Producto";
//            List<Producto> listProducto = s.createQuery(hql, Producto.class).getResultList();
//            System.out.println("********************** LISTA DE TODOS LOS PRODUCTOS **********************");
//            listProducto.forEach(System.out::println);
//            
//            System.out.println("Dame el nombre del fabricante: ");
//            String fabr = new Scanner(System.in).nextLine();
//            
//            int existe = (int)s.createQuery("from Fabricante", Fabricante.class)
//                    .getResultList().stream().filter(x -> x.getNombre().equals(fabr.toUpperCase())).count();
//            
//            if(existe>0){
//                String hqlUpdate = "update producto set precio=precio*1.1 \n" +
//                                    "where codigo_fabricante in (select codigo " + 
//                                    "from fabricante where nombre=:nom);";
//                Query queryUpdate = s.createSQLQuery(hqlUpdate);
//                queryUpdate.setParameter("nom", fabr.toUpperCase());
//                
//                int cant = queryUpdate.executeUpdate();
//                System.out.println("Cantidad de filas afectadas " + cant);
//            }else{
//                System.out.println("El proveedor no existe en la base de datos");
//                System.exit(0);
//            }
//            
//            System.out.println("********************** LISTA DE TODOS LOS PRODUCTOS ACTUALIZADOS **********************");
//            s.clear();
//            listProducto = s.createQuery(hql, Producto.class).getResultList();
//            listProducto.forEach(System.out::println);
//            
//                //  6) Elimina todos los productos que contengan 'monitor' 
//                //  en este ejemplo seran los que contengan una 0
//                String hqlDelete = "delete from producto where nombre like '%o%'";
//                Query queryDelete = s.createSQLQuery(hqlDelete);
//                int cantDel = queryDelete.executeUpdate();
//                System.out.println("Cantidad de productos borrados: " + cantDel);
//                s.clear();
//                listProducto = s.createQuery(hql, Producto.class).getResultList();
//                listProducto.forEach(System.out::println);
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

/*  
//  1) Querys para crear las tablas
create table fabricante(
    codigo integer(10) auto_increment primary key,
    nombre varchar(100) not null
);

create table producto(
    codigo integer(10) auto_increment primary key,
    nombre varchar(100) not null,
    precio decimal(10,2) not null,
    codigo_fabricante integer(10) references fabricante(codigo)
);

2)
//  Insert de datos para fabricantes
insert into fabricante(nombre) values('ASUS');
insert into fabricante(nombre) values('ROG');
insert into fabricante(nombre) values('NVIDIA');
insert into fabricante(nombre) values('INTEL');
insert into fabricante(nombre) values('APPLE');
insert into fabricante(nombre) values('ALIENWARE');

//  insert de datos para producto
insert into producto(nombre, precio, codigo_fabricante) values('Portatil', 1800.0, 1);
insert into producto(nombre, precio, codigo_fabricante) values('PlacaMadre', 800.0, 1);
insert into producto(nombre, precio, codigo_fabricante) values('Fuente', 400.0, 2);
insert into producto(nombre, precio, codigo_fabricante) values('Tarjeta', 1200.0, 3);
insert into producto(nombre, precio, codigo_fabricante) values('Procesador', 900.0, 4);
insert into producto(nombre, precio, codigo_fabricante) values('Iphone 15', 1400.0, 5);
insert into producto(nombre, precio, codigo_fabricante) values('Mac-Book', 1800.0, 5);
insert into producto(nombre, precio, codigo_fabricante) values('Portatil', 2300.0, 6);

//  3) Consulta para ver los datos de ambas tablas
select p.codigo, p.nombre, p.precio, p.codigo_fabricante, f.nombre 
from producto p, fabricante f where p.codigo_fabricante=f.codigo;


//  5) Consulta 
select nombre, precio from producto order by precio desc;

//  7) Consulta
select p.codigo, p.nombre, p.precio, p.codigo_fabricante, f.nombre 
from producto p, fabricante f where p.codigo_fabricante=f.codigo;
*/
