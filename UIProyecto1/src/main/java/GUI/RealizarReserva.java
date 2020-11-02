package GUI;

import Modelo.Cliente;
import Modelo.TEstilo;
import Modelo.Vehiculo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
 

public final class RealizarReserva extends JFrame implements ActionListener {
    Cliente clienteRelacionado;
    
    Container container = getContentPane();
    
    ArrayList<String> ServiciosOpcionales = new ArrayList<String>();
        
    static Vehiculo AutoSeleccionado;
    
    Cliente [] ListaClientes = {};
    
    static public JComboBox<String> TextFieldSedeRecogida = new JComboBox<>(Inicio.listaSedes);
    JComboBox<String> TextFieldSedeEntrega = new JComboBox<>(Inicio.listaSedes);
    static public com.toedter.calendar.JDateChooser TextFieldFechaInicio= new com.toedter.calendar.JDateChooser();
    static public com.toedter.calendar.JDateChooser TextFieldFechaFinalizacion= new com.toedter.calendar.JDateChooser();
    JTextField TextFieldBuscarCliente = new JTextField();
    
    JButton botonSeleccionarvehiculo= new JButton("Seleccionar");
    
    JCheckBox SO1= new JCheckBox();
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
    JButton botonBuscarCliente = new JButton("Buscar");
 
 
 
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
        int k= 40;
        TextoNombreCompleto.setBounds(40, 100+k, 150, 30);
        TextoCédula.setBounds(40, 140+k, 150, 30);
        TextoDirección.setBounds(40, 180+k, 150, 30);
        TextoCorreo.setBounds(40, 220+k, 150, 30);
        TextoFechaEmisionLicencia.setBounds(40, 260+k, 150, 30);
        TextoPlaca.setBounds(40, 300+k, 200, 30);
        
        TextoFechaExpiracionLicencia.setBounds(40, 420+k, 150, 30);
        TextoSedeRecogida.setBounds(370, 100, 150, 30);

        
        TextoTipoLicencia.setBounds(40, 100, 150, 30);
        
        TextoSedeEntrega.setBounds(370, 140+k, 150, 30);
        
