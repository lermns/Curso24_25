// Crear una clase Animal como madre de las subclases Gato y Perro. Utilizar a
// continuación el polimorfismo para rellenar una referencia de tipo Animal con
// una instancia u objeto de tipo Gato. Provocar al conversión de dicha referencia
// al tipo Perro (es correcto porque hay relación entre Animal y Perro). Comprobar
// como el compilador no genera ningún error ni advertencia, ya que éste se limita
// sólo a comprobar la validez del casting a "nivel de superficie", sin entrar a
// verificar la verdadera naturaleza del objeto apuntado por la referencia.

// Ejecutar el programa para verificar cómo finalmente la máquina virtual (JVM)
// advierte el error (tratar de manejar un tipo de dato a través de una referencia
// NO COMPATIBLE) generando un error en tiempo de ejecución, una excepción (objeto),
// del tipo ClassCastException (error en la conversión de tipos).

// Nota: a pesar de que el compilador pueda dar el OK al código y compilar éste 
// generándose el .class, quién tiene la última palabra es la máquina virtual.


package p0;

public class Animal {}

class Gato extends Animal {}

class Perro extends Animal {}


class PruebaCasting {

    public static void main(String[] args) {
        
        Animal animal = new Gato();
        
        System.out.println("¿DE QUE TIPO ES EL OBJETO EN LA REFERENCIA animal ... ?");
        System.out.print("ES DE TIPO " + (animal.getClass().getSimpleName()));
        System.out.println("... Y LO QUIERES CONVERTIR EN PERRO\n\n");

        try {
            
            // forzamos DOWN-CASTING. Es válido porque hay relación entre Animal y Perro,
            // pero no esperemos que el compilador "se meta dentro de la referencia" para 
            // ver cuál es realmente la naturaleza, el tipo, del objeto que está siendo
            // manejado por ella ... para eso tenemos el operador instanceof (regla IS-A).
            Perro perro = (Perro)animal;
            
        } catch(ClassCastException cce) {
            
            System.out.println("ERROR EN LA CONVERSION DE TIPOS");
            System.out.println("---> " + cce + "\n\n");
            System.out.println("UTILIZA EL instanceof PARA ASEGURAR UN CASTING CORRECTO");
        
        }        
    }
}