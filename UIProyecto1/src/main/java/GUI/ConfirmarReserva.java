/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.Detalles.TextoTL;
import static GUI.RealizarReserva.SO1;
import static GUI.RealizarReserva.SO2;
import static GUI.RealizarReserva.SO3;
import static GUI.RealizarReserva.SO4;
import static GUI.RealizarReserva.SO5;
import static GUI.RealizarReserva.ServiciosOpcionales;
import static GUI.RealizarReserva.TextFieldBuscarCliente;
import static GUI.RealizarReserva.TextFieldFechaFinalizacion;
import static GUI.RealizarReserva.TextFieldFechaInicio;
import static GUI.RealizarReserva.TextFieldSedeEntrega;
import static GUI.RealizarReserva.TextFieldSedeRecogida;
import static GUI.RealizarReserva.TextoPlacaSeleccionada;
import static GUI.RealizarReserva.clienteRelacionado;
import Modelo.Vehiculo;
import com.itextpdf.text.DocumentException;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 * Esta clase hereda de JFrame, despliega los datos de la reserva y permite al usuario confirmarla en una ventana
 * @since 28/10/2020
 * @version 1.0
 * @author Fabricio Delgado Morales, Johan Alonso Calvo Vargas, Mariana Hidalgo Sandoval, Silvia Melissa Rodríguez Fernández
 */

public final class ConfirmarReserva extends JFrame implements ActionListener {
    JScrollPane scroll = new JScrollPane();
    JLabel label = new JLabel();
    Container container = getContentPane();
    
    Vehiculo Auto;
    
    final JFileChooser explorer = new JFileChooser();
    
    JLabel ContenidoTextoRecogida = new JLabel();
    JLabel ContenidoTextoEntrega= new JLabel();
    JLabel ContenidoTextoInicio= new JLabel();
    JLabel ContenidoTextoFinal = new JLabel();
    JLabel ContenidoTextoSolicitud = new JLabel();
    JLabel ContenidoTextoOperador = new JLabel();
    JLabel ContenidoTextoVehiculo = new JLabel();
    JLabel ContenidoTextoCliente = new JLabel();
    JButton ContenidoTextoServicio = new JButton("Ver");  
    JButton DetallesVehiculo = new JButton("Ver");
    JButton DetallesCliente = new JButton("Ver");
    JLabel TextoID = new JLabel("Factura");
    JLabel ContenidoTextoID = new JLabel(); 
    JLabel TextoSedeRecogida = new JLabel("Sede de Recogida");
    JLabel TextoSedeEntrega = new JLabel("Sede de Entrega");
    JLabel TextoInicio = new JLabel("Fecha de Inicio");
    JLabel TextoFinalizacion = new JLabel("Fecha Final");
    JLabel TextoSolicitud = new JLabel("Fecha de Solicitud");
    JLabel TextoOperador = new JLabel("Operador");
    JLabel TextoVehiculo = new JLabel("Vehiculo Seleccionado");
    JLabel TextoCliente = new JLabel("Cliente Relacionado");
    JLabel TextoServicio = new JLabel("Servicios Opcionales");
    

    JButton botonAtras = new JButton("Atrás");
    JButton botonOk = new JButton("Realizar Reserva");
 
