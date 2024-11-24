// Crear una clase que mediante un bloque switch evalúe la nota de un alumno haciendo
// uso del FALL-THROUGH (versión optimizada con respecto a la anterior).


package p0;

public class ExamenFallThrough {

    public static void main(String[] args) {
        
        int nota = 8;
        
        switch (nota) {
            case 0: // eliminamos el código repetido.
            case 1:
            case 2:
                System.out.println(nota + " ... MUY DEFICIENTE");                
                break;
                
            case 3:
            case 4:
                System.out.println(nota + " ... INSUFICIENTE");                
                break;
                
            case 5:
                System.out.println(nota + " ... APROBADO");                
                break;
                
            case 6:
                System.out.println(nota + " ... BIEN");                
                break;
                
            case 7:
            case 8:
                System.out.println(nota + " ... NOTABLE");                
                break;
                
            case 9:
                System.out.println(nota + " ... SOBRESALIENTE");                
                break;
                
            case 10:
                System.out.println(nota + " ... MATRICULA DE HONOR");                
                break;
                
            default :
                System.out.println("NOTA " + nota + " INCORRECTA");
        }
    }    
}