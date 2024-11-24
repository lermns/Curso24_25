// Crear una clase que implemente el patrón de diseño Singleton (una sóla instancia para
// toda la aplicación.


package p0;



public class Singleton {
    
    // SI SÓLO HAY 1 HILO, CON TODA SEGURIDAD SE INSTANCIARÁ UN SÓLO OBJETO.
    // SI HAY VARIOS HILOS, DEBEMOS MODIFICAR EL CÓDIGO PARA DAR UNA GARANTÍA DEL 100%, USANDO:
    // Eagerly-declaration o bien Sincronización de método/bloque para comprobar null en variable.

    
    // private static Singleton singleton = new Singleton; // EAGERLY DECLARATION.    
    private static Singleton singleton; // variable privada y estática (NO FINAL).
    
    
    private Singleton() { // constructor privado
        System.out.println(">>> SE HA LLAMADO AL CONSTRUCTOR DEL SINGLETON");
    }
    
    public static Singleton obtenerSingleton() { // método público y estático.
 
        // sincronización a nivel de método. Implícitamente se usa la llave de instancia this.
        //synchronized public static Singleton obtenerSingleton() { // método publico y estático.        
        
        // o bien, sincronizando por bloque, usando el objeto fantasma o llave estática (1 por clase):
        //synchronized(Singleton.class) {
        
        if(singleton == null) {
            
            // *** ¿¿¿CONMUTAR HILO???. EN ESTOS MOMENTOS singleton SIGUE SIENDO null ***
            
            // SI JUSTAMENTE AHORA SE CONMUTA EL PRIMER HILO ENTRANTE, EL SIGUIENTE
            // PODRÍA GENERAR DE UNA VEZ TODO EL CÓDIGO CONTENIDO EN EL MÉTODO,
            // DEVOLVIENDO LA REFERENCIA AL OBJETO QUE EL MISMO HA CREADO CREADO.
            // A CONTINUACIÓN VUELVE A ENTRAR EL QUE PRIMERO LO HIZO, CREA EL OBJETO
            // MACHACANDO AL QUE YA SE HABÍA GENERADO DESPUÉS DE LA CONMUTACIÓN Y
            // DEVOLVIENDO LA REFERENCIA AL NUEVO OBJETO, CON LO QUE AL FINAL, NO
            // TENEMOS UNA ÚNICA INSTANCIA SINO 2, LO CUÁL HACE QUE YA NO SEA SINGLETON.
            System.out.println(">>> SE VA A CREAR LA INSTANCIA DEL SINGLETON");
            singleton = new Singleton();
        }
        
        //}

        return singleton;
    }

    
    public String toString(int x) {
        return "SOY EL SINGLETON";
    }
    

    
}
class Prueba {

    public static void main(String[] args) {
        
        //Singleton s0 = new Singleton(); // error, el constructor es privado.
        
        Singleton s1 = Singleton.obtenerSingleton(); // 1ª vez.
        System.out.println("s1 = " + s1);
        
        Singleton s2 = Singleton.obtenerSingleton(); // 2ª vez.
        System.out.println("s2 = " + s2);
        
        System.out.println("¿ Son iguales s1 y s2 ? ... " + (s1 == s2) ); // sí.
    }
}