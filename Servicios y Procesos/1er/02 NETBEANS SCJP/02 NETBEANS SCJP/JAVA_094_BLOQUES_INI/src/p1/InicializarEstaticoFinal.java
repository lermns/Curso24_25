// Comprobar cómo mediante el uso de un bloque de inicialización estático SÍ es
// posible inicializar atributos declarados cómo estáticos y finales, algo que
// un constructor (no por el simple hecho de ser estáticos, sino por ser finales),
// NO podía hacer.


package p1;

public class InicializarEstaticoFinal {

    // INICIALIZACIÓN A TRAVÉS DEL BLOQUE DE INICIALIZACIÓN ESTÁTICO.
    private static final int valor1;
    
    // DECLARACIÓN TEMPRANA (eagerly declaration).
    private static final int valor2 = 777;

    static {
        valor1 = 999;
    }
    
    
    // ERROR. LA VARIABLE YA HA SIDO CREADA Y NECESITA DE UN VALOR POR EL
    // HECHO DE SER ESTÁTICA Y FINAL.
//    public InicializarEstaticoFinal(int valor) {
//        valor1 = valor;
//    }
   
}