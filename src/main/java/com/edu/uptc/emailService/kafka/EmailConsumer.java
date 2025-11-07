package com.edu.uptc.emailService.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.edu.uptc.emailService.dto.EmailNotificationEvent;
import com.edu.uptc.emailService.service.ResendEmailService;

@Service
public class EmailConsumer {

    private final ResendEmailService resendEmailService;

    public EmailConsumer(ResendEmailService resendEmailService) {
        this.resendEmailService = resendEmailService;
    }

    @KafkaListener(topics = "email-notifications", groupId = "email-service")
    public void consumeEmailEvent(EmailNotificationEvent event) {
        System.out.println("vento recibido de Kafka: " + event.getRequestUri());
        resendEmailService.sendEmailFromEvent(event);
    }
}
