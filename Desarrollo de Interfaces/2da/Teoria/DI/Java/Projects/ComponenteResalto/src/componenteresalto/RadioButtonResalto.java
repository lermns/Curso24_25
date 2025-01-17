
package componenteresalto;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JRadioButton;

/**
 *
 * @author PedroBorreganBurgos
 */

public class RadioButtonResalto extends JRadioButton implements MouseListener {

    public RadioButtonResalto() {
        this.setText("Opcion X");
        this.setPreferredSize(new Dimension(150, 60));
        this.setFont(new Font("Tahoma", Font.PLAIN, 14));
        addMouseListener(this);
    }
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (this.isSelected())
            this.setFont(new Font("Tahoma", Font.BOLD, 34));
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (!this.isSelected())
            this.setFont(new Font("Tahoma", Font.BOLD, 24));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (this.isSelected())
            this.setFont(new Font("Tahoma", Font.BOLD, 34));
        if (!this.isSelected())
            this.setFont(new Font("Tahoma", Font.PLAIN, 14));
    }
    
}
