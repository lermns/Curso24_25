// Crear la clase Etiqueta como elemento que utilizaremos para componer el objeto
// Botella. Se dispone del atributo texto para representar el contenido de la 
// etiqueta.


package p0;

public class Etiqueta {

    private String texto;

    public Etiqueta(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return texto;
    }    
}