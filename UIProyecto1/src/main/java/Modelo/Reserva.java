/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Utilitaria;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author fabri
 */
public class Reserva {
    private String sedeRecogida;
    private String sedeEntrega;
    private Calendar fechaInicio;
    private Calendar fechaFinalizacion;
    private Calendar fechaSolicitud;
    private Operador operador;
    private Vehiculo vehiculoSeleccionado;
    private Cliente clienteRelacionado;
    private HashMap serviciosOpcionales;
    private int numeroFactura;

    public Reserva() {
    }

    public Reserva(String sedeRecogida, String sedeEntrega, Calendar fechaInicio, Calendar fechaFinalizacion, 
                   Calendar fechaSolicitud, Operador operador, Vehiculo vehiculoSeleccionado, Cliente clienteRelacionado, 
                   HashMap serviciosOpcionales, int numeroFactura) {
        this.sedeRecogida = sedeRecogida;
        this.sedeEntrega = sedeEntrega;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.fechaSolicitud = fechaSolicitud;
        this.operador = operador;
        this.vehiculoSeleccionado = vehiculoSeleccionado;
        this.clienteRelacionado = clienteRelacionado;
        this.serviciosOpcionales = serviciosOpcionales;
        this.numeroFactura = numeroFactura;
    }
    
    public String getSedeRecogida() {
        return sedeRecogida;
    }

    public void setSedeRecogida(String sedeRecogida) {
        this.sedeRecogida = sedeRecogida;
    }

    public String getSedeEntrega() {
        return sedeEntrega;
    }

    public void setSedeEntrega(String sedeEntrega) {
        this.sedeEntrega = sedeEntrega;
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    public Vehiculo getVehiculoSeleccionado() {
        return vehiculoSeleccionado;
    }

    public void setVehiculoSeleccionado(Vehiculo vehiculoSeleccionado) {
        this.vehiculoSeleccionado = vehiculoSeleccionado;
    }

    public Cliente getClienteRelacionado() {
        return clienteRelacionado;
    }

    public void setClienteRelacionado(Cliente clienteRelacionado) {
        this.clienteRelacionado = clienteRelacionado;
    }

    public HashMap getServiciosOpcionales() {
        return serviciosOpcionales;
    }

    public void setServiciosOpcionales(HashMap serviciosOpcionales) {
        this.serviciosOpcionales = serviciosOpcionales;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Calendar getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Calendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Calendar getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Calendar fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public Calendar getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Calendar fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public int getDuracion()
    {
        int days = 0;
        while (fechaInicio.compareTo(fechaFinalizacion) < 0) 
        {
            fechaInicio.add(Calendar.DAY_OF_MONTH, 1); // suma un día al calendario 1
            days++;
        }
        if (days == 0)
            days++;
        return days;
    }
    
    public double getCostoRenta()
    {
        double costo = getDuracion() * vehiculoSeleccionado.getCostoDiario();
        return costo;
    }
    public double getCostoSO()
    {
        double se = 0;
        for(int i = 0; i < serviciosOpcionales.keySet().size(); i++)
        {            
            String key = serviciosOpcionales.keySet().toArray()[i].toString();
            serviciosOpcionales.get(key).toString();
            se += (Double)serviciosOpcionales.get(key);
        }        
        return se * getDuracion();
    }
    public double getCostoTotal()
    {
        return getCostoSO() + getCostoRenta();
    }
    
    public Object[][] getArrayServicios(){
        Set keys = serviciosOpcionales.keySet();
        Object[][] O = new Object[][]{{"WiFi", keys.contains("WiFi limitado") ? "Sí" : "No"},{"GPS", keys.contains("GPS") ? "Sí" : "No"},{"Seguro", keys.contains("Cobertura por daños a terceros") ? "Sí" : "No"},{"Asistencia", keys.contains("Asistencia en carretera") ? "Sí" : "No"},{"Asiento Niños", keys.contains("Asiento para niño") ? "Sí" : "No"}};
        return O;
    }
    @Override
    public String toString() {
        return "Reserva número "+ numeroFactura + " (" + Utilitaria.formatoFecha(fechaInicio) + " - " + Utilitaria.formatoFecha(fechaFinalizacion) + ')';
    }
    
    
    
    
}
