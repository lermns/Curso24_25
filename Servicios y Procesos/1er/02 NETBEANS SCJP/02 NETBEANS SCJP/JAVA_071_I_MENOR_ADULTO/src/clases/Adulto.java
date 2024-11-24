// Crear la implementación de la interfaz del adulto. La inicialización del atributo
// heredado se realizará por encadenamiento de constructores desde la clase hija a la
// madre.


package clases;

import interfaces.InterfazAdulto;

// Heredamos de Menor, con lo que tendremos sus "derechos" -> atributos y funcionalidad,
// y sus "obligaciones" -> el contrato a seguir, las obligaciones de las interfaces que
// pueda implementar, que de ser clase concreta ya estarán cumplidadas (implementadas),
// pudiéndose sobrescribir las mismas.

// Adulto cumple la regla IS-A con Adulto, Menor, Object, InterfazMenor e InterfazAdulto.

public class Adulto extends Menor implements InterfazAdulto {
   
    public Adulto(Tienda tienda) {
        super(tienda);
    }

    @Override
    public void comprarAlcohol(int cuantas) {
        tienda.comprarAlcohol(cuantas);
    }

    @Override
    public void comprarTabaco(int cuantas) {
        tienda.comprarTabaco(cuantas);
    }
}