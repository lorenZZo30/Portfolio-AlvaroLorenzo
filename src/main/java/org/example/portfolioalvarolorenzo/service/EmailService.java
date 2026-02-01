package org.example.portfolioalvarolorenzo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class EmailService {

    @Value("${spring.mail.username}")
    private String destino;

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void enviarCorreoContacto(String cuerpo) {

        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(destino);
        mensaje.setSubject("Nuevo mensaje desde el portfolio");
        mensaje.setText(cuerpo);

        mailSender.send(mensaje);
    }
}
