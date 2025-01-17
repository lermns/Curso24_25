import javax.swing.*;
import java.util.Arrays;

public class MiCombo extends JComboBox<String> {
    private String tipoCombo;

    public MiCombo() {
        super();
    }

    public String getTipoCombo() {
        return tipoCombo;
    }

    public void setTipoCombo(String tipoCombo) {
        this.tipoCombo = tipoCombo;
        actualizarCombo();
    }

    private void actualizarCombo() {
        this.removeAllItems();

        switch (tipoCombo.toUpperCase()) {
            case "DIASSEMANA":
                Arrays.asList("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")
                      .forEach(this::addItem);
                break;
            case "MESES":
                Arrays.asList("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", 
                              "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre")
                      .forEach(this::addItem);
                break;
            default:
                addItem("Sin opciones");
        }
    }
}

