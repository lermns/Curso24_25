// Utilizar la clase PrintWriter para generar una simple página HTML, en la
// que se pueda apreciar la fecha actual. Abrir el fichero generado con un
// navegador web.

// Nota: El flujo escritor generará cada una de las etiquetas y su contenido,
// para que más tarde el navegador web las pueda renderizar (leer y dibujar) 
// por pantalla. Este es básicamente el funcionamiento de todo Servlet.

// Podemos, desde la pestaña Files, hacer botón derecho - view sobre el fichero,
// lo cuál abrirá automáticamente el navegador web por defecto del sistema.

package p1;

import java.io.PrintWriter;
import java.util.Date;


public class PaginaHTML {

    public static void main(String[] args) throws Exception {
        
        String fichero = "c:\\MIWEB\\miPaginaWeb.htm";
        
        PrintWriter escritor = new PrintWriter(fichero);
        
        escritor.println("<html>");
        escritor.println("<head></head>");        
        escritor.println("<body>");        
        escritor.println("<center>");
        escritor.println("<font color='blue' size='6'> MASTER JAVA </font>");
        escritor.println(new Date());
        escritor.println("</center>");
        escritor.println("</body>");
        escritor.println("</html>");

        escritor.flush();
        escritor.close();
        
        System.out.println("\n!!! ABRE EL FICHERO miPaginaWeb.htm !!!\n");
        System.out.println("\nFIN DE IMPRESION\n");        
    }
    
}