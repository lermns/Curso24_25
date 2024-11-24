// Crear una clase que evalúe a un alumno en función de la nota obtenida, a través
// de un mensaje. Utilizar un bloque switch, sin hacer uso del FALL-THROUGH, para 
// comprobar cómo repetimos código de forma innecesaria (en el siguiente ejercicio
// usaremos la versión optimizada que hace uso de FALL-THROUGH).


package p0;

public class Examen {

    public static void main(String[] args) {

        int nota = 7;

        switch (nota) {
            case 0:
                //caida libre------------------------------------------------------
            case 1: // código repetido.
                //caida libre------------------------------------------------------
            case 2:
                System.out.println(nota + " ... MUY DEFICIENTE");                
                break;
            case 3:
                //caida libre------------------------------------------------------
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
                //caida libre------------------------------------------------------
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