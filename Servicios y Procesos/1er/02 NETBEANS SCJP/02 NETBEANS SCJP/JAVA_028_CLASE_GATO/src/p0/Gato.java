// Crear una clase que represente el concepto abstracto de gato, como animal doméstico.
// Dotar a la misma de los atributos nombre, raza y edad (encapsulación private) así
// como de los constructores (por defecto y parametrizado) y los métodos maullar y 
// comer(String comida). Establecer adicionalmente setter y getters para los atributos y
// sobrescribir el método toString para obtener la información del objeto Gato creado.

// Crearemos por tanto una clase tipo JavaBean ... clase pública con constructor público
// sin argumentos, que opcionalmente puede disponer de métodos getters y setters para sus
// atributos.


package p0;

public class Gato {

    // ATRIBUTOS:
    private String nombre; // BLANKED VARIABLE.
    private String raza;
    private int edad;
    //public int edad;  // No es lo adecuado ya que rompe la encapsulación de la clase,
                        // además que podríamos colocar cualquier valor de tipo int.
    
    // CONSTRUCTORES:
    public Gato() {
        this.nombre = "DESCONOCIDO";
        this.raza = "DESCONOCIDO";
        this.edad = -1;
    }
        
    public Gato(String nombre, String raza, int edad) { // se podría aplicar filtrado de datos.
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
    }
        
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {        
        // el método nos permite filtrar la información, pero sería mucho mejor que
        // la misma viene ya validada/convertida desde otro elemento. Los setters y
        // getters NO DEBERÍAN CONTENER NINGUA LÓGICA DE NEGOCIO, sólo consulta y
        // asignación.
        if(edad <1 || edad > 15) {
            System.out.println("LA EDAD " + edad + " ES INCORRECTA");
            return;
        }
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) { // se podría utilizar un tipo enumerado (TYPE-SAFE). 
        this.raza = raza;
    }
    
    public void maullar() {
        System.out.println("MIAAAUUUUUU");
    }
        
    public boolean comer(String comida) { // el gato sólo quiere "sardinas".
        if("sardinas".equalsIgnoreCase(comida)) {
            System.out.println("EL GATO COME SARDINAS");
            return true;
        }
        
        System.out.println("EL GATO NO QUIERE ... " + comida);
        return false;
    }
    
    @Override
    public String toString() { // DEVOLVEMOS EL ESTADO DEL OBJETO:
        return "NOMBRE: " + nombre + " RAZA: " + raza +
                " EDAD: " + edad;
    }
}