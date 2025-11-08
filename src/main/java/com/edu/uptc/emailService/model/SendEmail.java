package com.edu.uptc.emailService.model;

import com.edu.uptc.emailService.dto.EmailNotificationEvent;


public interface SendEmail {
    void sendEmailFromEvent(EmailNotificationEvent event);
}
