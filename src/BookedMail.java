package airline.reservation;


import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

public class BookedMail extends Thread {
    private String email;
    private String ticketNo;
    private String confirmCode;
    public BookedMail(String email , String ticketNo){
        this.email = email;
        this.ticketNo = ticketNo;
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
        final String user = "<Your mail>";// change accordingly
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
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("TICKET BOOKED MY AIRLINES");
            message.setText("Thanks For flying with us \n Your ticket is = " + ticketNo);
            Transport.send(message);

            System.out.println("message sent successfully...");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
