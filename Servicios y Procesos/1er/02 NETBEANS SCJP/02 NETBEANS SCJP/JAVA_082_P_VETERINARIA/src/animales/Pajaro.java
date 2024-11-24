// Crear la clas Pajaro como heredera de la clase abstracta Animal implementando el
// método chequear en base a la posible revisión que un veterinario realizaría.


package animales;

public class Pajaro extends Animal {

    @Override
    public void chequear() {
        System.out.println("SE LE RECORTA EL PICO");
    }
}