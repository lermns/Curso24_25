// Crear la interfaz que define los métodos (funcionalidad) de todos los patos.

// Nota: por simplicidad sólo declararemos el método volar ... considerar que
// no todos los patos vuelan (los de goma no lo hacen), por lo que el ejercicio
// tratará de seguir el patrón de diseño STRATEGY, para "encapsular aquello que
// varia", en este caso el comportamiento volar.


package p0;

public interface InterfazMetodosPato {

    public void volar();    
    
    // ... resto de métodos.
}