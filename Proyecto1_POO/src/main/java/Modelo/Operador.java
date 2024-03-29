/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author fabri
 */
public class Operador {
    private String correoElectronico;
    private String contraseña;
    private String nombreCompleto;
    private boolean estado;

    public Operador() {} 

    public Operador(String correoElectronico, String contraseña, String nombreCompleto, boolean estado) {
        this.correoElectronico = correoElectronico;
        this.contraseña = contraseña;
        this.nombreCompleto = nombreCompleto;
        this.estado = estado;
    }
    
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public String getUsername()
    {
        String[] username = correoElectronico.split("@", 2); 
        return username[0];
    }

    @Override
    public String toString() {
        return "Operador{" + "correoElectronico=" + correoElectronico + ", contrase\u00f1a=" 
                + contraseña + ", nombreCompleto=" + nombreCompleto + ", estado=" + estado + '}';
    }
    
    
    
}
