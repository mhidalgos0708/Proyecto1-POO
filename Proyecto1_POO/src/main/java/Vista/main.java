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
/**
 *
 * @author mhidalgos0708
 */
public class main {
    
    private static AdministradorAplicacion adminApp = new AdministradorAplicacion();
    
    public static void main(String[] args) {
        adminApp.inicializarServiciosEspeciales();
        adminApp.cargarInformacionJSON("empresas.json", "Empresa");
        adminApp.cargarInformacionJSON("servicios.json", "Servicio");
        adminApp.cargarInformacionJSON("vehiculos.json", "Vehiculo");
        adminApp.cargarInformacionJSON("operadores.json", "Operador");
        adminApp.cargarInformacionJSON("clientes.json", "Cliente");
        adminApp.cargarInformacionJSON("reservas.json", "Reserva");
        
        ArrayList<String> serviciosAdicionales = new ArrayList<>();
        serviciosAdicionales.add("WiFi limitado");
        serviciosAdicionales.add("GPS");
        
        HashMap diccionario = adminApp.generarServiciosEspeciales(serviciosAdicionales);
        
        System.out.println(diccionario.toString());
    }
}
