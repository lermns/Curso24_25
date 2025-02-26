package leonardoramos_act_miradiobutton_micombobox;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JRadioButton;

public class MiRadioButton extends JRadioButton implements MouseListener {
    
    public MiRadioButton(){
        this.setText("Opcion x");
        this.setPreferredSize(new Dimension(150, 60));
        this.setFont(new Font("Tohoma", Font.PLAIN, 14));
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(this.isSelected()){
            this.setFont(new Font("Tahoma", Font.BOLD, 34));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(!this.isSelected()){
            this.setFont(new Font("Tahoma", Font.BOLD, 24));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(this.isSelected()){
            this.setFont(new Font("Tahoma", Font.BOLD, 34));
        }else{
            this.setFont(new Font("Tahoma", Font.PLAIN, 14));
    }
    }
}
