// Crear un tipo enumerado Colores con los valores ROJO, VERDE y AZUL (se tienen
// en cuenta las mayúsculas) y hacer uso de los métodos name, valueOf y values del
// mismo para comprobar su funcionamiento.

// Nota: los tipos enumerados definen valores constantes. Es por ésto, que se
// deberían indicar los mismos en mayúsculas, a la hora de definirlos.


package p0;

public enum Colores {

    // SON VALORES ESTÁTICOS Y FINALES.
    ROJO, VERDE, AZUL;    
    
//    @Override
//    public String toString() {
//        return name();            // el valor visto como un String ... Ej: ROJO. 
//    }    
}


class Prueba {

    public static void main(String[] args) {
        
        Colores unColor = Colores.ROJO;        
        //Colores otroColor = Colores.AMARILLO;

        Colores[] losColores = Colores.values();
        
        for(Colores color : losColores) {
            System.out.println("---> " + color); // se llama al toString().
        }
        
        System.out.println("\n__________________________________\n");
        
        Colores colorVerde = Colores.valueOf("VERDE");
        System.out.println("EL VERDE ES ... " + colorVerde);
        
        // DE NO EXISTIR EL VALOR, SE GENERARÁ UNA EXCEPCIÓN AL EJECUTAR,
        // EL COMPILADOR NO REALIZA LA COMPROBACIÓN SOBRE EL STRING USADO.
        // error ... "No enum constant p0.Colores.NINGUN COLOR"
        //Colores colorError = Colores.valueOf("NINGUN COLOR");
        
        System.out.println("\n__________________________________\n");
        
        String cadena = ""; // concatenación de String.
        Colores colorCompuesto = Colores.VERDE;
        cadena = colorCompuesto.name();
        colorCompuesto = Colores.ROJO;
        cadena += colorCompuesto.name();
        System.out.println("cadena = " + cadena);
    }
}