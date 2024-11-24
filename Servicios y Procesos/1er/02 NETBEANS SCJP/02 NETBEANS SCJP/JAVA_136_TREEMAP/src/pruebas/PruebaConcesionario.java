// Crear una clase que genere distintos objetos Coche y se los asigne al concesionario,
// de modo que éste pueda mostrarlos ordenados en base a modelo, fecha y precio (este
// último tanto de forma ascendente como descendente).


package pruebas;

import coches.Coche;
import concesionarios.Concesionario;
import interfaces.Orden;

public class PruebaConcesionario {

    public static void main(String[] args) {              
        
        Concesionario concesionario = new Concesionario();
        
        Coche c1 = new Coche("PORSCHE 911", 2001, 80000);
        concesionario.añadirCoche(c1);
        
        Coche c2 = new Coche("FERRARI F50", 1997, 90000);
        concesionario.añadirCoche(c2);
        
        Coche c3 = new Coche("LAMBORGHINI AVENTATOR ", 2012, 130000);
        concesionario.añadirCoche(c3);
        
        System.out.println("\n______________ COCHES ORDENADOS POR MODELO - ASC ______________\n");
        
        concesionario.verCochesPorModelo();
        
        System.out.println("\n______________ COCHES ORDENADOS POR FECHA - ASC ________________\n");
        
        concesionario.verCochesPorFecha();

        
        System.out.println("\n_______________ COCHES ORDENADOS POR PRECIO - ASC _______________\n");
        
        concesionario.verCochesPorPrecio(Orden.MENOR_MAYOR_PRECIO);
        

        System.out.println("\n___________ COCHES ORDENADOS POR PRECIO INVERSO - DESC __________\n");
        
        concesionario.verCochesPorPrecio(Orden.MAYOR_MENOR_PRECIO);           
    }   
}