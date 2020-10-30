/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author fabri
 */
public final class AgregarEmpresa extends JFrame implements ActionListener {
    Container container = getContentPane();
    
    final JFileChooser explorer = new JFileChooser();
    
    JTextField TextFieldIdentificador = new JTextField();
    JTextField TextFieldFechaInicio= new JTextField();
    JTextField TextFieldFechaFinal= new JTextField();
    JTextField TextFieldMontoPagado = new JTextField();
    JTextField TextFieldDetalles = new JTextField();
    JTextField TextFieldTipoServicio = new JTextField();
    JTextField TextFieldEmpresaServicio = new JTextField();
    
   
    JLabel TextoRazonSocial = new JLabel("Razón Social");
    JLabel TextoNumeroCedula = new JLabel("Número de Cédula");
    JLabel TextoTelefono = new JLabel("Teléfono");
    JLabel TextoProvincia = new JLabel("Provincia");
    JLabel TextoDetalles = new JLabel("Cantón");
    JLabel TextoTipoDeServicio = new JLabel("Distrito");
    JLabel TextoEmpresaRelacionada = new JLabel("Señas");

    JButton botonAtras = new JButton("Atrás");
    JButton botonAgregarEmpresa = new JButton("Agregar");
 
    AgregarEmpresa() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }
 
    public void setLayoutManager() {
        container.setLayout(null);
    }
 
    public void setLocationAndSize() {
        TextoRazonSocial.setBounds(40, 100, 150, 30);
        TextoNumeroCedula.setBounds(40, 140, 150, 30);
        TextoTelefono.setBounds(40, 180, 150, 30);
        TextoProvincia.setBounds(40, 220, 150, 30);
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
        botonAgregarEmpresa.setBounds(140, 475, 150, 30);
        botonAtras.setBounds(200,30, 150, 30);
    }
 
    public void addComponentsToContainer() {
        container.add(botonAgregarEmpresa);
        container.add(TextoRazonSocial);
        container.add(TextoNumeroCedula);
        container.add(TextoTelefono);
        container.add(TextoProvincia);
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
        botonAgregarEmpresa.addActionListener(this);   
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource()==botonAtras){
            TextFieldIdentificador.setText("");
            TextFieldMontoPagado.setText("");
            TextFieldDetalles.setText("");
            TextFieldEmpresaServicio.setText("");
            TextFieldTipoServicio.setText("");
            TextFieldFechaInicio.setText("");
            TextFieldFechaFinal.setText("");

            Inicio.VentanaMenuAdministrador(true);
            Inicio.VentanaAgregarEmpresa(false); 
          
        }
        String fiTemp;
        String ffTemp;
        
        if (e.getSource()==botonAgregarEmpresa){
           
            if (TextFieldTipoServicio.getText().equals("") || TextFieldEmpresaServicio.getText().equals("") || TextFieldFechaFinal.getText().equals("") || TextFieldFechaInicio.getText().equals("") || TextFieldEmpresaServicio.getText().equals("") || TextFieldDetalles.getText().equals("") || TextFieldIdentificador.getText().equals("") || TextFieldMontoPagado.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Ingreso inválido o incompleto de elementos");
            
            } else {
                JOptionPane.showMessageDialog(this, "Se ha agregado una nueva empresa de mantenimiento");
                TextFieldIdentificador.setText("");
                TextFieldMontoPagado.setText("");
                TextFieldDetalles.setText("");
                TextFieldEmpresaServicio.setText("");
                Inicio.VentanaMenuAdministrador(true);
                Inicio.VentanaAgregarServicio(false);    
                
            }

        }
            
        
       //Coding Part of showPassword JCheckBox
    }
}
