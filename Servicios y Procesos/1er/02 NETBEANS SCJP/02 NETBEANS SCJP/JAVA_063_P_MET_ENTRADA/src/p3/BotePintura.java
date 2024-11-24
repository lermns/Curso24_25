// Crear una clase JavaBean que represente un bote de pintura, con una propiedad color.


package p3;

public class BotePintura {

    private String color;
    
    public BotePintura(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    // SI LA VARIABLE color SE HUBIESE DEFINIDO COMO final, EL SETTER DARÍA ERROR.
    public void setColor(String color) {
        this.color = color;
    }   
}