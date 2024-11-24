// Crear una clase que ponga de manifiesto las reglas de la sobrescritura de cara
// al tratamiento de excepciones.

// Nota: Para las comprobativas, la hija debe declarar ... las de la madre, subtipos
// de ellas, menos o bien ninguna. En ningún caso puede declarar una comprobativa
// que no cumpla la regla IS-A con respecto a las declaradas en la madre. Respecto
// a las NO comprobativas, no hay ninguna regla a seguir.


package p4;

import java.io.IOException;
import java.sql.SQLException;


// CLASE MADRE.
public class SobrescrituraExcepciones {

    // SE PERMITE DEFINIR INFINITAS VECES EL LANZAMIENTO DE UNA DETERMINADA EXCEPCIÓN (INNECESARIO).
    // ... ADEMÁS, OBSERVAR CÓM SQLEXCEPTION YA ES UNA EXCEPTION ... REDUNDANCIA.     
    public void metodo() throws Exception, Exception, SQLException {}
}


// CLASE HIJA.
class Hija extends SobrescrituraExcepciones {

    
// ESTOS SON CORRECTOS:
    
//    @Override
//    public void metodo() throws Exception, SQLException {}

//    @Override
//    public void metodo() throws SQLException {} 
    
//    @Override
//    public void metodo() {}

//    @Override
//    public void metodo() throws IOException {}  // subtipo de Exception (es comprobativa).

    
// ESTOS NO SON CORRECTOS:    

//    @Override
//    public void metodo() throws Throwable {}   // sí comprobativa y de grano mayor.    

}