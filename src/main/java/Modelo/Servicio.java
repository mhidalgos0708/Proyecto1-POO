/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Calendar;

/**
 *
 * @author fabri
 */
public class Servicio {
    private int identificador;
    private Calendar fechaInicio;
    private Calendar fechaFinalizacion;
    private double montoPagado;
    private String detalles; 
    private TServicio tipo;
    private EmpresaMantenimiento empresaRelacionada;

    public Servicio() {}

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
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

    public double getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(double montoPagado) {
        this.montoPagado = montoPagado;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public TServicio getTipo() {
        return tipo;
    }

    public void setTipo(TServicio tipo) {
        this.tipo = tipo;
    }

    public EmpresaMantenimiento getEmpresaRelacionada() {
        return empresaRelacionada;
    }

    public void setEmpresaRelacionada(EmpresaMantenimiento empresaRelacionada) {
        this.empresaRelacionada = empresaRelacionada;
    }
    
    
    
    
}
