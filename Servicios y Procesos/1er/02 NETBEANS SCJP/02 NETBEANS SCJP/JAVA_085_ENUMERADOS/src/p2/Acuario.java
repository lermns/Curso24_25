// Crear un tipo enumerado Gatos equivalente al anterior del paquete p1 pero
// en esta ocasión, en el paquete p2 y con nivel de encapsulación "default",
// marcando el sufijo como _p2. Crear un clase pública Acuario sin contenido.


package p2;

public class Acuario {}

// CLASE ASOCIADA A LA CLASE PÚBLICA Acuario, EN EL PAQUETE p2.
// ES MIEMBRO DE LA CLASE.
enum Gatos { // NIVEL DE PAQUETE ... NO USAR FUERA DE EL PAQUETE p2.
    
    ANGORA_p2,
    PERSA_p2,
    CALLEJERO_p2
}