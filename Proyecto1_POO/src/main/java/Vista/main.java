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
import Modelo.TServicio;
import Modelo.Reserva;
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
        
        HashMap diccionario = new HashMap();
        diccionario.put("Año fabricación", Integer.toString(1990));
        diccionario.put("Estilo", String.valueOf(TEstilo.MiniVan));
        diccionario.put("Sede", "Cartago");
        diccionario.put("Color", "Blanco");
        diccionario.put("Imagen", "Foto");
        
        HashMap diccionario2 = new HashMap();
        diccionario2.put("Año fabricación", Integer.toString(1970));
        diccionario2.put("Estilo", String.valueOf(TEstilo.Económico));
        diccionario2.put("Sede", "Cartago");
        diccionario2.put("Color", "Azul");
        diccionario2.put("Imagen", "Fotografía");
        
        Calendar fechaInicio = Calendar.getInstance();
        Calendar fechaFinalizacion = Calendar.getInstance();
        //fechaFinalizacion.add(Calendar.DAY_OF_MONTH, 20);
        
        Reserva laReserva = adminApp.obtenerReserva(0);
        
        System.out.println(laReserva.getCostoRenta());
        
    }
}
