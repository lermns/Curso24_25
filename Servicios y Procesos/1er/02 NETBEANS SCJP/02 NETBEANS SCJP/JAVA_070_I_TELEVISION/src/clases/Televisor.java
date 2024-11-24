// Crear una clase que implemente a InterfazTVConMKV, permitiendo de esta forma tener
// completa funcionalidad.


package clases;

import interfaces.InterfazTVConMKV;

public class Televisor implements InterfazTVConMKV {

    @Override
    public void verCanalTelevision(int canal) {
        System.out.println("ESTOY VIENDO LA TELEVISION EN EL CANAL " + canal);
    }
    
    @Override
    public void verPeliculaMKV(String nombre) {
        System.out.println("ESTOY VIENDO LA PELICULA DIVX ... " + nombre);
    }
}