    ConfirmarReserva() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }
 
    /**
     *
     */
    public void setLayoutManager() {
        container.setLayout(null);      
    }
 
    /**
     *
     */
    public void setLocationAndSize() {
        int k = 10;
        TextoID.setBounds(40, 50-k, 250, 30);
        TextoSedeRecogida.setBounds(40, 100-k, 150, 30);
        TextoSedeEntrega.setBounds(40, 140-k, 150, 30);
        TextoInicio.setBounds(40, 180-k, 150, 30);
        TextoFinalizacion.setBounds(40, 220-k, 150, 30);
        TextoSolicitud.setBounds(40, 260-k, 150, 30);
        TextoOperador.setBounds(40, 300-k, 150, 30);
        TextoVehiculo.setBounds(40, 340-k, 150, 30);  
        TextoCliente.setBounds(40, 380-k, 150, 30);  
        TextoServicio.setBounds(40, 420-k, 150, 30);
        
        DetallesVehiculo.setBounds(200, 340-k, 150, 30);
        DetallesCliente.setBounds(200, 380-k, 150, 30);
        
        
        ContenidoTextoID.setBounds(200, 50-k, 150, 30);
        ContenidoTextoRecogida.setBounds(200, 100-k, 150, 30);
        ContenidoTextoEntrega.setBounds(200, 140-k, 150, 30);
        ContenidoTextoInicio.setBounds(200, 180-k, 150, 30);
        ContenidoTextoFinal.setBounds(200, 220-k, 150, 30); 
        ContenidoTextoSolicitud.setBounds(200, 260-k, 150, 30); 
        ContenidoTextoOperador.setBounds(200, 300-k, 300, 30);
        ContenidoTextoVehiculo.setBounds(200, 340-k, 300, 30);
        ContenidoTextoCliente.setBounds(200, 380-k, 300, 30);
        ContenidoTextoServicio.setBounds(200, 420-k, 150, 30);
        
        botonOk.setBounds(220, 550-k, 150, 30);
    }
 
    /**
     *
     */
    public void addComponentsToContainer() {
        TextoID.setFont(new java.awt.Font("Dialog", 1, 25));
        ContenidoTextoID.setFont(new java.awt.Font("Dialog", 1, 25));
        container.add(label);
        container.add(TextoID);
        container.add(ContenidoTextoID);
        container.add(botonOk);
        container.add(TextoSedeRecogida);
        container.add(TextoSedeEntrega);
        container.add(TextoInicio);
        container.add(TextoFinalizacion);
        container.add(TextoSolicitud);
        container.add(TextoOperador);
        container.add(TextoVehiculo);
        container.add(TextoCliente);  
        container.add(TextoServicio);  
        
        container.add(ContenidoTextoRecogida);
        container.add(ContenidoTextoFinal);
        container.add(ContenidoTextoSolicitud);
        container.add(DetallesVehiculo);
        container.add(ContenidoTextoOperador);
        container.add(ContenidoTextoEntrega);
        container.add(ContenidoTextoInicio);
        container.add(botonAtras);
        container.add(DetallesCliente);
        container.add(ContenidoTextoServicio);
        
    }
 
    /**
     *
     */
    public void addActionEvent() {
        botonAtras.addActionListener(this);
        botonOk.addActionListener(this);   
        DetallesVehiculo.addActionListener(this);  
        DetallesCliente.addActionListener(this);  
        ContenidoTextoServicio.addActionListener(this);
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource()==DetallesVehiculo){       
            Inicio.VentanaDetallesVehículo(true);
        }
        
        if (e.getSource()==DetallesCliente){   
            DatosCliente.frameDatosCliente.setVisible(true);
        }
        
        if (e.getSource()==botonOk){
            if(TextFieldFechaInicio.getCalendar()!=null){
               int año = TextFieldFechaInicio.getCalendar().get(Calendar.YEAR);
               int mes = TextFieldFechaInicio.getCalendar().get(Calendar.MONTH) + 1;
               int dia = TextFieldFechaInicio.getCalendar().get(Calendar.DAY_OF_MONTH);
                String direccionTemporal=dia+"/"+mes+"/"+año;
            }
            if(TextFieldFechaFinalizacion.getCalendar()!=null){
               int año = TextFieldFechaFinalizacion.getCalendar().get(Calendar.YEAR);
               int mes = TextFieldFechaFinalizacion.getCalendar().get(Calendar.MONTH) + 1;
               int dia = TextFieldFechaFinalizacion.getCalendar().get(Calendar.DAY_OF_MONTH);
                String correoTemporal=dia+"/"+mes+"/"+año;
            }
       

            
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
            
            try {
                String archivo = Inicio.adminApp.crearPDF(Inicio.adminApp.obtenerReserva(Inicio.listaReservas.size()-1));
                Controlador.EnviarEmail.enviarCorreo("pruebaproyecto1poo@gmail.com", "ReservaPrueba", "Buenas", archivo);
            } catch (DocumentException ex) {
                Logger.getLogger(ConfirmarReserva.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ConfirmarReserva.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            Inicio.VentanaConfirmarReserva(false);
                
            
          
        }
        if(e.getSource()==ContenidoTextoServicio){
            TablaServiciosReserva.frameTablaServiciosPorReserva.setVisible(true);
        }
    }
}
