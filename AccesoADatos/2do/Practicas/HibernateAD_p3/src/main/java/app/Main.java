package app;

import java.util.logging.*;

public class Main {
    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
        OperationsHQL hqlOper = new OperationsHQL();
        
        //hqlOper.borrarLibroHQL(2);
        String s = "j";
        hqlOper.leerLibrosConFiltroHQL(s);
    }
}
