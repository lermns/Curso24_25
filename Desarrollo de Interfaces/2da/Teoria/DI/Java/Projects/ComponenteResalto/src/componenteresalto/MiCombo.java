
package componenteresalto;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComboBox;

/**
 *
 * @author pedbo
 */

public class MiCombo extends JComboBox implements MouseListener {
    
    private String tipoCombo;
    
    public MiCombo(){
        tipoCombo = "DIASSEMANA";
        this.setPreferredSize(new Dimension(150, 60));
        addMouseListener(this);
    }

    public String getTipoCombo() {
        return tipoCombo;
    }

    public void setTipoCombo(String tipoCombo) {
        this.tipoCombo = tipoCombo;
    }
    
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        rellenaItems();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    private void rellenaItems() {
        this.removeAllItems();
        
        if (tipoCombo == "DIASSEMANA"){
            this.addItem("Lunes");
            this.addItem("Martes");
            this.addItem("Miércoles");
            this.addItem("Jueves");
            this.addItem("Viernes");
            this.addItem("Sábado");
            this.addItem("Domingo");
        }
        
        if (tipoCombo == "DIAS"){
            for (int i = 0 ; i < 31 ; i++){
                this.addItem(i);
            }
        }
        
        if (tipoCombo == "MESES"){
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
    }
}
