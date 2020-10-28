/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static Controlador.Utilitaria.formatoFecha;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;

//import com.itextpdf.io.font.FontConstants;
//import com.itextpdf.kernel.font.PdfFont;
//import com.itextpdf.kernel.font.PdfFontFactory;
//import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfWriter;

//import com.itextpdf.layout.Document;
//import com.itextpdf.layout.element.IBlockElement;
//import com.itextpdf.layout.element.ListItem;
import com.itextpdf.text.Font;
//import com.itextpdf.layout.element.Paragraph;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


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

import java.util.Random;

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
    private HashMap<String, Double> serviciosEspeciales = new HashMap<String, Double>();
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
    public HashMap getServiciosEspeciales() {
        return serviciosEspeciales;
    }
    public void inicializarServiciosEspeciales() {
        serviciosEspeciales.put("WiFi limitado", 15.0);
        serviciosEspeciales.put("Asistencia en carretera", 3.99);
        serviciosEspeciales.put("GPS", 13.99);
        serviciosEspeciales.put("Asiento para niño", 6.99);
        serviciosEspeciales.put("Cobertura por daños a terceros", 12.99);
    }
    public HashMap generarServiciosEspeciales(ArrayList<String> serviciosSeleccionados) {
        HashMap<String, Double> servicios = new HashMap<>();
        for(int i = 0; i < serviciosSeleccionados.size(); i++) {
            String nombreServicio = serviciosSeleccionados.get(i);
            servicios.put(nombreServicio, serviciosEspeciales.get(nombreServicio));
        }
        return servicios;
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
   
    public String generarContraseña()
    {
        Random random = new Random();
        int[] posiblesLongitudes = {8, 9, 10, 11, 12};
        char[] mayusculas = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ".toCharArray();
        char[] minusculas = "abcdefghijklmnñopqrstuvwxyz".toCharArray();
        char[] numeros = "0123456789".toCharArray();
        char[] caracteresEspeciales = "!#$?@^~".toCharArray();
        int mayusLong = mayusculas.length;
        int minusLong = minusculas.length;
        int numerosLong = numeros.length;
        int especialesLong = caracteresEspeciales.length;       

        String contraseña = "";
        int size = posiblesLongitudes[random.nextInt(5)];
        int numero = (int)(Math.random()*2);
        for(int i = 0; i < size; i++)
        {
            if (i == 0)
            {
                contraseña += caracteresEspeciales[random.nextInt(especialesLong)];
            }
            else if(i < size/2)
            {
                contraseña += numeros[random.nextInt(numerosLong)];
            }
            else
            {
                if(numero == 1)
                {
                    if(i % 2 == 0)
                    {
                        contraseña += mayusculas[random.nextInt(mayusLong)];
                    }
                    else
                    {
                        contraseña += minusculas[random.nextInt(minusLong)];
                    }
                }
                else
                {
                    if(i % 2 != 0)
                    {
                        contraseña += mayusculas[random.nextInt(mayusLong)];
                    }
                    else
                    {
                        contraseña += minusculas[random.nextInt(minusLong)];
                    }
                }
            }
        }
        return contraseña;
    }
    public boolean verificarPlaca(String placa)
    {
        if(placa.length() != 6 && placa.length() != 7)
        {
            return false;
        }
        else if(placa.length() == 6)
        {
            Pattern patron = Pattern.compile("0-9");
            Matcher comparador = patron.matcher(placa);        
            return comparador.find();
        }
        else
        {
            if(placa.charAt(3) != '-')
            {
                return false;
            }
            else
            {
                Pattern patron2 = Pattern.compile("[a-zA-Z][-][0-9]");
                Matcher comparador = patron2.matcher(placa);        
                return comparador.find();
            }
        }
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
                ArrayList<Servicio> listaServiciosRelacionados = new ArrayList<>();
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
                HashMap<String, Double> dicServiciosOpcionales = new HashMap<>();
                JSONArray serviciosOpcionales = (JSONArray) dato.get("Servicios opcionales");
                for(int i = 0; i < serviciosOpcionales.size(); i++) {
                    JSONObject par = (JSONObject) serviciosOpcionales.get(i);
                    dicServiciosOpcionales.put((par.get("Key")).toString(), Double.parseDouble((par.get("Value")).toString()));
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
                dato.put("Estado", String.valueOf(ultimoOperador.isEstado()));
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
                dato.put("Año fabricación", Integer.toString(ultimoVehiculo.getAñoFabricacion()));
                dato.put("Estilo", (ultimoVehiculo.getEstilo()).toString());
                dato.put("Color", ultimoVehiculo.getColor());
                dato.put("Marca", ultimoVehiculo.getMarca());
                dato.put("Capacidad", Integer.toString(ultimoVehiculo.getCapacidad()));
                dato.put("Kilometraje", Double.toString(ultimoVehiculo.getKilometraje()));
                dato.put("Numero puertas", Integer.toString(ultimoVehiculo.getNumeroPuertas()));
                dato.put("Numero vin", ultimoVehiculo.getNumeroVin());
                dato.put("Mpg", Double.toString(ultimoVehiculo.getMpg()));
                dato.put("Sede", ultimoVehiculo.getSede());
                dato.put("Costo diario", Double.toString(ultimoVehiculo.getCostoDiario()));
                dato.put("Capacidad maletas", Integer.toString(ultimoVehiculo.getCapacidadMaletas()));
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
                dato.put("Identificador", Integer.toString(ultimoServicio.getIdentificador()));
                dato.put("Fecha inicio", Utilitaria.formatoFechaJSON(ultimoServicio.getFechaInicio()));
                dato.put("Fecha final", Utilitaria.formatoFechaJSON(ultimoServicio.getFechaFinalizacion()));
                dato.put("Monto pagado", Double.toString(ultimoServicio.getMontoPagado()));
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
    
    public boolean editarVehiculoJSON(String placa, HashMap edicion) {
        JSONParser jsonParser = new JSONParser();
        //Línea para comprobar la actualización de la lista de vehículos
        Vehiculo vehiculoActual = obtenerVehiculo(placa);
        
        try (FileReader reader = new FileReader("vehiculos.json")) {
            Object objetos = jsonParser.parse(reader);
            JSONArray listaVehiculosJSON = (JSONArray) objetos;
            for(int i = 0; i < listaVehiculosJSON.size(); i++) {
                JSONObject vehiculoActualJSON = (JSONObject) listaVehiculosJSON.get(i);
                JSONObject vehiculo = (JSONObject) vehiculoActualJSON.get("Vehiculo");
                for(int j = 0; j < edicion.keySet().size(); j++) {
                    if((vehiculo.get("Placa")).toString().equals(placa)) {
                        vehiculo.put(edicion.keySet().toArray()[j], edicion.get(edicion.keySet().toArray()[j]));
                    }
                    //Línea para comprobar la actualización de la lista de vehículos
                    setDatoEdicion(vehiculoActual, (edicion.keySet().toArray()[j]).toString(), 
                                   (edicion.get(edicion.keySet().toArray()[j])).toString());
                    
                }
            }
        try (FileWriter archivo = new FileWriter("vehiculos.json")) {
                archivo.write(listaVehiculosJSON.toJSONString());
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
    
    //Método de prueba para actualizar la lista de vehículos del administrador
    public void setDatoEdicion(Vehiculo vehiculoActual, String nombreDato, String datoActualizado) {
        switch(nombreDato) {
            case "Año fabricación":
                vehiculoActual.setAñoFabricacion(Integer.parseInt(datoActualizado));
                break;
            case "Estilo":
                vehiculoActual.setEstilo(TEstilo.valueOf(datoActualizado));
                break;
            case "Color":
                vehiculoActual.setColor(datoActualizado);
                break;
            case "Marca":
                vehiculoActual.setMarca(datoActualizado);
                break;
            case "Capacidad":
                vehiculoActual.setCapacidad(Integer.parseInt(datoActualizado));
                break;
            case "Kilometraje":
                vehiculoActual.setKilometraje(Double.parseDouble(datoActualizado));
                break;
            case "Numero puertas":
                vehiculoActual.setNumeroPuertas(Integer.parseInt(datoActualizado));
                break;
            case "Numero vin":
                vehiculoActual.setNumeroVin(datoActualizado);
                break;
            case "Mpg":
                vehiculoActual.setMpg(Double.parseDouble(datoActualizado));
                break;
            case "Sede":
                vehiculoActual.setSede(datoActualizado);
                break;
            case "Costo diario":
                vehiculoActual.setCostoDiario(Double.parseDouble(datoActualizado));
                break;
            case "Capacidad maletas":
                vehiculoActual.setCapacidadMaletas(Integer.parseInt(datoActualizado));
                break;
            case "Transmision":
                vehiculoActual.setTipoTransmision(TTransmision.valueOf(datoActualizado));
                break;
            case "Estado":
                vehiculoActual.setEstado(TEstado.valueOf(datoActualizado));
                break;
            case "Imagen":
                vehiculoActual.setImagen(datoActualizado);
                break;
            default:
                break;
        }
    }

    public String crearPDF(Reserva laReserva) throws FileNotFoundException, DocumentException, IOException
    {
        Document documento = new Document();
        
        // El OutPutStream para el fichero donde crearemos el PDF
        FileOutputStream ficheroPDF = new FileOutputStream("Reserva" + laReserva.getNumeroFactura() + ".pdf");
        
        // Se asocia el documento de OutPutStream
        PdfWriter.getInstance(documento, ficheroPDF);
        
        // Se abre el documento
        documento.open();
        
        // Fuente
        //PdfFont font = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
        
        // Parrafo}
        Paragraph titulo = new Paragraph("Rent A Car",
                FontFactory.getFont("arial",
                22,
                Font.BOLD,
                BaseColor.BLUE));
        // Añadimos el titulo al documento    
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        documento.add(titulo);
        
        Paragraph p1 = new Paragraph ("\nFecha de solicitud: " + formatoFecha(laReserva.getFechaSolicitud()));
        Paragraph p2 = new Paragraph("Número de factura: " + laReserva.getNumeroFactura());
        p1.setAlignment(Paragraph.ALIGN_RIGHT);
        p2.setAlignment(Paragraph.ALIGN_RIGHT);
        
        Operador varOperador = laReserva.getOperador();
        Paragraph p3 = new Paragraph("\nNombre del operador que le atendió: "
                + varOperador.getNombreCompleto());
        
        Paragraph p4 = new Paragraph("\n\nDatos del cliente");
        Paragraph p5 = new Paragraph("Nombre completo: " + laReserva.getClienteRelacionado().getNombreCompleto());
        Paragraph p6 = new Paragraph("Número de teléfono: " + laReserva.getClienteRelacionado().getCedula());
        Paragraph p7 = new Paragraph("Correo electrónico: " + laReserva.getClienteRelacionado().getCorreoElectronico());
        Paragraph p8 = new Paragraph("Dirección exacta: " + laReserva.getClienteRelacionado().getDireccionExacta());
      
        Paragraph p9 = new Paragraph("\nDatos de la reserva");
        Paragraph p10 = new Paragraph("Sede donde se entrega el vehículo: " + laReserva.getSedeEntrega());
        Paragraph p11 = new Paragraph("Sede donde se recoge el vehículo: " + laReserva.getSedeRecogida());
        Paragraph p12 = new Paragraph("Fecha de inicio de la renta: " + formatoFecha(laReserva.getFechaInicio()));
        Paragraph p13 = new Paragraph("Fecha de finalización de la renta: " + formatoFecha(laReserva.getFechaFinalizacion()));
        Paragraph p14 = new Paragraph("Duración de la reserva: " + laReserva.getDuracion());
        Paragraph p15 = new Paragraph("\nDatos del vehículo");
        Paragraph p16 = new Paragraph("Estilo: " + laReserva.getVehiculoSeleccionado().getEstilo() + 
                "\nMarca: " + laReserva.getVehiculoSeleccionado().getMarca() + 
                "\nAño de fabricación: " + laReserva.getVehiculoSeleccionado().getAñoFabricacion() + 
                "\nNúmero de placa: " + laReserva.getVehiculoSeleccionado().getPlaca());
        
        
        documento.add(p1);
        documento.add(p2);
        documento.add(p3);
        documento.add(p4);
        documento.add(p5);
        documento.add(p6);
        documento.add(p7);
        documento.add(p8);
        documento.add(p9);
        documento.add(p10);
        documento.add(p11);
        documento.add(p12);
        documento.add(p13);
        documento.add(p14);
        documento.add(p15);
        documento.add(p16);
        
        HashMap servicios = laReserva.getServiciosOpcionales();
        for(int i = 0; i < servicios.keySet().size(); i++)
        {
            System.out.println(servicios.keySet().toArray()[i].toString());
            
            Paragraph se = new Paragraph(servicios.toString());
            documento.add(se);
        }
                
        // Se cierra el documento
        documento.close();
        
        return "";
    }
    
}
