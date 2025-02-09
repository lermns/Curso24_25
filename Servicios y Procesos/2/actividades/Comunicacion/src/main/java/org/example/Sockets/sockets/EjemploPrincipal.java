package org.example.Sockets.sockets;

import java.security.Principal;

public class EjemploPrincipal implements Principal, java.io.Serializable { 
      
      private String name;//nombre del principal 
      
      //Crea un EjemploPrincipal con el nombre suministrado. 
      public EjemploPrincipal(String name) { 
            
            if (name == null) 
                  throw new NullPointerException("Entrada nula"); 
            this.name = name; 
      } 
      
      //Devuelve el nombre del Principal
      public String getName() {return name;} 
      
      //Compara el objeto especificado con el Principal 
      //para ver si son iguales. 
      public boolean equals(Object o) { 
            
            if (o == null) return false; 
            if (this == o) return true; 
            if (!(o instanceof EjemploPrincipal)) return false; 
            EjemploPrincipal that = (EjemploPrincipal) o; 
            if (this.getName().equals(that.getName())) return true; 
            
            return false; 
      }//Fin de equals

      public int hashCode() {return name.hashCode();} 
      
      public String toString() {return (name);} 
      
}//Fin de EjemploPrincipal
