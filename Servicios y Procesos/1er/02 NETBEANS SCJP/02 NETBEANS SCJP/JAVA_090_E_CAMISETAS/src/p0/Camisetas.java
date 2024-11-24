// Crear el tipo enumerado Camisetas para definir los valores PEQUEÑA, MEDIANA
// Y GRANDE. En esta ocasión se hará uso de un constructor parametrizado que
// recibirá los argumentos para inicializar los atributos privados, tamaño (char)
// y precio. Se sobrescribe el método toString para dar información sobre la
// camiseta elegida. Generar distintos objeto para comprobar el funcionamiento
// del sistema.


package p0;

public enum Camisetas {

    PEQUEÑA('S',22),
    MEDIANA('M',30),
    GRANDE('G',40); // no olvidar el separador de valores, del resto del código ;
        
    private char tamaño;
    private int precio;
    
    private Camisetas(char tamaño, int precio) { // constructor privado o "default".
        this.tamaño = tamaño;
        this.precio = precio;
    }
    
    @Override
    public String toString() {
        return name() + " ... " + tamaño + " ... " + precio + " €" ;
    }
 
    public static void main(String[] args) {
        Camisetas c1 = Camisetas.PEQUEÑA;
        System.out.println("---> " + c1);

        Camisetas c2 = Camisetas.MEDIANA;
        System.out.println("---> " + c2);

        Camisetas c3 = Camisetas.GRANDE;
        System.out.println("---> " + c3);       
    }   
}