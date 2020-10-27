package EmailPackage;

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

public class SendEmail {

	public static void EnviarCorreo() {
		//authentication info
		final String username = "pruebaproyecto1poo@gmail.com";
		final String password = "PruebaPOO";
		String fromEmail = "pruebaproyecto1poo@gmail.com";
		String toEmail = "pruebaproyecto1poo@gmail.com";
		
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
		//Start our mail message
		MimeMessage msg = new MimeMessage(session);
                
		try {
			msg.setFrom(new InternetAddress(fromEmail));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			msg.setSubject("AsuntoPrueba");
			
			Multipart emailContent = new MimeMultipart();
			
			//Text body part
			MimeBodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setText("TextoPrueba");
			
			//Attachment body part.
			MimeBodyPart PdfAttachment = new MimeBodyPart();
                        PdfAttachment.attachFile("C:\\Users\\JoJo\\Desktop\\Tarea 4 Johan Calvo Vargas.pdf");
			
			//Attach body parts
			emailContent.addBodyPart(textBodyPart);
                        emailContent.addBodyPart(PdfAttachment);
			
			
			//Attach multipart to message
			msg.setContent(emailContent);
			
			Transport.send(msg);
			System.out.println("Sent message");
		} catch (MessagingException e) {
                    
                         
			e.printStackTrace();
		} catch (IOException e){
                        e.printStackTrace();
                }  

	}

}
