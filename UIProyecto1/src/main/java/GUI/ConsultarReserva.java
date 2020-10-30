package GUI;

/**
 *
 * @author fabri
 */

import static GUI.Inicio.frameAgregarEmpresa;
import static GUI.Inicio.img;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
 

public final class ConsultarReserva extends JFrame implements ActionListener {
    String[] Operadores = {"", "Operador1", "Operador2"};
    String [] SedesTotales = {"","Zapote","Cartago"};
    Container container = getContentPane();
    
    final JFrame frame = new JFrame();
        
    
    JButton TextFieldRecogida = new JButton("Ir a filtro");
    JButton TextFieldVehiculo = new JButton("Ir a filtro");
    JTextField TextFieldIDReserva = new JTextField();
    
    JButton TextFieldInicioReserva= new JButton("Ir a filtro");
    JButton TextFieldOperadores = new JButton("Ir a filtro");
    
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
        TextFieldInicioReserva.addActionListener(this);

    }
    
 
    @Override
    public void actionPerformed(ActionEvent e) {
        
            
            
        
        //Coding Part of LOGIN button
        if (e.getSource()==botonAtras){
           
            

            TextoOperadorSeleccionado.setText("No se ha seleccionado Cliente");

            Inicio.VentanaMenuPrincipal(true);
            Inicio.VentanaConsultarReserva(false);
         
        }
        if(e.getSource()==TextFieldOperadores){
            FiltroOperador.frameRegistrarOperador.setVisible(true);
        }
        if(e.getSource()==TextFieldRecogida){
            FiltroPuntoRecogida.frameRegistrarOperador.setVisible(true);
        }
        if(e.getSource()==TextFieldVehiculo){
            FiltroPlaca.frameRegistrarOperador.setVisible(true);
        }
        if(e.getSource()==TextFieldInicioReserva){
            FiltroFecha.frameRegistrarOperador.setVisible(true);
        }
        
        if (e.getSource()==botonConsultarReserva){
            
            
            
            
            
            System.out.println(TextFieldIDReserva.getText());
            
            String textoID =TextFieldIDReserva.getText(); 
            String textoDeSedeRecogida;
            textoDeSedeRecogida = TextoSedeRecogida.getText();
            
            String textoDePlaca;
            textoDePlaca = TextFieldVehiculo.getText();
            
            String textoDeOperador;
            textoDeOperador = TextoOperadorSeleccionado.getText();
            
            
            String textoDeFechaDeRecogida;
            
            

            if (textoID.equals("")) {
            JOptionPane.showMessageDialog(this, "Ingreso inválido o incompleto de elementos");
            
            } else {
            Inicio.frameRes.ContenidoTextoID.setText(TextFieldIDReserva.getText());
            Inicio.VentanaReserva(true);
            Inicio.VentanaConsultarReserva(false);   
                
            } 
        }
        
        
        
    }
 
}