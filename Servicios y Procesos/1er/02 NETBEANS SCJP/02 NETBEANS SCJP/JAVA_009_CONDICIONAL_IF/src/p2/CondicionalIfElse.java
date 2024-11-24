// Crear una clase que compruege el estado económico de una persona mediante el
// comparador relacional >= y la estructura disyuntiva(uno u otro) if-else.


package p2;

public class CondicionalIfElse {

    public static void main(String[] args) {
        
        int dinero = 3000;
        
        if(dinero >= 1000000) {
            System.out.println("ES RICO");
        } else {
            System.out.println("NO ES RICO");
        }        
    }    
}