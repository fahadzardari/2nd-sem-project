package airline.reservation;


import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

public class SendMail extends Thread {
    private String email;
    private String confirmCode;
    public SendMail(String email){
        this.email = email;
    }
    public String getCode(){
        return confirmCode;
    }
    /**
     * 
     */
    @Override 
    public void run() {

        String host = "smtp.gmail.com";
        final String user = "<YOur mail>";// change accordingly
        final String password = "<Your password>";// change accordingly

        String to = email;// change accordingly

        // Get the session object
        Properties props = System.getProperties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        // Compose the message
        try {
            confirmCode = FlightsController.getAlphaNumericString(5);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("CONFIRMATION FROM MY AIRLINES");
            message.setText("Confirmation code = " + confirmCode);
            Transport.send(message);

            System.out.println("message sent successfully...");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
