// Crear una interfaz que declare el método verPeliculaMKV, pidiendo como valor de 
// entrada un String que representará el nombre de la película que se desea ver.
// Dicha interfaz extiende a la anterior InterfazTV.


package interfaces;

public interface InterfazTVConMKV extends InterfazTVSinMKV {

    public void verPeliculaMKV(String nombre);   
}