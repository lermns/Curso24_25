package AyudaEmms.Animales;

public class Pajaro extends Animal{
    boolean puedeVolar;

    public Pajaro(String nombre, int edad, boolean puedeVolar) {
        super(nombre, edad);
        this.puedeVolar=puedeVolar;
    }

    @Override
    public void hacerSonido() {
        System.out.println("el Pajaro canta: Pio!Pio!");
    }

    @Override
    public void infoAnimal() {
        System.out.println("Nombre: " + nombre + "\nEdad: " + edad + "\nPuede volar: " + puedeVolar);
    }
}
