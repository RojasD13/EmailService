package com.edu.uptc.emailService.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.edu.uptc.emailService.dto.EmailNotificationEvent;
import com.edu.uptc.emailService.model.SendEmail;
import com.resend.Resend;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.CreateEmailOptions;

import jakarta.annotation.PostConstruct;

@Service
public class ResendEmailService implements SendEmail {

    @Value("${RESEND_API_KEY}")
    private String apiKey;
    @Value("${APP_ADMIN_EMAIL}")
    private String adminEmail;
    @Value("${API_EMAIL}")
    private String fromEmail;

    private Resend resend;

    public ResendEmailService() {
    }

    @PostConstruct
    public void init() {
        this.resend = new Resend(apiKey);
    }

    @Override
    public void sendEmailFromEvent(EmailNotificationEvent event) {
        try {
            String html = generateHtml(event);
            CreateEmailOptions params = CreateEmailOptions.builder()
                    .from(fromEmail)
                    .to(adminEmail)
                    .subject("Info Registro Quejas")
                    .html(html)
                    .build();
            resend.emails().send(params);
        } catch (ResendException e) {
            e.printStackTrace();
        }
    }

    private String generateHtml(EmailNotificationEvent event) {
        return "<html><body>" +
                "<h1>Detalles de la Petición</h1>" +
                "<p><strong>Usuario:</strong> " + event.getUserEmail() + "</p>" +
                "<p><strong>IP:</strong> " + event.getClientIp() + "</p>" +
                "<p><strong>Método HTTP:</strong> " + event.getHttpMethod() + "</p>" +
                "<p><strong>URI:</strong> " + event.getRequestUri() + "</p>" +
                "<p><strong>Fecha:</strong> " + event.getTimestamp() + "</p>" +
                "</body></html>";
    }

}
