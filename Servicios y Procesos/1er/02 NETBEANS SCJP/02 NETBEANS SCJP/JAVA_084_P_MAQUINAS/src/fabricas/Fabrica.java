// Crear una clase para verificar el comportamiento del sistema. Definir 2
// referencias de tipo Maquina y cargarlas con un objeto de cada una de las
// subclases de ésta (la invocación al método fabricar se realiza de forma
// automática en el constructor. Revisar el número de lote que generaría el
// fallo ya que puede quedar fuera del proceso de fabricación. Crear un total
// de 100 lotes de bocadillos y 75 de tuercas.


package fabricas;

import maquinas.Maquina;
import maquinas.MaquinaBocadillos;
import maquinas.MaquinaTuercas;

public class Fabrica {

    public static void main(String[] args) {
        
        Maquina m1 = new MaquinaBocadillos(100);       

        Maquina m2 = new MaquinaTuercas(75);        
    }   
}