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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Silvia Rodriguez
 */
public class AdministradorAplicacion {
    private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    private ArrayList<Operador> listaOperadores = new ArrayList<Operador>();
    private ArrayList<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
    private ArrayList<EmpresaMantenimiento> listaEmpresasMantenimiento = new ArrayList<EmpresaMantenimiento>();
    private ArrayList<Servicio> listaServicios = new ArrayList<Servicio>();
    private ArrayList<Reserva> listaReservas = new ArrayList<Reserva>();
    private HashMap ServiciosEspeciales;
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
                   HashMap serviciosOpcionales, boolean lectura)
    {
        Reserva nuevaReserva = new Reserva(sedeRecogida, sedeEntrega, fechaInicio, fechaFinalizacion, fechaSolicitud, operador,
                                           vehiculoSeleccionado, clienteRelacionado, serviciosOpcionales, numeroFactura);
        listaReservas.add(nuevaReserva);
        if(!lectura) {
            agregarInformacionJSON("reservas.json","Reserva");
        }
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
    public int getNumeroFactura() {
        return numeroFactura;
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
               Telefono.charAt(i) != '7' && Telefono.charAt(i) != '8' && Telefono.charAt(i) != '9' &&
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
                registrarCliente((dato.get("Nombre")).toString(), (dato.get("Cedula")).toString(), (dato.get("Direccion")).toString(), 
                                (dato.get("Correo")).toString(), (dato.get("Telefono")).toString(), (dato.get("Numero licencia")).toString(),
                                Utilitaria.obtenerFecha((dato.get("Fecha emision licencia")).toString()), TLicencia.valueOf((dato.get("Tipo licencia")).toString()), 
                                Utilitaria.obtenerFecha((dato.get("Fecha expiracion licencia")).toString()), (dato.get("Imagen")).toString(), true);
                break;
            case "Operador":
                registrarOperador((dato.get("Correo")).toString(), (dato.get("Contraseña")).toString(), 
                                  (dato.get("Nombre")).toString(), Boolean.parseBoolean((dato.get("Estado")).toString()), true);
                break;
            case "Vehiculo":
                ArrayList<Servicio> listaServiciosRelacionados = new ArrayList<Servicio>();
                JSONArray servicios = (JSONArray) dato.get("Lista servicios relacionados");
                for(int i = 0; i < servicios.size(); i++) {
                    JSONObject servicioJSON = (JSONObject) servicios.get(i);
                    int identificador = Integer.parseInt((servicioJSON.get("Identificador")).toString());
                    registrarDato(servicioJSON, "Servicio");
                    listaServiciosRelacionados.add(obtenerServicio(identificador));
                }
                registrarVehiculo((dato.get("Placa")).toString(), Integer.parseInt((dato.get("Año fabricación")).toString()),
                                  TEstilo.valueOf((dato.get("Estilo")).toString()), (dato.get("Color")).toString(), (dato.get("Marca")).toString(), 
                                  Integer.parseInt((dato.get("Capacidad")).toString()), Double.parseDouble((dato.get("Kilometraje")).toString()),
                                  Integer.parseInt((dato.get("Numero puertas")).toString()), (dato.get("Numero vin")).toString(),
                                  Double.parseDouble((dato.get("Mpg")).toString()), (dato.get("Sede")).toString(), 
                                  Double.parseDouble((dato.get("Costo diario")).toString()), Integer.parseInt((dato.get("Capacidad maletas")).toString()),
                                  TTransmision.valueOf((dato.get("Transmision")).toString()), TEstado.valueOf(( dato.get("Estado")).toString()), 
                                  listaServiciosRelacionados, (dato.get("Imagen")).toString(), true);
                break;
            case "Empresa":
                registrarEmpresaServicios((dato.get("Razon social")).toString(), (dato.get("Cedula")).toString(), 
                                          (dato.get("Telefono")).toString(), (dato.get("Provincia")).toString(), 
                                          (dato.get("Canton")).toString(), (dato.get("Distrito")).toString(),
                                          (dato.get("Señas")).toString(), true);
                break;
            case "Servicio":
                JSONArray empresas = (JSONArray) dato.get("Empresa relacionada");
                JSONObject empresaJSON = (JSONObject) empresas.get(0);
                String cedulaJuridica = (empresaJSON.get("Cedula")).toString();
                registrarDato(empresaJSON, "Empresa");
                EmpresaMantenimiento empresa = obtenerEmpresa(cedulaJuridica);
                registrarNuevoServicio(Integer.parseInt((dato.get("Identificador")).toString()), Utilitaria.obtenerFecha((dato.get("Fecha inicio")).toString()),
                                       Utilitaria.obtenerFecha((dato.get("Fecha final")).toString()), Double.parseDouble((dato.get("Monto pagado")).toString()),
                                       (dato.get("Detalles")).toString(), TServicio.valueOf((dato.get("Tipo")).toString()), empresa, true);
                break;
            case "Reserva":
                HashMap<String, Double> dicServiciosOpcionales = new HashMap<String, Double>();
                JSONArray serviciosOpcionales = (JSONArray) dato.get("Servicios opcionales");
                for(int i = 0; i < dicServiciosOpcionales.size(); i++) {
                    JSONArray par = (JSONArray) serviciosOpcionales.get(i);
                    JSONObject key = (JSONObject) par.get(0);
                    JSONObject value = (JSONObject) par.get(1);
                    dicServiciosOpcionales.put((key.get("Key")).toString(), Double.parseDouble((value.get("Value")).toString()));
                }
                realizarReserva((dato.get("Sede recogida")).toString(), (dato.get("Sede entrega")).toString(), 
                                Utilitaria.obtenerFecha((dato.get("Fecha inicio")).toString()), Utilitaria.obtenerFecha((dato.get("Fecha final")).toString()), 
                                Utilitaria.obtenerFecha((dato.get("Fecha solicitud")).toString()), obtenerOperador(buscarObjeto(dato, "Operador", "Correo")),
                                obtenerVehiculo(buscarObjeto(dato, "Vehiculo", "Placa")), obtenerCliente(buscarObjeto(dato, "Cliente", "Cedula")), 
                                dicServiciosOpcionales, true);
                break;
            default:
                break;
        }
    }
    
    //NombresObjeto Cliente, Operador, Vehiculo, Empresa, Servicio, Reserva
    public boolean agregarInformacionJSON(String nombreArchivo, String nombreObjeto) {
        JSONParser jsonParser = new JSONParser();
        JSONArray listaDatosJSON;
        try (FileReader reader = new FileReader(nombreArchivo)) {
            if(listaTieneDatos(nombreObjeto)) {
                Object objetos = jsonParser.parse(reader);
                listaDatosJSON = (JSONArray) objetos;
            } else {
                listaDatosJSON = new JSONArray();
            }
            JSONObject datoActualJSON = new JSONObject();
            datoActualJSON = agregarDato(datoActualJSON, nombreObjeto, true, 0);
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
   
    public JSONObject agregarDato(JSONObject dato, String nombreObjeto, boolean ultimo, int indice) {
        switch(nombreObjeto) {
            case "Cliente":
                Cliente ultimoCliente;
                if(ultimo) {
                    ultimoCliente = listaClientes.get(listaClientes.size()-1);
                } else {
                    ultimoCliente = (listaReservas.get(listaReservas.size()-1)).getClienteRelacionado();
                }
                dato.put("Nombre", ultimoCliente.getNombreCompleto());
                dato.put("Cedula", ultimoCliente.getCedula());
                dato.put("Direccion", ultimoCliente.getDireccionExacta());
                dato.put("Correo", ultimoCliente.getCorreoElectronico());
                dato.put("Telefono", ultimoCliente.getTelefono());
                dato.put("Numero licencia", ultimoCliente.getNumeroLicencia());
                dato.put("Fecha emision licencia", Utilitaria.formatoFechaJSON(ultimoCliente.getFechaEmisionLicencia()));
                dato.put("Tipo licencia", (ultimoCliente.getTipoLicencia()).toString());
                dato.put("Fecha expiracion licencia", Utilitaria.formatoFechaJSON(ultimoCliente.getFechaExpiracionLicencia()));
                dato.put("Imagen", ultimoCliente.getImagen());
                break;
            case "Operador":
                Operador ultimoOperador;
                if(ultimo) {
                    ultimoOperador = listaOperadores.get(listaOperadores.size()-1);
                } else {
                    ultimoOperador = (listaReservas.get(listaReservas.size()-1)).getOperador();
                }
                dato.put("Correo", ultimoOperador.getCorreoElectronico());
                dato.put("Contraseña", ultimoOperador.getContraseña());
                dato.put("Nombre", ultimoOperador.getNombreCompleto());
                dato.put("Estado", ultimoOperador.isEstado());
                break;
            case "Vehiculo":
                Vehiculo ultimoVehiculo;
                if(ultimo) {
                    ultimoVehiculo = listaVehiculos.get(listaVehiculos.size()-1);
                } else {
                    ultimoVehiculo = listaReservas.get(listaReservas.size()-1).getVehiculoSeleccionado();
                }
                ArrayList<Servicio> listaServiciosRegistrados = ultimoVehiculo.getListaServiciosRelacionados();
                JSONObject servicioJSON = new JSONObject();
                JSONArray listaServiciosJSON = new JSONArray();
                for(int i = 0; i < listaServiciosRegistrados.size(); i++) {
                    servicioJSON = agregarDato(servicioJSON, "Servicio", false, i);
                    listaServiciosJSON.add(servicioJSON);
                }
                dato.put("Placa", ultimoVehiculo.getPlaca());
                dato.put("Año fabricación", ultimoVehiculo.getAñoFabricacion());
                dato.put("Estilo", (ultimoVehiculo.getEstilo()).toString());
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
                dato.put("Transmision", (ultimoVehiculo.getTipoTransmision()).toString());
                dato.put("Estado", (ultimoVehiculo.getEstado()).toString());
                dato.put("Lista servicios relacionados", listaServiciosJSON);
                dato.put("Imagen", ultimoVehiculo.getImagen());
                break;
            case "Empresa":
                EmpresaMantenimiento ultimaEmpresa;
                if(ultimo) {
                    ultimaEmpresa = listaEmpresasMantenimiento.get(listaEmpresasMantenimiento.size()-1);
                } else {
                    ultimaEmpresa = (listaServicios.get(listaServicios.size()-1)).getEmpresaRelacionada();
                }
                dato.put("Razon social", ultimaEmpresa.getRazonSocial());
                dato.put("Cedula", ultimaEmpresa.getNumeroCedula());
                dato.put("Telefono", ultimaEmpresa.getTelefono());
                dato.put("Provincia", ultimaEmpresa.getProvincia());
                dato.put("Canton", ultimaEmpresa.getCanton());
                dato.put("Distrito", ultimaEmpresa.getDistrito());
                dato.put("Señas", ultimaEmpresa.getSeñas());
                break;
            case "Servicio":
                Servicio ultimoServicio;
                if(ultimo) {
                    ultimoServicio = listaServicios.get(listaServicios.size()-1);
                } else {
                    Vehiculo ultimoVehiculoRegistrado = listaVehiculos.get(listaVehiculos.size()-1);
                    ultimoServicio = ultimoVehiculoRegistrado.getListaServiciosRelacionados().get(indice);
                }
                JSONObject empresaJSON = new JSONObject();
                JSONArray listaEmpresasJSON = new JSONArray();
                dato.put("Identificador", ultimoServicio.getIdentificador());
                dato.put("Fecha inicio", Utilitaria.formatoFechaJSON(ultimoServicio.getFechaInicio()));
                dato.put("Fecha final", Utilitaria.formatoFechaJSON(ultimoServicio.getFechaFinalizacion()));
                dato.put("Monto pagado", ultimoServicio.getMontoPagado());
                dato.put("Detalles", ultimoServicio.getDetalles());
                dato.put("Tipo", (ultimoServicio.getTipo()).toString());
                empresaJSON = agregarDato(empresaJSON, "Empresa", false, 0);
                listaEmpresasJSON.add(empresaJSON);
                dato.put("Empresa relacionada", listaEmpresasJSON);
                break;
            case "Reserva":
                Reserva ultimaReserva = listaReservas.get(listaReservas.size()-1);
                JSONArray operadorJSON = prepararArrayObjetos("Operador");
                JSONArray vehiculoJSON = prepararArrayObjetos("Vehiculo");
                JSONArray clienteJSON = prepararArrayObjetos("Cliente");
                HashMap<String, Double> serviciosOpcionales = ultimaReserva.getServiciosOpcionales();
                JSONArray serviciosOpcionalesJSON = new JSONArray();
                for (String i : serviciosOpcionales.keySet()) {
                    JSONObject par = new JSONObject();
                    par.put("Key", i);
                    par.put("Value", serviciosOpcionales.get(i));
                    serviciosOpcionalesJSON.add(par);
                }
                dato.put("Sede recogida", ultimaReserva.getSedeRecogida());
                dato.put("Sede entrega", ultimaReserva.getSedeEntrega());
                dato.put("Fecha inicio", Utilitaria.formatoFechaJSON(ultimaReserva.getFechaInicio()));
                dato.put("Fecha final", Utilitaria.formatoFechaJSON(ultimaReserva.getFechaFinalizacion()));
                dato.put("Fecha solicitud", Utilitaria.formatoFechaJSON(ultimaReserva.getFechaSolicitud()));
                dato.put("Operador", operadorJSON);
                dato.put("Vehiculo", vehiculoJSON);
                dato.put("Cliente", clienteJSON);
                dato.put("Servicios opcionales", serviciosOpcionalesJSON);
                break;
            default:
                break;
        }
        return dato;
    }
    
    public boolean listaTieneDatos(String nombreObjeto) {
        switch(nombreObjeto) {
            case "Operador":
                return listaOperadores.size() > 1;
            case "Empresa":
                return listaEmpresasMantenimiento.size() > 1;
            case "Cliente":
                return listaClientes.size() > 1;
            case "Servicio":
                return listaServicios.size() > 1;
            case "Vehiculo":
                return listaVehiculos.size() > 1;
            case "Reserva":
                return listaReservas.size() > 1;
        }
        return false;
    }
    
    public String buscarObjeto(JSONObject dato, String nombreObjeto, String id) {
        JSONArray listaObjetos = (JSONArray) dato.get(nombreObjeto);
        JSONObject objetoJSON = (JSONObject) listaObjetos.get(0);
        registrarDato(objetoJSON, nombreObjeto);
        return (objetoJSON.get(id)).toString();
    }
    
    public JSONArray prepararArrayObjetos(String nombreObjeto) {
        JSONObject objetoJSON = new JSONObject();
        JSONArray arrayObjeto = new JSONArray();
        objetoJSON = agregarDato(objetoJSON, nombreObjeto, false, 0);
        arrayObjeto.add(objetoJSON);
        return arrayObjeto;
    }
    
}
