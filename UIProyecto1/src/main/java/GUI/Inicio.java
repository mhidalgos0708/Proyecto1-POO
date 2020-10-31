package GUI;


import com.formdev.flatlaf.FlatDarculaLaf;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import Controlador.AdministradorAplicacion;
import Modelo.Operador;
import Modelo.Vehiculo;
import java.util.ArrayList;


public class Inicio {
        
    public static AdministradorAplicacion adminApp = new AdministradorAplicacion();
    static ArrayList<Operador> listaOperadores= Inicio.adminApp.getListaOperadores();
    static ArrayList<Vehiculo> listaVehiculos= Inicio.adminApp.getListaVehiculos();
    static String [] listaSedes = {"", "Zapote", "Cartago", "Heredia", "Uruca"};
    
    static ImageIcon img;
    static LoginFrame frameLogin;
    static MenuPrincipal frameMenuPrincipal;
    static RegistrarOperador frameRegistrarOperador;
    static RegistrarCliente frameRegistrarCliente;
    static RealizarReserva frameRealizarReserva;
    static ConsultarReserva frameConsultarReserva;
    static MenuAdministrador frameMenuAdministrador;
    static AgregarVehiculo frameAgregarVehiculo;
    static AgregarServicio frameAgregarServicio;
    static AgregarEmpresa frameAgregarEmpresa;
    static Reservas frameRes;
    static EditarVehiculo frameEditarVehiculo;
    static SeleccionadoVehículo frameSeleccionadoVehículo;
    static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    public static void center(JFrame J){
        J.setLocation(dim.width/2-J.getSize().width/2, dim.height/2-J.getSize().height/2);
    }
    public static void main(String[] a) {
        
        
        FlatDarculaLaf.install();
        adminApp.cargarInformacionJSON("empresas.json", "Empresa");
        adminApp.cargarInformacionJSON("servicios.json", "Servicio");
        adminApp.cargarInformacionJSON("vehiculos.json", "Vehiculo");
        adminApp.cargarInformacionJSON("operadores.json", "Operador");
        adminApp.cargarInformacionJSON("clientes.json", "Cliente");
        adminApp.cargarInformacionJSON("reservas.json", "Reserva");
        adminApp.inicializarServiciosEspeciales();
        
        img = new ImageIcon( "src\\main\\java\\img\\A.png");
        frameLogin = new LoginFrame();
        frameMenuPrincipal = new MenuPrincipal();
        frameRegistrarOperador = new RegistrarOperador();
        frameRegistrarCliente = new RegistrarCliente();
        frameRealizarReserva = new RealizarReserva();
        frameConsultarReserva = new ConsultarReserva();
        frameMenuAdministrador = new MenuAdministrador();
        frameAgregarVehiculo = new AgregarVehiculo();
        frameAgregarServicio = new AgregarServicio();
        frameAgregarEmpresa = new AgregarEmpresa();
        frameRes = new Reservas();
        frameEditarVehiculo = new EditarVehiculo();
        frameSeleccionadoVehículo = new SeleccionadoVehículo();
        VentanaLogin(true);
        
        
        
    }
    
    public static void VentanaLogin(boolean visibilidad){
        frameLogin.setTitle("Rent a Car - Inicio de Sesión");
        frameLogin.setVisible(visibilidad);
        frameLogin.setBounds(410, 190, 700, 450);
        center(frameLogin);
        frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLogin.setResizable(false);
        frameLogin.setIconImage(img.getImage());
    }
    public static void VentanaMenuPrincipal(boolean visibilidad){
        frameMenuPrincipal.setTitle(" Plataforma Rent a Car");
        frameMenuPrincipal.setVisible(visibilidad);
        frameMenuPrincipal.setBounds(410, 190, 700, 450);
        center(frameMenuPrincipal);
        frameMenuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMenuPrincipal.setResizable(false);
        frameMenuPrincipal.setIconImage(img.getImage());
    }
    public static void VentanaRegistrarOperador(boolean visibilidad){
        frameRegistrarOperador.setTitle("Rent a Car - Registrar Operador");
        frameRegistrarOperador.setVisible(visibilidad);
        frameRegistrarOperador.setBounds(500, 30, 400, 450);
        center(frameRegistrarOperador);
        frameRegistrarOperador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameRegistrarOperador.setResizable(false);
        frameRegistrarOperador.setIconImage(img.getImage());
    }
    
