/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author JoJo
 */
public class FiltroOperador extends javax.swing.JFrame {
        static FiltroOperador frameRegistrarOperador = new FiltroOperador();
        static String SedeSeleccionada;
    /**
     * Creates new form FiltroPuntoRecogida
     */
    public FiltroOperador() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        BotónBuscar = new javax.swing.JButton();
        BotónAtrás = new javax.swing.JButton();
        SedesDeRecogida = new javax.swing.JComboBox<>();
        SedesDisponibles = new javax.swing.JComboBox<>();

        jToggleButton2.setText("jToggleButton2");

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 250));

        BotónBuscar.setText("Buscar");
        BotónBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotónBuscarActionPerformed(evt);
            }
        });

        BotónAtrás.setText("Atrás");
        BotónAtrás.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotónAtrásActionPerformed(evt);
            }
        });

        SedesDeRecogida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Operador1", "Operador2" }));
        SedesDeRecogida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SedesDeRecogidaActionPerformed(evt);
            }
        });

        SedesDisponibles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "","Item 1", "Item 2", "Item 3", "Item 4" }));
        SedesDisponibles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SedesDisponiblesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(BotónAtrás)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(140, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BotónBuscar)
                        .addGap(162, 162, 162))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SedesDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SedesDeRecogida, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(126, 126, 126))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BotónAtrás)
                .addGap(55, 55, 55)
                .addComponent(SedesDeRecogida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(SedesDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(BotónBuscar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotónAtrásActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotónAtrásActionPerformed
        frameRegistrarOperador.setVisible(false); 
        SedesDeRecogida.setSelectedIndex(0);// TODO add your handling code here:
    }//GEN-LAST:event_BotónAtrásActionPerformed

    private void SedesDeRecogidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SedesDeRecogidaActionPerformed
        
        if(SedesDeRecogida.getSelectedIndex()==0){
            SedesDisponibles.setSelectedIndex(0);
            SedesDisponibles.setEnabled(false);
        }else if(SedesDeRecogida.getSelectedIndex()==1){
            SedesDisponibles.setEnabled(true);
            SedesDisponibles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "","Operador1_1", "Operador1_2" }));
            
        }else if(SedesDeRecogida.getSelectedIndex()==2){
            SedesDisponibles.setEnabled(true);
            SedesDisponibles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "","Operador2_1", "Operador2_2" }));

        };        // TODO add your handling code here:
    }//GEN-LAST:event_SedesDeRecogidaActionPerformed

    private void BotónBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotónBuscarActionPerformed
        if(SedesDeRecogida.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this, "Elementos incompletos");
        } else if(SedesDisponibles.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this, "Elementos incompletos");
        } else{
            Inicio.VentanaReserva(true);
            frameRegistrarOperador.setVisible(false);
            Inicio.frameRes.ContenidoTextoID.setText(SedeSeleccionada);
            SedesDeRecogida.setSelectedIndex(0);
        
        
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_BotónBuscarActionPerformed

    private void SedesDisponiblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SedesDisponiblesActionPerformed
        JComboBox cb=(JComboBox)evt.getSource();
            SedeSeleccionada=((String)cb.getSelectedItem());        // TODO add your handling code here:
    }//GEN-LAST:event_SedesDisponiblesActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotónAtrás;
    private javax.swing.JButton BotónBuscar;
    private javax.swing.JComboBox<String> SedesDeRecogida;
    private javax.swing.JComboBox<String> SedesDisponibles;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    // End of variables declaration//GEN-END:variables
}
