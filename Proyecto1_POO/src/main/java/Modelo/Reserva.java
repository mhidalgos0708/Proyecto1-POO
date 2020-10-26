/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Utilitaria;
import java.util.Calendar;
import java.util.HashMap;

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

    @Override
    public String toString() {
        return "Reserva{" + "sedeRecogida=" + sedeRecogida + ", sedeEntrega=" + sedeEntrega + 
                ", fechaInicio=" + Utilitaria.formatoFecha(fechaInicio) + ", fechaFinalizacion=" +
                Utilitaria.formatoFecha(fechaFinalizacion) + ", fechaSolicitud=" + Utilitaria.formatoFecha(fechaSolicitud) + 
                ", operador=" + operador + ", vehiculoSeleccionado=" + vehiculoSeleccionado + ", clienteRelacionado=" + 
                clienteRelacionado + ", serviciosOpcionales=" + serviciosOpcionales + ", numeroFactura=" + numeroFactura + '}';
    }
    
    
    
    
}