    public static void VentanaRegistrarCliente(boolean visibilidad){
        frameRegistrarCliente.setTitle("Rent a Car - Registrar Cliente");
        frameRegistrarCliente.setVisible(visibilidad);
        frameRegistrarCliente.setBounds(500, 30, 400, 650);
        center(frameRegistrarCliente);
        frameRegistrarCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameRegistrarCliente.setResizable(false);
        frameRegistrarCliente.setIconImage(img.getImage());
    }
    
    public static void VentanaRealizarReserva(boolean visibilidad){
        frameRealizarReserva.setTitle("Rent a Car - Realizar Reserva");
        frameRealizarReserva.setVisible(visibilidad);
        frameRealizarReserva.setBounds(500, 30, 650, 650);
        center(frameRealizarReserva);
        frameRealizarReserva.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameRealizarReserva.setResizable(false);
        frameRealizarReserva.setIconImage(img.getImage());  
    }
    
    public static void VentanaConsultarReserva(boolean visibilidad){
        frameConsultarReserva.setTitle("Rent a Car - Consultar Reserva");
        frameConsultarReserva.setVisible(visibilidad);
        frameConsultarReserva.setBounds(450, 200, 650, 450);
        center(frameConsultarReserva);
        frameConsultarReserva.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameConsultarReserva.setResizable(false);
        frameConsultarReserva.setIconImage(img.getImage());  
    }
    
    public static void VentanaMenuAdministrador(boolean visibilidad){
        frameMenuAdministrador.setTitle("Rent a Car - Menú Administrador");
        frameMenuAdministrador.setVisible(visibilidad);
        frameMenuAdministrador.setBounds(450, 200, 650, 400);
        center(frameMenuAdministrador);
        frameMenuAdministrador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMenuAdministrador.setResizable(false);
        frameMenuAdministrador.setIconImage(img.getImage());  
    }
    
    public static void VentanaAgregarVehiculo(boolean visibilidad){
        frameAgregarVehiculo.setTitle("Rent a Car - Menú Administrador - Agregar Vehículo");
        frameAgregarVehiculo.setVisible(visibilidad);
        frameAgregarVehiculo.setBounds(400, 100, 750, 600);
        center(frameAgregarVehiculo);
        frameAgregarVehiculo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameAgregarVehiculo.setResizable(false);
        frameAgregarVehiculo.setIconImage(img.getImage());  
    }
    
    public static void VentanaAgregarServicio(boolean visibilidad){
        frameAgregarServicio.setTitle("Rent a Car - Menú Administrador - Agregar Servicio");
        frameAgregarServicio.setVisible(visibilidad);
        frameAgregarServicio.setBounds(560, 140, 400, 600);
        center(frameAgregarServicio);
        frameAgregarServicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameAgregarServicio.setResizable(false);
        frameAgregarServicio.setIconImage(img.getImage());  
    }
    
    public static void VentanaAgregarEmpresa(boolean visibilidad){
        frameAgregarEmpresa.setTitle("Rent a Car - Agregar Empresa");
        frameAgregarEmpresa.setVisible(visibilidad);
        frameAgregarEmpresa.setBounds(560, 140, 400, 600);
        center(frameAgregarEmpresa);
        frameAgregarEmpresa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameAgregarEmpresa.setResizable(false);
        frameAgregarEmpresa.setIconImage(img.getImage());  
    }
    
    public static void VentanaReserva(boolean visibilidad){
        
        frameRes.setTitle("Rent a Car - Consultar");
        frameRes.setVisible(visibilidad);
        frameRes.setBounds(500, 50, 600, 700);
        center(frameRes);
        frameRes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameRes.setResizable(true);
        frameRes.setIconImage(img.getImage());
        
    }
    
    public static void VentanaEditarVehiculo(boolean visibilidad){
        frameEditarVehiculo.setTitle("Rent a Car - Menú Administrador - Editar Vehículo");
        frameEditarVehiculo.setVisible(visibilidad);
        frameEditarVehiculo.setBounds(200, 30, 850, 650);
        center(frameEditarVehiculo);
        frameEditarVehiculo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameEditarVehiculo.setResizable(false);
        frameEditarVehiculo.setIconImage(img.getImage());  
    }
    public static void VentanaSeleccionadoVehículo(boolean visibilidad){
        
        frameSeleccionadoVehículo.setTitle("Rent a Car - Seleccionando Vehículo");
        frameSeleccionadoVehículo.setVisible(visibilidad);
        frameSeleccionadoVehículo.setBounds(200, 30, 850, 650);
        center(frameSeleccionadoVehículo);
        frameSeleccionadoVehículo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameSeleccionadoVehículo.setResizable(false);
        frameSeleccionadoVehículo.setIconImage(img.getImage()); 
        
    }

    
 
}