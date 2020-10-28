package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.toedter.calendar.JDateChooser;
import java.util.Calendar;
import java.util.Date;
import java.util.Dictionary;
 

public class RealizarReserva extends JFrame implements ActionListener {
    String filename;
    String[] TiposLicencias = {"", "A1","A2","A3","A4","B1","B2","B3","B4","C1","C2","D1","D2","D3","E1","E1"};
    String[] ClientesTotales = {"", "Abiel", "Chuculun"};
    String[] OperadoresTotales={"", "Jason", "Roy"};
    String [] SedesTotales = {"","Zapote","Cartago"};
    Container container = getContentPane();
    final JFileChooser explorer = new JFileChooser();
    
    JComboBox<String> TextFieldNombreCompleto = new JComboBox<>(SedesTotales);
    JComboBox<String> TextFieldCédula = new JComboBox<>(SedesTotales);
    com.toedter.calendar.JDateChooser TextFieldDirección= new com.toedter.calendar.JDateChooser();
    com.toedter.calendar.JDateChooser TextFieldCorreo= new com.toedter.calendar.JDateChooser();
    JComboBox<String> TextFieldTipoLicencia = new JComboBox<>(ClientesTotales);
    JButton TextFieldFechaEmisionLicencia= new JButton("Seleccionar");
   JCheckBox TextFieldFechaExpiracionLicencia= new JCheckBox();
   JCheckBox SO2= new JCheckBox();
   JCheckBox SO3= new JCheckBox();
   JCheckBox SO4= new JCheckBox();
   JCheckBox SO5= new JCheckBox();
    
    
    
    JLabel TextoNombreCompleto = new JLabel("Sede Recogida");
    JLabel TextoCédula = new JLabel("Sede Entrega");
    JLabel TextoDirección = new JLabel("Fecha Inicio");
    JLabel TextoCorreo = new JLabel("Fecha Finalización");
    JLabel TextoFechaEmisionLicencia = new JLabel("Vehículo Seleccionado");
    JLabel TextoTipoLicencia = new JLabel("Cliente Relacionado");
    JLabel TextoFechaExpiracionLicencia = new JLabel("Servicios Opcionales");
    JLabel TextoSedeRecogida = new JLabel ("");
    JLabel TextoSedeEntrega = new JLabel("");
   
    JLabel TextoSO1=new JLabel("Wifi Ilimitado");
    JLabel TextoSO2=new JLabel("Asistencia carretera");
    JLabel TextoSO3=new JLabel("GPS");
    JLabel TextoSO4=new JLabel("Asiento niño ");
    JLabel TextoSO5=new JLabel("Seguro");
    JLabel TextoPlaca=new JLabel("Placa Vehículo Seleccionado:");
    JLabel TextoPlacaSeleccionada=new JLabel("No se ha seleccionado el vehículo");
    JLabel TextoClienteSeleccionar = new JLabel("Cliente seleccionado:");
    
    
    
    
    
    
    JLabel TextoTL=new JLabel("No se ha seleccionado Cliente");
    
    JButton botonAtras = new JButton("Atrás");
    JButton botonAgregarOperador = new JButton("Agregar");
 
 
 
    RealizarReserva() {
        
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
 
    }
 
    public void setLayoutManager() {
        container.setLayout(null);
    }
 
    public void setLocationAndSize() {
        TextoNombreCompleto.setBounds(40, 100, 150, 30);
        TextoCédula.setBounds(40, 140, 150, 30);
        TextoDirección.setBounds(40, 180, 150, 30);
        TextoCorreo.setBounds(40, 220, 150, 30);
        TextoFechaEmisionLicencia.setBounds(40, 260, 150, 30);
        TextoPlaca.setBounds(40, 300, 200, 30);
        TextoTipoLicencia.setBounds(40, 340, 150, 30);
        TextoFechaExpiracionLicencia.setBounds(40, 420, 150, 30);
        TextoSedeRecogida.setBounds(370, 100, 150, 30);
        TextoTL.setBounds((325-150/2), 380, 200, 30);
        TextoClienteSeleccionar.setBounds(40, 380, 200, 30);
        
        TextoSedeEntrega.setBounds(370, 140, 150, 30);
        
        TextFieldNombreCompleto.setBounds((325-150/2), 100, 150, 30);
        TextFieldCédula.setBounds((325-150/2), 140, 150, 30);
        TextFieldDirección.setBounds((325-150/2), 180, 150, 30); 
        TextFieldCorreo.setBounds((325-150/2), 220, 150, 30); 
        TextFieldFechaEmisionLicencia.setBounds((325-150/2), 260, 150, 30); 
        TextoPlacaSeleccionada.setBounds((325-150/2), 300, 250, 30);
        
        
        TextFieldTipoLicencia.setBounds((325-150/2), 340, 150, 30); 
        TextFieldFechaExpiracionLicencia.setBounds(370, 420, 20, 30);
        SO2.setBounds(370, 460, 20, 30);
        SO3.setBounds(370, 500, 20, 30);
        SO4.setBounds(370+160, 420, 20, 30);
        SO5.setBounds(370+160, 460, 20, 30);
        
        TextoSO1.setBounds(200, 420, 150, 30);
        TextoSO2.setBounds(200, 460, 150, 30);
        TextoSO3.setBounds(200, 500, 150, 30);
        TextoSO4.setBounds(400, 420, 150, 30);
        TextoSO5.setBounds(400, 460, 150, 30);
        
       botonAgregarOperador.setBounds((325-150/2), 550, 150, 30);
        botonAtras.setBounds(470,30, 150, 30);
        
        
 
 
    }
 
