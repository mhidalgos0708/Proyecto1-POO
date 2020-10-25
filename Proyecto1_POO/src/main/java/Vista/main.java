/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import Controlador.AdministradorAplicacion;
import Modelo.Operador;
/**
 *
 * @author mhidalgos0708
 */
public class main {
    
    private static AdministradorAplicacion adminApp = new AdministradorAplicacion();
    
    public static void main(String[] args) {
        adminApp.cargarInformacionJSON("operadores.json", "Operador");
        Operador operador1 = adminApp.obtenerOperador("juanpa@gmail.com");
        System.out.println(operador1.toString());
    }
}
