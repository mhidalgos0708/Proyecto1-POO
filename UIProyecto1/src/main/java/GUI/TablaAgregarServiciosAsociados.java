/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Modelo.Servicio;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author JoJo
 */
public class TablaAgregarServiciosAsociados extends javax.swing.JFrame {
    
    static Servicio ServicioSeleccionado;
    static javax.swing.table.DefaultTableModel model;
    static TablaAgregarServiciosAsociados frameTablaEditarServiciosVehiculo= new TablaAgregarServiciosAsociados();

    public TablaAgregarServiciosAsociados() {
        initComponents();
        model= new javax.swing.table.DefaultTableModel();
        TablaEditarServiciosAsociados.setModel(model);
        model.addColumn("Servicios de Mantenimiento");
        
    }
    static  boolean ValidarRepetitivo(ArrayList<Servicio> lista){
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(ServicioSeleccionado)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaEditarServiciosAsociados = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        ServiciosAsociadosDisponibles = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 250));
        TablaEditarServiciosAsociados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Servicio Asociado"
            }
        ));
        jScrollPane1.setViewportView(TablaEditarServiciosAsociados);

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Añadir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        DefaultComboBoxModel mod= new DefaultComboBoxModel(Inicio.listaServicios.toArray());
        ServiciosAsociadosDisponibles.setModel(mod);
        ServiciosAsociadosDisponibles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ServiciosAsociadosDisponiblesActionPerformed(evt);
            }
        });

        jButton3.setText("Remover");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ServiciosAsociadosDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))))
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ServiciosAsociadosDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Boton Aceptar
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            ArrayList<Servicio> listafinal= new ArrayList<>();
            for (int i = 0; i < TablaEditarServiciosAsociados.getRowCount(); i++) {
                listafinal.add((Servicio) TablaEditarServiciosAsociados.getValueAt(i, 0));   
            }
            if (editando){
                System.out.println("Editando");
                Inicio.frameEditarVehiculo.setEnabled(true);
            }else{
                AgregarVehiculo.serviciosAsociados = listafinal;
                Inicio.frameAgregarVehiculo.setEnabled(true);
                System.out.println(AgregarVehiculo.serviciosAsociados);
            }
            frameTablaEditarServiciosVehiculo.setVisible(false);
    }

    private void ServiciosAsociadosDisponiblesActionPerformed(java.awt.event.ActionEvent evt) {
        JComboBox cb=(JComboBox)evt.getSource();
        ServicioSeleccionado=((Servicio)cb.getSelectedItem());
    }
    
    //Boton agregar
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ArrayList<Servicio> lista= new ArrayList<>();
        
        for (int i = 0; i < TablaEditarServiciosAsociados.getRowCount(); i++) {
            lista.add((Servicio) TablaEditarServiciosAsociados.getValueAt(i, 0));   
        }
        
        if(!ValidarRepetitivo(lista)){
           if(ServicioSeleccionado==null){
                System.out.println("Seleccione un servicio");

           }else {
                cantServicios++;
                model.addRow(new Object[]{ServicioSeleccionado});      
           }
        }
    }
    

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try{
            if (cantServicios!=0) {
                model.removeRow(TablaEditarServiciosAsociados.getSelectedRow());
                cantServicios--;
            }else{
                JOptionPane.showMessageDialog(this, "No quedan servicios para eliminar");
            }
        }catch(Exception error){
            JOptionPane.showMessageDialog(this, "Seleccione un servicio antes de eliminar");
        }
        
    }
    
    static void LimpiarTabla(){
        cantServicios=0;
        model.setRowCount(0);
    }
    /**
     * @param args the command line arguments
     */
   
    public static javax.swing.JComboBox<Servicio> ServiciosAsociadosDisponibles;
    public static javax.swing.JTable TablaEditarServiciosAsociados;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    static public int cantServicios = 0;
    static public boolean editando = false;
}
