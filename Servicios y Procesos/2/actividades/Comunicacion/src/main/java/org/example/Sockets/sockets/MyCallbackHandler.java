package org.example.Sockets.sockets;

import java.io.*;
import javax.security.auth.callback.*; 

public class MyCallbackHandler implements CallbackHandler { 
      
      private String usuario;
      private String clave; 
      
      //Constructor recibe parámetros usuario y clave 
      public MyCallbackHandler(String usu, String clave) { 
            
            this.usuario = usu; 
            this.clave = clave;
      } 
      
      //método handle sera invocado por el LoginMbdule 
      public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException { 
            
            for (int i = 0; i < callbacks.length; i++) { 
                  
                  Callback callback = callbacks[i]; 
                  if (callback instanceof NameCallback) { 
                        NameCallback nameCB = (NameCallback) callback; 
                        //se asigna al NameCallback el nombre de usuario 
                        nameCB.setName(usuario);     
                  } else if (callback instanceof PasswordCallback) { 
                        PasswordCallback passwordCB = (PasswordCallback) callback; 
                        //se asigna al PasswordCallback la clave    
                        passwordCB.setPassword(clave.toCharArray()); 
                  }// fin del if 
            }// fin del for
            
      }// Fin de handle
}// Fin de handle MyCallbackHandler
