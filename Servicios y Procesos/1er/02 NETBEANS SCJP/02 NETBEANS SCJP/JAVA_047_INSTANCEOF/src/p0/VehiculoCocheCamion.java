// Crear una clase que demuestre el funcionamiento del operador instanceof.
// Para ello, crear las clases Vehiculo, Camion y coche. Crear un array (TYPE-SAFE)
// de elementos Vehiculos y rellenar sus posiciones con los siguientes objetos:
// Vehiculo + Coche + Camion. Utilizar un bucle for-each para ir comprobando uno
// a uno si cada uno de ellos pasan la prueba (true/false) del operador. Utilizar
// un simple operador ternario para indicar si se es o no instancia de cada una
// de las anteriores clases.

// Nota: Dado que el tipo utilizado es Vehiculo para almacenar todos y cada uno de
// los objetos, no tendremos ningún problema al aplicar el operador. Si quisiésemos
// utilizarlo para relacionar Coche con Camion, obtendríamos un error de compilación
// puesto que no hay relación entre ambas clases.

// Una referencia puede contener null (vacia) en cuyo caso, el operador dará siempre false.


package p0;



public class VehiculoCocheCamion {

    public static void main(String[] args) {

        Coche c = new Coche();
        
        // Error. Coche y Camión no tienen ningún tipo de relación y por tanto no se puede
        // aplicar el operador.
        //System.out.println("¿coche es intancia de camion?" + (c instanceof Camion));
        
        Vehiculo[] vehiculos = {new Vehiculo(), new Coche(), new Camion()};
        
        for(Vehiculo vehiculo : vehiculos) {
            System.out.println  (                    
                                    vehiculo + " ¿es instancia de Vehiculo? ... " +
                                    ((vehiculo instanceof Vehiculo)?"SI":"NO")                    
                                );

            System.out.println("\n___________________________________________\n");
            
            System.out.println  (                    
                                    vehiculo + " ¿es instancia de Coche? ... " +
                                    ((vehiculo instanceof Coche)?"SI":"NO")                    
                                );

            System.out.println("\n___________________________________________\n");
            
            System.out.println  (                    
                                    vehiculo + " ¿es instancia de Camion? ... " +
                                    ((vehiculo instanceof Camion)?"SI":"NO")                    
                                );   
            
            System.out.println("\n...............................................\n");
        }   
    }
}
class Vehiculo {

    @Override
    public String toString() {
        return getClass().getSimpleName().toUpperCase();
    }    
}

class Coche extends Vehiculo {}

class Camion extends Vehiculo {}