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
import Modelo.Reserva;
import Modelo.TServicio;
import Modelo.Servicio;
import Modelo.TEstado;
import Modelo.TEstilo;
import Modelo.TTransmision;
import java.util.ArrayList;
import Modelo.Vehiculo;
import java.util.HashMap;
import Controlador.EnviarEmail;
import Controlador.TipoCambioBCCR;
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
        
        //adminApp.registrarEmpresaServicios("Taller", "1", "+50687895654", "San José", "Escazú", "San Antonio", "50 metros norte de Mas x menos", false);
        EmpresaMantenimiento empresa1 = adminApp.obtenerEmpresa("1");
        
        Calendar fEmision = Calendar.getInstance();
        Calendar fExpiracion = Calendar.getInstance();
        fExpiracion.add(Calendar.DATE, 30);
        
        //adminApp.registrarNuevoServicio(1, fExpiracion, fExpiracion, 100, "Muy bueno", TServicio.Preventivo, empresa1, false);
        //adminApp.registrarNuevoServicio(2, fExpiracion, fExpiracion, 100, "Muy bueno", TServicio.Preventivo, empresa1, false);
        Servicio servicio2 = adminApp.obtenerServicio(1);
        Servicio servicio3 = adminApp.obtenerServicio(2);
        
        ArrayList<Servicio> listaServiciosRelacionados = new ArrayList<>();
        listaServiciosRelacionados.add(servicio2);
        listaServiciosRelacionados.add(servicio3);
        
        //adminApp.registrarVehiculo("6128374", 2020, TEstilo.SUV, "rojo", "bmw", 4, 10.0, 4, "2", 3.0, "San José", 1000, 4, TTransmision.Automática, TEstado.Activo, listaServiciosRelacionados, "imagen", false);
        
        HashMap diccionario = new HashMap();
        diccionario.put("Año fabricación", Integer.toString(1990));
        diccionario.put("Estilo", String.valueOf(TEstilo.MiniVan));
        diccionario.put("Sede", "Cartago");
        diccionario.put("Color", "Blanco");
        diccionario.put("Imagen", "Foto");
        
        HashMap diccionario2 = new HashMap();
        diccionario2.put("Año fabricación", Integer.toString(1970));
        diccionario2.put("Estilo", String.valueOf(TEstilo.Económico));
        diccionario2.put("Sede", "Heredia");
        diccionario2.put("Color", "Azul");
        diccionario2.put("Imagen", "Fotografía");
        
        System.out.println((adminApp.obtenerVehiculo("28642891")).toString());
        
        if(adminApp.editarVehiculoJSON("28642891", diccionario)) {
            System.out.println((adminApp.obtenerVehiculo("28642891")).toString());
        }
        
        System.out.println((adminApp.obtenerVehiculo("6128374")).toString());
        
        if(adminApp.editarVehiculoJSON("6128374", diccionario2)) {
            System.out.println((adminApp.obtenerVehiculo("6128374")).toString());
        }
        
        //EnviarEmail.enviarCorreo(correo, asunto, texto, direccion);
        
        TipoCambioBCCR servicioTipoCambio = new TipoCambioBCCR();
        //Obtiene el valor double del precio de compra USD
        System.out.println("Compra: " + servicioTipoCambio.getCompra());
        //Obtiene el valor double del precio de venta USD
        System.out.println("Venta: " + servicioTipoCambio.getVenta());
        
    }
}
