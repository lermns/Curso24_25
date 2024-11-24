// Crear una clase que compruebe cómo el utilizar el pre o post incrementador en 
// una operación de asignación puede tener como resultado un comportamiento distinto
// en cada caso.

// Aplicar dichos conceptos a un supuesto en el que se permite o no la entrada a
// la discoteca a una persona, sólo en caso de tener cumplidos los 18 años de edad.

package p0;

public class AutoIncrementalAsignacion {

    public static void main(String[] args) {
        
        int contador = 10;

        System.out.println("contador = " + contador);
                
        int consultaContador = contador++;
        
        System.out.println("consultaContador = " + consultaContador);
        System.out.println("contador = " + contador);


        System.out.println("\n_________________________________\n");
        
        
        int contador2 = 10;

        System.out.println("contador2 = " + contador2);
                
        int consultacontador2 = ++contador2;
        
        System.out.println("consultacontador2 = " + consultacontador2);
        System.out.println("contador2 = " + contador2);
        
                
        System.out.println("\n_________________________________\n");
        
        
        // edad++ >= 18 ... evalúa primero y luego incrementa.
        // ++edad >= 18 ... incrementa primero y luego evalua.
        
        
        // Partimos de que la persona tiene 17 años, que incrementaremos en +1:
        int edad = 17;
        
        // UTILIZACIÓN DEL POST Y PRE INCREMENTADOR PARA PERMITIR ACCESO A LA DISCOTECA:        
        //if(edad++ >= 18) { // NO ENTRARÁ.
        if(++edad >= 18) {   // SÍ ENTRARÁ.
            System.out.println("ERES MAYOR DE EDAD ... PUEDES ENTRAR A LA DISCOTECA");
        } else {
            System.out.println("ESPERATE A TENER LOS 18");
        }
    }    
}