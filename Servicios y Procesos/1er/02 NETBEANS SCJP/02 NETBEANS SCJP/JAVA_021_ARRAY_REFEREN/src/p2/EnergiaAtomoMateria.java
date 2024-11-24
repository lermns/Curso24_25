// Crear una clase que demuestre cómo en un array de un determinado tipo, se pueden
// añadir elementos de dicho tipo y subtipos (relación IS-A), almacenándose los mismos
// con el tipo empleado en la declaración.

// Crear la siguiente línea de jerarquía de clases (todo en el mismo fichero):
// Energia <-- Atomo <-- Materia.


package p2;

public class EnergiaAtomoMateria {

    public static void main(String[] args) {
        
        // PUEDO ALMACENAR LOS 3 TIPOS, PORQUE TODOS ELLOS SON Energia.
        Energia[] energias = new Energia[3];
        
        energias[0] = new Energia();
        energias[1] = new Materia();
        energias[2] = new Atomo();
        
        for(Energia e : energias) {
            System.out.println("---> " + e.getClass().getSimpleName());
        }
        
        
        System.out.println("\n____________________________\n");

        
        // SÓLO PUEDO ALMACENAR 2 TIPOS, LOS QUE SEAN Atomo (Energia NO LO ES).        
        Atomo[] atomos = new Atomo[2];
        
        atomos[0] = new Atomo();
        atomos[1] = new Materia();
        
        for(Atomo a : atomos) {
            System.out.println("---> " + a.getClass().getSimpleName());
        }
        

        System.out.println("\n____________________________\n");        
        
        // SÓLO PUEDO ALMACENAR 1 TIPOS, EL QUE SEA Materia (Energia Y Atomo NO LO SON).                
        Materia[] materias = new Materia[1];
        
        materias[0] = new Materia();

        for(Materia m : materias) {
            System.out.println("---> " + m.getClass().getSimpleName());
        }        
    }    
}

//////////////////////////////////////////////////////////////////////////

// VIGILAR LA REGLA IS-A.
class Energia {}

class Atomo extends Energia {}

class Materia extends Atomo {}