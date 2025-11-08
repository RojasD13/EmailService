package com.edu.uptc.emailConsumer.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.edu.uptc.emailConsumer.dto.EmailNotificationEvent;
import com.edu.uptc.emailConsumer.model.SendEmail;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmailConsumer {

    private final SendEmail emailService;

    public EmailConsumer(SendEmail emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(topics = "email-notifications", groupId = "email-service-group")
    public void consumeEmailEvent(EmailNotificationEvent event) {
        log.info("Received email notification event: {}", event);        
        emailService.sendEmailFromEvent(event);
    }
}
