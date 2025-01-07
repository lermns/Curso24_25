package AyudaEmms.Animales;

public abstract class Animal {
    String nombre;
    int edad;

    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    protected void hacerSonido(){
        System.out.println("el animal hace un sonido");
    }

    protected void infoAnimal(){
        System.out.println("Nombre: " + nombre + "\nEdad: " + edad);
    }
}
