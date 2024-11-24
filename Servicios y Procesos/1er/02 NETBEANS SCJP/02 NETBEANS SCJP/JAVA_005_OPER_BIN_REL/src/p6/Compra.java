// Crear una clase que realice la suma de distintos tipos de datos sobre una 
// misma variable de tipo byte, utilizando el operador de autoasignación +=,
// demostrándose que se produce el conocido autocasting al tipo receptor.


package p6;

public class Compra {

    public static void main(String[] args) {
        
        byte    cebolla     = 2;
        short   lechuga     = 1;
        int     tomate      = 3;
        long    pimiento    = 4;
        
        byte sumaTotal = 0;
        
        sumaTotal += cebolla;
        sumaTotal += lechuga;
        sumaTotal += tomate;
        sumaTotal += pimiento;
        
        System.out.println("SUMA TOTAL = " + sumaTotal);
    }    
}