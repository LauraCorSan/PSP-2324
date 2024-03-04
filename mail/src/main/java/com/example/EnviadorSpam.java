package com.example;

import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;

public class EnviadorSpam implements ObservadorMensajes {
    private String cuentaEnvio;
    private String contraseñaEnvio;

    public EnviadorSpam(String ctEnvio, String passEnvio) {
        this.cuentaEnvio = ctEnvio;
        this.contraseñaEnvio = passEnvio;
    }

    public void aviso(String info) {
        System.out.println(info);
        String[] informacion = info.split("-");
        try {
            Email email = EmailBuilder.startingBlank()
                    .to("Alguien", informacion[0].toString())
                    .from("Laura", "laura.cordero6@educa.madrid.org")
                    .withReplyTo("Laura", "laura.cordero6@educa.madrid.org")
                    .withSubject("Proyecto Spamtoso")
                    // .withHTMLText("<h1>Hola!!</h1><p>¿Qué tal?</p>")
                    .withPlainText(informacion[1].toString())
                    .buildEmail();

            Mailer mailer = MailerBuilder
                    .withSMTPServer("smtp.educa.madrid.org", 587, cuentaEnvio, contraseñaEnvio)
                    .withTransportStrategy(TransportStrategy.SMTP_TLS)
                    .clearEmailValidator() // turns off email validation
                    .buildMailer();
            mailer.sendMail(email);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
