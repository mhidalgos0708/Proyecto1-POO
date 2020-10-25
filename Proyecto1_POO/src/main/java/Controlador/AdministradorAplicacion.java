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
                   Calendar fechaExpiracionLicencia, String imagen)
    {
        Cliente nuevoCliente = new Cliente(nombreCompleto, cedula, direccionExacta, correoElectronico, telefono,
                                           numeroLicencia, fechaEmisionLicencia, tipoLicencia, fechaExpiracionLicencia,
                                           imagen);
        listaClientes.add(nuevoCliente);
    }
    public void registrarVehiculo(String placa, int añoFabricacion, TEstilo estilo, String color, String marca, 
                    int capacidad, double kilometraje, int numeroPuertas, String numeroVin, double mpg, 
                    String sede, double costoDiario, int capacidadMaletas, TTransmision tipoTransmision, 
                    TEstado estado, ArrayList<Servicio> listaServiciosRelacionados, String imagen)
    {
        Vehiculo nuevoVehiculo = new Vehiculo(placa, añoFabricacion, estilo, color, marca, capacidad, kilometraje,
                                              numeroPuertas, numeroVin, mpg, sede, costoDiario, capacidadMaletas,
                                              tipoTransmision, estado, listaServiciosRelacionados, imagen);
        listaVehiculos.add(nuevoVehiculo);
    }
    public void registrarEmpresaServicios(String razonSocial, String numeroCedula, String telefono, String provincia, 
                                          String canton, String distrito, String señas)
    {
        EmpresaMantenimiento nuevaEmpresa = new EmpresaMantenimiento(razonSocial, numeroCedula, telefono, provincia,
                                                                     canton, distrito, señas);
        listaEmpresasMantenimiento.add(nuevaEmpresa);
    }
    public void registrarNuevoServicio(int identificador, Calendar fechaInicio, Calendar fechaFinalizacion, double montoPagado, 
                                       String detalles, TServicio tipo, EmpresaMantenimiento empresaRelacionada)
    {
        Servicio nuevoServicio = new Servicio(identificador, fechaInicio, fechaFinalizacion, montoPagado, 
                                              detalles, tipo, empresaRelacionada);
        listaServicios.add(nuevoServicio);
    }
    public void registrarOperador(String correoElectronico, String contraseña, String nombreCompleto, boolean estado)
    {
        Operador nuevoOperador = new Operador(correoElectronico, contraseña, nombreCompleto, estado);
        listaOperadores.add(nuevoOperador);
    }
    public void realizarReserva(String sedeRecogida, String sedeEntrega, Calendar fechaInicio, Calendar fechaFinalizacion, 
                   Calendar fechaSolicitud, Operador operador, Vehiculo vehiculoSeleccionado, Cliente clienteRelacionado, 
                   Dictionary serviciosOpcionales)
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
            if(elVehiculo.getPlaca() == pID)
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
            if(elOperador.getCorreoElectronico() == pCorreo)
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
            if(elCliente.getCedula()== pId)
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
}
