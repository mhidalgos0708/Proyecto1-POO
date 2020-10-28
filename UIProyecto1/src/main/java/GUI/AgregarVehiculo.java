/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
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
public class AgregarVehiculo extends JFrame implements ActionListener {
    String filename;
    String[] TiposEstilos = {"", "Compacto", "Pick-Up", "Intermedio", "SUV", "Mini-Van", "Convertible", "Económico"};
    String[] TiposTransmision = {"", "Automática", "Manual"};
    String[] TiposSedes = {"", "Cartago", "Zapote"};
    String[] TiposServicios = {"", "Servicio1", "Servicio2"};
    Container container = getContentPane();
    final JFileChooser explorer = new JFileChooser();
    
    JTextField TextFieldPlaca = new JTextField();
    JTextField TextFieldColor = new JTextField();
    JTextField TextFieldMarca = new JTextField();
    JTextField TextFieldCapacidad = new JTextField();
    JTextField TextFieldKilometraje = new JTextField();
    JTextField TextFieldCostoDiario = new JTextField();
    JTextField TextFieldCapacidadMaletas = new JTextField();
    
    JTextField TextFieldNumeroPuertas = new JTextField();
    JTextField TextFieldVin = new JTextField();
    JTextField TextFieldMPG = new JTextField();
    
    
    JComboBox<String> TextFieldSede = new JComboBox<>(TiposSedes);
    JComboBox<String> TextFieldEstilo = new JComboBox<>(TiposEstilos);
    JComboBox<String> TextFieldTransmision = new JComboBox<>(TiposTransmision);
    JComboBox<String> TextFieldServicio = new JComboBox<>(TiposServicios);
   
    JLabel TextoPlaca = new JLabel("Placa");
    JLabel TextoEstilo = new JLabel("Estilo");
    JLabel TextoColor = new JLabel("Color");
    JLabel TextoMarca = new JLabel("Marca");
    JLabel TextoCapacidad = new JLabel("Capacidad");
    JLabel TextoKilometraje = new JLabel("Kilometraje");
    JLabel TextoNumeroPuertas = new JLabel("Numeros de Puertas");
    JLabel TextoNumeroVin = new JLabel("Número VIN");
    JLabel TextoMPG = new JLabel("MPG");
    JLabel TextoSede = new JLabel("Sede");
    JLabel TextoCostoDiario =new JLabel("Costo Diario");
    JLabel TextoCapacidadMaletas =new JLabel("Capacidad de Maletas");
    JLabel TextoTipoTransmision =new JLabel("Tipo de Transmision");
    JLabel TextoServicioAsociado =new JLabel("Servicio");
    JLabel TextoImagen =new JLabel("Imagen");
    JLabel ruta =new JLabel("ruta");

    JLabel TextoTL=new JLabel("");
     
    JButton TextFieldImágen = new JButton("Seleccionar Imagen");
    JButton botonAtras = new JButton("Atrás");
    JButton botonAgregarOperador = new JButton("Agregar");
    
    
    ImageIcon img = new ImageIcon("");
    JLabel img2 = new JLabel(img);
 
 
 
    AgregarVehiculo() {
        
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
 
    }
 
    public void setLayoutManager() {
        container.setLayout(null);
    }
 
    public void setLocationAndSize() {
        img2.setBounds(550, 350, 150, 150);
        TextoPlaca.setBounds(40, 100, 150, 30);
        TextoEstilo.setBounds(40, 140, 150, 30);
        TextoColor.setBounds(40, 180, 150, 30);
        TextoMarca.setBounds(40, 220, 150, 30);
        TextoCapacidad.setBounds(40, 260, 150, 30);
        TextoKilometraje.setBounds(40, 300, 150, 30);
        TextoNumeroPuertas.setBounds(40, 340, 150, 30);
        TextoNumeroVin.setBounds(40, 380, 150, 30);
        TextoMPG.setBounds(40, 420, 150, 30);
        TextoSede.setBounds(400, 100, 150, 30);
        TextoCostoDiario.setBounds(400, 140, 150, 30);
        TextoTL.setBounds(120, 380, 150, 30);
        TextoCapacidadMaletas.setBounds(400, 180, 150, 30);
        TextoTipoTransmision.setBounds(400, 220, 150, 30);
        TextoServicioAsociado.setBounds(400, 260, 150, 30);
        TextoImagen.setBounds(400, 300, 150, 30);
           
        TextFieldPlaca.setBounds(200, 100, 150, 30);
        TextFieldEstilo.setBounds(200, 140, 150, 30);
        TextFieldColor.setBounds(200, 180, 150, 30); 
        TextFieldMarca.setBounds(200, 220, 150, 30); 
        TextFieldCapacidad.setBounds(200, 260, 150, 30); 
        TextFieldKilometraje.setBounds(200, 300, 150, 30); 
        TextFieldNumeroPuertas.setBounds(200, 340, 150, 30); 
        TextFieldVin.setBounds(200, 380, 150, 30); 
        TextFieldMPG.setBounds(200, 420, 150, 30); 
        TextFieldImágen.setBounds(550, 300, 150, 30);
        TextFieldSede.setBounds(550, 100, 150, 30);
        
        TextFieldCostoDiario.setBounds(550, 140, 150, 30);
        TextFieldCapacidadMaletas.setBounds(550, 180, 150, 30);
        TextFieldTransmision.setBounds(550, 220, 150, 30);
        TextFieldServicio.setBounds(550, 260, 150, 30);
        
       botonAgregarOperador.setBounds((400-150/2)-5, 475, 150, 30);
        botonAtras.setBounds(550,30, 150, 30);
 
 
    }
 
