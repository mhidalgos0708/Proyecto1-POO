/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import Controlador.AdministradorAplicacion;
import Controlador.Utilitaria;
import Modelo.Operador;
import Modelo.EmpresaMantenimiento;
import Modelo.TLicencia;
import java.util.Calendar;
import Modelo.Cliente;
import Modelo.TServicio;
import Modelo.Servicio;
import Modelo.TEstado;
import Modelo.TEstilo;
import Modelo.TTransmision;
import java.util.ArrayList;
import Modelo.Vehiculo;
/**
 *
 * @author mhidalgos0708
 */
public class main {
    
    private static AdministradorAplicacion adminApp = new AdministradorAplicacion();
    
    public static void main(String[] args) {
        adminApp.cargarInformacionJSON("operadores.json", "Operador");
        Operador operador1 = adminApp.obtenerOperador("heyhey@gmail.com");
        System.out.println(operador1.toString());
        adminApp.cargarInformacionJSON("empresas.json", "Empresa");
        //adminApp.registrarEmpresaServicios("Taller", "1", "+50687895654", "San José", "Escazú", "San Antonio", "50 metros norte de Mas x menos", false);
        EmpresaMantenimiento empresa1 = adminApp.obtenerEmpresa("1");
        System.out.println(empresa1.toString());
        //adminApp.registrarOperador("juanpa@gmail.com", "hola1234", "Mariana", false, false);
        //adminApp.registrarOperador("heyhey@gmail.com", "hola1234", "Mariana", false, false);
        Calendar fEmision = Calendar.getInstance();
        Calendar fExpiracion = Calendar.getInstance();
        fExpiracion.add(Calendar.DATE, 30);
        adminApp.cargarInformacionJSON("clientes.json", "Cliente");
        Cliente cliente1 = adminApp.obtenerCliente("111");
        System.out.println(cliente1.toString());
        adminApp.registrarCliente("Mariana Hidalgo S", "112", "Escazú", "nanahs0708@gmail.com", "+50684657381", "1", fEmision, TLicencia.C1, fExpiracion, "imagen", false);
        Cliente cliente2 = adminApp.obtenerCliente("112");
        System.out.println(cliente2.toString());
        //adminApp.registrarNuevoServicio(1, fExpiracion, fExpiracion, 100, "Muy bueno", TServicio.Preventivo, empresa1, false);
        adminApp.cargarInformacionJSON("servicios.json", "Servicio");
        Servicio servicio2 = adminApp.obtenerServicio(1);
        System.out.println(servicio2.toString());
        //Cliente cliente1 = adminApp.obtenerCliente("111");
        //System.out.println(cliente1.toString());
        
        //System.out.println(Utilitaria.formatoFecha(cliente1.getFechaEmisionLicencia()));
        //System.out.println(Utilitaria.formatoFecha(cliente1.getFechaExpiracionLicencia()));
        ArrayList<Servicio> listaServiciosRelacionados = new ArrayList<Servicio>();
        listaServiciosRelacionados.add(servicio2);
        //adminApp.registrarVehiculo("12387234", 2020, TEstilo.SUV, "rojo", "bmw", 4, 10, 4, "2", 3, "San José", 1000, 4, TTransmision.Automática, TEstado.Activo, listaServiciosRelacionados, "imagen", false);
        adminApp.cargarInformacionJSON("vehiculos.json", "Vehiculo");
        Vehiculo vehiculo1 = adminApp.obtenerVehiculo("12387234");
        System.out.println(vehiculo1.toString());
    }
}
