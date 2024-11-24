// Crear una clase de prueba que genere un par de tiendas (SOL y ATOCHA) sobre las
// que se invocarán los distintos métodos comprarXXX, para al finalizar, mostrar el
// conjunto de ventas parciales y totales (atributos estáticos).

// El total de articulos a comprar de cada tipo puede determinarse de forma aleatoria.


package p0;

public class PruebaTiendas {
    
    private static int cuantosComprar() {   // reutilización de código.
        return (int)(Math.random()*5)+1;    // [1..5].
    }

    public static void main(String[] args) {
        
        Tienda sol = new Tienda("SOL");
        Tienda atocha = new Tienda("ATOCHA");
        
        // ES VÁLIDO ACCEDER A LO ESTÁTICO A TRAVÉS DE LA INSTANCIA, PERO NO ES LO
        // LO MÁS ADECUADO:
        //System.out.println(sol.consultarVentasTotales());
        
        // ESTA FORMA SERÍA MÁS CORRECTA. DE HECHO, EL COMPILADOR CONVERTIRÁ NUESTRO
        // CÓDIGO PARA QUE HAGA USO DEL NOMBRE DE LA CLASE EN LUGAR DE LA INSTANCIA.
        //System.out.println(Tienda.consultarVentasTotales());

        sol.comprarChicle(cuantosComprar());
        sol.comprarCocaCola(cuantosComprar());
        sol.comprarDonut(cuantosComprar());
                
        atocha.comprarChicle(cuantosComprar());
        atocha.comprarCocaCola(cuantosComprar());
        atocha.comprarDonut(cuantosComprar());
                
        System.out.println(sol.consultarVentasParciales()); // Ventas parciales Sol.

        System.out.println(atocha.consultarVentasParciales()); // Ventas parciales Atocha.
        
        System.out.println(Tienda.consultarVentasTotales()); // Ventas totales.        
    }    
}