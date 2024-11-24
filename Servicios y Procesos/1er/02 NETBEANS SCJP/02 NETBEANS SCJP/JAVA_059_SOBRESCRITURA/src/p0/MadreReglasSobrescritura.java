// Crear una clase que demuestre las reglas de la sobrescritura.


package p0;

public class MadreReglasSobrescritura {

//// CLASE MADRE QUE DEFINE DIVERSOS MÉTODOS ////    
    
    public void m1() {
        System.out.println("METODO m1 DE LA MADRE");
    }
        
    public int m2() {
        return 10;
    }
    
    protected String m3() {
        return "";
    }
    
    public static void m4() {}
    
    public static final void m5() {}
    
    public final void m6() {}
    
    public void m7(int x) {}
    
    void m8(Object y) {}
    
     // Java 5 y posteriores admite devolución COVARIANTE (tipo y subtipo del declarado).
    Animal m9() { return null; }
    
     // con este método no hay herencia visible, luego no cabe hablar de sobrescritura.
    private void m10(Object y) {}
}


//// CLASE HIJA QUE TRATARÁ DE SOBRESCRIBIR LOS MÉTODOS DE LA MADRE ////

class Hija extends MadreReglasSobrescritura {

    @Override
    public void m1() {
        super.m1(); // podemos invocar a la definición de la madre (vigilar encapsulación).
        System.out.println("SOBRESCRITO EN HIJA");
    }
    
    @Override
    public int m2() {
        return super.m2() + 100; // 10 + 100 = 110 como valor devuelto.
    }
    
    @Override
    protected String m3() { // nivel de encapsulación original o más visible.
        return "";
    }    
        
//    @Override    
//    public String m3() { // por lo que public también sería correcto.
//        return "";
//    }    
    
    //@Override // error en anotación. los estáticos no admiten sobrescritura.
    public static void m4() {}    
    
    //@Override // si además de estático es final, no se permite la versión de Hija.    
    //public static final void m5() {}    
        
    //@Override // el método es final, no se puede sobrescribir.    
    //public final void m6() {}
        
    @Override    
    public void m7(int x) {}    
    //public void m7(Integer x) {} // no se permite autoboxing en la declaración (tipo exacto).
    // Sí podriamos pasarle al método un argumento de tipo Integer (se hace autoBoxing). Así, 
    // tanto a la entrada como a la salida del método, se aplicaría autoBoxing o autoUnBoxing.
    
    @Override
    void m8(Object y) {}
    //public void m8(Object y) {} // correcto, public es más visible que "default".
    //protected void m8(Object y) {} // correcto, protected es más visible que "default".            
    //void m8(String y) {} // error ... el covariante sólo se aplica al dato devuelto. Java 5.

    Gato m9() {
        return new Gato();
    }
    
    //@Override // error. Lo private no se hereada (no directamente visible .. se anexa).
    private void m10(Object y) {}   // este método es propio de la hija. No hay sobrescritura,
                                    // luego puedo declararlo como quiera (ninguna regla a cumplir).
}



// CLASES DE APOYO PARA DEMOSTRAR LA DEVOLUCIÓN COVARIANTE.

abstract class Animal {}

class Gato extends Animal {}