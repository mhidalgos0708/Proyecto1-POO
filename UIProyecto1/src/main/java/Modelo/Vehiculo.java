/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.Inicio;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Esta clase de modela los vehhículos de la flotilla del sistema
 * @since 23/10/2020
 * @version 1.0
 * @author Fabricio Delgado Morales, Johan Alonso Calvo Vargas, Mariana Hidalgo Sandoval, Silvia Melissa Rodríguez Fernández
 * 
 */

public class Vehiculo {
    private String placa;
    private int añoFabricacion;
    private TEstilo estilo;
    private String color;
    private String marca;
    private int capacidad;
    private double kilometraje;
    private int numeroPuertas;
    private String numeroVin;
    private double mpg;
    private String sede;
    private double costoDiario;
    private int capacidadMaletas;
    private TTransmision tipoTransmision;
    private TEstado estado;
    private ArrayList<Servicio> listaServiciosRelacionados;
    private String imagen;

    public Vehiculo() {
    }

    public Vehiculo(String placa, int añoFabricacion, TEstilo estilo, String color, String marca, 
                    int capacidad, double kilometraje, int numeroPuertas, String numeroVin, double mpg, 
                    String sede, double costoDiario, int capacidadMaletas, TTransmision tipoTransmision, 
                    TEstado estado, ArrayList<Servicio> listaServiciosRelacionados, String imagen) {
        this.placa = placa;
        this.añoFabricacion = añoFabricacion;
        this.estilo = estilo;
        this.color = color;
        this.marca = marca;
        this.capacidad = capacidad;
        this.kilometraje = kilometraje;
        this.numeroPuertas = numeroPuertas;
        this.numeroVin = numeroVin;
        this.mpg = mpg;
        this.sede = sede;
        this.costoDiario = costoDiario;
        this.capacidadMaletas = capacidadMaletas;
        this.tipoTransmision = tipoTransmision;
        this.estado = estado;
        this.listaServiciosRelacionados = listaServiciosRelacionados;
        this.imagen = imagen;
    }
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAñoFabricacion() {
        return añoFabricacion;
    }

    public void setAñoFabricacion(int añoFabricacion) {
        this.añoFabricacion = añoFabricacion;
    }

    public TEstilo getEstilo() {
        return estilo;
    }

    public void setEstilo(TEstilo estilo) {
        this.estilo = estilo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(double kilometraje) {
        this.kilometraje = kilometraje;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    public String getNumeroVin() {
        return numeroVin;
    }

    public void setNumeroVin(String numeroVin) {
        this.numeroVin = numeroVin;
    }

    public double getMpg() {
        return mpg;
    }

    public void setMpg(double mpg) {
        this.mpg = mpg;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public double getCostoDiario() {
        return costoDiario;
    }

    public void setCostoDiario(double costoDiario) {
        this.costoDiario = costoDiario;
    }

    public int getCapacidadMaletas() {
        return capacidadMaletas;
    }

    public void setCapacidadMaletas(int capacidadMaletas) {
        this.capacidadMaletas = capacidadMaletas;
    }

    public TTransmision getTipoTransmision() {
        return tipoTransmision;
    }

    public void setTipoTransmision(TTransmision tipoTransmision) {
        this.tipoTransmision = tipoTransmision;
    }

    public TEstado getEstado() {
        return estado;
    }

    public void setEstado(TEstado estado) {
        this.estado = estado;
    }

    public ArrayList<Servicio> getListaServiciosRelacionados() {
        return listaServiciosRelacionados;
    }

    public void setListaServiciosRelacionados(ArrayList<Servicio> listaServiciosRelacionados) {
        this.listaServiciosRelacionados = listaServiciosRelacionados;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    /**
     * Este método verifica si un automóvil está rentado en el período de tiempo indicado.
     * 
     * @param Desde Calendario indicando la fecha desde donde se pretende reservar.
     * @param Hasta Calendario indicando la fecha hasta donde se pretende reservar.
     * @return Valor booleano true si se encuentra reservado, false si no lo está.
     */
    public boolean isRentadoEnElRango(Calendar Desde, Calendar Hasta){
        ArrayList<Reserva> listaReservasAutoActual;
        listaReservasAutoActual = Inicio.adminApp.filtrarReservaVehiculo(placa);
        System.out.println(listaReservasAutoActual);
        if (listaReservasAutoActual.isEmpty()) {
            return false;
        }
        for (Reserva R: listaReservasAutoActual){
            if ((0<=Hasta.compareTo(R.getFechaInicio()) && Desde.compareTo(R.getFechaFinalizacion())<=0) || (0<=Hasta.compareTo(R.getFechaInicio()) && Hasta.compareTo(R.getFechaFinalizacion())<=0) || (0<=Desde.compareTo(R.getFechaInicio()) && Desde.compareTo(R.getFechaFinalizacion())<=0)) {
                System.out.println("Esta Reservado");
                return true;
            }
        }System.out.println("No Esta Reservado");
        return false;
    }
    

    @Override
    public String toString() {
        return "Vehículo " + marca + ", Placa: " + placa;
    }
    
    /**
     * Este método permite añadir un nuevo servicio de mantenimiento al vehículo.
     * @param servicioActual Servicio que se desea agregar.
     * @return Valor booleano true si se logra agregar satisfactoriamente el servicio, false si no.
     */
    public boolean agregarServicio(Servicio servicioActual) {
        boolean servicio = false;
        for(int i = 0; i < listaServiciosRelacionados.size(); i++) {
            if(servicioActual.getIdentificador() == listaServiciosRelacionados.get(i).getIdentificador()) {
                servicio = true;
            }
        }
        if(!servicio) {
            listaServiciosRelacionados.add(servicioActual);
            return true;
        }
        return false;
    }
    
}
