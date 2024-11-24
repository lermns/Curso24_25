// Crear la subclase Cuadrado, que a su vez es subclase de Rectangulo. Utilizar el
// encadenamiento de constructores para establecer el valor de los atributos base
// y altura (ambos son iguales y los llamaremos lado) para en base a ellos, calcular
// el area y el perimetro.

// Nota: la clase cuadrado no redefine los métodos de cálculo heredados de Rectangulo,
// ya que le son igualmente válidos (sólo tenemos que enviar los parámetros adecuados).


package p0;

public class Cuadrado extends Rectangulo {

    // Es un rectangulo de lados iguales, luego aprovechamos el código
    // ya implementado en la madre Rectángulo.
    public Cuadrado(double lado) { // el constructor pide 1 parámetro.
        super(lado,lado); // y encadena con el de la madre pasándoselo 2 veces.
    }   
}