/*
 * Created on Feb 1, 2018
 */
package asd.framework.booking.mail.pattern;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import asd.framework.booking.domain.Customer;

public abstract class SendingEmailTemplateMethod {
    private final String USERNAME = "chav.vecteur@gmail.com"; //user send
    private final String PASSWORD = "012249021"; //passwordfdfdffd

    
    public void sendEmailToClient(Customer customer) {
        Session session = getSession(USERNAME, PASSWORD);
        try {
            Message message = new MimeMessage(session);
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(getRecipients(customer)));
            message.setSubject(buildSubject(customer));
            message.setText(buildBody(customer));
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
    private Session getSession(String username , String password) {
        Properties props = getPropertiesMail();
        Session session = Session.getInstance(props,new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });
        return session;
    }
    
    private Properties getPropertiesMail() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        return props;
    }

    public abstract String getRecipients(Customer customer);
    public abstract String buildSubject(Customer customer);
    public abstract String buildBody(Customer customer); 
}
