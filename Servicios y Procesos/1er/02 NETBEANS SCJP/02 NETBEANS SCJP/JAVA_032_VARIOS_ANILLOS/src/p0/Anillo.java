// Crear la clase Anillo para obtener uno de los siguientes tipos de anillo:
// DIAMANTES, ESMERALDAS, RUBIES o bien NINGUNO (utilizar String ya que aún no se
// conocen los tipos enumerados). Se dispondrá del método obtenerTipoAnillo() que
// nos devolverá una instancia de Anillo con un tipo elegido aleatoriamente de entre
// los posibles. Se sobrescribe el método toString para ver cúal es dicho tipo.


package p0;

public class Anillo {

    private String tipoAnillo;
    
    private final String[] tipos = {
        "DIAMANTES",
        "ESMERALDAS",
        "RUBIES",
        "NINGUNO"
    };
    
    public Anillo() {
        int aleatorio = (int)(Math.random()*tipos.length);
        tipoAnillo =  tipos[aleatorio];       
    }
    
    @Override
    public String toString() {
        return tipoAnillo;
    }   
}