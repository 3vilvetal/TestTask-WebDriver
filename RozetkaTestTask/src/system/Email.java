package system;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {    
    /**
     * Send email via GMAIL service
     * @param from
     * @param pass
     * @param to
     * @param subject
     * @param body
     */
    public void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }
    
    /**
     * Sample
     * @param args
     */
    public static void main(String[] args) {
    	XmlParser xml = new XmlParser("access.xml");
    	Email email = new Email();
    	
        String from = xml.getValues("emailLogin").get(0);
        String pass = xml.getValues("emailPass").get(0);
        
        //list of recipient email addresses 
        int toSize = xml.getValues("emailTo").size();
        String [] to = new String [toSize];
        to = xml.getValues("emailTo").toArray(to);     
        
        String subject = "Test results";
        String body = "Welcome to JavaMail!";

        email.sendFromGMail(from, pass, to, subject, body);
    }
}
