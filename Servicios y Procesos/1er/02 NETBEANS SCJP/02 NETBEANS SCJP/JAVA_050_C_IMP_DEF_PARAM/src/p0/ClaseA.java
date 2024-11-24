// Crear una clase que estudie las diferencias entre el denominado cómo constructor
// implícito (lo coloca el compilador al generar el .class) el de por defecto (cómo
// el implícito, pero lo escribe el programador ... explícitamente) y el parametrizado
// (aquél que emplea una cadena de parámetros de entrada separados por comas - los 
// valores recibidos es lo que denominamos argumentos).


package p0;

public class ClaseA {
// CONSTRUCTOR IMPLÍCITO:
//    public ClaseA() {
//        super(); // encadenamiento implícito con el constructor de la madre.
//    }
}

class B {
// CONSTRUCTOR POR DEFECTO:
    public B() {
        super();
    }
}

class C1 {
// CONSTRUCTOR PARAMETRIZADO:    
    public C1(int x) {}    
}

class C2 extends C1{
// CONSTRUCTOR PARAMETRIZADO:
    public C2(int x) {
        super(x); // encadenamiento correcto. El hecho de recibir un parámetro no obliga a utilizarlo.
    }   
}

class D1 {
    public D1(int x) {}                       
}

class D2 extends D1{
    public D2() {
        //super();      // ERROR, EN LA MADRE NO HAY CONSTRUCTOR QUE "CASE" CON ÉSTE.
        super(999);     // Podemos utilizar un valor por defecto en el encadenamiento.
    }
}