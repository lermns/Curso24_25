// Crear la clase Empleado la cual definirá funcionalidad en el main para 
// determinar, de forma aleatoria, si la empresa le ha pagado o no la nomina
// del mes. En caso negativo, se deberá lanzar la excepción personalizada
// ImpagoNomina para dejar constancia del problema (capturarla, mostrando
// por pantalla su información y luego romper la ejecución de la aplicación
// con un System.exit(0)). En caso afirmativo, se mostrará un simple mensaje
// por pantalla de que todo está correcto.


package empresa;

import excepciones.ImpagoNominaException;

public class Empleado {

    public static void main(String[] args) {
        
        int aleatorio = (int)(Math.random()*100 + 1); // [1..100]
        
        int posibilidadImpago = 50; // ajustar posibilidad impago.
                
        System.out.println("NUMERO QUE SE OBTIENE = " + aleatorio + "\n\n");
        
        if(aleatorio <= posibilidadImpago) { // si número menor, excepción.
            try {
                throw new ImpagoNominaException();
            } catch(ImpagoNominaException in) {
                System.out.println("---> " + in.getMessage());
                System.out.println(in);
                System.exit(0);
            }
        }
        
        System.out.println("ME HAN PAGADO LA NOMINA DEL MES, TODO CORRECTO.");
    }
}