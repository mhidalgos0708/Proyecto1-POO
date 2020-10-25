/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Servicio;
import Modelo.Cliente;
import Modelo.Operador;
import Modelo.Vehiculo;
import Modelo.EmpresaMantenimiento;
import Modelo.Reserva;
import Modelo.TEstado;
import Modelo.TEstilo;
import Modelo.TLicencia;
import Modelo.TServicio;
import Modelo.TTransmision;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Dictionary;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Silvia Rodriguez
 */
public class AdministradorAplicacion {
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Operador> listaOperadores;
    private ArrayList<Vehiculo> listaVehiculos;
    private ArrayList<EmpresaMantenimiento> listaEmpresasMantenimiento;
    private ArrayList<Servicio> listaServicios;
    private ArrayList<Reserva> listaReservas;
    private Dictionary ServiciosEspeciales;
    private int numeroFactura;
    
    public void registrarCliente(String nombreCompleto, String cedula, String direccionExacta, String correoElectronico, 
                   String telefono, String numeroLicencia, Calendar fechaEmisionLicencia, TLicencia tipoLicencia, 
                   Calendar fechaExpiracionLicencia, String imagen, boolean lectura)
    {
        if(obtenerCliente(cedula) == null) {
            Cliente nuevoCliente = new Cliente(nombreCompleto, cedula, direccionExacta, correoElectronico, telefono,
                                           numeroLicencia, fechaEmisionLicencia, tipoLicencia, fechaExpiracionLicencia,
                                           imagen);
            listaClientes.add(nuevoCliente);
            if(!lectura) {
                agregarInformacionJSON("clientes.json","Cliente");
            }
        }
    }
    public void registrarVehiculo(String placa, int añoFabricacion, TEstilo estilo, String color, String marca, 
                    int capacidad, double kilometraje, int numeroPuertas, String numeroVin, double mpg, 
                    String sede, double costoDiario, int capacidadMaletas, TTransmision tipoTransmision, 
                    TEstado estado, ArrayList<Servicio> listaServiciosRelacionados, String imagen, boolean lectura)
    {
        if(obtenerVehiculo(placa) == null) {
            Vehiculo nuevoVehiculo = new Vehiculo(placa, añoFabricacion, estilo, color, marca, capacidad, kilometraje,
                                              numeroPuertas, numeroVin, mpg, sede, costoDiario, capacidadMaletas,
                                              tipoTransmision, estado, listaServiciosRelacionados, imagen);
            listaVehiculos.add(nuevoVehiculo);
            if(!lectura) {
                agregarInformacionJSON("vehiculos.json", "Vehiculo");
            }
        }
    }
    public void registrarEmpresaServicios(String razonSocial, String numeroCedula, String telefono, String provincia, 
                                          String canton, String distrito, String señas, boolean lectura)
    {
        if(obtenerEmpresa(numeroCedula) == null) {
            EmpresaMantenimiento nuevaEmpresa = new EmpresaMantenimiento(razonSocial, numeroCedula, telefono, provincia,
                                                                     canton, distrito, señas);
            listaEmpresasMantenimiento.add(nuevaEmpresa);
            if(!lectura) {
                agregarInformacionJSON("empresas.json","Empresa");
            }
        }
    }
    public void registrarNuevoServicio(int identificador, Calendar fechaInicio, Calendar fechaFinalizacion, double montoPagado, 
                                       String detalles, TServicio tipo, EmpresaMantenimiento empresaRelacionada, boolean lectura)
    {
        if(obtenerServicio(identificador) == null) {
            Servicio nuevoServicio = new Servicio(identificador, fechaInicio, fechaFinalizacion, montoPagado, 
                                              detalles, tipo, empresaRelacionada);
            listaServicios.add(nuevoServicio);
            if(!lectura) {
                agregarInformacionJSON("servicios.json","Servicio");
            }
        }
    }
    public void registrarOperador(String correoElectronico, String contraseña, String nombreCompleto, boolean estado, boolean lectura)
    {
        if(obtenerOperador(correoElectronico) == null) {
            Operador nuevoOperador = new Operador(correoElectronico, contraseña, nombreCompleto, estado);
            listaOperadores.add(nuevoOperador);
            if(!lectura) {
                agregarInformacionJSON("operadores.json","Operador");
            }
        }
    }
    public void realizarReserva(String sedeRecogida, String sedeEntrega, Calendar fechaInicio, Calendar fechaFinalizacion, 
                   Calendar fechaSolicitud, Operador operador, Vehiculo vehiculoSeleccionado, Cliente clienteRelacionado, 
                   Dictionary serviciosOpcionales, boolean lectura)
    {
        Reserva nuevaReserva = new Reserva(sedeRecogida, sedeEntrega, fechaInicio, fechaFinalizacion, fechaSolicitud, operador,
                                           vehiculoSeleccionado, clienteRelacionado, serviciosOpcionales, numeroFactura);
        listaReservas.add(nuevaReserva);
        numeroFactura++;
    }
    public Vehiculo obtenerVehiculo(String pID)
    {
        Vehiculo elVehiculo;
        for(int i = 0; i < listaVehiculos.size(); i++)
        {
            elVehiculo = listaVehiculos.get(i);
            if(elVehiculo.getPlaca().equals(pID))
            {
                return elVehiculo;
            }
        }
        return null;
    }
    public Operador obtenerOperador(String pCorreo)
    {
        Operador elOperador;
        for(int i = 0; i < listaOperadores.size(); i++)
        {
            elOperador = listaOperadores.get(i);
            if(elOperador.getCorreoElectronico().equals(pCorreo))
            {
                return elOperador;
            }
        }
        return null;
    }
    public Cliente obtenerCliente(String pId)
    {
        Cliente elCliente;
        for(int i = 0; i < listaClientes.size(); i++)
        {
            elCliente = listaClientes.get(i);
            if(elCliente.getCedula().equals(pId))
            {
                return elCliente;
            }
        }
        return null;
    }
    public Servicio obtenerServicio(int pId)
    {
        Servicio elServicio;
        for(int i = 0; i < listaServicios.size(); i++)
        {
            elServicio = listaServicios.get(i);
            if(elServicio.getIdentificador()== pId)
            {
                return elServicio;
            }
        }
        return null;
    }
    public Reserva obtenerReserva(int pId)
    {
        Reserva laReserva;
        for(int i = 0; i < listaReservas.size(); i++)
        {
            laReserva = listaReservas.get(i);
            if(laReserva.getNumeroFactura() == pId)
            {
                return laReserva;
            }
        }
        return null;
    }
    public EmpresaMantenimiento obtenerEmpresa(String pId)
    {
        EmpresaMantenimiento laEmpresa;
        for(int i = 0; i < listaEmpresasMantenimiento.size(); i++)
        {
            laEmpresa = listaEmpresasMantenimiento.get(i);
            if(laEmpresa.getNumeroCedula().equals(pId))
            {
                return laEmpresa;
            }
        }
        return null;
    }
    public ArrayList<Vehiculo> filtrarTipoVehiculo(TEstilo tipo)
    {
        ArrayList<Vehiculo> vehiculosSegunTipo = new ArrayList();
        Vehiculo elVehiculo;
        for(int i = 0; i < listaVehiculos.size(); i++)
        {
            elVehiculo = listaVehiculos.get(i);
            if(elVehiculo.getEstilo() == tipo)
            {
                vehiculosSegunTipo.add(elVehiculo);
            }
        }
        return vehiculosSegunTipo;
    }
    public ArrayList<Reserva> filtrarReservaOperador(String pNombreCompleto)
    {
        ArrayList<Reserva> reservasSegunOperador = new ArrayList();
        Reserva laReserva;
        for(int i = 0; i < listaReservas.size(); i++)
        {
            laReserva = listaReservas.get(i);
            Operador elOperador = laReserva.getOperador();
            if(elOperador.getNombreCompleto().equals(pNombreCompleto))
            {
                reservasSegunOperador.add(laReserva);
            }
        }
        return reservasSegunOperador;
    }
    public ArrayList<Reserva> filtrarReservaRecogida(String pSedeRecogida)
    {
        ArrayList<Reserva> reservasSegunRecogida = new ArrayList();
        Reserva laReserva;
        for(int i = 0; i < listaReservas.size(); i++)
        {
            laReserva = listaReservas.get(i);
            if(laReserva.getSedeRecogida().equals(pSedeRecogida))
            {
                reservasSegunRecogida.add(laReserva);
            }
        }
        return reservasSegunRecogida;
    }
    public ArrayList<Reserva> filtrarReservaVehiculo(String pPlaca)
    {
        ArrayList<Reserva> reservasSegunVehiculo = new ArrayList();
        Reserva laReserva;
        for(int i = 0; i < listaReservas.size(); i++)
        {
            laReserva = listaReservas.get(i);
            Vehiculo elVehiculo= laReserva.getVehiculoSeleccionado();
            if(elVehiculo.getPlaca().equals(pPlaca))
            {
                reservasSegunVehiculo.add(laReserva);
            }
        }
        return reservasSegunVehiculo;
    }
    public ArrayList<Reserva> filtrarReservaInicio(Calendar pFInicio)
    {
        ArrayList reservasSegunInicio = new ArrayList();
        Reserva laReserva;
        for(int i = 0; i < listaReservas.size(); i++)
        {
            laReserva = listaReservas.get(i);
            if(laReserva.getFechaInicio() == pFInicio)
            {
                reservasSegunInicio.add(laReserva);
            }
        }
        return reservasSegunInicio;
    }
   
