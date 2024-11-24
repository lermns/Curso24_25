// Crear la clase Alumno para que utilice los métodos estáticos definidos en la
// clase Ecuaciones, a través de una importación estática mediante el uso del 
// comodin (*).


package p1;

import static p0.Ecuaciones.*;


public class Alumno {

    public static void main(String[] args) {
        
        double radio = 1;
        double masa = 1;
        
        System.out.println("AREA DEL CIRCULO DE RADIO ... " + radio + " = " + calcularAreaCirculo(radio));

        System.out.println("\n");
        
        System.out.println("VOLUMEN DE LA ESFERA DE RADIO ... " + radio + " = " + calcularVolumenEsfera(radio));

        System.out.println("\n");
        
        System.out.println("ENERGIA ASOCIADA A LA PARTICULA DE MASA ... " + masa + " = " + calcularEnergiaAsociada(masa));
        
        System.out.println("\n");
        
        System.out.println("PESO ASOCIADO A LA MASA ... " + masa + " = " + calcularPeso(masa));
    }   

}