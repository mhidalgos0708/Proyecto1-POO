/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Operador;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;


import com.itextpdf.text.Font;
//import com.itextpdf.layout.element.Paragraph;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Silvia Rodriguez
 */
public class pruebaPDF {
    public static void main(String[] args) throws FileNotFoundException, IOException, DocumentException {
        List<Operador> listaPersonas = new ArrayList<Operador>();
        
        Operador persona = new Operador("a@gmail.com", "1234", "Silvia", false);
        listaPersonas.add(persona);
        
        Operador persona1 = new Operador("b@gmail.com", "wfd", "Laura", false);
        listaPersonas.add(persona1);
        
        Operador persona2 = new Operador("c@gmail.com", "df", "Maria", false);
        listaPersonas.add(persona2);
        
        System.out.println("LA LISTA TIENE: "+listaPersonas.size()+" agregadas");
        
        // LLAMADA AL METODO PARA CREAR EL PDF
        crearPDF(listaPersonas);
    }
    public static void crearPDF(List<Operador> lista) throws FileNotFoundException, IOException, DocumentException {
        
        /*String dest = "C:\\Users\\Wendy\\OneDrive\\Escritorio\\hola.pdf";
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);
        */
        
        Document documento = new Document();
        
        // El OutPutStream para el fichero donde crearemos el PDF
        FileOutputStream ficheroPDF = new FileOutputStream("Personas.pdf");
        
        // Se asocia el documento de OutPutStream
        PdfWriter.getInstance(documento, ficheroPDF);
        
        // Se abre el documento
        documento.open();
        
        // Fuente
        //PdfFont font = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
        
        // Parrafo}
        Paragraph titulo = new Paragraph("Lista de personas \n\n",
                FontFactory.getFont("arial",
                        22,
                        Font.BOLD,
                        BaseColor.BLUE
                        )
        );
        // Añadimos el titulo al documento        
        documento.add(titulo);
        
        PdfPTable tabla = new PdfPTable(4);
        tabla.addCell("ID");
        tabla.addCell("CORREO");
        tabla.addCell("PASSWORD");
        tabla.addCell("NOMBRE");
        
        for(int i = 0 ; i < lista.size() ; i++) {
            tabla.addCell("" + i);
            tabla.addCell(lista.get(i).getCorreoElectronico());
            tabla.addCell(lista.get(i).getContraseña());
            tabla.addCell(lista.get(i).getNombreCompleto());
        }
        
        // Añadimos la tabla al documento
        //document.add((IBlockElement) tabla);
                
        documento.add(tabla);
        
        // Se cierra el documento
        documento.close();
    }
    
    
}
