// Crear una clase que simule el comportamiento de una cuerda elástica (imprimiendo
// por pantalla asteriscos separados por espacios blancos) que estiraremos de forma
// indefinida hasta que se rompa (será el momento en el que el valor de ruptura sea
// igual o inferior al aplicado sobre la cuerda). Utilizaremos break y continue.

// La fuerza aplicada a la cuerda viene representada por un valor aleatorio [1..10] y
// el punto de ruptura por un offset fijo [7] + un valor aleatorio [1..3], de forma
// que para cada ejecución del programa variará en el margen [7..10].


package p2;

public class EstiramientoCuerda {

    public static void main(String[] args) {

        // DEFINIMOS EL PUNTO DE RUPTURA COMO UN OFFSET FIJO + UN VALOR ALEATORIO:
        int ruptura = 7 + (int)(Math.random()*4); // [0..3] mín=7+0=7 .. máx=7+3=10.
        
        // LA FUERZA REAL QUE SE APLICARÁ A LA CUERDA.
        int estiramiento;
        
        System.out.println("PUNTO DE RUPTURA EN ... " + ruptura + "\n\n");
                
        while (true)  { // bucle infinito, estirar mientras no se rompa.
            estiramiento = (int)(Math.random()*10) + 1; // [1..10]
            
            if(estiramiento >= ruptura) {
                System.out.println("\nLA CUERDA SE HA ROTO CON ESTIRAMIENTO = " + estiramiento + "\n");
                break;
            }
            
            for (int i = 1; i <= estiramiento; i++) { // dibujar los * * * de la cuerda.
                System.out.print("* ");
            }

            System.out.println("   estiramiento = " + estiramiento);
        }
        
        System.out.println("\nFIN DE PROGRAMA\n");
    }
}