    public void addComponentsToContainer() {
        container.add(botonAgregarOperador);
        
        container.add(TextoPlaca);
        container.add(TextoEstilo);
        container.add(TextoColor);
        container.add(TextoMarca);
        container.add(TextoCapacidad);
        container.add(TextoKilometraje);
        container.add(TextoNumeroPuertas);
        container.add(TextoNumeroVin);
        container.add(TextoMPG);
        container.add(TextoSede);
        container.add(TextoCapacidadMaletas);
        container.add(TextoTipoTransmision);
        container.add(TextoServicioAsociado);
        container.add(TextoImagen);
        
       
        container.add(TextFieldPlaca);
        container.add(TextFieldEstilo);
        container.add(TextFieldColor);
        container.add(TextFieldMarca);
        container.add(TextFieldCapacidad);
        container.add(TextFieldKilometraje);
        container.add(TextFieldNumeroPuertas);
        container.add(TextFieldVin);
        container.add(TextFieldMPG);
        container.add(TextFieldImágen);
        container.add(TextoCostoDiario);
        container.add(TextoTL);
        container.add(TextFieldSede);
        container.add(TextFieldCostoDiario);
        container.add(TextFieldCapacidadMaletas);
        container.add(TextFieldTransmision);
        container.add(TextFieldServicio);
        
        container.add(botonAtras);
        
        container.add(img2);
    }
 
    public void addActionEvent() {

        botonAtras.addActionListener(this);
        botonAgregarOperador.addActionListener(this);
        TextFieldImágen.addActionListener(this);
        TextFieldVin.addActionListener(this);
        
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource()==botonAtras){
            TextFieldPlaca.setText("");
            TextFieldVin.setText("");
            TextFieldColor.setText("");
            TextFieldMarca.setText("");
            TextFieldCapacidad.setText("");
            TextFieldKilometraje.setText("");
            TextFieldNumeroPuertas.setText("");
            TextFieldEstilo.setSelectedIndex(0);
            TextFieldTransmision.setSelectedIndex(0);
            TextFieldSede.setSelectedIndex(0);
            TextFieldServicio.setSelectedIndex(0);
            TextFieldMPG.setText("");
            TextFieldCostoDiario.setText("");
            TextFieldCapacidadMaletas.setText("");
            
            Login.VentanaMenuAdministrador(true);
            Login.VentanaAgregarVehiculo(false); 
          
        }
        if (e.getSource()==botonAgregarOperador){
            if (TextFieldServicio.getSelectedItem().equals("") || TextFieldTransmision.getSelectedItem().equals("") || TextFieldEstilo.getSelectedItem().equals("") || TextFieldSede.getSelectedItem().equals("") || TextFieldMPG.getText().equals("") || TextFieldVin.getText().equals("") || TextFieldNumeroPuertas.getText().equals("") || TextFieldCapacidadMaletas.getText().equals("") || TextFieldCostoDiario.getText().equals("") || TextFieldKilometraje.getText().equals("") || TextFieldCapacidad.getText().equals("") || TextFieldMarca.getText().equals("") || TextFieldPlaca.getText().equals("") || TextFieldColor.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ingreso inválido o incompleto de elementos");
            
            } else {
                JOptionPane.showMessageDialog(this, "Se ha agregado un nuevo vehículo");
                TextFieldPlaca.setText("");
                TextFieldVin.setText("");
                TextFieldColor.setText("");
                TextFieldMarca.setText("");
                TextFieldCapacidad.setText("");
                TextFieldKilometraje.setText("");
                TextFieldNumeroPuertas.setText("");
                TextFieldEstilo.setSelectedIndex(0);
                TextFieldTransmision.setSelectedIndex(0);
                TextFieldSede.setSelectedIndex(0);
                TextFieldServicio.setSelectedIndex(0);
                TextFieldMPG.setText("");
                TextoCostoDiario.setText("");
                TextoTL.setText("");
                Login.VentanaMenuAdministrador(true);
                Login.VentanaAgregarVehiculo(false);    
                
            }

        }
        if(e.getSource()==TextFieldImágen){
            int accion = explorer.showOpenDialog(Login.frameRegistrarCliente);
            if (accion == JFileChooser.APPROVE_OPTION){  
                System.out.println("AAAAAAAAAa");
                JLabel images = new JLabel();
                filename = explorer.getSelectedFile().toString();
                container.remove(img2);
                ruta.setText(filename);
                ImageIcon h = new ImageIcon(ruta.getText());
                JLabel K = new JLabel(h);
                K.setBounds(550, 350, 150, 150);
                img2=K;
                container.add(img2);
                container.revalidate();
                container.repaint();
                
                
                
            }else{
                filename = "Error, no se encuentra el archivo";
            }
        }
        if(e.getSource()==TextFieldEstilo){
            JComboBox cb=(JComboBox)e.getSource();
            TextoTL.setText((String)cb.getSelectedItem());
        }
            
        
       //Coding Part of showPassword JCheckBox
    }
}
