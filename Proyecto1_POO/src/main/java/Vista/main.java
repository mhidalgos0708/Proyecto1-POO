/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import Controlador.AdministradorAplicacion;
import java.util.HashMap;
import java.util.Calendar;
import Modelo.TEstilo;
import Modelo.TLicencia;
import Modelo.TServicio;
import Modelo.EmpresaMantenimiento;
import Modelo.TEstado;
import Modelo.TTransmision;
import java.util.ArrayList;
import Modelo.Servicio;
import Modelo.Vehiculo;
/**
 *
 * @author mhidalgos0708
 */
public class main {
    
    private static AdministradorAplicacion adminApp = new AdministradorAplicacion();
    

    public static void main(String[] args) {
        
        adminApp.cargarInformacionJSON("empresas.json", "Empresa");
        adminApp.cargarInformacionJSON("servicios.json", "Servicio");
        adminApp.cargarInformacionJSON("vehiculos.json", "Vehiculo");
        adminApp.cargarInformacionJSON("operadores.json", "Operador");
        adminApp.cargarInformacionJSON("clientes.json", "Cliente");
        adminApp.cargarInformacionJSON("reservas.json", "Reserva");
        adminApp.inicializarServiciosEspeciales();
        
        Calendar fechaActual = Calendar.getInstance();
        
        EmpresaMantenimiento empresaActual = adminApp.obtenerEmpresa("25");
        
        System.out.println(adminApp.obtenerCliente("10"));
        System.out.println(adminApp.obtenerEmpresa("25"));
        System.out.println(adminApp.obtenerServicio(12));
        System.out.println(adminApp.obtenerServicio(13));
        
        ArrayList<Servicio> listaServicios = new ArrayList<>();
        listaServicios.add(adminApp.obtenerServicio(12));
        
        //adminApp.registrarVehiculo("1234567", 2010, TEstilo.SUV, "Plateado", "BMW", 5, 110.87, 4, "1209", 20, "San José", 12000.0, 6, TTransmision.Automática, TEstado.Activo, listaServicios, "Imagen", false);
        
        ArrayList<String> nombresServicios = new ArrayList<>();
        nombresServicios.add("Asistencia en carretera");
        HashMap<String, Double> serviciosOp = adminApp.generarServiciosEspeciales(nombresServicios);
        
        //adminApp.realizarReserva("Guanacaste", "Guanacaste", fechaActual, fechaActual, fechaActual, adminApp.obtenerOperador("mhidalgos0708@gmail.com"), adminApp.obtenerVehiculo("1234567"), adminApp.obtenerCliente("10"), serviciosOp, false);
        
        //adminApp.agregarServicioAVehiculo("1234567", adminApp.obtenerServicio(13));
        
        System.out.println(adminApp.obtenerReserva(0));
        System.out.println(adminApp.obtenerReserva(1));
        System.out.println(adminApp.obtenerReserva(2));
        
    }
}
