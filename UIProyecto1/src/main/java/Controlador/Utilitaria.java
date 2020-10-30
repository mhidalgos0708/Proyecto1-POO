/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.Calendar;

/**
 *
 * @author mhidalgos0708
 */
public class Utilitaria {
    
    //set año, mes, día
    public static Calendar obtenerFecha(String fechaString) {
        String[] datos = fechaString.split(" ");
        Calendar fechaCalendar = Calendar.getInstance();
        fechaCalendar.set(Integer.parseInt(datos[2]), (Integer.parseInt(datos[1]))-1, Integer.parseInt(datos[0]));
        return fechaCalendar;
    }
    
    public static String formatoFecha(Calendar fechaCalendar) {
        return fechaCalendar.get(Calendar.DATE)+"/"+(fechaCalendar.get(Calendar.MONTH)+1)+"/"+fechaCalendar.get(Calendar.YEAR);
    }
    
    public static String formatoFechaJSON(Calendar fechaCalendar) {
        return fechaCalendar.get(Calendar.DATE)+" "+(fechaCalendar.get(Calendar.MONTH)+1)+" "+fechaCalendar.get(Calendar.YEAR);
    }
    
    public static String verificarMetodo(boolean estadoMetodo) {
        if(estadoMetodo) {
            return "El proceso ha concluido existosamente.";
        } else {
            return "Ha ocurrido un error.";
        }
    }
    
}
