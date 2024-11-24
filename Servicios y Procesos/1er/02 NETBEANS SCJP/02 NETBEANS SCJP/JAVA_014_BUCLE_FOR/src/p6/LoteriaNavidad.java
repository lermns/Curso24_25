// Crear una clase que genere los dígitos de un número de lotería mediante bucles
// for convencionales anidados y la sentencia continue. Emplear una variable String
// que vaya concatenando los distintos dígitos y la clase Math para generarlos 
// aleatoriamente, así como los if de control necesarios.

// BILLETE ... 5 DÍGITOS XXXXX, SIENDO EL PRIMERO [0..8] Y EL RESTO [0..9]
// RANGO DISPONIBLE ... [89999..00000]


package p6;

public class LoteriaNavidad {

    public static void main(String[] args) {

        //FORMA RÁPIDA:
        int aleatorio;
        
        for (int i=0;i<16;i++){
            aleatorio = (int) (Math.random() * 11);
            System.out.println(i + "-->" + aleatorio);
        }
        
      /*  
        
        // FORMA EXIGIDA:       
        /// billete con todos los digitos 00000 --> 89999.

        // TOTAL DE BILLETES DE PRUEBA QUE VAMOS A COMPRAR.
        int totalBilletes = 10;
        
        for (int i = 1; i <= totalBilletes; i++) {
            
            String billete = "";

            for (int indice = 0; indice < 5;) { // 5 dígitos // AQUÍ NO SE INCREMENTA EL ÍNDICE.

                int numero = (int) (Math.random() * 10); // [0..9] ... [0 .. N-1]

                if (indice == 0) { // primer dígito [0..8] ... 00000 ... 89999
                    if (numero == 9) {
                        //System.out.println("EL NUEVE EN PRIMER LUGAR NO ME VALE");
                        continue;  
                        //vuelve a la comprobación del for, no habiendo incrementado, por lo que el bucle for se repite hasta que la primera posición no tenga un 9 
                    }
                }

                billete += numero;
                indice++; // incrementamos aquí, una vez que vemos que el dígito es correcto.
            }
            
            System.out.println("TU BILLETE ES EL ... " + billete + "\n\n\n");
        }*/
    }
}