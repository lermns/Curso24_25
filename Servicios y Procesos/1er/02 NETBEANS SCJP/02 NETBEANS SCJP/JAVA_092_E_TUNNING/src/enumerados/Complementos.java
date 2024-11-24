// Generar el tipo enumerado Complementos para establecer un conjunto de elementos
// que se pueden añadir a un determinado coche. El complemento tiene asociado un
// nivel de tunning ("lo que mola") y un precio. Se dispone de métodos públicos
// para consultar los atributos y se sobrescribe el método toString. La opción
// comprarTodos, devuelve un array de complementos (método values()) para facilitar
// el supuesto de querer comprarlos todos (crear el método como estático).


package enumerados;

public enum Complementos {

    // nivelTunning, precio.
    MOTOR_V8(3, 25000),
    LLANTAS_ALEACION(2,15000),
    ALERONES(1,7000);
    
    private int nivelTunning;
    private int precio;
    
    private Complementos(int nivelTunning, int precio) {
        this.nivelTunning = nivelTunning;
        this.precio = precio;
    }

    public int obtenerNivelTunning() {
        return nivelTunning;
    }

    public int obtenerPrecio() {
        return precio;
    }
    
    public static Complementos[] comprarTodos() { // método estatico.
        return values();
    }
        
    @Override
    public String toString(){
        return name() + " ---> " + nivelTunning + " estrellas, " + precio + " €";
    }
}