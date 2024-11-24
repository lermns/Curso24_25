// Crear la clase Conductor que a través de su constructor establezca como
// propiedad de la misma, la posible infracción que va a cometer (es posible
// que se obtenga el valor NINGUNA, en cuyo caso no hay infracción). Se dota
// a la clase de distintos métodos para consultar las propiedades nombre,
// puntosCarnet e infracción. De igual forma, se proporciona un método para
// poder restar los puntos de carné correspondientes a la infracción cometida,
// proceso que llevará a cabo la clase GuardiCivil trás dar el alto y realizar
// la comprobación.


package conductores;

import enumerados.EnumInfracciones;

public class Conductor {

    private String nombre;
    private int puntosCarne;
    private EnumInfracciones infraccion; // tipo enumerado

    // EN EL CONDUCTOR NO ESTÁ EL OBJETO INFRACCIÓN, SINO UN TIPO ENUMERADO
    // EnumInfracciones QUE LO REPRESENTA. EN EL CONTROL DE CARRETERA, EL
    // AGENTE DE TRÁFICO CONSULTARÁ EL ENUMERADO DEL CONDUCTOR Y EN BASE A
    // EL, GENERARÁ EL OBJETO INFRACCIÓN CORRESPONDIENTE (salvo que sea ninguna).
    
    public Conductor(String nombre) {
        this.nombre = nombre;
        this.puntosCarne = 12;
        
        // DE FORMA ALEATORIA ASIGNARLE UN TIPO DE INFRACCION (tipo enumerado)
        // GRAVE - MEDIA - LEVE ... o ninguna.
        EnumInfracciones[] lasInfracciones = EnumInfracciones.values();
        int cual = (int)(Math.random()*lasInfracciones.length); // [0..3]
        infraccion = lasInfracciones[cual];
    }

    public EnumInfracciones consultarInfraccion() {
        return infraccion;
    }

    public String consultarNombre() {
        return nombre;
    }

    public int consultarPuntosCarne() {
        return puntosCarne;
    }
        
    public void restarPuntosCarne(int puntosARestar) {
        puntosCarne -= puntosARestar;
        
        if(puntosCarne <= 0) {
            System.out.println("NO PUEDE SEGUIR CIRCULANDO ...0 PUNTOS EN EL CARNE");
        }        
    }

    @Override
    public String toString() {
        return "     NOMBRE = " + nombre + ", PUNTOS DEL CARNE = " + puntosCarne + " INFRACCION = " + infraccion;
    }
}