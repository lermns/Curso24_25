// Crear la clase que implemente a la interfaz I3 (contiene la declaración de todos
// los métodos, ya sean propios o heredados). Su nivel de encapsulación será "default", 
// lo que imposibilitará su uso fuera de su paquete de definición original (se busca el
// "programar en base a un supertipo, interfaz o clase abstracta, no una implementación").


package clases;

import interfaces.I3;

class ClaseImplementacion implements I3 {
    
    @Override
    public void m3() {
        System.out.println("metodo m3()");
    }

    @Override
    public void m2() {
        System.out.println("metodo m2()");
    }

    @Override
    public void m1() {
        System.out.println("metodo m1()");
    }

    // Este método es público y sin embargo la clase Cliente JAMÁS podrá hacer
    // uso de él (salvo que se modifique alguna de las interfaces de negocio, de
    // forma que dicho método, quede EXPUESTO en la interfaz).
    // Ésta es la técnica que siguen los EJB (Enterprise Java Bean) de cara a
    // utilizar la interfaz (remota o local) y la clase (Stateless, Stateful ...) 
    // que la implementa.
    public void m4() {
        System.out.println("metodo m4() ... PROPIO DE ClaseImplementacion");
    }    
}