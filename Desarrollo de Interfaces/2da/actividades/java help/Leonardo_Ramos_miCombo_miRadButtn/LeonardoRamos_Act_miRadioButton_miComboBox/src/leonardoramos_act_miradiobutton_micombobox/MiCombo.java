package leonardoramos_act_miradiobutton_micombobox;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComboBox;

public class MiCombo extends JComboBox implements MouseListener{
    private String tipoCombo;
    
    public MiCombo(){
        this.setPreferredSize(new Dimension(150, 60));
        addMouseListener(this);
    }

    public void setTipoCombo(String tipoCombo) {
        this.tipoCombo = tipoCombo;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        rellenarItems();
    }

    private void rellenarItems(){
        this.removeAllItems();
        
        switch (tipoCombo) {
            case "DIASSEMANA" -> {
                this.addItem("Lunes");
                this.addItem("Martes");
                this.addItem("Miercoles");
                this.addItem("Jueves");
                this.addItem("Viernes");
                this.addItem("Sabado");
                this.addItem("Domingo");
            }
            case "MESES" -> {
                this.addItem("Enero");
                this.addItem("Febrero");
                this.addItem("Marzo");
                this.addItem("Abril");
                this.addItem("Mayo");
                this.addItem("Junio");
                this.addItem("Julio");
                this.addItem("Agosto");
                this.addItem("Septiembre");
                this.addItem("Octubre");
                this.addItem("Noviembre");
                this.addItem("Diciembre");
            }
            case "NUMEROS" -> {
                for(int i=1; i<32; i++){
                    this.addItem(String.valueOf(i));
                }
            }
            default -> {
                System.out.println("ninguno seleccionado");
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mouseReleased");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("mouseEntered");    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("mouseExited");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mouseClicked");
    }

}
