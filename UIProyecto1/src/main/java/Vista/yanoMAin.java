/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import Controlador.AdministradorAplicacion;
import Modelo.Operador;
import java.util.Calendar;
import Modelo.Reserva;
import Modelo.Servicio;
import java.util.ArrayList;
import com.itextpdf.text.DocumentException;
import java.io.IOException;
/**
 *
 * @author mhidalgos0708
 */
public class yanoMAin {
    
    public static AdministradorAplicacion adminApp = new AdministradorAplicacion();
    

    public static void main(String[] args) {
        
        adminApp.cargarInformacionJSON("empresas.json", "Empresa");
        adminApp.cargarInformacionJSON("servicios.json", "Servicio");
        adminApp.cargarInformacionJSON("vehiculos.json", "Vehiculo");
        adminApp.cargarInformacionJSON("operadores.json", "Operador");
        adminApp.cargarInformacionJSON("clientes.json", "Cliente");
        adminApp.cargarInformacionJSON("reservas.json", "Reserva");
        adminApp.inicializarServiciosEspeciales();
        
        Calendar fEmision = Calendar.getInstance();
        
        System.out.println(fEmision);
    }
}
