// Aunque se estudiarán más tarde, se muestra la utilización de un TIPO-ENUMERADO para
// definir el atributo tipo de moto del ejercicio anterior. El uso de tales elementos
// es mucho más conveniente que la utilización de un String (el compilador revisa los
// valores mientras estamos picando el código y de encontrar un error nos avisa, luego
// no hay que esperar a ejecutar el programa).


package p1;

enum TipoMoto { // tipo enumerado definido en el propio fichero de la clase.
    CARRETERA, CAMPO;
}

public class EnumeradoMotos {

    public static void main(String[] args) {
        TipoMoto tipo = TipoMoto.CAMPO;
        System.out.println("EL TIPO DE LA MOTO ES " + tipo);
        
    }
}