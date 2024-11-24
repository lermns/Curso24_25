// Crear una clase en la que se usen los distintos tipos primitivos de Java.


package p1;

public class TiposPrimitivosJava {

    public static void main(String[] args) {

        // 1 bit (depende del hardware de la máquina, pero es lo habitual).
        boolean correcto1 = false;
        boolean correcto2 = true;
        
        if(5>3) { // los if siempre se evalúan a boolean (si no dará error).
            System.out.println("5 mayor que 3");
        }
        
        /////////////////////////////////////////////////////        
        
        // 8 bits ... 1(signo) + 7 módulo.
        // [-128 .. +127]  ............ -2^[n-1] .. +2[n-1] -1
        byte b1 = 3;
        byte b2 = -5;
        byte b3 = -128;
        //byte b4 = -129; // error, fuera de rango.
        byte b5 = 127;
        //byte b6 = 128; // error, fuera de rango.
        
        byte dinero_1 = 1;
        byte dinero_2 = 2;
        //byte dineroTotalError = dinero_1 + dinero_2; // error, resulta un int.
        byte dineroTotal = (byte)(dinero_1 + dinero_2); // autopromociona a int, hacer casting.
        System.out.println("dineroTotal = " + dineroTotal);
        
        // 16 bits ... 1(signo) + 15
        short sh1 = 1000;
        short sh2 = -500;        
        short sh3 = (short)(sh1 + sh2); // autopromociona a int, hacer casting.        
        short sh4 = 1000 - 500; // no hay autopromoción a int porque sólo son números.
        //short sh5 = 1000 - sh2;
        
        // 16 bits ... SIN SIGNO.
        char c1 = 'a';
        char c2 = '\u1234'; // CODIGO UNICODE DE 16 BITS.
        char c3 = 65; // la A.
        char c4 = 97; // la a ... los caracteres son en último caso números.

        System.out.println("c3 = " + c3);       
        System.out.println("c4 = " + c4);        
                
        // 32 bits ... 1(signo) + 31. *** LOS PREFERIDOS PARA PARTE ENTERA ***
        int altura1 = 10;
        int altura2 = 1000000000; // si superamos su rango, usar L, l para long.
        int altura3 = -889000000;
        
        int valorMinimo = Integer.MIN_VALUE;
        int valorMaximo = Integer.MAX_VALUE;
        int valorMaximoX2 = valorMaximo + valorMaximo; // no error, pero dato incorrecto.
        
        System.out.println("int maximo = " + valorMaximo);
        System.out.println("int minimo = " + valorMinimo);
        System.out.println("int maximoX2 = " + valorMaximoX2);
        
        // 64 bits ... 1(signo) + 63.        
        long deficitPublico1 = 8000000000L;  // L o l
        long deficitPublico2 = -3499999999975783746L;  // L o l
        
        /////////////////////////////////////////////////////
        
        // 32 ... con signo. Utiliza mantisa lo que permite un número mayor que long.
        float f1 = 3;
        
        long miLong = 1;
        float miFloat = miLong;
        //miLong = miFloat; // como se puede ver, float es mayor que long.
        
        //float f2 = 3.0; // EN EL MOMENTO EN EL QUE APARECE UN . LO TOMA COMO double.
        float f3 = 3.0F; // sufijos para float ... F f.
        float f4 = -23423342332342f;
        
        // 64 ... con signo. *** LOS PREFERIDOS PARA PARTE DECIMAL ***
        double d1 = 1;
        double d2 = -2;
        double d3 = d1 + d2;
        double d4 = 32423423423423D; // sufijos para double ... D d
        double d5 = 9.99d;
        
        
        byte el_byte        = 100;
        long el_long        = -33;
        double el_double    = 90000;
        
        //float resultado = el_byte + el_long + el_double; // ajusta a operador mayor.
        double resultado = el_byte + el_long + el_double; 
        
        byte un_byte    = 0;
        short un_short  = 0;
        char un_char    = 0;
        
        int resultado2 = un_byte + un_short + un_char; // promocionan a int.
     
        
        // HEXADECIMAL:
        int numeroHexadecimal = 0XFFFFF; // o bien con x.
        
        // OCTAL:
        int numeroOctal = 010;
        
        // BINARIO - JAVA 7:
        int numeroBinario = 0B1010; // o bien con b.
        
        
        // POR ÚLTIMO:
        // Recordar que no pueden mezclarse ni castearse tipos incompatibles de
        // datos, como boolean con int o String con Integer ... error compilación.
    }    
}