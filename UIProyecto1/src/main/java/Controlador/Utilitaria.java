/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.Calendar;

/**
 * Esta clase maneja formatos de fechas.
 * @since 25/10/2020
 * @version 1.0
 * @author Mariana Hidalgo Sandoval
 */

public class Utilitaria {
    
    /**
     * @param fechaString
     * Este método convierte un string de forma día/mes/año a un tipo de dato Calendar
     * @return Calendar
     */
    
    public static Calendar obtenerFecha(String fechaString) {
        String[] datos = fechaString.split(" ");
        Calendar fechaCalendar = Calendar.getInstance();
        fechaCalendar.set(Integer.parseInt(datos[2]), (Integer.parseInt(datos[1]))-1, Integer.parseInt(datos[0]));
        return fechaCalendar;
    }
    
    /**
     * @param fechaCalendar
     * Este método convierte un tipo de dato Calendar a una fecha en formato string "día/mes/año"
     * @return String 
     */
    
    public static String formatoFecha(Calendar fechaCalendar) {
        return fechaCalendar.get(Calendar.DATE)+"/"+(fechaCalendar.get(Calendar.MONTH)+1)+"/"+fechaCalendar.get(Calendar.YEAR);
    }
    
    /**
     * @param fechaCalendar
     * Este método convierte un tipo de dato Calendar a una fecha en formato string "día mes año"
     * @return String 
     */
    
    public static String formatoFechaJSON(Calendar fechaCalendar) {
        return fechaCalendar.get(Calendar.DATE)+" "+(fechaCalendar.get(Calendar.MONTH)+1)+" "+fechaCalendar.get(Calendar.YEAR);
    }
    
    /**
     * @param estadoMetodo
     * Este método retorna un mensaje indicando si el estado de un método es exitoso o no
     * @return String 
     */
    
    public static String verificarMetodo(boolean estadoMetodo) {
        if(estadoMetodo) {
            return "El proceso ha concluido existosamente.";
        } else {
            return "Ha ocurrido un error.";
        }
    }
    
}
