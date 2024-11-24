// Crear una clase Madre que defina un método estático y opcionalmente final.
// Se comprobará cómo ya no se le permite a la clase Hija definir su propia 
// versión (si no fuese final sí, pero y aún a pesar de que no hay sobrescritura
// @Override, hay que cumplir con las reglas de la sobrescritura).


package p4;

public class MadreMEstaticoFinal {

    // SI EL MÉTODO ESTÁTICO ES ADEMÁS FINAL, YA NO SE PERMITE QUE
    // HIJA DEFINA SU PROPIO MÉTODO ESTÁTICO COMO EL DE LA MADRE:
    
    //public static final void cocinar() {
    private static void cocinar() {
        System.out.println("LA MADRE COCINA LENTEJAS");
    }   
}