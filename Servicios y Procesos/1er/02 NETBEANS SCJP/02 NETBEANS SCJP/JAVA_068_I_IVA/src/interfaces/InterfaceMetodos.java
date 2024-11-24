// Crear una interfaz que estableza el contrato o conjunto de métodos de negocio que
// deberá tener la clase Articulo (y todos sus herederas). Dicha interfaz constituye
// el supertipo que nos ofrecerá lo que se conoce como "interfaz de negocio", declarando
// (no definiendo) los métodos que se podrán usar.

// Un buen diseño consistiría en trabajar con referencias a dicha interfaz (o alternativamente
// a una clase madre abstracta), rellenándolas con objetos de clases que la implementen
// (o hereden de ella si usamos clase abstracta ... es polimorfismo, regla IS_A).


package interfaces;

public interface InterfaceMetodos {

    void imprimirPrecioSinIVA();
    
    void imprimirPrecioConIVA();   
}