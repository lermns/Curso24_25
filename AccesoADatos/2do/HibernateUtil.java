
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
 
    //Método cerrarSessionFactory    
    public static void cerrarSessionFactory() {
        try {
            if (sessionFactory != null && !sessionFactory.isClosed()) {
                sessionFactory.close();
            }
        } catch (HibernateException he) {
            System.err.println("Error al cerrar SessionFactory: " + he.getMessage());
        }
    } //Fin método cerrarSessionFactory

    //Método abrirSesion
    public static Session abrirSesion() {
       try {
           return sessionFactory.openSession();
       } catch (HibernateException he) {
           System.err.println("Error al abrir Session: " + he.getMessage());
           return null;
       }
    } //Fin método abrirSession    

    //Método cerrarSesion
    public static void cerrarSesion(Session session){
        try {
            if (session != null && session.isOpen() ) {
                session.close();
            }
        } catch (HibernateException he) {
    System.err.println("Error al cerrar Session: " + he.getMessage());
        }
    } //Fin método cerrarSesion


}