        TextFieldSedeRecogida.setBounds((325-150/2), 100+k, 150, 30);
        TextFieldSedeEntrega.setBounds((325-150/2), 140+k, 150, 30);
        TextFieldFechaInicio.setBounds((325-150/2), 180+k, 150, 30); 
        TextFieldFechaFinalizacion.setBounds((325-150/2), 220+k, 150, 30); 
        botonSeleccionarvehiculo.setBounds((325-150/2), 260+k, 150, 30); 
        TextoPlacaSeleccionada.setBounds((325-150/2), 300+k, 250, 30);
        
        
        TextFieldBuscarCliente.setBounds((325-150/2), 100, 150, 30); 
        botonBuscarCliente.setBounds((325-150/2)+170, 100, 100, 30); 
        SO1.setBounds(370, 420, 20, 30);
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
        container.add(botonBuscarCliente);
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
        container.add(TextFieldSedeRecogida);
        container.add(TextFieldSedeEntrega);
        container.add(TextFieldFechaInicio);
        container.add(TextFieldFechaFinalizacion);
        container.add(botonSeleccionarvehiculo);
        container.add(TextFieldBuscarCliente);
        container.add(SO1);
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
        botonBuscarCliente.addActionListener(this);
        botonAtras.addActionListener(this);
        botonAgregarOperador.addActionListener(this);
        TextFieldSedeRecogida.addActionListener(this);
        TextFieldBuscarCliente.addActionListener(this);
        TextFieldSedeEntrega.addActionListener(this);
        botonSeleccionarvehiculo.addActionListener(this);
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource()==botonBuscarCliente){
            if (!"".equals(TextFieldBuscarCliente.getText())) {
                if (Inicio.adminApp.obtenerCliente(TextFieldBuscarCliente.getText())!=null) {
                    clienteRelacionado = Inicio.adminApp.obtenerCliente(TextFieldBuscarCliente.getText());
                    System.out.println(clienteRelacionado);
                }else{
                    JOptionPane.showMessageDialog(this, "No se encontró el cliente solicitado");
                }
                
            }else{
                JOptionPane.showMessageDialog(this, "Ingrese una identificación para buscar un cliente");
            }
            
          
        }
        if (e.getSource()==botonAtras){
            TextFieldSedeRecogida.setSelectedIndex(0);
            TextFieldSedeEntrega.setSelectedIndex(0);
            TextFieldFechaInicio.setDate(null);
            TextFieldFechaFinalizacion.setDate(null);
            
            TextFieldBuscarCliente.setText("");
            SO1.setSelected(false);
            SO2.setSelected(false);
            SO3.setSelected(false);
            SO4.setSelected(false);
            SO5.setSelected(false);
            TextoPlacaSeleccionada.setText("No se ha seleccionado el vehículo");
            TextoTL.setText("No se ha seleccionado Cliente");
            
            
            Inicio.VentanaMenuPrincipal(true);
            Inicio.VentanaRealizarReserva(false);
          
        }
        if (e.getSource()==botonAgregarOperador){

            String direccionTemporal;
            String correoTemporal;

            
            
            
            if(TextFieldFechaInicio.getCalendar()!=null){
               int año = TextFieldFechaInicio.getCalendar().get(Calendar.YEAR);
               int mes = TextFieldFechaInicio.getCalendar().get(Calendar.MONTH) + 1;
               int dia = TextFieldFechaInicio.getCalendar().get(Calendar.DAY_OF_MONTH);
                direccionTemporal=dia+"/"+mes+"/"+año;
            }
            if(TextFieldFechaFinalizacion.getCalendar()!=null){
               int año = TextFieldFechaFinalizacion.getCalendar().get(Calendar.YEAR);
               int mes = TextFieldFechaFinalizacion.getCalendar().get(Calendar.MONTH) + 1;
               int dia = TextFieldFechaFinalizacion.getCalendar().get(Calendar.DAY_OF_MONTH);
                correoTemporal=dia+"/"+mes+"/"+año;
            }
       

            if (TextoPlacaSeleccionada.getText().equals("No se ha seleccionado el vehículo") || TextFieldSedeRecogida.getSelectedItem().equals(null) || TextFieldSedeEntrega.getSelectedItem().equals(null) ||TextFieldFechaInicio.getDate()==null ||TextFieldFechaFinalizacion.getDate()==null || TextFieldBuscarCliente.getText().equals("") || clienteRelacionado == null ||TextoTL.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Ingreso inválido o incompleto de elementos");
            
            } else if (TextFieldFechaInicio.getDate()==null || TextFieldFechaFinalizacion.getDate()==null){
                JOptionPane.showMessageDialog(this, "Ingrese fechas de inicio y finalización");
                
            }else if (TextFieldFechaInicio.getCalendar().compareTo(TextFieldFechaFinalizacion.getCalendar())==1){
                JOptionPane.showMessageDialog(this, "La fecha de inicio debe ser anterior o igual a la de finalización");
            
            }else {
                if(SO1.isSelected()){
                    ServiciosOpcionales.add("WiFi limitado");
                }if(SO2.isSelected()){
                    ServiciosOpcionales.add("Asistencia en carretera");
                }if(SO3.isSelected()){
                    ServiciosOpcionales.add("GPS");
                }if(SO4.isSelected()){
                    ServiciosOpcionales.add("Asiento para niño");
                }if (SO5.isSelected()){
                    ServiciosOpcionales.add("Cobertura por daños a terceros");
                }
                
                HashMap diccionario = Inicio.adminApp.generarServiciosEspeciales(ServiciosOpcionales);
                
                Inicio.adminApp.realizarReserva((String) TextFieldSedeRecogida.getSelectedItem(), (String) TextFieldSedeEntrega.getSelectedItem(), TextFieldFechaInicio.getCalendar(), TextFieldFechaFinalizacion.getCalendar(), Calendar.getInstance(), Inicio.adminApp.getOperadorActivo(), Inicio.adminApp.obtenerVehiculo(TextoPlacaSeleccionada.getText()), clienteRelacionado, diccionario, false);

                JOptionPane.showMessageDialog(this, "Se ha agregado una nueva Reserva");
                TextFieldSedeRecogida.setSelectedIndex(0);
                TextFieldSedeEntrega.setSelectedIndex(0);
                TextFieldFechaInicio.setDate(null);
                TextFieldFechaFinalizacion.setDate(null);

                TextFieldBuscarCliente.setText("");

                SO1.setSelected(false);
                SO2.setSelected(false);
                SO3.setSelected(false);
                SO4.setSelected(false);
                SO5.setSelected(false);

                TextoPlacaSeleccionada.setText("No se ha seleccionado el vehículo");
                TextoTL.setText("No se ha seleccionado Cliente");

                Inicio.VentanaMenuPrincipal(true);
                Inicio.VentanaRealizarReserva(false);    
                
            }

        }
        
        if(e.getSource()==TextFieldSedeRecogida){
            JComboBox cb=(JComboBox)e.getSource();
            TextoSedeRecogida.setVisible(false);
            TextoSedeRecogida.setText((String)cb.getSelectedItem());
        }
        
        if(e.getSource()==TextFieldSedeEntrega){
            JComboBox cb=(JComboBox)e.getSource();
            TextoSedeEntrega.setVisible(false);
            TextoSedeEntrega.setText((String)cb.getSelectedItem());
        }
        if(e.getSource()==botonSeleccionarvehiculo){
            if (TextFieldFechaInicio.getDate()==null || TextFieldFechaFinalizacion.getDate()==null){
                JOptionPane.showMessageDialog(this, "Ingrese fechas de inicio y finalización para seleccionar un vehículo");
            }else if (TextFieldFechaInicio.getCalendar().compareTo(TextFieldFechaFinalizacion.getCalendar())==1){
                JOptionPane.showMessageDialog(this, "La fecha de inicio debe ser anterior o igual a la de finalización");
            }else{
                Inicio.VentanaSeleccionadoVehículo(true);
                Inicio.frameRealizarReserva.setEnabled(false);
                
            }
        }

        
            
        
       
    }
 
}