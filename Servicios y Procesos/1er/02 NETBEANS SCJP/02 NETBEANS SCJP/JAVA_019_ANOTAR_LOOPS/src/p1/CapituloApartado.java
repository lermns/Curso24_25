// Crear una clase que simule la lectura de un libro. Dicho libro contendrá infinitos
// capítulos (representados por un número int que empecerá en 1) y 6 apartados (que
// representaremos por las letras a..f). Se comienza la lectura desde el capítulo 1,
// apartado a. Aleatoriamente para cada capítulo el sistema elige cuántos apartados
// se deben leer, de tal forma, que si son menos de 6 [a..e] y una vez impresos éstos,
// se continúa con el siguiente capítulo. Si son 6 [a..f], se imprimen todos ellos pero
// el programa finaliza indicando el mensaje " >>> NO QUIERO SEGUIR LEYENDO <<< ".
// En cualquier caso, saltaremos siempre el apartado 'd'.

// Utilizar anotación de bucles.


package p1;

public class CapituloApartado {

    public static void main(String[] args) {

        int capitulo = 1;

        bucleCapitulos:
        while (true) {

            int cuantosApartados = (int) (Math.random() * 6); // [0..5]
            System.out.println("cuantosApartados: "+(cuantosApartados+1));    
            // a  b  c  d  e  f
            // 0  1  2  3  4  5
            for (char apartado = 'a'; apartado <= ('a' + cuantosApartados); apartado++) {

                if (apartado == 'd') { // EL CAPITULO 'd' QUIERO SALTÁRMELO SIEMPRE
                    continue;
                }

                System.out.print(capitulo + "_" + apartado + " ... ");

                if (apartado == 'f') { // SI LLEGO ESA NOCHE HASTA EL CAPITULO 'f' YA NO LEO MÁS.
                    System.out.println("\n\n >>> NO QUIERO SEGUIR LEYENDO <<< ");
                    break bucleCapitulos;
                } 
            }

            capitulo++;

            System.out.println("\n________________________________________\n");
        }

        System.out.println("\n\n FIN DE PROGRAMA");
    }
}