package AyudaEmms.Animales;

public class Main {
    public static void main(String[] args) {
        Animal gato1 = new Gato("susi", 5);
        Animal perro1 = new Perro("Balto", 7);
        Animal pajaro = new Pajaro("Gigo", 10, true);

        //Animal animal1 = new Animal("??", 20);

        gato1.hacerSonido();
        gato1.infoAnimal();

        perro1.hacerSonido();
        perro1.infoAnimal();

        perro1.hacerSonido();
        perro1.infoAnimal();
    }
}
/*
Enunciado:
Crea un programa que modele un sistema de animales utilizando herencia. Debes seguir estos pasos:

Clase base Animal:

Atributos: nombre (String), edad (int).
Métodos:
Constructor que inicialice nombre y edad.
Método hacerSonido() que imprima "El animal hace un sonido genérico".
Método mostrarInfo() que imprima el nombre y la edad del animal.
Clases derivadas:

Perro:
Método sobrescrito hacerSonido() que imprima "El perro ladra: ¡Guau guau!".
Gato:
Método sobrescrito hacerSonido() que imprima "El gato maúlla: ¡Miau miau!".
Pájaro:
Atributo adicional: puedeVolar (boolean).
Método sobrescrito hacerSonido() que imprima "El pájaro canta: ¡Pío pío!".
Constructor que inicialice los atributos de la clase base y el atributo adicional.
Sobrescribe el método mostrarInfo() para incluir si puede volar o no.
Clase principal Main:

Crea un array de tipo Animal que contenga objetos de las diferentes clases (Perro, Gato, Pájaro).
Recorre el array con un bucle para llamar a hacerSonido() y mostrarInfo() en cada objeto.
*/
