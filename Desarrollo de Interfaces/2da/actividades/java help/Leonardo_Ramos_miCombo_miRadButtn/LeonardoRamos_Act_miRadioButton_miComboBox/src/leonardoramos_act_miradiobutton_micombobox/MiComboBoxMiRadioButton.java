package leonardoramos_act_miradiobutton_micombobox;

public class MiComboBoxMiRadioButton extends javax.swing.JFrame {

    public MiComboBoxMiRadioButton() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        miRadioButton1 = new leonardoramos_act_miradiobutton_micombobox.MiRadioButton();
        miRadioButton2 = new leonardoramos_act_miradiobutton_micombobox.MiRadioButton();
        miRadioButton3 = new leonardoramos_act_miradiobutton_micombobox.MiRadioButton();
        miCombo1 = new leonardoramos_act_miradiobutton_micombobox.MiCombo();
        miCombo2 = new leonardoramos_act_miradiobutton_micombobox.MiCombo();
        miCombo3 = new leonardoramos_act_miradiobutton_micombobox.MiCombo();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        miRadioButton2.setText("Opcion y");

        miRadioButton3.setText("Opcion z");

        miCombo1.setTipoCombo("MESES");
        miCombo1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                miCombo1PropertyChange(evt);
            }
        });

        miCombo2.setTipoCombo("DIASSEMANA");

        miCombo3.setTipoCombo("NUMEROS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(miRadioButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(miRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(miRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(miCombo1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(miCombo2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(miCombo3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(miRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(miCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(miRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(miCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(miCombo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(miRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miCombo1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_miCombo1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_miCombo1PropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private leonardoramos_act_miradiobutton_micombobox.MiCombo miCombo1;
    private leonardoramos_act_miradiobutton_micombobox.MiCombo miCombo2;
    private leonardoramos_act_miradiobutton_micombobox.MiCombo miCombo3;
    private leonardoramos_act_miradiobutton_micombobox.MiRadioButton miRadioButton1;
    private leonardoramos_act_miradiobutton_micombobox.MiRadioButton miRadioButton2;
    private leonardoramos_act_miradiobutton_micombobox.MiRadioButton miRadioButton3;
    // End of variables declaration//GEN-END:variables
}