    public boolean verificarCorreo(String correo)
    {
        Pattern patron = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        Matcher comparador = patron.matcher(correo);
        return comparador.find();
    }
    public boolean verificarTelefono(String Telefono)
    {
        if (Telefono.length() != 12)
        {
            return false;
        }
        if(Telefono.charAt(0) != '+' && Telefono.charAt(1) != '5' && Telefono.charAt(2) != '0'
           && Telefono.charAt(3) != '6')
        {
            return false;
        }
        if(Telefono.charAt(4) != '2' && Telefono.charAt(4) != '8' 
          && Telefono.charAt(4) != '6' && Telefono.charAt(4) != '7')
            
        {
            return false;
        }
        for(int i = 5; i < 12; i++)
        {
            if(Telefono.charAt(i) != '1' && Telefono.charAt(i) != '2' && Telefono.charAt(i) != '3' &&
               Telefono.charAt(i) != '4' && Telefono.charAt(i) != '5' && Telefono.charAt(i) != '6' &&
               Telefono.charAt(i) != '7' && Telefono.charAt(i) != '8' && Telefono.charAt(i) != '0' &&
               Telefono.charAt(i) != '0')
            {
                return false;
            }
        }
        return true;       
    }
    
    //Archivos clientes.json, operadores.json, vehiculos.json, empresas.json, servicios.json, reservas.json
    //NombresObjeto Cliente, Operador, Vehiculo, Empresa, Servicio, Reserva
    public boolean cargarInformacionJSON(String archivo, String nombreObjeto) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(archivo)) {
            Object objetos = jsonParser.parse(reader);
            JSONArray listaDatosJSON = (JSONArray) objetos;
            for(int i = 0; i < listaDatosJSON.size(); i++) {
                JSONObject objetoDato = (JSONObject) listaDatosJSON.get(i);
                JSONObject dato = (JSONObject) objetoDato.get(nombreObjeto);
                registrarDato(dato, nombreObjeto);
            }
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException | ParseException e) {
            return false;
        }
        return true;
    }
    
    public void registrarDato(JSONObject dato, String nombreObjeto) {
        switch(nombreObjeto) {
            case "Cliente":
                /*registrarCliente(dato.get("Nombre"), dato.get("Cedula"), dato.get("Direccion"), 
                                   dato.get("Correo"), dato.get("Telefono"), dato.get("Numero licencia"),
                                   dato.get("Fecha emision licencia"), dato.get("Tipo licencia"), 
                                   dato.get("Fecha expiracion licencia"), dato.get("Imagen"), true);*/
                break;
            case "Operador":
                registrarOperador((dato.get("Correo")).toString(), (dato.get("Contraseña")).toString(), 
                                  (dato.get("Nombre")).toString(), Boolean.parseBoolean((dato.get("Estado")).toString()), true);
                break;
            case "Vehiculo":
                /*registrarVehiculo(dato.get("Placa"), dato.get("Año fabricación"), dato.get("Estilo"), dato.get("Color"), 
                                  dato.get("Marca"), dato.get("Capacidad"), dato.get("Kilometraje"), dato.get("Numero puertas"),
                                  dato.get("Numero vin"), dato.get("Mpg"), dato.get("Sede"), dato.get("Costo diario"), 
                                  dato.get("Capacidad maletas"), dato.get("Transmision"), dato.get("Estado"), 
                                  dato.get("Lista servicios relacionados"), dato.get("Imagen"), true);*/
                break;
            case "Empresa":
                /*registrarEmpresaServicios(dato.get("Razon social"), dato.get("Cedula"), dato.get("Telefono"), 
                                          dato.get("Provincia"), dato.get("Canton"), dato.get("Distrito"),
                                          dato.get("Señas"), true);*/
                break;
            case "Servicio":
                /*registrarNuevoServicio(dato.get("Identificador"), dato.get("Fecha inicio"), dato.get("Fecha final"), 
                                       dato.get("Monto pagado"), dato.get("Detalles"), dato.get("Tipo"), 
                                       dato.get("Empresa relacionada"), true);*/
                break;
            case "Reserva":
                /*realizarReserva(dato.get("Sede recogida"), dato.get("Sede entrega"), dato.get("Fecha inicio"), 
                                dato.get("Fecha final"), dato.get("Fecha solicitud"), dato.get("Operador"), 
                                dato.get("Vehiculo seleccionado"), dato.get("Cliente relacionado"), 
                                dato.get("Servicios opcionales"), true);*/
                break;
            default:
                break;
        }
    }
    
    //NombresObjeto Cliente, Operador, Vehiculo, Empresa, Servicio, Reserva
    public boolean agregarInformacionJSON(String nombreArchivo, String nombreObjeto) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(nombreArchivo)) {
            Object objetos = jsonParser.parse(reader);
            JSONArray listaDatosJSON = (JSONArray) objetos;
            
            JSONObject datoActualJSON = new JSONObject();
            datoActualJSON = agregarDato(datoActualJSON, nombreObjeto);
            
            JSONObject paquete = new JSONObject();
            paquete.put(nombreObjeto, datoActualJSON);
            listaDatosJSON.add(paquete);
            
            try (FileWriter archivo = new FileWriter(nombreArchivo)) {
                archivo.write(listaDatosJSON.toJSONString());
                archivo.flush();
            } catch (IOException e) {
                return false;
            }
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException | ParseException e) {
            return false;
        }
        return true;
    }
    
    public JSONObject agregarDato(JSONObject dato, String nombreObjeto) {
        switch(nombreObjeto) {
            case "Cliente":
                Cliente ultimoCliente = listaClientes.get(listaClientes.size()-1);
                dato.put("Nombre", ultimoCliente.getNombreCompleto());
                dato.put("Cedula", ultimoCliente.getCedula());
                dato.put("Direccion", ultimoCliente.getDireccionExacta());
                dato.put("Correo", ultimoCliente.getCorreoElectronico());
                dato.put("Telefono", ultimoCliente.getTelefono());
                dato.put("Numero licencia", ultimoCliente.getNumeroLicencia());
                dato.put("Fecha emision licencia", ultimoCliente.getFechaEmisionLicencia());
                dato.put("Tipo licencia", ultimoCliente.getTipoLicencia());
                dato.put("Fecha expiracion licencia", ultimoCliente.getFechaExpiracionLicencia());
                dato.put("Imagen", ultimoCliente.getImagen());
                break;
            case "Operador":
                Operador ultimoOperador = listaOperadores.get(listaOperadores.size()-1);
                dato.put("Correo", ultimoOperador.getCorreoElectronico());
                dato.put("Contraseña", ultimoOperador.getContraseña());
                dato.put("Nombre", ultimoOperador.getNombreCompleto());
                dato.put("Estado", ultimoOperador.isEstado());
            case "Vehiculo":
                Vehiculo ultimoVehiculo = listaVehiculos.get(listaVehiculos.size()-1);
                dato.put("Placa", ultimoVehiculo.getPlaca());
                dato.put("Año fabricación", ultimoVehiculo.getAñoFabricacion());
                dato.put("Estilo", ultimoVehiculo.getEstilo());
                dato.put("Color", ultimoVehiculo.getColor());
                dato.put("Marca", ultimoVehiculo.getMarca());
                dato.put("Capacidad", ultimoVehiculo.getCapacidad());
                dato.put("Kilometraje", ultimoVehiculo.getKilometraje());
                dato.put("Numero puertas", ultimoVehiculo.getNumeroPuertas());
                dato.put("Numero vin", ultimoVehiculo.getNumeroVin());
                dato.put("Mpg", ultimoVehiculo.getMpg());
                dato.put("Sede", ultimoVehiculo.getSede());
                dato.put("Costo diario", ultimoVehiculo.getCostoDiario());
                dato.put("Capacidad maletas", ultimoVehiculo.getCapacidadMaletas());
                dato.put("Transmision", ultimoVehiculo.getTipoTransmision());
                dato.put("Estado", ultimoVehiculo.getEstado());
                dato.put("Lista servicios relacionados", ultimoVehiculo.getListaServiciosRelacionados());
                dato.put("Imagen", ultimoVehiculo.getImagen());
                break;
            case "Empresa":
                EmpresaMantenimiento ultimaEmpresa = listaEmpresasMantenimiento.get(listaEmpresasMantenimiento.size()-1);
                dato.put("Razon social", ultimaEmpresa.getRazonSocial());
                dato.put("Cedula", ultimaEmpresa.getNumeroCedula());
                dato.put("Telefono", ultimaEmpresa.getTelefono());
                dato.put("Provincia", ultimaEmpresa.getProvincia());
                dato.put("Canton", ultimaEmpresa.getCanton());
                dato.put("Distrito", ultimaEmpresa.getDistrito());
                dato.put("Señas", ultimaEmpresa.getSeñas());
                break;
            case "Servicio":
                Servicio ultimoServicio = listaServicios.get(listaServicios.size()-1);
                dato.put("Identificador", ultimoServicio.getIdentificador());
                dato.put("Fecha inicio", ultimoServicio.getFechaInicio());
                dato.put("Fecha final", ultimoServicio.getFechaFinalizacion());
                dato.put("Monto pagado", ultimoServicio.getMontoPagado());
                dato.put("Detalles", ultimoServicio.getDetalles());
                dato.put("Tipo", ultimoServicio.getTipo());
                dato.put("Empresa relacionada", ultimoServicio.getEmpresaRelacionada());
                break;
            case "Reserva":
                Reserva ultimaReserva = listaReservas.get(listaReservas.size()-1);
                dato.put("Sede recogida", ultimaReserva.getSedeRecogida());
                dato.put("Sede entrega", ultimaReserva.getSedeEntrega());
                dato.put("Fecha inicio", ultimaReserva.getFechaInicio());
                dato.put("Fecha final", ultimaReserva.getFechaFinalizacion());
                dato.put("Fecha solicitud", ultimaReserva.getFechaSolicitud());
                dato.put("Operador", ultimaReserva.getOperador());
                dato.put("Vehiculo seleccionado", ultimaReserva.getVehiculoSeleccionado());
                dato.put("Cliente relacionado", ultimaReserva.getClienteRelacionado());
                dato.put("Servicios opcionales", ultimaReserva.getServiciosOpcionales());
                break;
            default:
                break;
        }
        return dato;
    }
}
