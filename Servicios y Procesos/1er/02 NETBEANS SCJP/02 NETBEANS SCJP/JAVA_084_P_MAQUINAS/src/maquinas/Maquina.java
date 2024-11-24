// Crear el supertipo Maquina (clase abstracta) como punto de inicio en la 
// jerarquía de clases. Se dispone de diversos atributos y funcionalidad común
// a todas las subclases.


package maquinas;

import interfaces.InterfazMaquina;
import soporte.ServicioTecnico;

public abstract class Maquina implements InterfazMaquina {

    protected String nombre;        // el nombre de la máquina.
    protected int cuantosLotes;     // cuántos lotes se quieren fabricar.
    protected int fallo;            // fallo aleatorio en lote de fabricación número [1..125].
    protected int productividad;    // beneficios - gastos
    protected int costeReparacion;  // en función de una constante y el número del fallo.

    private final int retardo = 80; // mseg de retardo.
    
    protected Maquina(int cuantosLotes) {
        this.cuantosLotes = cuantosLotes;
        nombre = getClass().getSimpleName().toUpperCase();
        fallo = (int)(Math.random()*125 + 1); // [1..125]. Puede quedar fuera de la fabricación = NO FALLO.
        fabricar(); // INICIO DE FABRICACIÓN AUTOMÁTICA.
        informeProductividad(); // INFORME AL FINALIZAR LA FABRICACIÓN.
        System.out.println("\n\n....................................................");
        System.out.println("....................................................\n\n");
    }
    
    public String obtenerNombre() {
        return nombre;
    }
    
    public int obtenerFallo() { // Método puente a utilizar por ServicioTecnico
        return fallo;
    }
    
    public void asignarCosteReparacion(int costeReparacion) {
        this.costeReparacion += costeReparacion;
    }
    
    // MÉTODO ABSTRACTO A DEFINIR EN CADA UNA DE LAS SUBCLASES.
    public abstract void reparar();
    
    protected void informeProductividad() {
        System.out.println("\n\n---------- INFORME DE PRODUCTIVIDAD ------------");
        System.out.println("NOMBRE = " + nombre);
        System.out.println("CUANTOS LOTES = " + cuantosLotes);
        System.out.println("FALLO EN = " + fallo);  
        System.out.println("COSTE REPARACION = " + costeReparacion);  
    }
    
    @Override
    public final void fabricar() {
        System.out.println("SE INICIA LA FABRICACION ... " + nombre + "\n");
        for (int i = 1; i <= cuantosLotes; i++) {
            System.out.println("FABRICANDO EL LOTE NUMERO ... " + i);
            if(i==fallo) {
                System.out.println("SE HA ROTO LA MAQUINA. SE ENVIA AL SERVICIO TECNICO");
                ServicioTecnico.repararMaquina(this); // pasar el objeto actual de ejecución.
            }
            
            // Un simple bloque de retardo.
            try {
                Thread.sleep(retardo);
            } catch(InterruptedException ie) {
                System.out.println("ERROR EN RETARDO: " + ie);
            }
        }
    }   
}