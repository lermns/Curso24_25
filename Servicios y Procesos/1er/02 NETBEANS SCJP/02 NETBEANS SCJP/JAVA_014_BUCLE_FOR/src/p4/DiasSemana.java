// Crear una clase que muestre los días de la semana y un comentario sobre los mismos, de
// forma que SABADO y DOMINGO son "buenos" y el resto "malos".

package p4;

public class DiasSemana {

    public static void main(String[] args) {

        String[] dias = {"LUNES", "MARTES", "MIERCOLES", "JUEVES",
                            "VIERNES", "SABADO", "DOMINGO"};

        for (int indice = 0; indice < dias.length; indice++) {
            System.out.println("---> " + dias[indice]);

// COMPROBACIÓN MEDIANTE CONDICIONAL if:
            
//            String queDia = dias[indice];
//            
//            if("SABADO".equals(queDia) || "DOMINGO".equals(queDia)) {
//                System.out.println("ES UN BUEN DIA");
//            } else {
//                System.out.println("ES UN MAL DIA");
//            }

            
// COMPROBACIÓN MEDIANTE OPERADOR TERNARIO:
            
//            System.out.println("comentario ... " +
//                    (("SABADO".equals(dias[indice]) ||
//                    "DOMINGO".equals(dias[indice]))?
//                    "ES BUEN DIA":"ES UN MAL DIA")
//                    );


// COMPROBACIÓN MEDIANTE BLOQUE switch, OBTENIENDO LAS INICIALES DEL NOMBRE DEL DÍA:
                        
            char inicial = dias[indice].charAt(0); //devuelve el primer caracter del contenido de días[indice]

            switch (inicial) {
                case 'S':
                case 'D':
                    System.out.println("ES UN BUEN DIA");
                    break;
                    
                default:
                    System.out.println("ES UN MAL DIA");                    
            }

            System.out.println("\n");
        }
    }
}