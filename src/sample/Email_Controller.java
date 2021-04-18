package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Email_Controller {

@FXML
TextField Email;
@FXML
Button Send_btn;
    public void SetupEmail() throws Exception {
        String messageTxt = Email.getText();
        System.out.println(messageTxt);
        Send_email("amfimitrul@gmail.com",messageTxt);
        //Notifications not = Notifications.create();
    }



    public static void Send_email(String recipient,String messageTxt) throws Exception{

        //String recepient = "amfimitrul@gmail.com";
        Properties properties = new Properties();

        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");

        String myAccountEmail = "pharmacysystem23@gmail.com";
        String password = "papaki123";

        Session session = Session.getInstance(properties, new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(myAccountEmail,password);
            }

        });

        Message message = prepareMessage(session,myAccountEmail,recipient , messageTxt);

        Transport.send(message);
        System.out.println("Message sent");

    }

        private static Message prepareMessage(Session session, String myAccountEmail, String recipient,String messageTxt) {



            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(myAccountEmail));
                message.setRecipients(Message.RecipientType.TO , new InternetAddress[]{new InternetAddress(recipient)});
                message.setSubject("My first email");
                message.setText(messageTxt);
                return message;

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
}
