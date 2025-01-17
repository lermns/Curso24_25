import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MiRadioButton extends JRadioButton {
    private static final Font FONT_NORMAL = new Font("Arial", Font.PLAIN, 14);
    private static final Font FONT_HOVER = new Font("Arial", Font.BOLD, 18);
    private static final Font FONT_SELECTED = new Font("Arial", Font.BOLD, 24);

    public MiRadioButton() {
        super();
        setFont(FONT_NORMAL);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!isSelected()) {
                    setFont(FONT_HOVER);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!isSelected()) {
                    setFont(FONT_NORMAL);
                }
            }
        });

        addActionListener(e -> {
            if (isSelected()) {
                setFont(FONT_SELECTED);
            } else {
                setFont(FONT_NORMAL);
            }
        });
    }
}

