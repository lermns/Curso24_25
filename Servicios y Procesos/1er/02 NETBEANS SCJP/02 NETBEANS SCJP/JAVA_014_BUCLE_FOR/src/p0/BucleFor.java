// Crear una clase que ponga de manifiesto el comportamiento y estructura de un bucle
// de control for convencional ... for(;;)


package p0;

public class BucleFor {
    
    public static void main(String[] args) {

// LOS VALORES DE CADA ZONA ; SON OPCIONALES.
// BUCLE INFINITO ... EL CÓDDIGO QUE SIGA AL BUCLE NO SE PODRÁ EJECUTAR NUNCA ... Unreachable Statement.
//        for(  ;  ;  ) {
//        
//        }
        
//        int a = 5; // uso de variable externa.

// OK        
//        for(a = 100; ; ) {}

// OK        
//        for(int b = 3; ; ) {}  // uso de variable declarada en el propio bucle for.
  
// OK        
//        for(int c=4, d=5; ; ) {} // uso de multiples variables en la declaración del bucle for.
  
// ERROR ... no se admiten distintos tipos, pero si múltiples variables del mismo.        
//        for(int e=6, float f=7; ; ) {}

// ERROR ... no se puede volver a definir la variable g dentro del bucle for.        
//        int g = 0;
//        for(; g<10; g++) {
//            int g = 12;
//        }
        
        int x = 10;
        
        for(int y=0; y<1; y++) { // y++ o ++y funcionan igual (se hace después de ejecutar contenido del bucle).
            x = y;
        }
        
        System.out.println("x = " + x);        
    }
}