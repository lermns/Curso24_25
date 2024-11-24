// Crear una clase Agenda que en base a una colección Hashtable (mapa) nos
// permita almacenar nombres de personas y su numero de teléfono. Así, se
// utilizará un String para el nombre, el cuál constituye la clave del
// mapa y un Integer para el teléfono, el valor. Se definen un conjunto de
// métodos para trabajar sobre dicha agenda, pudiéndose añadir, modificar,
// buscar, borrar, borrar todos y listar todos.

// Se generan distintos contactos, nuevos y repetidos y se opera sobre ellos
// para comprobar el funcionamiento del sistema.

// Nota: Es adecuado externalizar la funcionalidad de busqueda de un nombre
//       en un método "existe(String)" que devolverá un booleano, en lugar
//       de estar invocando repetidamente al método contains del Hashtable.
//       De esta forma, el código resulta más legible y podemos más tarde
//       añadir nueva funcionalidad o cambiar la existente con facilidad,
//       al haber hecho uso de la centralización.


package p0;

import java.util.Enumeration;
import java.util.Hashtable;


public class Agenda {

    private Hashtable<String, Integer> mapaContactos;
    
    
    public Agenda() {
        mapaContactos = new Hashtable<String, Integer>();
    }
    
    
    // Este método se empleará numerosas veces.
    private boolean existe(String nombre) {        
        return mapaContactos.containsKey(nombre);    
    }
    
    
    public void añadir(String nombre, Integer telefono) {
        // comprobar si el nombre existe, en cuyo caso no se añade.
        if(!existe(nombre)) {
            mapaContactos.put(nombre, telefono);
            System.out.println("AÑADIDO ... " + nombre + ", " + telefono);
        } else {        
            System.out.println("NO SE HA PODIDO AÑADIR ... " + nombre +
                ", EL CONTACTO YA EXISTE");
        }
        
        System.out.println("\n___________________________________________________\n");                
    }
    
    
    public void modificar(String nombre, Integer telefono) {
        // comprobar si el nombre existe para poder ser modificado.
        if(existe(nombre)) {
            Integer telefonoAntiguo = mapaContactos.put(nombre, telefono);
            System.out.println("MODIFICADO ... " + nombre + ":");
            System.out.println("TELEFONO ANTIGUO ... " + telefonoAntiguo);
            System.out.println("TELEFONO NUEVO ... " + telefono);            
        } else {        
            System.out.println("NO SE HA PODIDO MODIFICAR ... " + nombre +
                ", EL CONTACTO NO EXISTE");
        }
        
        System.out.println("\n___________________________________________________\n");                    
    }

    
    public void buscar(String nombre) {
        // si el nombre existe, se obtendrá su valor a través de su clave.
        if(existe(nombre)) {
            System.out.println("ENCONTRADO ... " + nombre + ", " +
                mapaContactos.get(nombre));            
        } else {
            System.out.println("CONTACTO NO ENCONTRADO ... " + nombre);
        }   
        
        System.out.println("\n___________________________________________________\n");                
    }
    
    
    public void borrar(String nombre) {
        // sólo si el nombre existe se podrá borrar.
        if(existe(nombre)) {
            System.out.println("BORRADO ... " + nombre);
            mapaContactos.remove(nombre);
        } else {
            System.out.println("IMPOSIBLE BORRAR ... " + nombre + ", CONTACTO NO ENCONTRADO");
        }
        
        System.out.println("\n___________________________________________________\n");                
    }
    
    
    public void borrarTodos() {
        // limpiar de claves/valores toda la agenda.
        mapaContactos.clear();
        System.out.println("SE HAN BORRADO TODOS LOS CONTACTOS");
        
        System.out.println("\n___________________________________________________\n");                        
    }
    
    
    public void listar() {        
        // mostrar todos los nombres y su correspondiente valor.
        Enumeration<String> e = mapaContactos.keys(); // obtener las claves.
        
        int contador = 0;
        
        while(e.hasMoreElements()) {
            String nombre = e.nextElement();
            Integer telefono = mapaContactos.get(nombre); // obtener el valor.
            System.out.println(++contador + " ---> [" + nombre + ", " + telefono + "]");
        }
        
        if(contador == 0) {
            System.out.println("NO HAY NINGUN CONTACTO EN LA AGENDA");
        }
        
        System.out.println("\n___________________________________________________\n");        
    }

    
    
    public static void main(String[] args) {
        
        Agenda agenda = new Agenda();
        
        agenda.listar();
        
        agenda.añadir("ANA", 617889966);
        agenda.añadir("LUIS", 916904532);
        agenda.añadir("JUAN", 777555666);
        agenda.añadir("PEDRO", 916456753);
        
        agenda.listar();
    
        // Prueba de métodos de la agenda sobre ANA:        
        agenda.añadir("ANA", 123456789);
        
        agenda.buscar("ANA");
        
        agenda.modificar("ANA", 666666666);
        
        agenda.borrar("ANA");
        
        agenda.listar();
        
        agenda.borrar("ANA");
        
        agenda.listar();
        
        agenda.borrarTodos();
        
        agenda.listar();
    }   

}