
import java.util.HashMap;
import java.util.Iterator;


/*
 String,Persona
 <k,v>
 Ana garcía  Objeto
 nombre_Apellidos
 * 
   
   
   
   
 */
public class AgendaPersonas {
    private HashMap<Integer, Persona> mapaContactos;

    
    public AgendaPersonas() {
        mapaContactos = new HashMap<Integer, Persona>();
    }

    
    
    private boolean existe(int nif) {        
        return mapaContactos.containsKey(nif);    
    }

    public void añadir(int nif, Persona persona) {
        // comprobar si el nombre existe, en cuyo caso no se añade.
        if(!existe(nif)) {
            mapaContactos.put(nif, persona);
            System.out.println("AÑADIDO ... " + persona.getNif() + " " + persona.getNombre() + " " + persona.getApellido() + ", " +persona.getTelefono());
        } else {        
            System.out.println("NO SE HA PODIDO AÑADIR ... " +persona.getNif()+": " + persona.getNombre() +
                ", EL CONTACTO YA EXISTE");
        }
        
        System.out.println("\n___________________________________________________\n");                
    }
    
    public void modificar(int nif, Persona persona) {
        // comprobar si el nombre existe para poder ser modificado.
        if(existe(persona.getNif())) {
            Persona personaAntigua = mapaContactos.put(persona.getNif(), persona);
            System.out.println("MODIFICADO ... \n NIF: " + personaAntigua.getNif() + ":");
            System.out.println("\nNOMBRE: " + personaAntigua.getNombre() + " " + personaAntigua.getApellido());
            System.out.println("\nTELEFONO: " + personaAntigua.getTelefono());            
        } else {        
            System.out.println("NO SE HA PODIDO MODIFICAR NIF: " + persona.getNif() +
                ", EL CONTACTO NO EXISTE");
        }
        
        System.out.println("\n___________________________________________________\n");                    
    }
    
     public void buscar(int nif) {
        // si el nombre existe, se obtendrá su valor a través de su clave.
        if(existe(nif)) {
            System.out.println("ENCONTRADO ... " + nif + ", " + mapaContactos.get(nif).getNif()+ ", " + mapaContactos.get(nif).getNombre()+ ", " + mapaContactos.get(nif).getApellido()+ ", " + mapaContactos.get(nif).getTelefono());
                            
        } else {
            System.out.println("CONTACTO NO ENCONTRADO ... " + nif);
        }   
        
        System.out.println("\n___________________________________________________\n");                
    }
     
     public void borrar(int nif) {
        // sólo si el nombre existe se podrá borrar.
        if(existe(nif)) {
            System.out.println("BORRADO ... " + nif);
            mapaContactos.remove(nif);
        } else {
            System.out.println("IMPOSIBLE BORRAR ... " + nif + ", CONTACTO NO ENCONTRADO");
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
        Iterator <Integer> e = mapaContactos.keySet().iterator(); // obtener las claves.
        
        int contador = 0;
        
        while(e.hasNext()) {
            Integer nif = e.next();
            System.out.println("listado Buscar: ");
            buscar(nif);
            System.out.println("listado a pelo-----: ");
            Persona pers = mapaContactos.get(nif); // obtener el valor.
            System.out.println(++contador + " ---> [" + pers.getNif() + " " + pers.getNombre() + ", " + pers.getApellido() + ", " + pers.getTelefono() + "]");
        }
        
        if(contador == 0) {
            System.out.println("NO HAY NINGUN CONTACTO EN LA AGENDA");
        }
        
        System.out.println("\n___________________________________________________\n");        
    }
     public static void main(String[] args) {
        
        AgendaPersonas agenda = new AgendaPersonas();
        
        agenda.listar();
        
        Persona p0= new Persona(45687390, "ANA", "ANA", 617889966);
        Persona p1= new Persona(45687391, "PEDRO", "PEDRO", 617889963);
        Persona p2= new Persona(45687392, "LUIS", "LUIS", 617889964);
        Persona p3= new Persona(45687393, "PEPE", "PEPE", 617889965);
        
        Persona pAnadir= new Persona(45687390, "ANA", "ANA", 617889966);
        Persona pAnadir2= new Persona(75687390, "andres", "andres", 619427057);
        
        
        agenda.añadir(45687390, p0);
        agenda.añadir(45687391, p1);
        agenda.añadir(45687392, p2);
        agenda.añadir(45687393, p3);
        
        agenda.listar();
    
        // Prueba de métodos de la agenda sobre ANA:        
        agenda.añadir(45687390, pAnadir);
        
        agenda.buscar(45687390);
        
        agenda.modificar(45687393, pAnadir2);
        
        agenda.borrar(45687390);
        
        agenda.listar();
        
        agenda.borrar(45687390);
        
        agenda.listar();
        
        agenda.borrarTodos();
        
        agenda.listar();
    }   
}
