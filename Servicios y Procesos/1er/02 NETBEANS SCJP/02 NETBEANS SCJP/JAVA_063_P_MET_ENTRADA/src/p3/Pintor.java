// Crear una clase Pintor que reciba un objeto BotePintura, puediendo consultar o 
// modificar el valor de su atributo color. Utilizar composición débil (agregación)
// inicializando la variable a través del constructor de Pintor.


package p3;

public class Pintor {

    private BotePintura botePintura;

    public Pintor(BotePintura botePintura) {
        this.botePintura = botePintura;
    }
    
    public void cambiarColorBote(String color) {
        botePintura.setColor(color);
    }
    
    public String consultarColor() {
        return botePintura.getColor();
    }   
}