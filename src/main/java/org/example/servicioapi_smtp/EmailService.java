package org.example.servicioapi_smtp;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailService {

    static final String host = "smtp.gmail.com"; // o el servidor SMTP que utilices
    static final String user = "correo@ejemplo.com"; // tu correo electrónico
    static final String password = "contrasenya"; // tu contraseña o token de aplicación

    public static void correos(String destinatario, String asunto, String texto){
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); // Para seguridad TLS

        // Crear una sesión de autenticación
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        try {
            // Crear el mensaje
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario)); //El que recibe el correo raul.martin.torrabadella@gmail.com
            message.setSubject(asunto);
            message.setText(texto);

            // Enviar el correo
            Transport.send(message);

            System.out.println("Correo enviado exitosamente.");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }


}