    public void addComponentsToContainer() {
        container.add(botonAgregarOperador);
        container.add(TextoSO1);
        container.add(TextoSO2);
        container.add(TextoSO3);
        container.add(TextoSO4);
        container.add(TextoSO5);
        container.add(TextoNombreCompleto);
        container.add(TextoCédula);
        container.add(TextoDirección);
        container.add(TextoCorreo);
        container.add(TextoFechaEmisionLicencia);
        container.add(TextoTipoLicencia);
        container.add(TextoFechaExpiracionLicencia);
        container.add(TextoSedeRecogida);
        container.add(TextoSedeEntrega);
        container.add(TextFieldNombreCompleto);
        container.add(TextFieldCédula);
        container.add(TextFieldDirección);
        container.add(TextFieldCorreo);
        container.add(TextFieldFechaEmisionLicencia);
        container.add(TextFieldTipoLicencia);
        container.add(TextFieldFechaExpiracionLicencia);
        container.add(SO2);
        container.add(SO3);
        container.add(SO4);
        container.add(SO5);
        container.add(TextoTL);
        
        container.add(botonAtras);
        container.add(TextoPlaca);
         container.add(TextoPlacaSeleccionada);
       container.add(TextoClienteSeleccionar);
    }
 
    public void addActionEvent() {

        botonAtras.addActionListener(this);
        botonAgregarOperador.addActionListener(this);
        TextFieldNombreCompleto.addActionListener(this);
        TextFieldTipoLicencia.addActionListener(this);
        TextFieldCédula.addActionListener(this);
        TextFieldFechaEmisionLicencia.addActionListener(this);
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource()==botonAtras){
            TextFieldNombreCompleto.setSelectedIndex(0);
            TextFieldCédula.setSelectedIndex(0);
            TextFieldDirección.setDate(null);
            TextFieldCorreo.setDate(null);
            
            TextFieldTipoLicencia.setSelectedIndex(0);
            TextFieldFechaExpiracionLicencia.setSelected(false);
            SO2.setSelected(false);
            SO3.setSelected(false);
            SO4.setSelected(false);
            SO5.setSelected(false);
            TextoPlacaSeleccionada.setText("No se ha seleccionado el vehículo");
            TextoTL.setText("No se ha seleccionado Cliente");
            
            
            Login.VentanaMenuPrincipal(true);
            Login.VentanaRealizarReserva(false);
          
        }
        if (e.getSource()==botonAgregarOperador){
            String NombreTemporal;
            
            String cédulaTemporal;
            String direccionTemporal;
            String correoTemporal;
            String telefonoTemporal;
            String numerolicenciaTemporal;
            String fechaemisionlicenciaTemporal;
            String tipolicenciaTemporal;
            String fechaexpiracionlicenciaTemporal;
            
            
            NombreTemporal = TextoSedeRecogida.getText();
            cédulaTemporal = TextoSedeEntrega.getText();
            if(TextFieldDirección.getCalendar()!=null){
               int año = TextFieldDirección.getCalendar().get(Calendar.YEAR);
               int mes = TextFieldDirección.getCalendar().get(Calendar.MONTH) + 1;
               int dia = TextFieldDirección.getCalendar().get(Calendar.DAY_OF_MONTH);
                direccionTemporal=dia+"/"+mes+"/"+año;
            }
            if(TextFieldCorreo.getCalendar()!=null){
               int año = TextFieldCorreo.getCalendar().get(Calendar.YEAR);
               int mes = TextFieldCorreo.getCalendar().get(Calendar.MONTH) + 1;
               int dia = TextFieldCorreo.getCalendar().get(Calendar.DAY_OF_MONTH);
                correoTemporal=dia+"/"+mes+"/"+año;
            }
            
            
            
            tipolicenciaTemporal= TextoTL.getText();
            numerolicenciaTemporal=TextoPlacaSeleccionada.getText();
            
            
            
            if (NombreTemporal.equals("") || cédulaTemporal.equals("") ||TextFieldDirección.getDate()==null ||TextFieldCorreo.getDate()==null ||numerolicenciaTemporal.equals("No se ha seleccionado el vehículo") ||tipolicenciaTemporal.equals("No se ha seleccionado Cliente")) {
            JOptionPane.showMessageDialog(this, "Ingreso inválido o incompleto de elementos");
            
            } else {
            JOptionPane.showMessageDialog(this, "Se ha agregado una nueva Reserva");
            TextFieldNombreCompleto.setSelectedIndex(0);
            TextFieldCédula.setSelectedIndex(0);
            TextFieldDirección.setDate(null);
            TextFieldCorreo.setDate(null);
            
            TextFieldTipoLicencia.setSelectedIndex(0);
            TextFieldFechaExpiracionLicencia.setSelected(false);
            SO2.setSelected(false);
            SO3.setSelected(false);
            SO4.setSelected(false);
            SO5.setSelected(false);
            TextoPlacaSeleccionada.setText("No se ha seleccionado el vehículo");
            TextoTL.setText("No se ha seleccionado Cliente");
            
         
            Login.VentanaMenuPrincipal(true);
            Login.VentanaRealizarReserva(false);    
                
            }

        }
        
        if(e.getSource()==TextFieldTipoLicencia){
            JComboBox cb=(JComboBox)e.getSource();
            TextoTL.setText((String)cb.getSelectedItem());
        }
        if(e.getSource()==TextFieldNombreCompleto){
            JComboBox cb=(JComboBox)e.getSource();
            TextoSedeRecogida.setText((String)cb.getSelectedItem());
        }
        
        if(e.getSource()==TextFieldCédula){
            JComboBox cb=(JComboBox)e.getSource();
            TextoSedeEntrega.setText((String)cb.getSelectedItem());
        }
        if(e.getSource()==TextFieldFechaEmisionLicencia){
            
            TextoPlacaSeleccionada.setText("caca");
        }

        
            
        
       
    }
 
}