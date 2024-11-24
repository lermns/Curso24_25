// Crear la clase Botella como heredera de Envase (relación IS-A) definiendo en
// ella las propiedades de tipo referenciado Tapo y Etiqueta (relación HAS-A).
// Utilizar un constructor parametrizado para asignar los valores de material,
// capacidad, color y texto de la etiqueta (los objetos de composición se crean
// dentro del constructor y a continuación se les asigna el valor).
// Sobrescribir el método toString() para informar del estado del objeto, haciéndo
// uso de la versión heredada de la madre (Envase) de cara a reutilizar código.


package p0;

public final class Botella extends Envase { // IS-A

    private Tapon       tapon;      // HAS-A
    private Etiqueta    etiqueta;   // HAS-A

    public Botella(String material, int capacidad, String color, String texto) {
        this.material   = material;
        this.capacidad  = capacidad;
        tapon           = new Tapon(color);
        etiqueta        = new Etiqueta(texto);        
            
        float f = (Float)5.0F;
    
    }

    @Override
    public String toString() {
        
        // El toString heredado de madre actua sobre las variables heredadas.
        // El "dibujo" del objeto hija lo ha de tener todo, lo suyo y lo heredado
        // ya se directamente visible o no, por lo que perfectamente podemos 
        // olvidarnos por completo del "dibujo" del posible objeto madre.
        String estado = "";
        estado += super.toString(); 
        estado += " _ " + tapon + " _ " + etiqueta;
        
        return estado;
    }
}