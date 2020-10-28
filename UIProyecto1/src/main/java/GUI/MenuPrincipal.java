package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 

public class MenuPrincipal extends JFrame implements ActionListener {
 
    Container container = getContentPane();
    
    JButton botonReserva = new JButton("Realizar Reserva");
    JButton botonConsultarReserva = new JButton("Consultar Reserva");
    JButton botonAdministracion = new JButton("Administración");
    JButton botonRegistrarCliente = new JButton("Registar Cliente");
    JButton botonRegistrarOperador = new JButton("Registar Operador");
    JButton botonCerrarSesion = new JButton("Salir de la sesión");
    JLabel NombreUsuario = new JLabel("Johan Calvo");
 
 
    MenuPrincipal() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
 
    }
 
    public void setLayoutManager() {
        container.setLayout(null);
    }
 
    public void setLocationAndSize() {
        int k = -5;
        NombreUsuario.setBounds(20, 30, 150, 30);
        botonReserva.setBounds((200-150/2)+k, 100, 150, 30);
        botonConsultarReserva.setBounds((200-150/2)+k, 140, 150, 30);
        botonAdministracion.setBounds((200-150/2)+k, 180, 150, 30);
        botonRegistrarCliente.setBounds((200-150/2)+k, 220, 150, 30);
        botonRegistrarOperador.setBounds((200-150/2)+k,260,150,30);
        botonCerrarSesion.setBounds(220,30, 150, 30);
 
 
    }
 
    public void addComponentsToContainer() {
        container.add(NombreUsuario);
        container.add(botonReserva);
        container.add(botonConsultarReserva);
        container.add(botonAdministracion);
        container.add(botonRegistrarCliente);
        container.add(botonRegistrarOperador);
        container.add(botonCerrarSesion);
    }
 
    public void addActionEvent() {
        botonReserva.addActionListener(this);
        botonConsultarReserva.addActionListener(this);
        botonAdministracion.addActionListener(this);
        botonRegistrarCliente.addActionListener(this);
        botonRegistrarOperador.addActionListener(this);
        botonCerrarSesion.addActionListener(this);
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonReserva) {
            Login.VentanaRealizarReserva(true);
            Login.VentanaMenuPrincipal(false);
        }
        if (e.getSource() == botonConsultarReserva) {
            Login.VentanaConsultarReserva(true);
            Login.VentanaMenuPrincipal(false);
        }
        if (e.getSource() == botonAdministracion) {
            Login.VentanaMenuAdministrador(true);
            Login.VentanaMenuPrincipal(false);
        }
        
        if (e.getSource()==botonRegistrarCliente){
            
            Login.VentanaRegistrarCliente(true);
            Login.VentanaMenuPrincipal(false);
        }
        
        if (e.getSource()==botonRegistrarOperador){
            
            Login.VentanaRegistrarOperador(true);
            Login.VentanaMenuPrincipal(false);
        }
        if (e.getSource()==botonCerrarSesion){
            Login.VentanaLogin(true);
            Login.VentanaMenuPrincipal(false);

        }
        
       //Coding Part of showPassword JCheckBox
    }
 
}