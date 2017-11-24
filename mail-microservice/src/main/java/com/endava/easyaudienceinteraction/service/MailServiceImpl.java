package com.endava.easyaudienceinteraction.service;

import com.endava.easyaudienceinteraction.dto.MailRequest;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @author Laurentiu Iordache
 */
@Service
public class MailServiceImpl implements MailService{

    private Properties property;
    private Session session;
    private PasswordAuthentication authentication;
    private Authenticator authenticator;

    {
        property = new Properties();
        property.put("mail.smtp.host", "smtp.gmail.com");
        property.put("mail.smtp.socketFactory.port", "465");
        property.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        property.put("mail.smtp.auth", "true");
        property.put("mail.smtp.port", "465");
    }

    public void init(String username, String password) {
        if (session == null) {
            authentication = new PasswordAuthentication(username, password);
            authenticator = new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return authentication;
                }
            };
            session = Session.getInstance(property,authenticator);

        } else {
            authentication = new PasswordAuthentication(username, password);
        }
    }

    public void sendMail(MailRequest mailRequest) {
        String username = mailRequest.getUsername();
        String password = mailRequest.getPassword();
        String receiver = mailRequest.getReceiver();
        String subject = mailRequest.getSubject();
        String content = mailRequest.getContent();

        init(username, password);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(receiver));
            message.setSubject(subject);
            message.setText(content);

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
