package br.com.cobradev.javamailhog;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailService {

    private final String ADD = "f05037967@gmail.com";
    private final String P_NOME = "Felipe";
    private final String Senha = "whqepvlepvxyapvw";
    private final String Nome = "f05037967@gmail.com";

    public void enviar(String sbj  , String msg , String endereco){
        try{

            Properties properties = new Properties();

            properties.put("mail.smtp.ssl.trust", "*");
            properties.put("mail.smtp.ssl.checkserveridentity", "true");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls", "true");
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "465");
            properties.put("mail.smtp.socketFactory.port", "465");
            properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");


            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(Nome , Senha);
                }
            });

            session.setDebug(true);
        Address[] add = InternetAddress.parse(endereco);

        Message mss = new MimeMessage(session);
        mss.setFrom(new InternetAddress(ADD,P_NOME));
        mss.setRecipients(Message.RecipientType.TO , add);
        mss.setSubject(sbj);
        mss.setContent(msg, "text/html; charset=utf-8");

            Transport.send(mss);
    }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
