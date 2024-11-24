// Crear un interfaz que declare un par de métodos de compra válidos para un adulto.
// Dicha interfaz extiende o complementa los métodos de negocio del menor, ya que 
// adulto puede también comprar lo que compre un menor, pero NO al revés.

// Métodos para comprar alcohol y tabaco, pidiéndo ambos una cantidad de tipo entero.


package interfaces;

public interface InterfazAdulto extends InterfazMenor {

    public void comprarAlcohol(int cuantas);    
    public void comprarTabaco(int cuantas);    
}