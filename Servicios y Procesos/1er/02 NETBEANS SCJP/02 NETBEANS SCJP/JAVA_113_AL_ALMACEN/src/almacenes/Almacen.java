// Crear una clase que simbolice un Almacen de grano. Para ello, se crean los
// contenedores princial, arroz, trigo y maiz, todos ellos instancias de la
// colección ArrayList, que opcionalmente marcaremos con el tipo <Saco>, que
// es el valor enumerado creado anteriormente.
// Se procede a generar aleatoriamente los distintos tipos de sacos (el usuario
// determinará mediante un parámetro cuántos quiere crear) que se almacenarán
// en el contenedor principal. A continuación, se separarán los sacos en base
// a su tipo (trigo con trigo, arroz con arroz ... etc) para lo cuál se moverán
// del contenedor principal al que les corresponda. Hecho ésto se visualizarán
// los 4 contenedores, debiendo estar el principal totalmente vacio y los otros
// 3, con los sacos de su tipo que les haya correspondido (podría no contener
// ninguno). Finalmente, se muestra por pantalla el total de kilos y precio
// de cada uno de los contenedores.

// Utilizar un bloque switch para separar los sacos del contenedor principal a
// los secundarios. Switch es compatible con los tipos enumerados y es mucho 
// más claro y mantenible que el uso de baterías if-else.

// Nota: Programar los métodos para que reciban parámetros de entrada de tipo
// ArrayList, trabajando sobre ellos y devolviendo un resultado en lugar de 
// programar todas la variables como globales ... de esta forma conseguiremos
// una mayor reutilización del código.


package almacenes;

import enumerados.Saco;
import java.util.ArrayList;


public class Almacen {

    // Marcar las colecciones con género evita la necesidad de casting
    // al recuperar sus elementos.
    private ArrayList<Saco> contenedorPrincipal;    
    private ArrayList<Saco> contenedorArroz;
    private ArrayList<Saco> contenedorTrigo;
    private ArrayList<Saco> contenedorMaiz;

    
    public Almacen(int cuantosSacos) { // constructor de los almacenes y los sacos.
        contenedorPrincipal = new ArrayList<Saco>();
        contenedorArroz = new ArrayList<Saco>();
        contenedorTrigo = new ArrayList<Saco>();
        contenedorMaiz = new ArrayList<Saco>();
        
        // crear el total de sacos cuyo tipo será aleatorio (ARROZ, TRIGO, MAIZ).
        generarSacos(cuantosSacos); 
    }
    
    
    private void generarSacos(int cuantosSacos) {
        final Saco[] losSacos = Saco.values(); // valores del enumerado.
        
        for (int i = 0; i < cuantosSacos; i++) {
            int aleatorio = (int)(Math.random() * losSacos.length);
            contenedorPrincipal.add(losSacos[aleatorio]); // guarda referencias.
            
            // hasta aquí, todos los sacos están mezclados en el contenedor
            // principal. Ahora habrá que proceder a su separación (BLOQUE SWITCH).
        }        
    }
    
    
    public void separarSacos() {
        // El bucle forEach admite arrays y colecciones.        
        for (Saco saco : contenedorPrincipal) {
            // NO QUITAR ELEMENTOS DENTRO DE ESTE FOREACH O NOS DARÁ
            // EXCEPCIÓN DE CONCURRENCIA POR MODIFICIACIÓN DE LA LONGITUD
            // DE LA COLECCIÓN MIENTRAS SE ESTÁ RECORRIENDO == INCONSISTENCIA.
        
            // El bloque switch admite tipos enumerados.            
            switch(saco) { // separar.
                case ARROZ:
                    contenedorArroz.add(saco); // no podemos hacer remove(quitar).                    
                    break;                     // copia y ya borraras todo más tarde. 
                    
                case TRIGO:
                    contenedorTrigo.add(saco);
                    break;

                case MAIZ:
                    contenedorMaiz.add(saco);
                    break;                    
            }
        }
        
        contenedorPrincipal.clear(); // SEPARADOS, BORRAMOS AHORA TODO DE GOLPE.
    }
    
    
    public String calcularPrecioPeso(ArrayList<Saco> contenedor) {
        int precioTotal = 0;
        int pesoTotal = 0;
        
        for (Saco saco : contenedor) {
            precioTotal += saco.obtenerPrecio();
            pesoTotal += saco.obtenerPeso();
        }
        
        return "PRECIO TOTAL = " + precioTotal + " ... PESO TOTAL = " + pesoTotal;     
    }
    
    
    public void visualizarContenedor(ArrayList<Saco> contenedor) {    
        for (Saco saco : contenedor) {
            System.out.println("---> " + saco);
        }        
    }   
    
    
    public ArrayList<Saco> obtenerContenedorPrincipal() {
        return contenedorPrincipal;
    }
    
    
    public ArrayList<Saco> obtenerContenedorArroz() {
        return contenedorArroz;
    }

    
    public ArrayList<Saco> obtenerContenedorTrigo() {
        return contenedorTrigo;
    }

    
    public ArrayList<Saco> obtenerContenedorMaiz() {
        return contenedorMaiz;
    }
    
    
    
    public static void main(String[] args) {
        
        Almacen almacen = new Almacen(10); // 10 sacos, tipo aleatorio y mezclados.

        almacen.visualizarContenedor(almacen.obtenerContenedorPrincipal());
        System.out.println(almacen.calcularPrecioPeso(almacen.obtenerContenedorPrincipal()));
        
        System.out.println("\n________________________________\n");
        
        almacen.separarSacos();
        
        almacen.visualizarContenedor(almacen.obtenerContenedorArroz());
        System.out.println(almacen.calcularPrecioPeso(almacen.obtenerContenedorArroz()));
                
        System.out.println("\n________________________________\n");

        almacen.visualizarContenedor(almacen.obtenerContenedorTrigo());
        System.out.println(almacen.calcularPrecioPeso(almacen.obtenerContenedorTrigo()));
        
        System.out.println("\n________________________________\n");

        almacen.visualizarContenedor(almacen.obtenerContenedorMaiz());        
        System.out.println(almacen.calcularPrecioPeso(almacen.obtenerContenedorMaiz()));
                
        System.out.println("\n________________________________\n");
        
        
        if(almacen.obtenerContenedorPrincipal().isEmpty()) {
            System.out.println("EL CONTENEDOR PRINCIPAL ESTA VACIO");            
        } else {
            almacen.visualizarContenedor(almacen.obtenerContenedorPrincipal());                        
        } 
     }
}