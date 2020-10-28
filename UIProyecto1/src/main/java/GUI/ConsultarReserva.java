package GUI;

/**
 *
 * @author fabri
 */

import static GUI.Login.frameAgregarEmpresa;
import static GUI.Login.img;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.HashSet;
import javax.swing.JFrame;
 

public final class ConsultarReserva extends JFrame implements ActionListener {
    String[] Operadores = {"", "Operador1", "Operador2"};
    String [] SedesTotales = {"","Zapote","Cartago"};
    Container container = getContentPane();
    
    final JFrame frame = new JFrame();
        
    
    JComboBox<String> TextFieldRecogida = new JComboBox<>(SedesTotales);
    JTextField TextFieldVehiculo = new JTextField();
    JTextField TextFieldIDReserva = new JTextField();
    
    com.toedter.calendar.JDateChooser TextFieldInicioReserva= new com.toedter.calendar.JDateChooser();
    JComboBox<String> TextFieldOperadores = new JComboBox<>(Operadores);
    
    JLabel TextoFiltro = new JLabel("Filtro:");
    JLabel TextoPuntoRecogida = new JLabel("Punto de recogida del vehículo");
    JLabel TextoPlacaVehiculo = new JLabel("Placa del vehículo");
    JLabel TextoInicioReserva = new JLabel("Fecha de inicio de la reserva");
    JLabel TextoOperadorRealizador = new JLabel("Operador que realizó la reserva");
    JLabel TextoIDReserva = new JLabel("ID de reserva");
    
    JLabel TextoSedeRecogida = new JLabel ("");
    JLabel TextoOperadorSeleccionado=new JLabel("");
    
    JButton botonAtras = new JButton("Atrás");
    JButton botonConsultarReserva = new JButton("Consultar");
 
 
 
    ConsultarReserva() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }
 
    public void setLayoutManager() {
        container.setLayout(null);
    }
 
    public void setLocationAndSize() {
        int k = 90;
        int t = 50;
        
        TextoFiltro.setBounds(40+k, 20+t, 200, 30);
        TextoIDReserva.setBounds(40+k, 60+t, 200, 30);
        TextoPuntoRecogida.setBounds(40+k, 100+t, 200, 30);
        TextoPlacaVehiculo.setBounds(40+k, 140+t, 200, 30);
        TextoInicioReserva.setBounds(40+k, 180+t, 200, 30);
        TextoOperadorRealizador.setBounds(40+k, 220+t, 200, 30);
        
        TextFieldIDReserva.setBounds((325-150/2)+k, 60+t, 150, 30);
        TextFieldRecogida.setBounds((325-150/2)+k, 100+t, 150, 30);
        TextFieldVehiculo.setBounds((325-150/2)+k, 140+t, 150, 30);
        TextFieldInicioReserva.setBounds((325-150/2)+k, 180+t, 150, 30); 
        TextFieldOperadores.setBounds((325-150/2)+k, 220+t, 150, 30); 
        
        botonConsultarReserva.setBounds((325-150/2), 350, 150, 30);
        botonAtras.setBounds((325-150/2)+k, 30, 150, 30);
    }
 
    public void addComponentsToContainer() {
        container.add(TextoFiltro);
        container.add(TextoIDReserva);
        container.add(TextFieldIDReserva);
        container.add(botonConsultarReserva);
        container.add(TextoPuntoRecogida);
        container.add(TextoPlacaVehiculo);
        container.add(TextoInicioReserva);
        container.add(TextoOperadorRealizador);
        container.add(TextoSedeRecogida);
        container.add(TextFieldRecogida);
        container.add(TextFieldVehiculo);
        container.add(TextFieldInicioReserva);
        container.add(TextFieldOperadores);
        container.add(TextoOperadorSeleccionado);
        
        container.add(botonAtras);

    }
    
 
    public void addActionEvent() {

        botonAtras.addActionListener(this);
        botonConsultarReserva.addActionListener(this);
        TextFieldRecogida.addActionListener(this);
        TextFieldOperadores.addActionListener(this);
        TextFieldVehiculo.addActionListener(this);
        TextFieldIDReserva.addActionListener(this);

    }
    
 
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(TextFieldIDReserva.getText());
            if (!"".equals(TextFieldIDReserva.getText())){
                TextFieldVehiculo.setEnabled(false);
                TextFieldRecogida.setEnabled(false);
                TextFieldOperadores.setEnabled(false);
                TextFieldVehiculo.setEnabled(false);
                TextFieldInicioReserva.setEnabled(false);
            }else{
                TextFieldVehiculo.setEnabled(true);
                TextFieldRecogida.setEnabled(true);
                TextFieldOperadores.setEnabled(true);
                TextFieldVehiculo.setEnabled(true);
                TextFieldInicioReserva.setEnabled(true);
            }
        
        //Coding Part of LOGIN button
        if (e.getSource()==botonAtras){
            TextFieldRecogida.setSelectedIndex(0);
            TextFieldInicioReserva.setDate(null);

            TextFieldOperadores.setSelectedIndex(0);
            TextoOperadorSeleccionado.setText("No se ha seleccionado Cliente");

            Login.VentanaMenuPrincipal(true);
            Login.VentanaConsultarReserva(false);
          
        }
        if (e.getSource()==botonConsultarReserva){
            
            
            
            
            
            System.out.println(TextFieldIDReserva.getText());
            
            String textoDeSedeRecogida;
            textoDeSedeRecogida = TextoSedeRecogida.getText();
            
            String textoDePlaca;
            textoDePlaca = TextFieldVehiculo.getText();
            
            String textoDeOperador;
            textoDeOperador = TextoOperadorSeleccionado.getText();
            
            
            String textoDeFechaDeRecogida;
            
            if(TextFieldInicioReserva.getCalendar()!=null){
               int año = TextFieldInicioReserva.getCalendar().get(Calendar.YEAR);
               int mes = TextFieldInicioReserva.getCalendar().get(Calendar.MONTH) + 1;
               int dia = TextFieldInicioReserva.getCalendar().get(Calendar.DAY_OF_MONTH);
                textoDeFechaDeRecogida=dia+"/"+mes+"/"+año;
            }

            if (TextFieldVehiculo.getText().equals("") && TextFieldIDReserva.getText().equals("") && TextFieldInicioReserva.getDate()==null && TextFieldRecogida.getSelectedItem().equals("") && TextFieldOperadores.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(this, "Ingreso inválido o incompleto de elementos");
            
            } else {
            Login.frameRes.ContenidoTextoID.setText(TextFieldIDReserva.getText());
            Login.VentanaReserva(true);
            Login.VentanaConsultarReserva(false);   
                
            }
        }
        
        if(e.getSource()==TextFieldOperadores){
            JComboBox cb=(JComboBox)e.getSource();
            TextoOperadorSeleccionado.setText((String)cb.getSelectedItem());
        }
        if(e.getSource()==TextFieldRecogida){
            JComboBox cb=(JComboBox)e.getSource();
            TextoSedeRecogida.setText((String)cb.getSelectedItem());
        }
        
    }
 
}