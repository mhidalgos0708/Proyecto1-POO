/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author johan
 */
public class EnviarEmail {
    
    public static boolean enviarCorreo(String correo, String asunto, String texto, String archivo) {
	//Autenticar información
	final String username = "pruebaproyecto1poo@gmail.com";
	final String password = "PruebaPOO";
	String fromEmail = "pruebaproyecto1poo@gmail.com";
	String toEmail = correo;
		
	Properties properties = new Properties();
	properties.put("mail.smtp.auth", "true");
	properties.put("mail.smtp.starttls.enable", "true");
	properties.put("mail.smtp.host", "smtp.gmail.com");
	properties.put("mail.smtp.port", "587");
		
	Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username,password);
            }
	});
	//Mensaje
	MimeMessage msg = new MimeMessage(session);
                
	try {
            msg.setFrom(new InternetAddress(fromEmail));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            msg.setSubject(asunto);

            Multipart emailContent = new MimeMultipart();

            //Texto
            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText(texto);

            //Archivo
            MimeBodyPart PdfAttachment = new MimeBodyPart();
            PdfAttachment.attachFile(archivo);

            //Adjuntar texto y archivo
            emailContent.addBodyPart(textBodyPart);
            emailContent.addBodyPart(PdfAttachment);	

            //Adjuntar contenido
            msg.setContent(emailContent);

            Transport.send(msg);
	} catch (MessagingException e) {
            return false;
	} catch (IOException e){
            return false;
        }
        return true;
    }
    
}