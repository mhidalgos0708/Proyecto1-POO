package GUI;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
public class Login {
        static ImageIcon img = new ImageIcon("C:\\Users\\fabri\\Desktop\\A.png");
        static LoginFrame frameLogin = new LoginFrame();
        static MenuPrincipal frameMenuPrincipal = new MenuPrincipal();
        static RegistrarOperador frameRegistrarOperador = new RegistrarOperador();
        static RegistrarCliente frameRegistrarCliente = new RegistrarCliente();
        static RealizarReserva frameRealizarReserva = new RealizarReserva();
        static ConsultarReserva frameConsultarReserva = new ConsultarReserva();
        static MenuAdministrador frameMenuAdministrador = new MenuAdministrador();
        static AgregarVehiculo frameAgregarVehiculo = new AgregarVehiculo();
        static AgregarServicio frameAgregarServicio = new AgregarServicio();
        static AgregarEmpresa frameAgregarEmpresa = new AgregarEmpresa();
        static Reservas frameRes = new Reservas();
        static EditarVehiculo frameEditarVehiculo = new EditarVehiculo();
        
    public static void main(String[] a) {
        VentanaMenuAdministrador(true);
        
    }
    
    public static void VentanaLogin(boolean visibilidad){
        frameLogin.setTitle("Rent a Car - Inicio de Sesión");
        frameLogin.setVisible(visibilidad);
        frameLogin.setBounds(500, 30, 400, 450);
        frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLogin.setResizable(false);
        frameLogin.setIconImage(img.getImage());
    }
    public static void VentanaMenuPrincipal(boolean visibilidad){
        frameMenuPrincipal.setTitle("Rent a Car - Menú Principal");
        frameMenuPrincipal.setVisible(visibilidad);
        frameMenuPrincipal.setBounds(550, 220, 400, 450);
        frameMenuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMenuPrincipal.setResizable(false);
        frameMenuPrincipal.setIconImage(img.getImage());
    }
    public static void VentanaRegistrarOperador(boolean visibilidad){
        frameRegistrarOperador.setTitle("Rent a Car - Registrar Operador");
        frameRegistrarOperador.setVisible(visibilidad);
        frameRegistrarOperador.setBounds(500, 30, 400, 450);
        frameRegistrarOperador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameRegistrarOperador.setResizable(false);
        frameRegistrarOperador.setIconImage(img.getImage());
    }
    
    public static void VentanaRegistrarCliente(boolean visibilidad){
        frameRegistrarCliente.setTitle("Rent a Car - Registrar Cliente");
        frameRegistrarCliente.setVisible(visibilidad);
        frameRegistrarCliente.setBounds(500, 30, 400, 650);
        frameRegistrarCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameRegistrarCliente.setResizable(false);
        frameRegistrarCliente.setIconImage(img.getImage());
    }
    
    public static void VentanaRealizarReserva(boolean visibilidad){
        frameRealizarReserva.setTitle("Rent a Car - Realizar Reserva");
        frameRealizarReserva.setVisible(visibilidad);
        frameRealizarReserva.setBounds(500, 30, 650, 650);
        frameRealizarReserva.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameRealizarReserva.setResizable(false);
        frameRealizarReserva.setIconImage(img.getImage());  
    }
    
    public static void VentanaConsultarReserva(boolean visibilidad){
        frameConsultarReserva.setTitle("Rent a Car - Consultar Reserva");
        frameConsultarReserva.setVisible(visibilidad);
        frameConsultarReserva.setBounds(450, 200, 650, 450);
        frameConsultarReserva.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameConsultarReserva.setResizable(false);
        frameConsultarReserva.setIconImage(img.getImage());  
    }
    
    public static void VentanaMenuAdministrador(boolean visibilidad){
        frameMenuAdministrador.setTitle("Rent a Car - Menú Administrador");
        frameMenuAdministrador.setVisible(visibilidad);
        frameMenuAdministrador.setBounds(450, 200, 650, 400);
        frameMenuAdministrador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMenuAdministrador.setResizable(false);
        frameMenuAdministrador.setIconImage(img.getImage());  
    }
    
    public static void VentanaAgregarVehiculo(boolean visibilidad){
        frameAgregarVehiculo.setTitle("Rent a Car - Menú Administrador - Agregar Vehículo");
        frameAgregarVehiculo.setVisible(visibilidad);
        frameAgregarVehiculo.setBounds(400, 100, 750, 600);
        frameAgregarVehiculo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameAgregarVehiculo.setResizable(false);
        frameAgregarVehiculo.setIconImage(img.getImage());  
    }
    
    public static void VentanaAgregarServicio(boolean visibilidad){
        frameAgregarServicio.setTitle("Rent a Car - Menú Administrador - Agregar Servicio");
        frameAgregarServicio.setVisible(visibilidad);
        frameAgregarServicio.setBounds(560, 140, 400, 600);
        frameAgregarServicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameAgregarServicio.setResizable(false);
        frameAgregarServicio.setIconImage(img.getImage());  
    }
    
    public static void VentanaAgregarEmpresa(boolean visibilidad){
        frameAgregarEmpresa.setTitle("Rent a Car - Agregar Empresa");
        frameAgregarEmpresa.setVisible(visibilidad);
        frameAgregarEmpresa.setBounds(560, 140, 400, 600);
        frameAgregarEmpresa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameAgregarEmpresa.setResizable(false);
        frameAgregarEmpresa.setIconImage(img.getImage());  
    }
    
    public static void VentanaReserva(boolean visibilidad){
        
        frameRes.setTitle("Rent a Car - Consultar");
        frameRes.setVisible(visibilidad);
        frameRes.setBounds(500, 50, 600, 700);
        frameRes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameRes.setResizable(true);
        frameRes.setIconImage(img.getImage());
        
    }
    
    public static void VentanaEditarVehiculo(boolean visibilidad){
        frameEditarVehiculo.setTitle("Rent a Car - Menú Administrador - Editar Vehículo");
        frameEditarVehiculo.setVisible(visibilidad);
        frameEditarVehiculo.setBounds(200, 30, 850, 650);
        frameEditarVehiculo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameEditarVehiculo.setResizable(false);
        frameEditarVehiculo.setIconImage(img.getImage());  
    }

    
 
}