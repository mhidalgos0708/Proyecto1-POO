/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author fabri
 */
public class AgregarServicio extends JFrame implements ActionListener {
    String filename;
    String[] ListaEmpresas = {"", "Empresa1", "Empresa2"};
    String[] TiposDeServicios = {"", "Preventivo", "Correctivo"};
    Container container = getContentPane();
    
    final JFileChooser explorer = new JFileChooser();
    
    JTextField TextFieldIdentificador = new JTextField();
    com.toedter.calendar.JDateChooser TextFieldFechaInicio= new com.toedter.calendar.JDateChooser();
    com.toedter.calendar.JDateChooser TextFieldFechaFinal= new com.toedter.calendar.JDateChooser();
    JTextField TextFieldMontoPagado = new JTextField();
    JTextField TextFieldDetalles = new JTextField();
    JComboBox<String> TextFieldTipoServicio = new JComboBox<>(TiposDeServicios);
    JComboBox<String> TextFieldEmpresaServicio = new JComboBox<>(ListaEmpresas);
    
   
    JLabel TextoIdentificador = new JLabel("Identificador");
    JLabel TextoFechaI = new JLabel("Fecha de Inicio");
    JLabel TextoFechaF = new JLabel("Fecha Final");
    JLabel TextoMontoPagado = new JLabel("Monto Pagado");
    JLabel TextoDetalles = new JLabel("Detalles");
    JLabel TextoTipoDeServicio = new JLabel("Tipo de Servicio");
    JLabel TextoEmpresaRelacionada = new JLabel("Empresa Relacionada");

    JButton botonAtras = new JButton("Atrás");
    JButton botonAgregarServicio = new JButton("Agregar");
 
 
 
    AgregarServicio() {
        
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
 
    }
 
    public void setLayoutManager() {
        container.setLayout(null);
    }
 
    public void setLocationAndSize() {
        TextoIdentificador.setBounds(40, 100, 150, 30);
        TextoFechaI.setBounds(40, 140, 150, 30);
        TextoFechaF.setBounds(40, 180, 150, 30);
        TextoMontoPagado.setBounds(40, 220, 150, 30);
        TextoDetalles.setBounds(40, 260, 150, 30);
        TextoTipoDeServicio.setBounds(40, 300, 150, 30);
        TextoEmpresaRelacionada.setBounds(40, 340, 150, 30);
        
        TextFieldIdentificador.setBounds(200, 100, 150, 30);
        
        TextFieldFechaInicio.setBounds(200, 140, 150, 30);
        TextFieldFechaFinal.setBounds(200, 180, 150, 30);
           
        
        TextFieldMontoPagado.setBounds(200, 220, 150, 30); 
        TextFieldDetalles.setBounds(200, 260, 150, 30); 
        
        TextFieldTipoServicio.setBounds(200, 300, 150, 30);
        TextFieldEmpresaServicio.setBounds(200, 340, 150, 30);
        botonAgregarServicio.setBounds(150, 475, 150, 30);
        botonAtras.setBounds(200,30, 150, 30);
 
 
    }
 
    public void addComponentsToContainer() {
        container.add(botonAgregarServicio);
        
        container.add(TextoIdentificador);
        container.add(TextoFechaI);
        container.add(TextoFechaF);
        container.add(TextoMontoPagado);
        container.add(TextoDetalles);
        container.add(TextoTipoDeServicio);
        container.add(TextoEmpresaRelacionada);
        
       
        container.add(TextFieldIdentificador);
        container.add(TextFieldMontoPagado);
        container.add(TextFieldDetalles);
        container.add(TextFieldEmpresaServicio);
        
        container.add(TextFieldTipoServicio);
        container.add(TextFieldFechaInicio);
        container.add(TextFieldFechaFinal);
        
        
        container.add(botonAtras);
    }
 
    public void addActionEvent() {

        botonAtras.addActionListener(this);
        botonAgregarServicio.addActionListener(this);
        
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource()==botonAtras){
            TextFieldIdentificador.setText("");
            TextFieldMontoPagado.setText("");
            TextFieldDetalles.setText("");
            TextFieldEmpresaServicio.setSelectedIndex(0);
            TextFieldTipoServicio.setSelectedIndex(0);
            TextFieldFechaInicio.setDate(null);
            TextFieldFechaFinal.setDate(null);

            Login.VentanaMenuAdministrador(true);
            Login.VentanaAgregarServicio(false); 
          
        }
        String fiTemp;
        String ffTemp;
        
        if (e.getSource()==botonAgregarServicio){
            if(TextFieldFechaInicio.getCalendar()!=null){
                int año = TextFieldFechaInicio.getCalendar().get(Calendar.YEAR);
                int mes = TextFieldFechaInicio.getCalendar().get(Calendar.MONTH) + 1;
                int dia = TextFieldFechaInicio.getCalendar().get(Calendar.DAY_OF_MONTH);
                fiTemp=dia+"/"+mes+"/"+año;
            }
            
            if(TextFieldFechaFinal.getCalendar()!=null){
                int año = TextFieldFechaFinal.getCalendar().get(Calendar.YEAR);
                int mes = TextFieldFechaFinal.getCalendar().get(Calendar.MONTH) + 1;
                int dia = TextFieldFechaFinal.getCalendar().get(Calendar.DAY_OF_MONTH);
                fiTemp=dia+"/"+mes+"/"+año;
            }
           
            if (TextFieldTipoServicio.getSelectedItem() == "" || TextFieldEmpresaServicio.getSelectedItem() == "" || TextFieldFechaFinal.getDate() == null || TextFieldFechaInicio.getDate() == null || TextFieldEmpresaServicio.getSelectedItem().equals("") || TextFieldDetalles.getText().equals("") || TextFieldIdentificador.getText().equals("") || TextFieldMontoPagado.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ingreso inválido o incompleto de elementos");
            
            } else {
                JOptionPane.showMessageDialog(this, "Se ha agregado un nuevo servicio de mantenimiento");
                TextFieldIdentificador.setText("");
                TextFieldMontoPagado.setText("");
                TextFieldDetalles.setText("");

                TextFieldEmpresaServicio.setSelectedIndex(0);

                Login.VentanaMenuAdministrador(true);
                Login.VentanaAgregarServicio(false);    
                
            }

        }
            
        
       //Coding Part of showPassword JCheckBox
    }
}
