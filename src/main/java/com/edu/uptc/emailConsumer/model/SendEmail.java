package com.edu.uptc.emailConsumer.model;

import com.edu.uptc.emailConsumer.dto.EmailNotificationEvent;


public interface SendEmail {
    void sendEmailFromEvent(EmailNotificationEvent event);
}
