/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author mhidalgos0708
 */
public class MetodoGET {
    
    @SuppressWarnings("ConvertToTryWithResources")
    protected static String getHTML(String leerURL) throws Exception {
        
        //Conexión
        
        StringBuilder result = new StringBuilder();
        URL url = new URL(leerURL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
    
        //Retorna el contenido del sitio
        
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = in.readLine()) != null) {
            result.append(line);
        }
        in.close();
        return result.toString();
    }
    
}
