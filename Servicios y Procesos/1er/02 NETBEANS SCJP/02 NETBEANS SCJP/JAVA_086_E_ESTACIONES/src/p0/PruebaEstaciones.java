// Crear una clase que defina una atributo estático y final con los valores
// del tipo enumerado Estaciones (obtener el array de valores a partir del
// método .values()).

// Generar un método estático elegirEstacionAleatoria que devuelva uno de los
// valores enumerados, de forma aleatoria.

// Generar un método mostrarMensaje que utilice el valor enumerado pasado como
// parámetro y un bloque switch, para indicar por pantalla un mensaje acorde con
// la estación correspondiente al valor recibido.

// Realizar una prueba que muestre por pantalla todas las estaciones y sus mensajes.
// Finalmente mostrar una estación elegida de forma aleatoria.


package p0;

public class PruebaEstaciones {

    private static final Estaciones[] lasEstaciones = Estaciones.values();

    private static Estaciones elegirEstacionAleatoria() {
        int aleatorio = (int) (Math.random() * lasEstaciones.length); // 0 .. 3
        return lasEstaciones[aleatorio];
    }

    private static void mostrarMensaje(Estaciones estacion) {

        // Para obtener el valor del enumerado utilizar toString() ó name().

        // Un bloque switch es compatible con los tipos enumerados.
        switch (estacion) {
            case PRIMAVERA:
                System.out.println("EN " + estacion.name() + " EL CAMPO SE LLENA DE FLORES");
                break;

            case VERANO:
                System.out.println("EN " + estacion.name() + " LA PLAYA SE LLENA DE GENTE");
                break;

            case OTOÑO:
                System.out.println("EN " + estacion.name() + " EL PARQUE SE LLENA DE HOJAS");
                break;

            case INVIERNO:
                System.out.println("EN " + estacion.name() + " LA CIUDAD SE LLENA DE NIEVE");
                break;
        }
    }

    
    public static void main(String[] args) {

        for (Estaciones estacion : lasEstaciones) {
            mostrarMensaje(estacion);
        }

        System.out.println("\n_________________________________________\n");

        mostrarMensaje(elegirEstacionAleatoria());
    }
}