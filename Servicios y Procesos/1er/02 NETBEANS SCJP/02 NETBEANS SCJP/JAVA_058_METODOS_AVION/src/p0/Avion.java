// Crear una clase Avión que simule el proceso a seguir desde el momento del 
// despegue hasta el aterrizaje. Se dispone de distintos atributos que habrá
// que comprobar antes de realizar cualquier operación, como es el estado de 
// los flags, el tren de aterrizaje ... etc. Sólo si la comprobación da cómo
// resultado un OK (true), se podrá invocar al siguiente método, si no, se 
// abortará la operación (o se tomarán las medidas oportunas si no pudiera
// detenerse).

// El avión levantará el vuelo a llegar a los 250 puntos de velocidad y 
// recogerá el tren de aterrizaje a los 350. Desactivará flags a los 500 y
// una vez alcanzados los 900 puntos de velocidad, se activará el piloto
// automático.

package p0;

public class Avion {

    private int velocidad;
    private String acelerometro; // →
    private String visorVelocidad;
    private boolean trenAterrizaje;
    private boolean flags;
    private boolean pilotoAutomatico;
    private final int retardo = 400; // tiempo de retardo para la ejecución (mseg).

    public Avion() {
        velocidad = 0;              // se inicializa por defecto a 0.
        acelerometro = "";
        visorVelocidad = "";
        trenAterrizaje = true;
        flags = false;
        pilotoAutomatico = false;   // se inicializa por defecto a false.        
    }

    private void acelerar(int velocidadFinal) {
        visorVelocidad = "";

        while (velocidad < velocidadFinal) {
            velocidad += 50; // incrementos de 50 en 50 puntos.
            acelerometro += " → ";
            visorVelocidad = acelerometro + velocidad + "\n";

            System.out.println(visorVelocidad);

            try {
                Thread.sleep(retardo);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }

            if (trenAterrizaje && velocidad >= 350) { // al llegar a 350 subir tren.
                imprimirAviso("[RECOGER EL TREN DE ATERRIZAJE]");
                trenAterrizaje = false;
            }

            if (flags && velocidad >= 500) { // al llegar a 500 desactivar flags.
                imprimirAviso("[DESACTIVAR FLAGS]");
                flags = false;
            }
        }
    }

    private void decelerar() {

        acelerometro = acelerometro.replace('→', '←'); // cambia el sentido (todos).
        visorVelocidad = "";

        while (velocidad > 0) {
            velocidad -= 50; // decrementos de 50 en 50.

            // quita la última flecha de velocidad negativa.
            acelerometro = acelerometro.substring(0, acelerometro.lastIndexOf("←"));

            if (!flags && velocidad <= 500) {
                imprimirAviso("[ACTIVAR FLAGS]"); // al llegar a 500, activar flags.
                flags = true;
            }            
            
            if (!trenAterrizaje && velocidad <= 350) {
                imprimirAviso("[EXTENDER EL TREN DE ATERRIZAJE]"); // al llegar a 350 bajar tren.
                trenAterrizaje = true;
            }

            visorVelocidad = acelerometro + velocidad + "\n";
            System.out.println(visorVelocidad);

            try {
                Thread.sleep(retardo);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    // DESPEGAR:
    public void despegar() {

        imprimirAviso("ACTIVACION DE FLAGS PREVIO A DESPEGUE");
        flags = true;
        imprimirAviso("VERIFICACION ANTES DE DESPEGUE ");
        imprimirAviso(visualizarEstadoDelAvion());

        if (!revisarEstadoDelAvion()) {
            imprimirAviso("SE DETECTA FALLO EN EL AVION, IMPOSIBLE DESPEGAR.");
            return;
        }

        imprimirAviso("TODO OK. INICIANDO DESPEGUE");
        acelerar(250);
        imprimirAviso("AVION ARRIBA");
        volar(); // LLAMAMOS AL MÉTODO VOLAR.
    }

    // VOLAR:
    private void volar() {
        imprimirAviso("ACELERANDO HASTA VELOCIDAD DE CRUCERO (900Km/h)");
        acelerar(900);
        imprimirAviso("ACTIVAR PILOTO AUTOMATICO");
        pilotoAutomatico = true;
        imprimirAviso("VOLANDO - VOLANDO - VOLANDO");
        aterrizar(); // LLAMAMOS AL MÉTODO VOLAR.
    }

    private void aterrizar() {
        imprimirAviso("APROXIMANDONOS A DESTINO");
        imprimirAviso("DESACTIVAR PILOTO AUTOMATICO");
        pilotoAutomatico = false;
        imprimirAviso("DECELERANDO HASTA VELOCIDAD DE ATERRIZAJE (100Km/h)");
        decelerar();
        imprimirAviso("AVION EN TIERRA Y DETENIDO");
        imprimirAviso("DESACTIVAR FLAGS");
        flags = false;
        imprimirAviso(visualizarEstadoDelAvion());
        imprimirAviso("INICIO DESEMBARCO PASAJEROS");        
    }

    private String visualizarEstadoDelAvion() {

        String texto = "";
        texto += "VELOCIDAD .............. " + velocidad + "\n";
        texto += "TREN DE ATERRIZAJE ..... " + trenAterrizaje + "\n";
        texto += "FLAGS .................. " + flags + "\n";
        texto += "PILOTO AUTOMATICO ...... " + pilotoAutomatico + "\n";
        return texto;
    }

    private boolean revisarEstadoDelAvion() {

        // VERIFICA TODOS LOS PARAMETROS ...
        if (velocidad == 0
                && trenAterrizaje == true
                && flags == true
                && pilotoAutomatico == false) {
            return true;
        }
        return false;
    }

    private void imprimirAviso(String aviso) {
        
        System.out.println("\n_______________________________");
        System.out.println(aviso);
        System.out.println("_______________________________\n");
    }
}