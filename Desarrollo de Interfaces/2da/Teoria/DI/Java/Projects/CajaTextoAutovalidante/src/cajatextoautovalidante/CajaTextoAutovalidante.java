
package cajatextoautovalidante;

/**
 *
 * @author Pedbo
 **/
        
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class CajaTextoAutovalidante extends JPanel {
    private JTextField textField;
    private JLabel errorLabel;
    private String tipoValidacion;

    public CajaTextoAutovalidante(String tipoValidacion) {
        this.tipoValidacion = tipoValidacion;
        initComponents();
    }

    private void initComponents() {
        textField = new JTextField(20);
        errorLabel = new JLabel("No hay error");
        
        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                validarCampo();
            }
        });
        
        setBorder(BorderFactory.createEtchedBorder());
        
        add(textField);
        add(errorLabel);
    }
    
    private void validarCampo() {
        String textoInsertado = textField.getText().trim();
        
        switch (tipoValidacion) {
            case "DNI":
                chequeoDNI(textoInsertado);
                break;
            case "TFN":
                chequeoTFN(textoInsertado);
                break;
            case "CP":
                chequeoCP(textoInsertado);
                break;
            default:
                errorLabel.setText("Tipo de validación no soportado");
                errorLabel.setForeground(Color.RED);
        }
    }
    
    private void chequeoDNI(String textoInsertado) {
        if (textoInsertado.length() == 9) {
            try {
                int numeros = Integer.parseInt(textoInsertado.substring(0, 7));
                try {
                    int letra = Integer.parseInt(textoInsertado.substring(8));
                    errorLabel.setText("El último dígito debe ser una letra.");
                    errorLabel.setForeground(Color.RED);
                } catch (NumberFormatException e) {
                    errorLabel.setText("No hay errores");
                    errorLabel.setForeground(Color.BLACK);
                }
            } catch (NumberFormatException e) {
                errorLabel.setText("Los 8 primeros dígitos del DNI deben ser números.");
                errorLabel.setForeground(Color.RED);
            }
        } else {
            errorLabel.setText("El DNI debe tener 9 dígitos.");
            errorLabel.setForeground(Color.RED);
        }
    }

    private void chequeoTFN(String textoInsertado) {
        if (textoInsertado.length() == 9) {
            try {
                int numeros = Integer.parseInt(textoInsertado);
                errorLabel.setText("No hay error");
                errorLabel.setForeground(Color.BLACK);
            } catch (NumberFormatException e) {
                errorLabel.setText("El teléfono solo debe tener números.");
                errorLabel.setForeground(Color.RED);
            }
        } else {
            errorLabel.setText("El teléfono debe tener 9 dígitos.");
            errorLabel.setForeground(Color.RED);
        }
    }

    private void chequeoCP(String textoInsertado) {
        if (textoInsertado.length() == 5) {
            try {
                int numeros = Integer.parseInt(textoInsertado);
                errorLabel.setText("No hay error");
                errorLabel.setForeground(Color.BLACK);
            } catch (NumberFormatException e) {
                errorLabel.setText("El código postal solo debe tener números.");
                errorLabel.setForeground(Color.RED);
            }
        } else {
            errorLabel.setText("El código postal debe tener 5 dígitos.");
            errorLabel.setForeground(Color.RED);
        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        jLabel1.setText("Texto de error actualizable");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
