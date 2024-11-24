// Crear la clase abstracta Infraccion como punto de inicio en la jerarquía de
// clases del tipo excepción personalizada. Se dispone de los atributos descripcion,
// puntosARestar y multa para representar las propiedades de la infracción cometida.
// Se establece un constructor parametrizado para darles valor al generar el objeto,
// el cual invocará al constructor de la madre para designar el mensaje de la
// infracción. Generar los métodos para consultar las propiedades y sobrescribir
// el método toString.

// Se establece la jerarquía de forma que la leve extienda a la media. La media
// extienda a la grave y finalmente ésta a la clase abstracta Infracción. El
// encadenamiento de constructores asignará los valores adecuados en cada caso
// a las propiedades heredadas hacia las subclases hija. Con ésto, se busca poner
// de manifiesto el concepto de GRANULARIDAD.


package infracciones;

public abstract class Infraccion extends Exception {

    protected String descripcion;
    protected int puntosARestar;
    protected int multa;
    
    protected Infraccion(String descripcion, int puntosARestar, int multa) {
        super(descripcion); // ajustamos el message a la descripcion.
        this.descripcion = descripcion;
        this.puntosARestar = puntosARestar;
        this.multa = multa;
    }

    public String consultarDescripcion() {
        return descripcion;
    }

    public int consultarMulta() {
        return multa;
    }

    public int consultarPuntosARestar() {
        return puntosARestar;
    }

    @Override
    public String toString() {
        return super.toString();
    }   

}