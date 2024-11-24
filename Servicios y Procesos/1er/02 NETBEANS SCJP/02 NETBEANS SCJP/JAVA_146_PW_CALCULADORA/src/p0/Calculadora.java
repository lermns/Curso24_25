// Crear la clase Calculadora para poder realizar la suma y la división de
// 2 números de tipo double. Se dispondrá de un sistema de traza (escribir
// en un fichero las distintas etapas del comportamiento del sistema para 
// su posterior análisis y depuración) implementado a través del uso de la
// clase PrintWriter.

// Nota: Se dispone en Java de la API - Log4J -  para realizar trazas, en
//       la que se pueden definir niveles de gravedad, qué información se
//       ha de generar y muchos otros aspectos. Antes de utilizar un código
//       propietario, conviene pensar en algún framework de desarrollo ya
//       constituido (hace que el resto de nuestro código sea más universal y
//       a la larga, más fácil de mantener).


package p0;


public class Calculadora {

    public void sumar(double x, double y) {
        double resultado = 0;
        try {
            resultado = x + y;
            System.out.println("RESULTADO DE SUMAR " + x + " CON " + y
                    + " = " + resultado);
            Trazador.escribirTraza("sumar", x, y, resultado);
        } catch (Exception e) {
            System.out.println("SE HA PRODUCIDO UN ERROR");
            System.out.println(e.getMessage());
            Trazador.escribirTraza(e.getMessage());
        }
    }

    
    public void dividir(double x, double y) {
        double resultado = 0;
        try {
            if(y==0) { // error de división por cero.
                throw new Exception("OPERADOR " + x + ", OPERADOR " + y + " ---> DIVISOR 0");
            }
            resultado = x / y;            
            Trazador.escribirTraza("dividir", x, y, resultado);
            System.out.println("RESULTADO DE DIVIDIR " + x + " CON " + y
                    + " = " + resultado);

        } catch (Exception e) {
            System.out.println("SE HA PRODUCIDO UN ERROR ... " + x + "/" + y + " ---> INFINITO");
            System.out.println(e.getMessage());
            Trazador.escribirTraza(e.getMessage());
        }
    }
    
}