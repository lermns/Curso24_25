// Crear una clase que represente el concepto abstracto de punto geografico. La clase
// dispondrá de los atributos latitud, longitud y localidad, sobrescribiéndose el método
// toString para dar información sobre ellos. Crear un total de 3 puntos e introducirlos
// en un array del tipo correspondiente para a continuación, mediante un bucle for-each 
// imprimirlos por pantalla.


package p0;

public class PuntoGeografico {

    private double latitud;
    private double longitud;
    private String localidad;

    
    public PuntoGeografico(double latitud, double longitud, String localidad) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.localidad = localidad;
    }

    
    @Override
    public String toString() {
        String texto = "";
        
        texto +=    "LATITUD = " + latitud + "\n";
        texto +=    "LONGITUD = " + longitud + "\n";
        texto +=    "LOCALIDAD = " + localidad + "\n";        
    
        return texto;
    }
    
    public static void main(String[] args) {
        
        PuntoGeografico[] puntos = new PuntoGeografico[3];
                
        puntos[0] = new PuntoGeografico(100, 150, "FUENLABRADA");
        puntos[1] = new PuntoGeografico(-70.5, 90.88, "LEGANES");
        puntos[2] = new PuntoGeografico(333, 555, "MOSTOLES");        
        
        for (PuntoGeografico pg: puntos) {
            System.out.println("\n" + pg + "\n");
        }   
    }   
}