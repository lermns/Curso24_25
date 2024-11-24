// Crear una clase que realice distintas operaciones sobre una pareja de datos
// para comprobar el funcionamiento de las trazas.

// IMPORTANTE: Borrar el fichero, si ya existe, antes de ejecutar la aplicación,
//             ya que de lo contrario, arrastraremos trazas de ejecuciones
//             anteriores.


package p0;


public class PruebaCalculadora {

    public static void main(String[] args) {
        
        Calculadora calculadora = new Calculadora();
        
        // traza correcta ... suma de 1 y 2:
        calculadora.sumar(1,2);       
        
        // traza correcta ... división de 1 con 2:
        // calculadora.dividir(1,2);

        // traza de error ... división por cero:
        // calculadora.dividir(1,0);
    }
    
}