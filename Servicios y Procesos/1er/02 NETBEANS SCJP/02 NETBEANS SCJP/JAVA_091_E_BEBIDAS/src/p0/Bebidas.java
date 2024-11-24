// Crear el tipo enumerado Bebidas para definir un conjunto de licores. Todos
// y cada uno de ellos, hacen uso del constructor parametrizado para asignar la
// graduación alcohólica, precio y nombre. Se dispone de métodos para consultar
// tanto los grados como el precio de la bebida. Así mismo, se podrá realizar la
// compra de un lote de bebidas (1 botella de cada) y de un conjunto de ellas 
// elegidas de forma aleatoria por el sistema, indicandose el número a comprar [1..10].
// En ambos casos, los métodos devuelven un array del tipo enumerado Bebidas.
// Sobrescribir el método toString para informar de la compra.

// Nota: utilizar el método values() para obtener el array de elementos enumerados.


package p0;

public enum Bebidas {

    // GRADOS, PRECIO, MARCA.
    WHISKY(40,180,"CHIVAS"),
    RON(38,18,"LEGENDARIO"),
    VODKA(20,5,"MERCADONA"),
    GINEBRA(45,22,"BOMBAY"),
    TEQUILA(95,2,"DIA");      
    // NO OLVIDAR EL ; QUE SEPARA LA DECLARACIÓN DE VALORES DEL RESTO DEL CÓDIGO. 
    
    
    // PROPIEDADES. SE PERMITEN LOS 4 NIVELES DE ENCAPSULACIÓN.
    private int grados;
    private int precio;
    private String marca;    

    
    // EL CONSTRUCTOR QUE SE INVOCARÁ AUTOMÁTICAMENTE AL USAR LOS VALORES DEL TIPO ENUMERADO.
    // PARA EL CONSTRUCTOR SÓLO SE PERMITEN NIVELES DE ENCAPSULACIÓN private Y "default".
    private Bebidas(int grados, int precio, String marca) {
        this.grados = grados;
        this.precio = precio;
        this.marca = marca;
    }
        

    // GETTERS Y SETTERS PARA ACTUAR SOBRE LOS ATRIBUTOS (lo mejor es definirlos private).

    // PARA PODER USARLOS, DADO QUE NO SE HAN DEFINIDO COMO ESTÁTICOS, DEBEREMOS HACERLO A 
    // PARTIR DE UN DETERMINADO VALOR DEL TIPO ENUMERADO (constituyen la instancia, de modo
    // que si tenemos 5 valores, podríamos hablar de 5 instancias únicas para toda la aplicación,
    //  ... recordar que en ningún momento se va a hacer uso de new).
    
    // Ej:   int precio = Bebidas.WHISKY.obtenerPrecio();
        
    public int obtenerGrados() {       
        return grados;
    }    
    
    public int obtenerPrecio() {
        return precio;
    }       
    
    
    // PODEMOS DEFINIR MÉTODOS PROPIOS DENTRO DEL TIPO ENUMERADO.
    // SI SE DECLARAN COMO PÚBLICOS Y ESTÁTICOS, SE PODRÁN USAR FUERA DE LA CLASE.
    public static Bebidas[] comprarUnaDeCada() {
        return values();
    }    
    
    
    public static Bebidas[] comprarAleatoriamente(int cuantas) {
        
        if(cuantas < 1 || cuantas > 10) {
            System.out.println("PUEDE COMPRAR UN MINIMO DE 1 Y UN MAXIMO DE 10 BOTELLAS");
            System.exit(0); // finalización del programa.
        }
        
        Bebidas[] bebidasAzar = new Bebidas[cuantas]; // instanciación del array de compra.
        
        final Bebidas[] tiposBebida = values(); // array de valores enumerados (bebidas).
        
        for (int i = 0; i < cuantas; i++) { // elección aleatoria de una bebida.
            int aleatorio = (int)(Math.random()*tiposBebida.length);
            bebidasAzar[i] = tiposBebida[aleatorio]; // almacenamiento en el array de compra.
        }
        
        return bebidasAzar;
    }

    
    @Override
    public String toString() {
        String texto = "\n_____________________________\n";
        texto += "NOMBRE ... " + name() + "\n";
        texto += "GRADOS ... " + grados + "\n";
        texto += "PRECIO ... " + precio + "\n";
        texto += "MARCA ... " + marca + "\n";
        texto += "\n_____________________________\n";

        return texto;
    }   
}