import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class email {

public void send(String recipeintEmail, 
        String subject, 
        String messageText) 
        throws MessagingException, AddressException {
    /*
       It is a good practice to put this in a java.util.Properties 
       file and encrypt password. Scroll down 
       to comments below to see 
       how to use java.util.Properties in JSF context. 
    */
    String senderEmail = "liliaqwer@gmail.com";
    String senderMailPassword = "120986qwer";
    String gmail = "smtp.gmail.com";

    Properties props = System.getProperties();

    props.put("mail.smtp.user", senderEmail);
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "465");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.debug", "true");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class", 
          "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.socketFactory.fallback", "false");

    // Required to avoid security exception.
    email.MyAuthenticator authentication = 
          new email.MyAuthenticator(senderEmail,senderMailPassword);
    Session session = 
          Session.getDefaultInstance(props,authentication);
    session.setDebug(true);
    System.out.println("after session");
    MimeMessage message = new MimeMessage(session);

    BodyPart messageBodyPart = new MimeBodyPart();      
    messageBodyPart.setText(messageText);

    // Add message text
    Multipart multipart = new MimeMultipart();
    multipart.addBodyPart(messageBodyPart);
    
    message.setContent(multipart);                
    message.setSubject(subject);
    message.setFrom(new InternetAddress(senderEmail));
    message.addRecipient(Message.RecipientType.TO,
        new InternetAddress(recipeintEmail));

    Transport transport = session.getTransport("smtps");
    transport.connect(gmail,465, senderEmail, senderMailPassword);
    transport.sendMessage(message, message.getAllRecipients());

    transport.close();

    System.out.println("Done");
}

private class MyAuthenticator extends javax.mail.Authenticator {
    String User;
    String Password;
    public MyAuthenticator (String user, String password) {
        User = user;
        Password = password;
    }

    @Override
    public PasswordAuthentication getPasswordAuthentication() {
        return new javax.mail.PasswordAuthentication(User, Password);
    }
}


public static void main(String args[]) throws MessagingException
{
   email e=new email();
   e.send("Karavaichik@irc.beltelecom.by", "hello","test");
}

}